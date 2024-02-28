package cn.lp.bean;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @Description TODO
 * @createTime 2022年06月22日
 */
@TableName("t_dict")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dict extends Model<Dict> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("type")
    private String type;
}

