package pojo;

public class Student extends User{
    String department;
    int grade;
    String className;
    int selectionCoins;
    int requiredCredits;
    int majorCredits;
    int preCredits;

    public Student(){

    }

    public Student(String id, String name, String pwd, String sex, String phone, String email, String department, int grade, String className, int selectionCoins, int requiredCredits, int majorCredits, int preCredits) {
        super(id, name, pwd, sex, phone, email);
        this.department = department;
        this.grade = grade;
        this.className = className;
        this.selectionCoins = selectionCoins;
        this.requiredCredits = requiredCredits;
        this.majorCredits = majorCredits;
        this.preCredits = preCredits;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getSelectionCoins() {
        return selectionCoins;
    }

    public void setSelectionCoins(int selectionCoins) {
        this.selectionCoins = selectionCoins;
    }

    public int getRequiredCredits() {
        return requiredCredits;
    }

    public void setRequiredCredits(int requiredCredits) {
        this.requiredCredits = requiredCredits;
    }

    public int getMajorCredits() {
        return majorCredits;
    }

    public void setMajorCredits(int majorCredits) {
        this.majorCredits = majorCredits;
    }

    public int getPreCredits() {
        return preCredits;
    }

    public void setPreCredits(int preCredits) {
        this.preCredits = preCredits;
    }

    @Override
    public String toString() {
        return "Student{" +
                "department='" + department + '\'' +
                ", grade=" + grade +
                ", className='" + className + '\'' +
                ", selectionCoins=" + selectionCoins +
                ", requiredCredits=" + requiredCredits +
                ", majorCredits=" + majorCredits +
                ", preCredits=" + preCredits +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
