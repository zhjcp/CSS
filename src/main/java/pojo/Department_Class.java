package pojo;

public class Department_Class {
        int id;
        String name;
        String type;
        String teacherName;
        int capacity;
        int targetGrade;
        int hours;
        int credits;
        String description;


        public Department_Class() {
        }

        public Department_Class(int id, String name, String type, String teacherName, int capacity, int targetGrade, int hours, int credits, String description) {
                this.id = id;
                this.name = name;
                this.type = type;
                this.teacherName = teacherName;
                this.capacity = capacity;
                this.targetGrade = targetGrade;
                this.hours = hours;
                this.credits = credits;
                this.description = description;
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

        public int getCapacity() {
                return capacity;
        }

        public void setCapacity(int capacity) {
                this.capacity = capacity;
        }

        public int getTargetGrade() {
                return targetGrade;
        }

        public void setTargetGrade(int targetGrade) {
                this.targetGrade = targetGrade;
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
}
