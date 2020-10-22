package dao.userDao;

import org.apache.ibatis.annotations.Param;
import pojo.user.AdminS;

public interface AdminSMapper {
    //根据id查询
    public AdminS selectById(@Param("id") String id);
}
