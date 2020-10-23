package pojo.classes;

public class DepartmentCourse extends Course {
        int groupId;
        int targetGrade;

        public DepartmentCourse(){

        }

        public DepartmentCourse(int groupId, int targetGrade) {
                this.groupId = groupId;
                this.targetGrade = targetGrade;
        }

        public DepartmentCourse(int id, String name, String type, String teacherName, int hours, int credits, String description, int capacity, int stuNum, int groupId, int targetGrade) {
                super(id, name, type, teacherName, hours, credits, description, capacity, stuNum);
                this.groupId = groupId;
                this.targetGrade = targetGrade;
        }

        public int getGroupId() {
                return groupId;
        }

        public void setGroupId(int groupId) {
                this.groupId = groupId;
        }

        public int getTargetGrade() {
                return targetGrade;
        }

        public void setTargetGrade(int targetGrade) {
                this.targetGrade = targetGrade;
        }

        @Override
        public String toString() {
                return "DepartmentCourse{" +
                        "group=" + groupId +
                        ", targetGrade=" + targetGrade +
                        ", id=" + id +
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
