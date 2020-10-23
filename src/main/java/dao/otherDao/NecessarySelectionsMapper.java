package dao.otherDao;

import org.apache.ibatis.annotations.Param;
import pojo.other.CourseSelections;

import java.util.List;

public interface NecessarySelectionsMapper {
    // 1. 增加一条学生选课信息（选课）
    public int addStuSelection(CourseSelections courseSelections);

    // 2. 删除一条学生选课信息（退选）
    public int deleteStuSelection(@Param("courseId") int courseId, @Param("stuId") String stuId);

    // 3. 查询一个课程的所有选中信息
    public List<CourseSelections> selectACourseById(@Param("courseId") int courseId);

    // 3. 查询一个学生的所有选课信息 （查询个人课程、生成课表）
    public List<CourseSelections> selectStuSelectionsById(@Param("stuId") String stuId);
}
