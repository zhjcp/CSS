package service.student;

import dao.userDao.StudentMapper;
import pojo.user.Student;

public class LoginModify {
    //service层调用dao层的方法操作数据库，需要一个Mapper实例
    StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public Student loginModify(String id, String pwd){
        Student student = studentMapper.selectById(id);
        if (student==null){
            return null;//用户不存在，提示：用户不存在或密码错误
        }else {
            if (!pwd.equals(student.getPwd())){
                return null;//密码错误，提示：用户不存在或密码错误
            }else {
                return student;
            }
        }
    }
}
