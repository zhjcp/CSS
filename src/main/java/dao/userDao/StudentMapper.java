package dao.userDao;

import org.apache.ibatis.annotations.Param;
import pojo.user.Student;

public interface StudentMapper {
    //根据id查询
    public Student selectById(@Param("id") String id);
}
