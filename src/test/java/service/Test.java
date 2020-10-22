package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.classes.NecessaryClassGroup;
import pojo.classes.PeClass;
import pojo.classes.PublicClass;
import service.student.CourseSelectService;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    @org.junit.Test
    //测试必修课套餐分类 成功！
    public void testGroping(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseSelectService stuCourseSelectServiceImpl = (CourseSelectService) context.getBean("stuCourseSelectServiceImpl");
        List<NecessaryClassGroup> departmentClasses = stuCourseSelectServiceImpl.selectNecessaryCourseById("ST000001");
        System.out.println(departmentClasses);
    }

    @org.junit.Test
    //测试时间戳
    //结果：java.sql.Date 使用时间戳初始化之后只有“年-月-日”
    public void testTimeStamps(){
        Date date1 = new Date(Long.parseLong("1603345529973"));
        System.out.println(date1);


        Date date2 = new Date(Long.parseLong("1608365549973"));
        System.out.println(date2);

        System.out.println(date2.compareTo(date1));//大于 =1
    }

    //map测试
    @org.junit.Test
    public void testMap(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseSelectService stuCourseSelectServiceImpl = (CourseSelectService) context.getBean("stuCourseSelectServiceImpl");
        List<PublicClass> publicClassList = stuCourseSelectServiceImpl.selectPublicCourseUnique();
        System.out.println(publicClassList);

        List<PeClass> peClassList = stuCourseSelectServiceImpl.selectPeCourseUnique();
        System.out.println(peClassList);
    }
}
