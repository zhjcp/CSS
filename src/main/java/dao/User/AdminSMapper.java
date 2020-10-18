package dao.User;

import org.apache.ibatis.annotations.Param;
import pojo.AdminS;

public interface AdminSMapper {
    //根据id查询
    public AdminS selectById(@Param("id") String id);
}
