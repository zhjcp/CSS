package service.student;

import dao.otherDao.SysStateMapper;
import dao.userDao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.other.SysState;
import pojo.user.Student;

import java.sql.Date;
import java.util.Calendar;

@Service
public class TimeModifyServiceImpl implements TimeModifyService {
    @Autowired
    @Qualifier("studentMapper")
    StudentMapper studentMapper;
    @Autowired
    @Qualifier("sysStateMapper")
    SysStateMapper sysStateMapper;

    @Override
    public boolean modifyOpTime(int opType,int opCourseType, String id) {
        boolean flag=false;
        Student stu = studentMapper.selectById(id);
        String department = stu.getDepartment();
        SysState sysState = sysStateMapper.selectSysStateByName(department,opCourseType);
        switch (opType){
            case 1:{//选课
                    Date date1 = new Date(Long.parseLong(sysState.getTime1()));
                    Date date2 = new Date(Long.parseLong(sysState.getTime2()));
                    Date dateNow =new Date(Calendar.getInstance().getTimeInMillis());
                System.out.println("=====date1:"+date1+"time1:"+sysState.getTime1());
                System.out.println("=====date2:"+date2+"time2:"+sysState.getTime2());
                System.out.println("====="+dateNow);
                if (dateNow.compareTo(date1) >= 0 && dateNow.compareTo(date2) <= 0) {
                        flag=true;//合法时间
                    }
                    break;
            }
            case 2:{//补选
                    Date date3 = new Date(Long.parseLong(sysState.getTime3()));
                    Date date4 = new Date(Long.parseLong(sysState.getTime4()));
                    Date dateNow =new Date(Calendar.getInstance().getTimeInMillis());
                if (dateNow.compareTo(date3) >= 0 && dateNow.compareTo(date4) <= 0) {
                    flag=true;//合法时间
                }
                    break;
            }
            default:{// 3 退选
                    Date date5 = new Date(Long.parseLong(sysState.getTime5()));
                    Date date6 = new Date(Long.parseLong(sysState.getTime6()));
                    Date dateNow =new Date(Calendar.getInstance().getTimeInMillis());
                if (dateNow.compareTo(date5) >= 0 && dateNow.compareTo(date6) <= 0) {
                    flag=true;//合法时间
                }
                break;
            }
        }
        return flag;
    }
}
