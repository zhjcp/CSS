package dao.classDao;

import org.apache.ibatis.annotations.Param;
import pojo.classes.PeClass;
import pojo.classes.PublicClass;

import java.util.List;

public interface PeClassMapper {
    //查询所有的体育课(需要什么限制吗？？？)
    public List<PeClass> selectAllPeClass();
    //查找一门体育的所有课堂（同一门课，不同老师）
    List<PeClass> selectPeClassByName(@Param("name") String name);
}
