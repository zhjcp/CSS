package controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.classes.DepartmentClass;
import pojo.classes.NecessaryClassGroup;
import pojo.classes.PeClass;
import pojo.classes.PublicClass;
import service.student.CourseSelectService;
import service.student.TimeModifyService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    @Qualifier("stuCourseSelectServiceImpl")
    CourseSelectService courseSelectService;
    @Autowired
    @Qualifier("timeModifyServiceImpl")
    TimeModifyService timeModifyService;

    /*
     * ps：点击某项选课操作之后，第一步是判断是否在该选课期之内
     *       不在选课期间就在当前页面alert弹出提示（jQuery ajax），否则直接跳转
     * */

    // 1.转到选课
    @RequestMapping("/StudentController/toSelectCourse")
    public String toSelectCourse(){
            return "student/jsp/1";
    }


    // 1.1 转到必修课选课
        //存在优化空间，应该给与alert提示而不是直接刷新
    @RequestMapping("/StudentController/toSelectNecessaryCourse")
    public String toSelectNecessaryCourse(int opType,int opCourseType,Model model, HttpSession session){
        // 加一层时间验证
        String id= (String) session.getAttribute("id");
        boolean timeFlag=timeModifyService.modifyOpTime(opType,opCourseType,id);
        if (timeFlag==true) {
            List<NecessaryClassGroup> necessaryClassGroups = courseSelectService.selectNecessaryCourseById((String) session.getAttribute("id"));
            model.addAttribute("necessaryClassGroups", necessaryClassGroups);
            return "student/jsp/1_1";
        }else {
            model.addAttribute("msg","error");//传递时间段错误信息，可以在前端根据msg判断
            return "student/jsp/1";//存在优化空间，应该给与alert提示而不是直接刷新
        }
    }

    // 1.2 转到专业选修课选课
    @RequestMapping("/StudentController/toSelectSelectiveCourse")
    public String toSelectSelectiveCourse(Model model,HttpSession session){
        List<DepartmentClass> selectiveCourses = courseSelectService.selectSelectiveCourseById((String) session.getAttribute("id"));
        model.addAttribute("selectiveCourses",selectiveCourses);
        return "student/jsp/1_2";
    }
    // 1.2. 转到专业选修课详情
    @RequestMapping("/StudentController/toSelectSelectiveCourseDes")
    public String toSelectSelectiveCourseDes(){
        return "student/jsp/1_2_";
    }


    // 1.3 转到体育课选课
    @RequestMapping("/StudentController/toSelectPECourse")
    public String toSelectPECourse(int opType,int opCourseType,Model model, HttpSession session){
        // 加一层时间验证
        String id= (String) session.getAttribute("id");
        boolean timeFlag=timeModifyService.modifyOpTime(opType,opCourseType,id);
        if(timeFlag==true) {
            List<PeClass> pe_classes = courseSelectService.selectAllPECourse();
            model.addAttribute("pE_Classes", pe_classes);
            return "student/jsp/1_3";
        }else {
            model.addAttribute("msg","error");//传递时间段错误信息，可以在前端根据msg判断
            return "student/jsp/1";//存在优化空间，应该给与alert提示而不是直接刷新
        }
    }
    // 1.3. 转到体育课详情
    @RequestMapping("/StudentController/toSelectPECourseDes")
    public String toSelectPECourseDes(String className, Model model){
        List<PeClass> peClassList = courseSelectService.selectPeCourseByName(className);
        model.addAttribute("peClassList",peClassList);
        return "student/jsp/1_3_";
    }


    // 1.4 转到公选课选课
        //存在优化空间，应该给与alert提示而不是直接刷新
    @RequestMapping("/StudentController/toSelectPublicCourse")
    public String toSelectPublicCourse(int opType,int opCourseType,Model model, HttpSession session){
        // 加一层时间验证
        String id= (String) session.getAttribute("id");
        boolean timeFlag=timeModifyService.modifyOpTime(opType,opCourseType,id);
        if(timeFlag==true) {
            List<PublicClass> publicClasses = courseSelectService.selectPublicCourseUnique();
            model.addAttribute("publicClasses", publicClasses);
            return "student/jsp/1_4";
        }else {
            model.addAttribute("msg","error");//传递时间段错误信息，可以在前端根据msg判断
            return "student/jsp/1";//存在优化空间，应该给与alert提示而不是直接刷新
        }
    }
    // 1.4. 转到公选课详情
    @RequestMapping("/StudentController/toSelectPublicCourseDes")
    public String toSelectPublicCourseDes(String className, Model model){
        List<PublicClass> publicClassList = courseSelectService.selectPublicCourseByName(className);
        model.addAttribute("publicClassList",publicClassList);
        return "student/jsp/1_4_";
    }


    // 2. 转到查询个人课程信息
    @RequestMapping("/StudentController/toSelectInfo")
    public String toSelectInfo(){
        return "student/jsp/2";
    }


    // 3. 转到课表
    @RequestMapping("/StudentController/toSelectTable")
    public String toSelectTable(){
        return "student/jsp/3";
    }
}
