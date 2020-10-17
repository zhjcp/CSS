package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.Student;
import pojo.Teacher;
import pojo.User;
import service.student.LoginModify;

@Controller
public class LoginController {
    //service层实例
    @Autowired
    @Qualifier("stuLoginModify")
    service.student.LoginModify stuLoginModify;
    @Autowired
    @Qualifier("loginModify")
    service.teacher.LoginModify teaLoginModify;
    service.administrator_d.LoginModify dLoginModify;
    service.administrator_s.LoginModify sLoginModify;

    //登录控制
    @RequestMapping(value = "/LoginController/login",method = RequestMethod.POST)
    public String login(String id, String pwd, Model model){
        System.out.println("===========");
        System.out.println(id+"   "+pwd);

        //根据id前缀对用户身份分类处理
        if (id.substring(0,2).equals("MD")){
            //校级管理员
            model.addAttribute("error","账号或者密码错误");
            return "/index.jsp";
        }else if (id.substring(0,2).equals("MS")){
            //院级管理员
            model.addAttribute("error","账号或者密码错误");
            return "/index.jsp";
        }else if (id.substring(0,2).equals("ST")){
            //学生
            Student stu=stuLoginModify.loginModify(id, pwd);
            if(stu!=null){
                model.addAttribute("id",stu.getId());//id可以传给前端，用来拼接头像路径
                model.addAttribute("name",stu.getName());
                return "student/jsp/index";//跳转到主页
            }else {
                System.out.println("=====没找到该学生");
                model.addAttribute("error","账号或者密码错误");
                return "redirect:/index.jsp";
            }
        }else if (id.substring(0,2).equals("TE")){
            //老师
            Teacher tea = teaLoginModify.loginModify(id, pwd);
            if (tea!=null){
                model.addAttribute("id",tea.getId());
                model.addAttribute("name",tea.getName());
                return "teacher/jsp/index";//跳转到主页
            }else {
                model.addAttribute("error","账号或者密码错误");
                return "redirect:/index.jsp";
            }
        }else {
            //啥身份也不是
            model.addAttribute("error","账号或者密码错误");
            return "/index.jsp";
        }
    }

}
