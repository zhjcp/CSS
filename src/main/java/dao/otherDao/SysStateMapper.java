package dao.otherDao;

import org.apache.ibatis.annotations.Param;
import pojo.other.SysState;

public interface SysStateMapper {
    //1. 根据学院名字、操作课程类型 查找SysState
    public SysState selectSysStateByName(@Param("departmentName") String departmentName,@Param("opCourseType") int opCourseType);
}
