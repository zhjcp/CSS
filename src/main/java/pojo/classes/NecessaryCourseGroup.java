package pojo.classes;

import java.util.ArrayList;
import java.util.List;

/*
* 作用：一个NecessaryClassGroup对象代表一组必修课，也就是一个“套餐”
* */
public class NecessaryCourseGroup {
    //一个套餐中的课程列表
    private List<DepartmentCourse> courseList;

    public NecessaryCourseGroup() {
        this.courseList =new ArrayList<>();
    }


    public List<DepartmentCourse> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<DepartmentCourse> courseList) {
        this.courseList = courseList;
    }

    public void addNecessaryCourse(DepartmentCourse departmentCourse){
        this.courseList.add(departmentCourse);
    }

    @Override
    public String toString() {
        return "NecessaryCourseGroup{" +
                "classList=" + courseList +
                '}';
    }
}
