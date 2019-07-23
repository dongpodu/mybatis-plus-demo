package com.bili.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bili.mybatisplusdemo.entity.Student;
import com.bili.mybatisplusdemo.mapper.StudentMapper;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

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
        System.out.println(studentMapper.selectList(new QueryWrapper<Student>().eq("name","张三")));
        System.out.println(studentMapper.selectList(new LambdaQueryWrapper<Student>().eq(Student::getName, "张三")));
    }
}
