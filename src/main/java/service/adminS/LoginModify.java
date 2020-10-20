package service.adminS;
import dao.AdminSMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.user.AdminS;

@Service("adminSLoginModify")
public class LoginModify {
    //service层调用dao层的方法操作数据库，需要一个Mapper实例
    @Autowired
    @Qualifier("adminSMapper")
    AdminSMapper adminSMapper;

    public void setAdminSMapper(AdminSMapper adminSMapper) {
        this.adminSMapper = adminSMapper;
    }


    public AdminS loginModify(String id, String pwd){
        AdminS adminS = adminSMapper.selectById(id);
        if (adminS==null){
            return null;//用户不存在，提示：用户不存在或密码错误
        }else {
            if (!pwd.equals(adminS.getPwd())){
                return null;//密码错误，提示：用户不存在或密码错误
            }else {
                return adminS;
            }
        }
    }
}
