package dao.userDao;

import org.apache.ibatis.annotations.Param;
import pojo.classes.Course;
import pojo.user.Student;

import java.util.List;

public interface StudentMapper {
    //根据id查询
    public Student selectById(@Param("id") String id);
    //修改选课币
    public void updateSelectionCoinsById(@Param("id") String id,@Param("selectionCoins") int selectionCoins);
    //查询该学生选了的所有必修课程
    public List<Course> selectMyNecessaryCourse(@Param("id") String id);
    //查询该学生选了的所有专业选修课程
    public List<Course> selectMySelectiveCourse(@Param("id") String id);
    //查询该学生选了的所有体育课程
    public List<Course> selectMyPeCourse(@Param("id") String id);
    //查询该学生选了的所有公选课程
    public List<Course> selectMyPublicCourse(@Param("id") String id);
}
