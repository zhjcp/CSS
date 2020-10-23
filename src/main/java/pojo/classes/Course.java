package pojo.classes;

public class Course {
    int id;
    String name;
    String type;
    String teacherName;
    int hours;
    int credits;
    String description;
    int capacity;
    int stuNum;

    public Course() {
    }

    public Course(int id, String name, String type, String teacherName, int hours, int credits, String description, int capacity, int stuNum) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.teacherName = teacherName;
        this.hours = hours;
        this.credits = credits;
        this.description = description;
        this.capacity = capacity;
        this.stuNum = stuNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", hours=" + hours +
                ", credits=" + credits +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", stuNum=" + stuNum +
                '}';
    }
}
