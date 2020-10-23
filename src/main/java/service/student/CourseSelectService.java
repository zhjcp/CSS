package service.student;

import pojo.classes.*;

import java.util.List;


public interface CourseSelectService {
    //查找所有必修课 学生id
    List<NecessaryCourseGroup> selectNecessaryCourseGrouping(String stuId);

    //查找所有专业选修课
    List<DepartmentCourse> selectSelectiveCourseUnique(String stuId);

    //查找一门专业课的所有课堂
    List<DepartmentCourse> selectSelectiveByCourseName(String className);

    //查找所有的体育课(需要什么限制吗？？？)
    List<PeCourse> selectAllPeCourse();

    //查找所有不重名的体育课
    List<PeCourse> selectPeCourseUnique();

    //查找一门体育课的所有课堂
    List<PeCourse> selectPeByCourseName(String className);

    //查找所有的公选课
    List<PublicCourse> selectAllPublicCourse();

    //查找所有不重名的公选课
    List<PublicCourse> selectPublicCourseUnique();

    //查找一门公选课的所有课堂（同一门课，不同老师）
    List<PublicCourse> selectPublicByCourseName(String className);

    // 提交必修课之外的选课 (首先要看这门课程有没有满)
    public boolean tryToAddSelection(int courseId, String stuId, int selectionCoins);

    // 提交必修课套餐的选择
    public boolean tryToAddSelectionGroup(int groupId,String stuId,int selectionCoins);

    // 查询一名学生的所有已选课程 （提供给 查看个人课程信息）
    public List<Course> selectMyAllSelectedCourse(String stuId);
}
