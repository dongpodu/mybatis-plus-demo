package com.bili.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 任务实体表
 * </p>
 *
 * @author willdu
 * @since 2019-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_task")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * taskid
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * task名称
     */
    private String name;

    /**
     * 任务id
     */
    private Integer oid;

    /**
     * 任务类型
     */
    private Integer type;

    /**
     * 通知类型:0=url ,1=databus
     */
    private Integer notifyType;

    /**
     * 通知的url
     */
    private String notifyUrl;

    /**
     * 通知的url参数，如果是get方法，则是拼好的参数如：?name=1；若是post方法，则是拼好的json，如：{"name":"test"}
     */
    private String notifyParam;

    /**
     * 当前执行了几次
     */
    private Integer exeCount;

    /**
     * 任务状态 0=等待执行，1=执行中，10=执行完成，-1=废弃任务，-5=执行失败
     */
    private Integer status;

    /**
     * 父任务id，先执行子任务，再执行父任务
     */
    private Integer parentId;

    /**
     * 重试次数 0表示不重试 
     */
    private Integer retry;

    /**
     * 设置的执行时间
     */
    private LocalDateTime exeTime;

    /**
     * 执行完成时间
     */
    private LocalDateTime finishTime;

    /**
     * 创建时间
     */
    private LocalDateTime ctime;

    /**
     * 修改时间
     */
    private LocalDateTime mtime;

    /**
     * 通知的返回值
     */
    private String notifyResponse;

    /**
     * 1=get 2=post
     */
    private Integer notifyMethod;

    /**
     * 实际执行时间
     */
    private LocalDateTime actExeTime;


}
