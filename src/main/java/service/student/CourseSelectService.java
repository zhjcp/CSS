package service.student;

import pojo.classes.DepartmentClass;
import pojo.classes.PeClass;
import pojo.classes.PublicClass;

import java.util.List;


public interface CourseSelectService {
    //查找所有必修课
    List<DepartmentClass> selectNecessaryCourseById(String id);

    //查找所有专业选修课
    List<DepartmentClass> selectSelectiveCourseById(String id);

    //查找所有的体育课(需要什么限制吗？？？)
    List<PeClass> selectAllPECourse();

    //查找所有的公选课
    List<PublicClass> selectAllPublicCourse();

}
