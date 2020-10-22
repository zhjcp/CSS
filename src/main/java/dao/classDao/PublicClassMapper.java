package dao.classDao;

import org.apache.ibatis.annotations.Param;
import pojo.classes.PublicClass;

import java.util.List;

public interface PublicClassMapper {
    //查询所有的公选课
    public List<PublicClass> selectAllPublicCourse();
    //查找一门公选课的所有课堂（同一门课，不同老师）
    List<PublicClass> selectPublicCourseByName(@Param("name") String name);
}
