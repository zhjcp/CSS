package pojo;

public class Student {
    String id;
    String name;
    String pwd;
    String sex;
    String department;
    int grade;
    String className;
    String phone;
    String email;
    int selectionCoins;
    int requiredCredits;
    int majorCredits;
    int preCredits;

    public Student() {
    }

    public Student(String id, String name, String pwd, String sex, String department, int grade, String className, String phone, String email, int selectionCoins, int requiredCredits, int majorCredits, int preCredits) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.sex = sex;
        this.department = department;
        this.grade = grade;
        this.className = className;
        this.phone = phone;
        this.email = email;
        this.selectionCoins = selectionCoins;
        this.requiredCredits = requiredCredits;
        this.majorCredits = majorCredits;
        this.preCredits = preCredits;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
