package dao.User;

import org.apache.ibatis.annotations.Param;
import pojo.AdminD;

public interface AdminDMapper {
    //根据id查询
    public AdminD selectById(@Param("id") String id);
}
