package controller.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.user.AdminD;
import pojo.user.AdminS;
import pojo.user.Student;
import pojo.user.Teacher;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    //service层实例
    @Resource(name = "stuLoginModify")
    service.student.LoginModify stuLoginModify;
    @Resource(name = "teaLoginModify")
    service.teacher.LoginModify teaLoginModify;
    @Resource(name = "adminDLoginModify")
    service.adminD.LoginModify adminDLoginModify;
    @Resource(name = "adminSLoginModify")
    service.adminS.LoginModify adminSLoginModify;

    //登录控制
    @RequestMapping(value = "/LoginController/login",method = RequestMethod.POST)
    public String login(String id, String pwd, Model model, HttpSession session){
        System.out.println("===========");
        System.out.println(id+"   "+pwd);
        //根据id前缀对用户身份分类处理
        switch (id.substring(0, 2)) {
            case "MD": {
                //校级管理员
                AdminD adminD = adminDLoginModify.loginModify(id, pwd);
                if (adminD != null) {
                    session.setAttribute("id", adminD.getId());//id可以传给前端，用来拼接头像路径
                    session.setAttribute("name", adminD.getName());
                    session.removeAttribute("error");
                    return "adminD/jsp/index";//跳转到主页
                } else {
                    System.out.println("=====没找到该院系管理员");
                    session.setAttribute("error", "账号或者密码错误!");
                    return "redirect:/index.jsp";
                }
            }
            case "MS": {
                //院级管理员
                AdminS adminS = adminSLoginModify.loginModify(id, pwd);
                if (adminS != null) {
                    session.setAttribute("id", adminS.getId());//id可以传给前端，用来拼接头像路径
                    session.setAttribute("name", adminS.getName());
                    session.removeAttribute("error");
                    return "adminS/jsp/index";//跳转到主页
                } else {
                    System.out.println("=====没找到该校级管理员");
                    session.setAttribute("error", "账号或者密码错误!");
                    return "redirect:/index.jsp";
                }
            }
            case "ST": {
                //学生
                Student stu = stuLoginModify.loginModify(id, pwd);
                if (stu != null) {
                    session.setAttribute("id", stu.getId());//id可以传给前端，用来拼接头像路径
                    session.setAttribute("name", stu.getName());
                    session.removeAttribute("error");
                    return "student/jsp/index";//跳转到主页
                } else {
                    System.out.println("=====没找到该学生");
                    session.setAttribute("error", "账号或者密码错误!");
                    return "redirect:/index.jsp";
                }
            }
            case "TE": {
                //老师
                Teacher tea = teaLoginModify.loginModify(id, pwd);
                if (tea != null) {
                    session.setAttribute("id", tea.getId());
                    session.setAttribute("name", tea.getName());
                    session.removeAttribute("error");
                    return "teacher/jsp/index";//跳转到主页
                } else {
                    session.setAttribute("error", "账号或者密码错误!");
                    return "redirect:/index.jsp";
                }
            }
            default: {
                //啥身份也不是
                session.setAttribute("error", "账号或者密码错误!");
                return "redirect:/index.jsp";
            }
        }
    }

}
