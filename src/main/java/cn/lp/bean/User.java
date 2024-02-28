package cn.lp.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GXM
 * @version 1.0.0
 * @Description 用户表（当作广播表使用）
 * @createTime 2022年06月24日
 */
@TableName("t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Model<User> {

    /**
     * 1、这里必须要使用Long，不能使用int 或者integer 因为
     * 使用shardSphere 的雪花算法生成的数值很大，已经超过了
     * Integer.MAX_VALUE()，只能使用Long来存储，而且数据库中也必须是bigint
     * 当然如果你选择使用字符串的类型，那这里就不没有那么多事情了
     * <p>
     * 注意这里的 type是默认值IdType.NONE，不要设置，NONE就是【用户输入ID 该类型可以通过自己注册自动填充插件进行填充】
     */
    @TableId(value = "id")
    private Long id;

    @TableField("name")
    private String name;

    @TableField("sex")
    private String sex;
}

