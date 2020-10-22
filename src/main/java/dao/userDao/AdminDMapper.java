package dao.userDao;

import org.apache.ibatis.annotations.Param;
import pojo.user.AdminD;

public interface AdminDMapper {
    //根据id查询
    public AdminD selectById(@Param("id") String id);
}
