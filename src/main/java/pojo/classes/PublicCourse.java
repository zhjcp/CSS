package pojo.classes;

public class PublicCourse extends Course {
    public PublicCourse() {
    }

    public PublicCourse(int id, String name, String type, String teacherName, int capacity, int hours, int credits, String description) {
        super(id, name, type, teacherName, capacity, hours, credits, description);
    }

    @Override
    public String toString() {
        return "PublicCourse{" +
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
