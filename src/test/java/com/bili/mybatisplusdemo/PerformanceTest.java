package com.bili.mybatisplusdemo;

import com.bili.mybatisplusdemo.entity.Student;
import com.bili.mybatisplusdemo.mapper.StudentMapper;
import org.junit.Test;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PerformanceTest extends BaseTest {
    @Resource
    private StudentMapper studentMapper;


    @Test
    public void test(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("selectIdListWithXml");
        List<Integer> list = studentMapper.selectIdListWithXml();
        System.out.println(list.size());
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }


    @Test
    public void testUpdatePerformance(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("update");
        IntStream.rangeClosed(1,100000).forEach(r ->{
            Student update = new Student();
            update.setId(r);
            update.setName("李四"+r);
            update.setNo(r);
            studentMapper.updateById(update);
        });
        stopWatch.stop();

        stopWatch.start("updateWithXml");
        IntStream.rangeClosed(1,100000).forEach(r ->{
            Student update = new Student();
            update.setId(r);
            update.setName("王五"+r);
            update.setNo(r);
            studentMapper.updateWithXml(update);
        });
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    @Test
    public void testSelectPerformance(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("select");
        IntStream.rangeClosed(1,100000).forEach(r ->{
            Student student = studentMapper.selectById(r);
        });
        stopWatch.stop();

        stopWatch.start("selectWithXml");
        LongStream.rangeClosed(1,100000).forEach(r ->{
            Student student = studentMapper.selectByIdWithXml(r);
        });
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
