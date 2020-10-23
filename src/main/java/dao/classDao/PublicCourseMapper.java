package dao.classDao;

import org.apache.ibatis.annotations.Param;
import pojo.classes.PublicCourse;

import java.util.List;

public interface PublicCourseMapper {
    //查询所有的公选课
    public List<PublicCourse> selectAllPublicCourse();
    //查找一门公选课的所有课堂（同一门课，不同老师）
    List<PublicCourse> selectPublicCourseByName(@Param("name") String name);
}
