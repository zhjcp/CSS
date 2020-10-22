package service.student;

import pojo.classes.DepartmentClass;
import pojo.classes.NecessaryClassGroup;
import pojo.classes.PeClass;
import pojo.classes.PublicClass;

import java.util.List;


public interface CourseSelectService {
    //查找所有必修课 学生id
    List<NecessaryClassGroup> selectNecessaryCourseById(String stuId);

    //查找所有专业选修课
    List<DepartmentClass> selectSelectiveCourseById(String stuId);

    //查找所有的体育课(需要什么限制吗？？？)
    List<PeClass> selectAllPECourse();

    //查找所有不重名的体育课
    List<PeClass> selectPeCourseUnique();

    //查找一门体育课的所有课堂
    List<PeClass> selectPeCourseByName(String className);

    //查找所有的公选课
    List<PublicClass> selectAllPublicCourse();

    //查找所有不重名的公选课
    List<PublicClass> selectPublicCourseUnique();

    //查找一门公选课的所有课堂（同一门课，不同老师）
    List<PublicClass> selectPublicCourseByName(String className);
}
