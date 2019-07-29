package com.bili.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bili.mybatisplusdemo.entity.Student;

import java.util.List;

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
    List<Integer> selectIdListWithXml();
}
