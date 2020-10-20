package controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.classes.DepartmentClass;
import pojo.classes.PeClass;
import pojo.classes.PublicClass;
import service.student.CourseSelectService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    @Qualifier("stuCourseSelectServiceImpl")
    CourseSelectService courseSelectService;

    // 1.转到选课
    @RequestMapping("/StudentController/toSelectCourse")
    public String toSelectCourse(){
        return "student/jsp/1";
    }

    // 1.1 转到必修课选课
    @RequestMapping("/StudentController/toSelectNecessaryCourse")
    public String toSelectNecessaryCourse(Model model, HttpSession session){
        List<DepartmentClass> department_classes = courseSelectService.selectNecessaryCourseById((String) session.getAttribute("id"));
        model.addAttribute("necessaryCourses",department_classes);
        return "student/jsp/1_1";
    }

    // 1.2 转到专业选修课选课
    @RequestMapping("/StudentController/toSelectSelectiveCourse")
    public String toSelectSelectiveCourse(Model model,HttpSession session){
        List<DepartmentClass> department_classes = courseSelectService.selectSelectiveCourseById((String) session.getAttribute("id"));
        model.addAttribute("selectiveCourses",department_classes);
        return "student/jsp/1_2";
    }

    // 1.2. 转到专业选修课详情
    @RequestMapping("/StudentController/toSelectSelectiveCourseDes")
    public String toSelectSelectiveCourseDes(){
        return "student/jsp/1_2_";
    }

    // 1.3 转到体育课选课
    @RequestMapping("/StudentController/toSelectPECourse")
    public String toSelectPECourse(Model model){
        List<PeClass> pe_classes = courseSelectService.selectAllPECourse();
        model.addAttribute("pE_Classes",pe_classes);
        return "student/jsp/1_3";
    }
    // 1.3. 转到体育课详情
    @RequestMapping("/StudentController/toSelectPECourseDes")
    public String toSelectPECourseDes(){
        return "student/jsp/1_3_";
    }

    // 1.4 转到公选课选课
    @RequestMapping("/StudentController/toSelectPublicCourse")
    public String toSelectPublicCourse(Model model){
        List<PublicClass> publicClasses = courseSelectService.selectAllPublicCourse();
        model.addAttribute("publicClasses",publicClasses);
        return "student/jsp/1_4";
    }
    // 1.4. 转到公选课详情
    @RequestMapping("/StudentController/toSelectPublicCourseDes")
    public String toSelectPublicCourseDEs(){
        return "student/jsp/1_4_";
    }

    // 2. 转到查询
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
