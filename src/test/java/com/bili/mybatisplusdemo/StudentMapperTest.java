package com.bili.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bili.mybatisplusdemo.entity.Student;
import com.bili.mybatisplusdemo.mapper.StudentMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * willdu 2019-07-23
 **/
public class StudentMapperTest extends BaseTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    public void testInsert() {
        Student insert = new Student();
        insert.setName("张三");
        insert.setNo(10001);
        studentMapper.insert(insert);
    }

    @Test
    public void testSelect() {
        System.out.println(studentMapper.selectList(new QueryWrapper<Student>().eq("id",100)));
        System.out.println(studentMapper.selectList(new LambdaQueryWrapper<Student>().eq(Student::getId, 1)));
        System.out.println(studentMapper.selectBatchIds(IntStream.rangeClosed(100,110).boxed().collect(Collectors.toList())));
        System.out.println(studentMapper.selectById(100));
        System.out.println(studentMapper.selectOne(new LambdaQueryWrapper<Student>().eq(Student::getId, 100)));
        System.out.println(studentMapper.selectCount(new LambdaQueryWrapper<Student>().eq(Student::getId, 1)));
        System.out.println(studentMapper.selectPage(new Page(1,10), new LambdaQueryWrapper<>()).getSize());
    }

    @Test
    public void testUpdate(){
        int id = 496655;
        String name = "李四";
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        studentMapper.updateById(student);

        Assert.assertEquals(name, studentMapper.selectById(id).getName());

        int id1 = 496656;
        int no1 = 1;
        String name1 = "王五";
        Student update = new Student();
        update.setName(name1);
        update.setNo(no1);
        studentMapper.update(update, new UpdateWrapper<Student>().lambda().eq(Student::getId, id1));

        Student ss = studentMapper.selectById(id1);
        Assert.assertEquals(update.getName(), ss.getName());
        Assert.assertEquals(update.getNo(), ss.getNo());
    }


    @Test
    public void testPerformance(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        IntStream.rangeClosed(1,100000).forEach(r ->{
            Student insert = new Student();
            insert.setName("张三"+r);
            insert.setNo(r);
            studentMapper.insert(insert);
        });
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    @Test
    public void testPerformance1(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        IntStream.rangeClosed(1,100000).forEach(r ->{
            Student insert = new Student();
            insert.setName("张三"+r);
            insert.setNo(r);
            studentMapper.insertWithXml(insert);
        });
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
