package controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.classes.*;
import service.student.CourseSelectService;
import service.student.TimeModifyService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {
    @Resource(name = "stuCourseSelectServiceImpl")
    CourseSelectService courseSelectService;
    @Resource(name = "timeModifyServiceImpl")
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
        // ps：存在优化空间，应该给与alert提示而不是直接刷新
    @RequestMapping("/StudentController/toSelectNecessaryCourse/{opType}/{opCourseType}")
    public String toSelectNecessaryCourse(@PathVariable int opType,@PathVariable int opCourseType,Model model, HttpSession session){
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
    // 1.. 提交必修课套餐选课
    //      ps：选课币的数量条件验证交给了前端
    @RequestMapping("/StudentController/submitASelectionGrouping/{groupId}/{selectionCoins}")
    public String submitASelectionGroup(@PathVariable int groupId,@PathVariable int selectionCoins,Model model,HttpSession session){
        String id= (String) session.getAttribute("id");
        boolean submitFlag = courseSelectService.tryToAddSelectionGroup(groupId, id, selectionCoins);
        if (submitFlag==true) {
            return "student/jsp/1";//提交成功返回上一级
        }else {
            model.addAttribute("msg","error");//传递时间段错误信息，可以在前端根据msg判断
            return "student/jsp/1_1";//存在优化空间，应该给与alert提示而不是直接刷新
        }
    }



    // 1.2 转到专业选修课选课
    @RequestMapping("/StudentController/toSelectSelectiveCourse/{opType}/{opCourseType}")
    public String toSelectSelectiveCourse(@PathVariable int opType,@PathVariable int opCourseType,Model model, HttpSession session){
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
    @RequestMapping("/StudentController/toSelectSelectiveCourseDes/{className}")
    public String toSelectSelectiveCourseDes(@PathVariable String className,Model model){
        List<DepartmentCourse> selectiveCourseList = courseSelectService.selectSelectiveByCourseName(className);
        model.addAttribute("selectiveCourseList",selectiveCourseList);
        return "student/jsp/1_2_";
    }
    // 1.2.. 提交专业课选课
    @RequestMapping("/StudentController/submitASelection2/{courseId}/{selectionCoins}")
    public String submitASelection2(@PathVariable int courseId, @PathVariable int selectionCoins,Model model,HttpSession session){
        String id= (String) session.getAttribute("id");
        boolean submitFlag = courseSelectService.tryToAddSelection(courseId, id, selectionCoins);
        if (submitFlag==true){
            List<DepartmentCourse> selectiveCourseList = courseSelectService.selectSelectiveCourseUnique((String) session.getAttribute("id"));
            model.addAttribute("selectiveCourseListUnique", selectiveCourseList);
            return "student/jsp/1_2";
        }else {
            model.addAttribute("msg","error");//传递选课失败错误信息，可以在前端根据msg判断
            return "student/jsp/1_2_";//存在优化空间，应该给与alert提示而不是直接刷新
        }
    }



    // 1.3 转到体育课选课
    @RequestMapping("/StudentController/toSelectPECourse/{opType}/{opCourseType}")
    public String toSelectPECourse(@PathVariable int opType,@PathVariable int opCourseType,Model model, HttpSession session){
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
    @RequestMapping("/StudentController/toSelectPECourseDes/{className}")
    public String toSelectPECourseDes(@PathVariable String className, Model model){
        List<PeCourse> peCourseList = courseSelectService.selectPeByCourseName(className);
        model.addAttribute("peCourseList", peCourseList);
        return "student/jsp/1_3_";
    }
    // 1.3.. 提交体育课选课
    @RequestMapping("/StudentController/submitASelection3/{courseId}/{selectionCoins}")
    public String submitASelection3(@PathVariable int courseId, @PathVariable int selectionCoins,Model model,HttpSession session){
        String id= (String) session.getAttribute("id");
        boolean submitFlag = courseSelectService.tryToAddSelection(courseId, id, selectionCoins);
        if (submitFlag==true){
            List<PeCourse> peCourses = courseSelectService.selectAllPeCourse();
            model.addAttribute("peCourseListUnique", peCourses);
            return "student/jsp/1_3";
        }else {
            model.addAttribute("msg","error");//传递选课失败错误信息，可以在前端根据msg判断
            return "student/jsp/1_3_";//存在优化空间，应该给与alert提示而不是直接刷新
        }
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
    @RequestMapping("/StudentController/toSelectPublicCourseDes/{className}")
    public String toSelectPublicCourseDes(@PathVariable String className, Model model){
        List<PublicCourse> publicCourseList = courseSelectService.selectPublicByCourseName(className);
        model.addAttribute("publicCourseList", publicCourseList);
        return "student/jsp/1_4_";
    }
    // 1.4.. 提交公选课选课
    @RequestMapping("/StudentController/submitASelection4/{courseId}/{selectionCoins}")
    public String submitASelection4(@PathVariable int courseId, @PathVariable int selectionCoins,Model model,HttpSession session){
        String id= (String) session.getAttribute("id");
        boolean submitFlag = courseSelectService.tryToAddSelection(courseId, id, selectionCoins);
        if (submitFlag==true){
            List<PublicCourse> publicCourses = courseSelectService.selectPublicCourseUnique();
            model.addAttribute("publicCourseListUnique", publicCourses);
            return "student/jsp/1_4";
        }else {
            model.addAttribute("msg","error");//传递选课失败信息，可以在前端根据msg判断
            return "student/jsp/1_4_";//存在优化空间，应该给与alert提示而不是直接刷新
        }
    }



    // 2. 转到查询个人课程信息
        // ps：依次链表：必修、专业选修、体育、公选
    @RequestMapping("/StudentController/toSelectInfo/{stuId}")
    public String toSelectInfo(@PathVariable String stuId,Model model){
        AllSelectedCourse allSelectedCourse = courseSelectService.selectMyAllSelectedCourse(stuId);
        model.addAttribute("allSelectedCourse",allSelectedCourse);
        return "student/jsp/2";
    }

    // 2.1 退课
        // ps：必修课不能退课（已在前端拦截），其他都能
    @RequestMapping("/StudentController/submitAReturn/{courseId}")
    public String submitAReturn(@PathVariable int courseId,Model model,HttpSession session){
        String id= (String) session.getAttribute("id");
        courseSelectService.returnACourseById(courseId,id);
        AllSelectedCourse allSelectedCourse = courseSelectService.selectMyAllSelectedCourse(id);
        model.addAttribute("allSelectedCourse",allSelectedCourse);
        return "student/jsp/2";
    }

    // 3. 转到课表
    @RequestMapping("/StudentController/toSelectTable")
    public String toSelectTable(Model model,HttpSession session){
        model.addAttribute("msg",session.getAttribute("name")+"的课表");
        return "student/jsp/3";
    }
}
