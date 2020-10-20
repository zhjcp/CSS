package dao;

import pojo.classes.PeClass;

import java.util.List;

public interface PeClassMapper {
    //查询所有的体育课(需要什么限制吗？？？)
    public List<PeClass> selectAllPECourse();
}
