package service.adminS;

import dao.classDao.DepartmentCourseMapper;
import dao.classDao.PeCourseMapper;
import dao.classDao.PublicCourseMapper;
import dao.otherDao.NecessarySelectionsMapper;
import dao.otherDao.PeSelectionsMapper;
import dao.otherDao.PublicSelectionsMapper;
import dao.otherDao.SelectiveSelectionsMapper;
import dao.userDao.StudentMapper;
import dao.userDao.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.classes.DepartmentCourse;
import pojo.classes.PeCourse;
import pojo.classes.PublicCourse;
import pojo.other.CourseSelections;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toMap;

@Service
public class SelectionsUpdateServiceImpl implements SelectionsUpdateService {
    //service层调用dao层的方法操作数据库，需要一个Mapper实例
    @Resource(name = "studentMapper")
    StudentMapper studentMapper;
    @Resource(name = "teacherMapper")
    TeacherMapper teacherMapper;
    @Resource(name = "departmentCourseMapper")
    DepartmentCourseMapper departmentCourseMapper;
    @Resource(name = "peCourseMapper")
    PeCourseMapper peCourseMapper;
    @Resource(name = "publicCourseMapper")
    PublicCourseMapper publicCourseMapper;
    @Resource(name = "necessarySelectionsMapper")
    NecessarySelectionsMapper necessarySelectionsMapper;
    @Resource(name = "selectiveSelectionsMapper")
    SelectiveSelectionsMapper selectiveSelectionsMapper;
    @Resource(name = "peSelectionsMapper")
    PeSelectionsMapper peSelectionsMapper;
    @Resource(name = "publicSelectionsMapper")
    PublicSelectionsMapper publicSelectionsMapper;


    @Override
    // 1. 计算专业选修课的选课结果
    public boolean calculateSelectiveResult1() {
        // step1:找出要进行计算处理的课程的id
        List<Integer> idList = departmentCourseMapper.selectCalculatingCourse();
        System.out.println("=======要删除的id有："+idList);
        // step2:依次处理每个id对应的课程   先对selectionCoins排序 然后删除多余 最终更新stuNum为capacity
        for (Integer courseId : idList) {
            //计算该id对应的课程超出容量的人数
            DepartmentCourse dC = departmentCourseMapper.selectByCourseId(courseId);
            int dealtNum=dC.getStuNum()-dC.getCapacity();
            System.out.println("=====要删除的个数"+dealtNum);
            //在selections表中找到该id对应的该课程的所有选择信息 并 升序排序
            ArrayList<CourseSelections> cSList = (ArrayList<CourseSelections>) necessarySelectionsMapper.selectACourseById(courseId);
            cSList.sort(Comparator.comparingInt(CourseSelections::getSelectionCoins));
            //由于是升序排序，从头开始删除多余个数即可
            for (int count=0;count<dealtNum;count++){
                CourseSelections cSItem = cSList.get(count);//获取当前要删除的项
                necessarySelectionsMapper.deleteStuSelection(cSItem.getCourseId(),cSItem.getStuId());//执行删除
            }
            departmentCourseMapper.updateStuNum(dC.getId(),dC.getCapacity());//最终更新stuNum
        }
        necessarySelectionsMapper.updateSelectedState(1,2);//（1选课中--->2已选)
        return true;
    }

