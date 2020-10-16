package pojo;

public class SelectionInfo_Class {
    int count;
    int classId;
    String stuId;
    int selectionCoins;
    String teacherId;
    int stuNum;
    int state;//选课中-1、已选-2、已修-3

    public SelectionInfo_Class() {
    }

    public SelectionInfo_Class(int count, int classId, String stuId, int selectionCoins, String teacherId, int stuNum, int state) {
        this.count = count;
        this.classId = classId;
        this.stuId = stuId;
        this.selectionCoins = selectionCoins;
        this.teacherId = teacherId;
        this.stuNum = stuNum;
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
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

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
