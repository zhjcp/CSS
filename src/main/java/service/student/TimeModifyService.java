package service.student;

/*
* 判断对于课程的某个操作是否在指定时间段内
* 参数：时间戳或者日期对象
* */
public interface TimeModifyService {
        // 根据操作类型，验证正选时间
        // opCourseType是要操作的课程类型,1-必修&&专业选修，2-体育，3-公选
        // opType是要操作类型，1-选课，2-补选，3-退课
        // id学号
        public  boolean modifyOpTime(int opType,int opCourseType, String id);
}
