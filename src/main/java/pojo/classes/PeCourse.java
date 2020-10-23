package pojo.classes;

public class PeCourse extends Course {
    public PeCourse() {
    }

    public PeCourse(int id, String name, String type, String teacherName, int capacity, int hours, int credits, String description) {
        super(id, name, type, teacherName, capacity, hours, credits, description);
    }

    @Override
    public String toString() {
        return "PeCourse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", capacity=" + capacity +
                ", hours=" + hours +
                ", credits=" + credits +
                ", description='" + description + '\'' +
                '}';
    }
}
