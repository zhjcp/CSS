package service.student;

import dao.classDao.DepartmentCourseMapper;
import dao.classDao.PeCourseMapper;
import dao.classDao.PublicCourseMapper;
import dao.userDao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.classes.DepartmentCourse;
import pojo.classes.NecessaryCourseGroup;
import pojo.classes.PeCourse;
import pojo.classes.PublicCourse;
import pojo.user.Student;
import service.utils.GroupingNecessaryUtil;

import java.util.*;
import java.util.stream.Collectors;

@Service("stuCourseSelectServiceImpl")
public class CourseSelectServiceImpl implements CourseSelectService{
    //service层调用dao层的方法操作数据库，需要一个Mapper实例
    @Autowired
    @Qualifier("studentMapper")
    StudentMapper studentMapper;
    @Autowired
    @Qualifier("departmentCourseMapper")
    DepartmentCourseMapper departmentCourseMapper;
    @Autowired
    @Qualifier("peCourseMapper")
    PeCourseMapper peCourseMapper;
    @Autowired
    @Qualifier("publicCourseMapper")
    PublicCourseMapper publicCourseMapper;

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



}
