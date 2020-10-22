package pojo.other;

public class SysState {
    int count;
    String departmentName;
    int opCourseType;
    String time1;//时间戳的字符串化
    String time2;
    String time3;
    String time4;
    String time5;
    String time6;

    public SysState() {
    }

    public SysState(int count, String departmentName, int opCourseType, String time1, String time2, String time3, String time4, String time5, String time6) {
        this.count = count;
        this.departmentName = departmentName;
        this.opCourseType = opCourseType;
        this.time1 = time1;
        this.time2 = time2;
        this.time3 = time3;
        this.time4 = time4;
        this.time5 = time5;
        this.time6 = time6;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getOpCourseType() {
        return opCourseType;
    }

    public void setOpCourseType(int opCourseType) {
        this.opCourseType = opCourseType;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTime3() {
        return time3;
    }

    public void setTime3(String time3) {
        this.time3 = time3;
    }

    public String getTime4() {
        return time4;
    }

    public void setTime4(String time4) {
        this.time4 = time4;
    }

    public String getTime5() {
        return time5;
    }

    public void setTime5(String time5) {
        this.time5 = time5;
    }

    public String getTime6() {
        return time6;
    }

    public void setTime6(String time6) {
        this.time6 = time6;
    }

    @Override
    public String toString() {
        return "Sys_State{" +
                "count=" + count +
                ", departmentName=" + departmentName +
                ", type='" + opCourseType + '\'' +
                ", time1='" + time1 + '\'' +
                ", time2='" + time2 + '\'' +
                ", time3='" + time3 + '\'' +
                ", time4='" + time4 + '\'' +
                ", time5='" + time5 + '\'' +
                ", time6='" + time6 + '\'' +
                '}';
    }
}
