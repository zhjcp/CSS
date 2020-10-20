package pojo.classes;

public class DepartmentClass extends Classes{
        int group;
        int targetGrade;


        public DepartmentClass() {
        }

        public DepartmentClass(int id, String name, String type, String teacherName, int capacity, int hours, int credits, String description, int group, int targetGrade) {
                super(id, name, type, teacherName, capacity, hours, credits, description);
                this.group = group;
                this.targetGrade = targetGrade;
        }

        public int getGroup() {
                return group;
        }

        public void setGroup(int group) {
                this.group = group;
        }

        public int getTargetGrade() {
                return targetGrade;
        }

        public void setTargetGrade(int targetGrade) {
                this.targetGrade = targetGrade;
        }

        @Override
        public String toString() {
                return "DepartmentClass{" +
                        "group=" + group +
                        ", targetGrade=" + targetGrade +
                        ", id=" + id +
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