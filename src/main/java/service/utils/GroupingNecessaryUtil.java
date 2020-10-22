package service.utils;

import pojo.classes.DepartmentClass;
import pojo.classes.NecessaryClassGroup;

import java.util.ArrayList;
import java.util.List;

public class GroupingNecessaryUtil {
    public static List<NecessaryClassGroup> group(List<DepartmentClass> classList){
        ArrayList<NecessaryClassGroup> classGroupList;
        // 1. 首先统计有多少组套餐，并且记录不同的组号
        ArrayList<Integer> groupNumList=new ArrayList<>();
        for (DepartmentClass departmentClass : classList) {
            if (!chargeExist(departmentClass.getGroup(),groupNumList)){
                groupNumList.add(departmentClass.getGroup());
            }
        }
        // 2. 长度等于套餐组数的List lambda
        groupNumList.sort((g1,g2)-> (g1-g2));
        int length=groupNumList.size();
        classGroupList=new ArrayList<>();//初始化
        for (int i=0;i<length;i++){
            classGroupList.add(new NecessaryClassGroup());
        }
        // 3. 将必修课放置到组号对应的位置
        for (DepartmentClass departmentClass : classList) {
            for (int i=0;i<length;i++){
                if (departmentClass.getGroup()==groupNumList.get(i)){
                    classGroupList.get(i).addNecessaryCourse(departmentClass);
                }
            }
        }
        // 4. 返回
        return classGroupList;
    }

    //判断一个组号是否已经存在于一个list中
    private static boolean chargeExist(int group,ArrayList<Integer> list){
        for (Integer num : list) {
            if (num==group){
                return true;
            }
        }
        return false;
    }

}
