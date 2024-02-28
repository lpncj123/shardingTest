package cn.lp.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GXM
 * @version 1.0.0
 * @Description 订单关联表（当前表和order表是关联表，也是需要配置分库分表的，以及和 order表一起设置为绑定表）
 * @createTime 2022年06月23日
 */
@TableName("t_order_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

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

    @TableField("order_id")
    private Long orderId;

    @TableField("name")
    private String name;
}

