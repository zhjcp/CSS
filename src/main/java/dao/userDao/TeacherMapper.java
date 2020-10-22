package dao.userDao;

import org.apache.ibatis.annotations.Param;
import pojo.user.Teacher;

public interface TeacherMapper {
    //根据id查询
    public Teacher selectById(@Param("id") String id);
}
