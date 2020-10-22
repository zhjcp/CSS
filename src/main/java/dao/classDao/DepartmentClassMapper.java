package dao.classDao;

import org.apache.ibatis.annotations.Param;
import pojo.classes.DepartmentClass;

import java.util.List;

public interface DepartmentClassMapper {
    //查找某个学生的所有必修课
    public List<DepartmentClass> selectNecessaryCourse(@Param("grade") int grade, @Param("department") String department);
    //查找某个学生的专业选修课
    public List<DepartmentClass> selectSelectiveCourse(@Param("grade") int grade, @Param("department") String department);
}
