package com.bili.mybatisplusdemo.mapper;

import com.bili.mybatisplusdemo.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author willdu
 * @since 2019-07-23
 */
public interface StudentMapper extends BaseMapper<Student> {
    void insertWithXml(Student student);
    void updateWithXml(Student student);
    Student selectByIdWithXml(Long id);
}
