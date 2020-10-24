package service.adminD;

import dao.userDao.AdminDMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.user.AdminD;

import javax.annotation.Resource;

@Service("adminDLoginModify")
public class LoginModify {
    //service层调用dao层的方法操作数据库，需要一个Mapper实例
    @Resource(name = "adminDMapper")
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
