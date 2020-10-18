package service.administrator_d;

import dao.User.AdminDMapper;
import dao.User.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import pojo.AdminD;
import pojo.Student;

public class LoginModify {
    //service层调用dao层的方法操作数据库，需要一个Mapper实例
    @Autowired
    @Qualifier("adminDMapper")
    AdminDMapper adminDMapper;

    public void setAdminDMapper(AdminDMapper adminDMapper) {
        this.adminDMapper = adminDMapper;
    }


    public AdminD loginModify(String id, String pwd){
        AdminD adminD = adminDMapper.selectById(id);
        if (adminD==null){
            return null;//用户不存在，提示：用户不存在或密码错误
        }else {
            if (!pwd.equals(adminD.getPwd())){
                return null;//密码错误，提示：用户不存在或密码错误
            }else {
                return adminD;
            }
        }
    }
}
