package pojo.classes;

/*
* 刚点进选课界面时的课程基本信息
* */
public class BasicCourseInfo {
    private String name;
    private String department;
    private int hours;
    private int credits;

    public BasicCourseInfo() {
    }

    public BasicCourseInfo(String name, String department, int hours, int credits) {
        this.name = name;
        this.department = department;
        this.hours = hours;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "BasicCourseInfo{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", hours=" + hours +
                ", credits=" + credits +
                '}';
    }
}
