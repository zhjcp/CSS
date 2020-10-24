package service.adminS;

public interface SelectionsUpdateService {
    // 1. 计算专业选修课的选课结果
    public boolean calculateSelectiveResult1();
    // 2. 计算专业选修课的选课结果
    public boolean calculateSelectiveResult2();
    // 3. 计算体育课的选课结果
    public boolean calculateSelectiveResult3();
    // 4. 计算公选课的选课结果
    public boolean calculateSelectiveResult4();
}
