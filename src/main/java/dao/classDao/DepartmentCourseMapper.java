package dao.classDao;

import org.apache.ibatis.annotations.Param;
import pojo.classes.DepartmentCourse;

import java.util.List;

public interface DepartmentCourseMapper {
    //查找某个学生的所有必修课
    public List<DepartmentCourse> selectNecessaryCourse(@Param("grade") int grade, @Param("department") String department);
    //查找某个学生的专业选修课
    public List<DepartmentCourse> selectSelectiveCourse(@Param("grade") int grade, @Param("department") String department);
    //查找一门专业选修课的所有课堂（同名，不同课堂）
    public List<DepartmentCourse> selectSelectiveCourseByName(@Param("name") String name);
}
