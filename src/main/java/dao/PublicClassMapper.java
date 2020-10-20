package dao;

import pojo.classes.PublicClass;

import java.util.List;

public interface PublicClassMapper {
    //查询所有的公选课
    public List<PublicClass> selectAllPublicCourse();
}
