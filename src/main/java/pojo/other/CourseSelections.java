package pojo.other;

public class CourseSelections {
    int courseId;
    String stuId;
    int selectionCoins;
    String teacherId;
    int state;//选课中-1、已选-2、已修-3

    public CourseSelections() {
    }

    public CourseSelections(int courseId, String stuId, int selectionCoins, String teacherId, int state) {
        this.courseId = courseId;
        this.stuId = stuId;
        this.selectionCoins = selectionCoins;
        this.teacherId = teacherId;
        this.state = state;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public int getSelectionCoins() {
        return selectionCoins;
    }

    public void setSelectionCoins(int selectionCoins) {
        this.selectionCoins = selectionCoins;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CourseSelections{" +
                ", courseId=" + courseId +
                ", stuId='" + stuId + '\'' +
                ", selectionCoins=" + selectionCoins +
                ", teacherId='" + teacherId + '\'' +
                ", state=" + state +
                '}';
    }
}
