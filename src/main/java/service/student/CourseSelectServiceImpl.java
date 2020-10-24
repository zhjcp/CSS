package service.student;

import dao.classDao.DepartmentCourseMapper;
import dao.classDao.PeCourseMapper;
import dao.classDao.PublicCourseMapper;
import dao.otherDao.NecessarySelectionsMapper;
import dao.otherDao.PeSelectionsMapper;
import dao.otherDao.PublicSelectionsMapper;
import dao.otherDao.SelectiveSelectionsMapper;
import dao.userDao.StudentMapper;
import dao.userDao.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.classes.*;
import pojo.other.CourseSelections;
import pojo.user.Student;
import pojo.user.Teacher;
import service.utils.GroupingNecessaryUtil;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service("stuCourseSelectServiceImpl")
public class CourseSelectServiceImpl implements CourseSelectService{
    //service层调用dao层的方法操作数据库，需要一个Mapper实例
    @Resource(name = "studentMapper")
    StudentMapper studentMapper;
    @Resource(name = "teacherMapper")
    TeacherMapper teacherMapper;
    @Resource(name = "departmentCourseMapper")
    DepartmentCourseMapper departmentCourseMapper;
    @Resource(name = "peCourseMapper")
    PeCourseMapper peCourseMapper;
    @Resource(name = "publicCourseMapper")
    PublicCourseMapper publicCourseMapper;
    @Resource(name = "necessarySelectionsMapper")
    NecessarySelectionsMapper necessarySelectionsMapper;
    @Resource(name = "selectiveSelectionsMapper")
    SelectiveSelectionsMapper selectiveSelectionsMapper;
    @Resource(name = "peSelectionsMapper")
    PeSelectionsMapper peSelectionsMapper;
    @Resource(name = "publicSelectionsMapper")
    PublicSelectionsMapper publicSelectionsMapper;


    //查找所有必修课 分组
    public List<NecessaryCourseGroup> selectNecessaryCourseGrouping(String stuId){
        Student stu = studentMapper.selectById(stuId);
        int grade = stu.getGrade();
        String department = stu.getDepartment();
        List<DepartmentCourse> departmentCourses = departmentCourseMapper.selectNecessaryCourse(grade, department);
        List<NecessaryCourseGroup> groupList= GroupingNecessaryUtil.group(departmentCourses);//套餐分组
        return groupList;
    }

    //查找所有不重名的专业选修课
    public List<DepartmentCourse> selectSelectiveCourseUnique(String stuId){
        Student stu = studentMapper.selectById(stuId);
        int grade = stu.getGrade();
        String department = stu.getDepartment();
        List<DepartmentCourse> departmentCourseList1 = departmentCourseMapper.selectSelectiveCourse(grade, department);
        Map map=new HashMap();
        for (DepartmentCourse departmentCourse : departmentCourseList1) {
            map.put(departmentCourse.getName(), departmentCourse);
        }
        List<DepartmentCourse> departmentCourseList2 = (List<DepartmentCourse>) map.values().stream().collect(Collectors.toList());
        return departmentCourseList2;
    }


    //查找一门体育课的所有课堂
    @Override
    public List<DepartmentCourse> selectSelectiveByCourseName(String className) {
        return departmentCourseMapper.selectSelectiveCourseByName(className);
    }

    //查找所有的体育课
    @Override
    public List<PeCourse> selectAllPeCourse() {
        return peCourseMapper.selectAllPeCourse();
    }

    @Override
    //查找所有不重名的体育课
    public List<PeCourse> selectPeCourseUnique() {
        List<PeCourse> peCourseList1 = peCourseMapper.selectAllPeCourse();
        Map map=new HashMap();
        for (PeCourse peCourse : peCourseList1) {
            map.put(peCourse.getName(), peCourse);//map 的key唯一
        }

        List<PeCourse> peCourseList2 = (List<PeCourse>) map.values().stream().collect(Collectors.toList());
        return peCourseList2;
    }

    @Override
    //查找一门体育课的所有课堂
    public List<PeCourse> selectPeByCourseName(String className) {
            return peCourseMapper.selectPeCourseByName(className);
    }


    //查找所有的公选课
    @Override
    public List<PublicCourse> selectAllPublicCourse() {
        return publicCourseMapper.selectAllPublicCourse();
    }


    //查找所有公选课（同一门课程，不同老师，只取一个实例）
    @Override
    public List<PublicCourse> selectPublicCourseUnique() {
        List<PublicCourse> publicCourseList1 = publicCourseMapper.selectAllPublicCourse();
        Map map=new HashMap();
        for (PublicCourse publicCourse : publicCourseList1) {
            map.put(publicCourse.getName(), publicCourse);//map 的key唯一
        }
        List<PublicCourse> publicCourseList2 = (List<PublicCourse>) map.values().stream().collect(Collectors.toList());
        /*
        Collection<PublicClass> values = map.values();
        for (PublicClass publicClass : values) {
            publicClassList2.add(publicClass);
        }
        */
        return publicCourseList2;
    }

    @Override
    //查找一门公选课的所有课堂（同一门课，不同老师）
    public List<PublicCourse> selectPublicByCourseName(String className) {
        return publicCourseMapper.selectPublicCourseByName(className);
    }