    @Override
    // 2. 计算专业选修课的选课结果
    public boolean calculateSelectiveResult2() {
        // step1:找出要进行计算处理的课程的id
        List<Integer> idList = departmentCourseMapper.selectCalculatingCourse();
        System.out.println("=======要删除的id有："+idList);
        // step2:依次处理每个id对应的课程   先对selectionCoins排序 然后删除多余 最终更新stuNum为capacity
        for (Integer courseId : idList) {
            //计算该id对应的课程超出容量的人数
            DepartmentCourse dC = departmentCourseMapper.selectByCourseId(courseId);
            int dealtNum=dC.getStuNum()-dC.getCapacity();
            System.out.println("=====要删除的个数"+dealtNum);
            //在selections表中找到该id对应的该课程的所有选择信息 并 升序排序
            ArrayList<CourseSelections> cSList = (ArrayList<CourseSelections>) selectiveSelectionsMapper.selectACourseById(courseId);
            cSList.sort(Comparator.comparingInt(CourseSelections::getSelectionCoins));
            //由于是升序排序，从头开始删除多余个数即可
            for (int count=0;count<dealtNum;count++){
                CourseSelections cSItem = cSList.get(count);//获取当前要删除的项
                selectiveSelectionsMapper.deleteStuSelection(cSItem.getCourseId(),cSItem.getStuId());//执行删除
            }
            departmentCourseMapper.updateStuNum(dC.getId(),dC.getCapacity());//最终更新stuNum
        }
        selectiveSelectionsMapper.updateSelectedState(1,2);//（1选课中--->2已选)
        return true;
    }

    @Override
    // 3. 计算体育课的选课结果
    public boolean calculateSelectiveResult3() {
        // step1:找出要进行计算处理的课程的id
        List<Integer> idList = peCourseMapper.selectCalculatingCourse();
        System.out.println("=======要删除的id有："+idList);
        // step2:依次处理每个id对应的课程   先对selectionCoins排序 然后删除多余 最终更新stuNum为capacity
        for (Integer courseId : idList) {
            //计算该id对应的课程超出容量的人数
            PeCourse pC = peCourseMapper.selectByCourseId(courseId);
            int dealtNum=pC.getStuNum()-pC.getCapacity();
            System.out.println("=====要删除的个数"+dealtNum);
            //在selections表中找到该id对应的该课程的所有选择信息 并 升序排序
            ArrayList<CourseSelections> cSList = (ArrayList<CourseSelections>) peSelectionsMapper.selectACourseById(courseId);
            cSList.sort(Comparator.comparingInt(CourseSelections::getSelectionCoins));
            //由于是升序排序，从头开始删除多余个数即可
            for (int count=0;count<dealtNum;count++){
                CourseSelections cSItem = cSList.get(count);//获取当前要删除的项
                peSelectionsMapper.deleteStuSelection(cSItem.getCourseId(),cSItem.getStuId());//执行删除
            }
            peCourseMapper.updateStuNum(pC.getId(),pC.getCapacity());//最终更新stuNum
        }
        peSelectionsMapper.updateSelectedState(1,2);//（1选课中--->2已选)
        return true;
    }

    @Override
    // 4. 计算公选课的选课结果
    public boolean calculateSelectiveResult4() {
        // step1:找出要进行计算处理的课程的id
        List<Integer> idList = publicCourseMapper.selectCalculatingCourse();
        System.out.println("=======要删除的id有："+idList);
        // step2:依次处理每个id对应的课程   先对selectionCoins排序 然后删除多余 最终更新stuNum为capacity
        for (Integer courseId : idList) {
            //计算该id对应的课程超出容量的人数
            PublicCourse pC = publicCourseMapper.selectByCourseId(courseId);
            int dealtNum=pC.getStuNum()-pC.getCapacity();
            System.out.println("=====要删除的个数"+dealtNum);
            //在selections表中找到该id对应的该课程的所有选择信息 并 升序排序
            ArrayList<CourseSelections> cSList = (ArrayList<CourseSelections>) publicSelectionsMapper.selectACourseById(courseId);
            cSList.sort(Comparator.comparingInt(CourseSelections::getSelectionCoins));
            //由于是升序排序，从头开始删除多余个数即可
            for (int count=0;count<dealtNum;count++){
                CourseSelections cSItem = cSList.get(count);//获取当前要删除的项
                publicSelectionsMapper.deleteStuSelection(cSItem.getCourseId(),cSItem.getStuId());//执行删除
            }
            publicCourseMapper.updateStuNum(pC.getId(),pC.getCapacity());//最终更新stuNum
        }
        publicSelectionsMapper.updateSelectedState(1,2);//（1选课中--->2已选)
        return true;
    }
}
