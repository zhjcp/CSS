package dao.classDao;

import org.apache.ibatis.annotations.Param;
import pojo.classes.DepartmentCourse;
import pojo.classes.PeCourse;

import java.util.List;

public interface PeCourseMapper {
    //查询所有的体育课(需要什么限制吗？？？)
    public List<PeCourse> selectAllPeCourse();
    //查找一门体育的所有课堂（同一门课，不同老师）
    List<PeCourse> selectPeCourseByName(@Param("name") String name);
    //按id查找一门课程
    public PeCourse selectByCourseId(@Param("id") int id);
    //增加一个课堂的已选人数
    public void updateStuNum(@Param("id") int id,@Param("stuNum") int stuNum);
    //查找stuNum > capacity的课堂   用处：根据找到的课堂的id去selections表中找到所有该课程的count
    public List<Integer> selectCalculatingCourse();
}