    @Override
    // 提交选课 （本来首先要看这门课程有没有满,由于赋权故不需要了）
    public boolean tryToAddSelection(int courseId, String stuId, int selectionCoins) {
        //ps：前端首先检查了选课币的数目是否足够
        // 由于采取选课币的选课模式，在正选时不需要检查课程的容量
        Student stu = studentMapper.selectById(stuId);
        if (courseId<=10000){
            //专业选修课
            DepartmentCourse departmentCourse = departmentCourseMapper.selectByCourseId(courseId);
            String teacherName=departmentCourse.getTeacherName();
            Teacher teacher = teacherMapper.selectByName(teacherName);
            departmentCourseMapper.updateStuNum(courseId,departmentCourse.getStuNum()+1);//更新课程已选人数
            selectiveSelectionsMapper.addStuSelection(new CourseSelections(courseId, stuId,selectionCoins, teacher.getId(), 1));
        }else if (courseId>10000&&courseId<=20000){
                //体育课
                PeCourse peCourse = peCourseMapper.selectByCourseId(courseId);
                String teacherName = peCourse.getTeacherName();
                Teacher teacher = teacherMapper.selectByName(teacherName);
                peCourseMapper.updateStuNum(courseId,peCourse.getStuNum()+1);//更新课程已选人数
                peSelectionsMapper.addStuSelection(new CourseSelections(courseId, stuId,selectionCoins, teacher.getId(), 1));
        }else {
                //公选课
                PublicCourse publicCourse = publicCourseMapper.selectByCourseId(courseId);
                String teacherName = publicCourse.getTeacherName();
                Teacher teacher = teacherMapper.selectByName(teacherName);
                publicCourseMapper.updateStuNum(courseId,publicCourse.getStuNum()+1);//更新课程已选人数
                publicSelectionsMapper.addStuSelection(new CourseSelections(courseId, stuId,selectionCoins, teacher.getId(), 1));
        }
        studentMapper.updateSelectionCoinsById(stuId,stu.getSelectionCoins()-selectionCoins);//减去选课币
        return true;//提交选课成功
    }


    @Override
    // 提交必修课套餐的选择
    public boolean tryToAddSelectionGroup(int groupId, String stuId, int selectionCoins) {
        //ps：前端首先检查了选课币的数目是否足够
        // 由于采取选课币的选课模式，在正选时不需要检查课程的容量
        Student stu = studentMapper.selectById(stuId);
        // step1: 找出该学生的学院、年级、选中的group所对应的课程（具体到课堂）
        List<DepartmentCourse> departmentCourseList = departmentCourseMapper.selectNecessaryCourseByDGG(stu.getDepartment(), stu.getGrade(), groupId);
        // step2: 用找到的课程，更新necessary_selections表
        for (DepartmentCourse d : departmentCourseList) {
            String teacherName = d.getTeacherName();
            Teacher teacher = teacherMapper.selectByName(teacherName);
            departmentCourseMapper.updateStuNum(d.getId(),d.getStuNum()+1);//更新课程已选人数
            necessarySelectionsMapper.addStuSelection(new CourseSelections(d.getId(), stuId,selectionCoins, teacher.getId(), 1));
        }
        studentMapper.updateSelectionCoinsById(stuId,stu.getSelectionCoins()-selectionCoins);//减去选课币
        return true;
    }

    @Override
    // 查询一名学生的所有已选课程 （提供给 查看个人课程信息 依次:）
    public AllSelectedCourse selectMyAllSelectedCourse(String stuId) {
        List<Course> myNecessaryCourseList = studentMapper.selectMyNecessaryCourse(stuId);
        //System.out.println(myNecessaryCourseList);
        List<Course> mySelectiveCourseList = studentMapper.selectMySelectiveCourse(stuId);
        //System.out.println(mySelectiveCourseList);
        List<Course> myPeCourseList = studentMapper.selectMyPeCourse(stuId);
        //System.out.println(myPeCourseList);
        List<Course> myPublicCourseList = studentMapper.selectMyPublicCourse(stuId);
        //System.out.println(myPublicCourseList);
        return new AllSelectedCourse(myNecessaryCourseList,mySelectiveCourseList,myPeCourseList,myPublicCourseList);
    }


    @Override
    // 退选某门课程+返回新的个人课程列表
    public AllSelectedCourse returnACourseById(int courseId,String stuId) {
        //  step1：根据课程的id ,分辨出课程的类别（专业选修、体育、公选）
        //  step2:  学生id删除在相应的selections表内的记录
        //  step3： 根据课程的id，将stuNum减1
        if (courseId<=10000){
            selectiveSelectionsMapper.deleteStuSelection(courseId,stuId);
            DepartmentCourse dC = departmentCourseMapper.selectByCourseId(courseId);//删除在相应的selections表内的记录
            departmentCourseMapper.updateStuNum(courseId,dC.getStuNum()-1);//将stuNum减1
        }else if (courseId<=20000){
            peSelectionsMapper.deleteStuSelection(courseId,stuId);
            PeCourse pC = peCourseMapper.selectByCourseId(courseId);
            peCourseMapper.updateStuNum(courseId,pC.getStuNum()-1);
        }else {
            publicSelectionsMapper.deleteStuSelection(courseId,stuId);
            PublicCourse pC = publicCourseMapper.selectByCourseId(courseId);
            publicCourseMapper.updateStuNum(courseId,pC.getStuNum()-1);
        }
        return selectMyAllSelectedCourse(stuId);
    }
}
