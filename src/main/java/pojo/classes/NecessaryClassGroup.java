package pojo.classes;

import java.util.ArrayList;
import java.util.List;

/*
* 作用：一个NecessaryClassGroup对象代表一组必修课，也就是一个“套餐”
* */
public class NecessaryClassGroup {
    //一个套餐中的课程列表
    private List<DepartmentClass> classList;

    public NecessaryClassGroup() {
        this.classList=new ArrayList<>();
    }


    public List<DepartmentClass> getClassList() {
        return classList;
    }

    public void setClassList(List<DepartmentClass> classList) {
        this.classList = classList;
    }

    public void addNecessaryCourse(DepartmentClass departmentClass){
        this.classList.add(departmentClass);
    }

    @Override
    public String toString() {
        return "NecessaryClassGroup{" +
                "classList=" + classList +
                '}';
    }
}
