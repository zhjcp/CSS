package service.adminS;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    // 测试查找要计算选课结果的课程 专业选修
    public void testSelectCalculate2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        SelectionsUpdateService sUPL = (SelectionsUpdateService) context.getBean("selectionsUpdateServiceImpl");
        sUPL.calculateSelectiveResult2();
    }

    @org.junit.Test
    // 测试查找要计算选课结果的课程 体育选修
    public void testSelectCalculate3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        SelectionsUpdateService sUPL = (SelectionsUpdateService) context.getBean("selectionsUpdateServiceImpl");
        sUPL.calculateSelectiveResult3();
    }

    @org.junit.Test
    // 测试查找要计算选课结果的课程 公选选修
    public void testSelectCalculate4(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        SelectionsUpdateService sUPL = (SelectionsUpdateService) context.getBean("selectionsUpdateServiceImpl");
        sUPL.calculateSelectiveResult4();
    }
}
