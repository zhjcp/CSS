package pojo.classes;

public class PublicCourse extends Course {
    public PublicCourse() {
    }

    public PublicCourse(int id, String name, String type, String teacherName, int hours, int credits, String description, int capacity, int stuNum) {
        super(id, name, type, teacherName, hours, credits, description, capacity, stuNum);
    }

    @Override
    public String toString() {
        return "PublicCourse{" +
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
