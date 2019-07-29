package com.bili.mybatisplusdemo;

import com.bili.mybatisplusdemo.entity.Student;
import com.bili.mybatisplusdemo.service.StudentService;
import org.junit.Test;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentServiceTest extends BaseTest{
    @Resource
    private StudentService studentService;

    @Test
    public void testBatchSave() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("insert");
        List<Student> list = IntStream.rangeClosed(1000001, 2000000).boxed().parallel().map(r -> {
            Student insert = new Student();
            insert.setName("张三" + r);
            insert.setNo(r);
            return insert;
        }).collect(Collectors.toList());
        studentService.saveBatch(list);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
