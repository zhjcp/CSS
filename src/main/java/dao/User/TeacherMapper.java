package dao.User;

import org.apache.ibatis.annotations.Param;
import pojo.Student;
import pojo.Teacher;

public interface TeacherMapper {
    //根据id查询
    public Teacher selectById(@Param("id") String id);
}
