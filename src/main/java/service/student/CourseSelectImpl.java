package service.student;

import dao.DepartmentClassMapper;
import dao.PeClassMapper;
import dao.PublicClassMapper;
import dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.classes.DepartmentClass;
import pojo.classes.PeClass;
import pojo.classes.PublicClass;
import pojo.user.Student;

import java.util.List;

@Service("stuCourseSelectServiceImpl")
public class CourseSelectImpl implements CourseSelectService{
    //service层调用dao层的方法操作数据库，需要一个Mapper实例
    @Autowired
    @Qualifier("studentMapper")
    StudentMapper studentMapper;
    @Autowired
    @Qualifier("departmentClassMapper")
    DepartmentClassMapper department_ClassMapper;
    @Autowired
    @Qualifier("peClassMapper")
    PeClassMapper pE_ClassMapper;
    @Autowired
    @Qualifier("publicClassMapper")
    PublicClassMapper public_ClassMapper;

    //查找所有必修课
    public List<DepartmentClass> selectNecessaryCourseById(String id){
        Student stu = studentMapper.selectById(id);
        int grade = stu.getGrade();
        String department = stu.getDepartment();
        return department_ClassMapper.selectNecessaryCourse(grade,department);
    }

    //查找所有专业选修课
    public List<DepartmentClass> selectSelectiveCourseById(String id){
        Student stu = studentMapper.selectById(id);
        int grade = stu.getGrade();
        String department = stu.getDepartment();
        return department_ClassMapper.selectSelectiveCourse(grade,department);
    }

    //查找所有的体育课
    @Override
    public List<PeClass> selectAllPECourse() {
        return pE_ClassMapper.selectAllPECourse();
    }

    //查找所有的公选课

    @Override
    public List<PublicClass> selectAllPublicCourse() {
        return public_ClassMapper.selectAllPublicCourse();
    }
}
