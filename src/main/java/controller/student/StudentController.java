package controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.classes.DepartmentCourse;
import pojo.classes.NecessaryCourseGroup;
import pojo.classes.PeCourse;
import pojo.classes.PublicCourse;
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
            List<NecessaryCourseGroup> necessaryCourseGroups = courseSelectService.selectNecessaryCourseGrouping((String) session.getAttribute("id"));
            model.addAttribute("necessaryCourseGroups", necessaryCourseGroups);
            return "student/jsp/1_1";
        }else {
            model.addAttribute("msg","error");//传递时间段错误信息，可以在前端根据msg判断
            return "student/jsp/1";//存在优化空间，应该给与alert提示而不是直接刷新
        }
    }

    // 1.2 转到专业选修课选课
    @RequestMapping("/StudentController/toSelectSelectiveCourse")
    public String toSelectSelectiveCourse(int opType,int opCourseType,Model model, HttpSession session){
        // 加一层时间验证
        String id= (String) session.getAttribute("id");
        boolean timeFlag=timeModifyService.modifyOpTime(opType,opCourseType,id);
        if (timeFlag==true) {
            List<DepartmentCourse> selectiveCourseList = courseSelectService.selectSelectiveCourseUnique((String) session.getAttribute("id"));
            model.addAttribute("selectiveCourseListUnique", selectiveCourseList);
            return "student/jsp/1_2";
        }else {
            model.addAttribute("msg","error");//传递时间段错误信息，可以在前端根据msg判断
            return "student/jsp/1";//存在优化空间，应该给与alert提示而不是直接刷新
        }
    }
    // 1.2. 转到专业选修课详情
    @RequestMapping("/StudentController/toSelectSelectiveCourseDes")
    public String toSelectSelectiveCourseDes(String className,Model model){
        List<DepartmentCourse> selectiveCourseList = courseSelectService.selectSelectiveByCourseName(className);
        model.addAttribute("selectiveCourseList",selectiveCourseList);
        return "student/jsp/1_2_";
    }


    // 1.3 转到体育课选课
    @RequestMapping("/StudentController/toSelectPECourse")
    public String toSelectPECourse(int opType,int opCourseType,Model model, HttpSession session){
        // 加一层时间验证
        String id= (String) session.getAttribute("id");
        boolean timeFlag=timeModifyService.modifyOpTime(opType,opCourseType,id);
        if(timeFlag==true) {
            List<PeCourse> peCourses = courseSelectService.selectAllPeCourse();
            model.addAttribute("peCourseListUnique", peCourses);
            return "student/jsp/1_3";
        }else {
            model.addAttribute("msg","error");//传递时间段错误信息，可以在前端根据msg判断
            return "student/jsp/1";//存在优化空间，应该给与alert提示而不是直接刷新
        }
    }
    // 1.3. 转到体育课详情
    @RequestMapping("/StudentController/toSelectPECourseDes")
    public String toSelectPECourseDes(String className, Model model){
        List<PeCourse> peCourseList = courseSelectService.selectPeByCourseName(className);
        model.addAttribute("peCourseList", peCourseList);
        return "student/jsp/1_3_";
    }


    // 1.4 转到公选课选课
        //存在优化空间，应该给与alert提示而不是直接刷新
    @RequestMapping("/StudentController/toSelectPublicCourse/{opType}/{opCourseType}")
    public String toSelectPublicCourse(@PathVariable int opType, @PathVariable int opCourseType, Model model, HttpSession session){
        // 加一层时间验证
        String id= (String) session.getAttribute("id");
        boolean timeFlag=timeModifyService.modifyOpTime(opType,opCourseType,id);
        System.out.println(timeFlag);
        if(timeFlag==true) {
            List<PublicCourse> publicCourses = courseSelectService.selectPublicCourseUnique();
            model.addAttribute("publicCourseListUnique", publicCourses);
            return "student/jsp/1_4";
        }else {
            model.addAttribute("msg","error");//传递时间段错误信息，可以在前端根据msg判断
            return "student/jsp/1";//存在优化空间，应该给与alert提示而不是直接刷新
        }
    }
    // 1.4. 转到公选课详情
    @RequestMapping("/StudentController/toSelectPublicCourseDes")
    public String toSelectPublicCourseDes(String className, Model model){
        List<PublicCourse> publicCourseList = courseSelectService.selectPublicByCourseName(className);
        model.addAttribute("publicCourseList", publicCourseList);
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
