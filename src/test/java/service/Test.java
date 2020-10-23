package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.classes.DepartmentCourse;
import pojo.classes.NecessaryCourseGroup;
import pojo.classes.PeCourse;
import pojo.classes.PublicCourse;
import service.student.CourseSelectService;
import service.student.TimeModifyService;

import java.sql.Date;
import java.util.List;

public class Test {
    @org.junit.Test
    //测试必修课套餐分类 成功！
    public void testGroping(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseSelectService stuCourseSelectServiceImpl = (CourseSelectService) context.getBean("stuCourseSelectServiceImpl");
        List<NecessaryCourseGroup> departmentClasses = stuCourseSelectServiceImpl.selectNecessaryCourseGrouping("ST000001");
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
        List<PublicCourse> publicCourseList = stuCourseSelectServiceImpl.selectPublicCourseUnique();
        System.out.println(publicCourseList);

        List<PeCourse> peCourseList = stuCourseSelectServiceImpl.selectPeCourseUnique();
        System.out.println(peCourseList);
    }

    //CourseSelectService 单元测试
    @org.junit.Test
    public void testSelect(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseSelectService stuCourseSelectServiceImpl = (CourseSelectService) context.getBean("stuCourseSelectServiceImpl");
        // 1. 必修
        List<NecessaryCourseGroup> necessaryCourseGroupList = stuCourseSelectServiceImpl.selectNecessaryCourseGrouping("ST000001");
        System.out.println(necessaryCourseGroupList);
        System.out.println("======================================");
        // 2. 专业选修
        List<DepartmentCourse> departmentCourseList1 = stuCourseSelectServiceImpl.selectSelectiveCourseUnique("ST000001");
        System.out.println(departmentCourseList1);
        List<DepartmentCourse> departmentCourseList2 = stuCourseSelectServiceImpl.selectSelectiveByCourseName("离散数学");
        System.out.println(departmentCourseList2);
        System.out.println("=======================================");
        // 3. 体育
        List<PeCourse> peCourseList1 = stuCourseSelectServiceImpl.selectPeCourseUnique();
        System.out.println(peCourseList1);
        List<PeCourse> peCourseList2 = stuCourseSelectServiceImpl.selectPeByCourseName("篮球");
        System.out.println(peCourseList2);
        System.out.println("=======================================");
        // 4. 公选
        List<PublicCourse> publicCourseList1 = stuCourseSelectServiceImpl.selectPublicCourseUnique();
        System.out.println(publicCourseList1);
        List<PublicCourse> publicCourseList2 = stuCourseSelectServiceImpl.selectPublicByCourseName("秦汉历史人物研究");
        System.out.println(publicCourseList2);
    }

    @org.junit.Test
    public void testTime(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        TimeModifyService timeModifyService = (TimeModifyService) context.getBean("timeModifyServiceImpl");
        boolean st000001 = timeModifyService.modifyOpTime(1, 3, "ST000001");
        System.out.println(st000001);
    }

    @org.junit.Test
    //测试提交公选课选课
    public void testSubmit1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseSelectService sCSSI = (CourseSelectService) context.getBean("stuCourseSelectServiceImpl");
        boolean f1 = sCSSI.tryToAddSelection(20002, "ST000001", 20);
        System.out.println("======="+f1);
    }

    @org.junit.Test
    //测试提交体育课选课
    public void testSubmit2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseSelectService sCSSI = (CourseSelectService) context.getBean("stuCourseSelectServiceImpl");
        boolean f = sCSSI.tryToAddSelection(10001, "ST000001", 20);
        System.out.println("======="+f);
    }

    @org.junit.Test
    //测试专业选修课选课
    public void testSubmit3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseSelectService sCSSI = (CourseSelectService) context.getBean("stuCourseSelectServiceImpl");
        boolean f = sCSSI.tryToAddSelection(5, "ST000001", 20);
        System.out.println("======="+f);
    }

    @org.junit.Test
    public void testSubmit4(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseSelectService sCSSI = (CourseSelectService) context.getBean("stuCourseSelectServiceImpl");
        boolean f2 = sCSSI.tryToAddSelectionGroup(1, "ST000001", 20);
        System.out.println("======="+f2);
    }

    @org.junit.Test
    public void testSelectMyAllSelectedCourse(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseSelectService sCSSI = (CourseSelectService) context.getBean("stuCourseSelectServiceImpl");
        sCSSI.selectMyAllSelectedCourse("ST000001");
    }
}
