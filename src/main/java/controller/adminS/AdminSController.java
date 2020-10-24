package controller.adminS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.adminS.SelectionsUpdateService;

import javax.annotation.Resource;

@Controller
public class AdminSController {
    @Resource(name = "selectionsUpdateServiceImpl")
    SelectionsUpdateService selectionsUpdateService;


    // 计算必修课的选课结果
    @RequestMapping("/AdminSController/calculateSelectionResult1")
    public String calculateSelectionResult1(){
        boolean f = selectionsUpdateService.calculateSelectiveResult1();
        return "adminD/jsp/index";
    }

    // 计算专业选修课的选课结果
    @RequestMapping("/AdminSController/calculateSelectionResult2")
    public String calculateSelectionResult2(){
        boolean f = selectionsUpdateService.calculateSelectiveResult2();
        return "adminD/jsp/index";
    }

    // 计算必修课的选课结果
    @RequestMapping("/AdminSController/calculateSelectionResult3")
    public String calculateSelectionResult3(){
        boolean f = selectionsUpdateService.calculateSelectiveResult3();
        return "adminD/jsp/index";
    }

    // 计算必修课的选课结果
    @RequestMapping("/AdminSController/calculateSelectionResult4")
    public String calculateSelectionResult4(){
        boolean f = selectionsUpdateService.calculateSelectiveResult4();
        return "adminD/jsp/index";
    }
}
