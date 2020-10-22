package service.student;

import dao.classDao.DepartmentClassMapper;
import dao.classDao.PeClassMapper;
import dao.classDao.PublicClassMapper;
import dao.userDao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.classes.DepartmentClass;
import pojo.classes.NecessaryClassGroup;
import pojo.classes.PeClass;
import pojo.classes.PublicClass;
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
    @Qualifier("departmentClassMapper")
    DepartmentClassMapper departmentClassMapper;
    @Autowired
    @Qualifier("peClassMapper")
    PeClassMapper peClassMapper;
    @Autowired
    @Qualifier("publicClassMapper")
    PublicClassMapper publicClassMapper;

    //查找所有必修课 分组
    public List<NecessaryClassGroup> selectNecessaryCourseById(String stuId){
        Student stu = studentMapper.selectById(stuId);
        int grade = stu.getGrade();
        String department = stu.getDepartment();
        List<DepartmentClass> departmentClasses = departmentClassMapper.selectNecessaryCourse(grade, department);
        List<NecessaryClassGroup> groupList= GroupingNecessaryUtil.group(departmentClasses);//套餐分组
        return groupList;
    }

    //查找所有专业选修课
    public List<DepartmentClass> selectSelectiveCourseById(String stuId){
        Student stu = studentMapper.selectById(stuId);
        int grade = stu.getGrade();
        String department = stu.getDepartment();
        return departmentClassMapper.selectSelectiveCourse(grade,department);
    }

    //查找所有的体育课
    @Override
    public List<PeClass> selectAllPECourse() {
        return peClassMapper.selectAllPeClass();
    }

    @Override
    //查找所有不重名的体育课
    public List<PeClass> selectPeCourseUnique() {
        List<PeClass> peClassList1 = peClassMapper.selectAllPeClass();
        Map map=new HashMap();
        for (PeClass peClass : peClassList1) {
            map.put(peClass.getName(),peClass);//map 的key唯一
        }

        List<PeClass> peClassList2= (List<PeClass>) map.values().stream().collect(Collectors.toList());
        return peClassList2;
    }

    @Override
    //查找一门体育课的所有课堂
    public List<PeClass> selectPeCourseByName(String className) {
            return peClassMapper.selectPeClassByName(className);
    }


    //查找所有的公选课
    @Override
    public List<PublicClass> selectAllPublicCourse() {
        return publicClassMapper.selectAllPublicCourse();
    }


    //查找所有公选课（同一门课程，不同老师，只取一个实例）
    @Override
    public List<PublicClass> selectPublicCourseUnique() {
        List<PublicClass> publicClassList1 = publicClassMapper.selectAllPublicCourse();
        Map map=new HashMap();
        for (PublicClass publicClass : publicClassList1) {
            map.put(publicClass.getName(),publicClass);//map 的key唯一
        }

        List<PublicClass> publicClassList2= (List<PublicClass>) map.values().stream().collect(Collectors.toList());
        /*
        Collection<PublicClass> values = map.values();
        for (PublicClass publicClass : values) {
            publicClassList2.add(publicClass);
        }
        */
        return publicClassList2;
    }


    @Override
    //查找一门公选课的所有课堂（同一门课，不同老师）
    public List<PublicClass> selectPublicCourseByName(String className) {
        return publicClassMapper.selectPublicCourseByName(className);
    }



}
