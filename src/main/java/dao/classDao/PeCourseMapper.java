package dao.classDao;

import org.apache.ibatis.annotations.Param;
import pojo.classes.PeCourse;

import java.util.List;

public interface PeCourseMapper {
    //查询所有的体育课(需要什么限制吗？？？)
    public List<PeCourse> selectAllPeCourse();
    //查找一门体育的所有课堂（同一门课，不同老师）
    List<PeCourse> selectPeCourseByName(@Param("name") String name);
}
