package dao.classDao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import pojo.classes.DepartmentCourse;
import pojo.other.MapItem;

import java.util.List;
import java.util.Map;

public interface DepartmentCourseMapper {
    //查找某个学生的所有必修课
    public List<DepartmentCourse> selectNecessaryCourse(@Param("grade") int grade, @Param("department") String department);
    //查找某个学生的专业选修课
    public List<DepartmentCourse> selectSelectiveCourse(@Param("grade") int grade, @Param("department") String department);
    //查找一门专业选修课的所有课堂（同名，不同课堂）
    public List<DepartmentCourse> selectSelectiveCourseByName(@Param("name") String name);
    //按id查找一门课程
    public DepartmentCourse selectByCourseId(@Param("id") int id);
    //增加一个课堂的已选人数
    public void updateStuNum(@Param("id") int id,@Param("stuNum") int stuNum);
    //按学院、年级、分组 (DGG) 查询课程
    public List<DepartmentCourse> selectNecessaryCourseByDGG(@Param("department") String department,@Param("targetGrade") int targetGrade,@Param("groupId") int groupId);
    //查找stuNum > capacity的课堂   用处：根据找到的课堂的id去selections表中找到所有该课程的count
    public List<Integer> selectCalculatingCourse();
}
