package service.student;

import dao.otherDao.SysStateMapper;
import dao.userDao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.other.SysState;
import pojo.user.Student;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.Calendar;

@Service
public class TimeModifyServiceImpl implements TimeModifyService {
    @Resource(name = "studentMapper")
    StudentMapper studentMapper;
    @Resource(name = "sysStateMapper")
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
                if (dateNow.compareTo(date1) >= 0 && dateNow.compareTo(date2) <= 0) {
                        flag=true;//正选合法时间
                    } else {
                            Date date3 = new Date(Long.parseLong(sysState.getTime3()));
                            Date date4 = new Date(Long.parseLong(sysState.getTime4()));
                            if (dateNow.compareTo(date3) >= 0 && dateNow.compareTo(date4) <= 0) {
                                flag=true;//补选合法时间
                            }
                }
                    break;
            }
            case 2:{//补选 (已经和1 合并了 不会用到)
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
