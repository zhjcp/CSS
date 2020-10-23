package dao.userDao;

import org.apache.ibatis.annotations.Param;
import pojo.user.Teacher;

public interface TeacherMapper {
    //根据id查询
    public Teacher selectById(@Param("id") String id);
    //根据name查询（缺点：可能有重名的，改进：用更多项数据进行匹配）
    public Teacher selectByName(@Param("name") String name);
}
