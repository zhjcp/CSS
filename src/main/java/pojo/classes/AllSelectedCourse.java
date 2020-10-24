package pojo.classes;

import java.util.List;

public class AllSelectedCourse {
    // 1. 一个学生的必修课列表
    private List<Course> necessaryCourseList;
    // 2. 一个学生的专业选修课列表
    private List<Course> selectiveCourseList;
    // 3. 一个学生的体育课列表
    private List<Course> peCourseList;
    // 4.  一个学生的公选课列表
    private List<Course> publicCourseList;

    public AllSelectedCourse() {
    }

    public AllSelectedCourse(List<Course> necessaryCourseList, List<Course> selectiveCourseList, List<Course> peCourseList, List<Course> publicCourseList) {
        this.necessaryCourseList = necessaryCourseList;
        this.selectiveCourseList = selectiveCourseList;
        this.peCourseList = peCourseList;
        this.publicCourseList = publicCourseList;
    }

    public List<Course> getNecessaryCourseList() {
        return necessaryCourseList;
    }

    public void setNecessaryCourseList(List<Course> necessaryCourseList) {
        this.necessaryCourseList = necessaryCourseList;
    }

    public List<Course> getSelectiveCourseList() {
        return selectiveCourseList;
    }

    public void setSelectiveCourseList(List<Course> selectiveCourseList) {
        this.selectiveCourseList = selectiveCourseList;
    }

    public List<Course> getPeCourseList() {
        return peCourseList;
    }

    public void setPeCourseList(List<Course> peCourseList) {
        this.peCourseList = peCourseList;
    }

    public List<Course> getPublicCourseList() {
        return publicCourseList;
    }

    public void setPublicCourseList(List<Course> publicCourseList) {
        this.publicCourseList = publicCourseList;
    }

    @Override
    public String toString() {
        return "AllSelectedCourse{" +
                "necessaryCourseList=" + necessaryCourseList +
                ", selectiveCourseList=" + selectiveCourseList +
                ", peCourseList=" + peCourseList +
                ", publicCourseList=" + publicCourseList +
                '}';
    }
}
