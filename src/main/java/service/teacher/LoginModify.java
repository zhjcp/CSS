package service.teacher;

import dao.User.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.Teacher;

@Service
public class LoginModify {
    //service层调用dao层的方法操作数据库，需要一个Mapper实例
    @Autowired
    @Qualifier("teacherMapper")
    TeacherMapper teacherMapper;

    public Teacher loginModify(String id, String pwd){
        Teacher teacher = teacherMapper.selectById(id);
        if (teacher==null){
            return null;//用户不存在，提示：用户不存在或密码错误
        }else {
            if (!pwd.equals(teacher.getPwd())){
                return null;//密码错误，提示：用户不存在或密码错误
            }else {
                return teacher;
            }
        }
    }
}
