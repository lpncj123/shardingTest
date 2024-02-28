package cn.lp.bean.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: sharedingtest
 * @BelongsPackage: cn.lp.bean.dto
 * @Author: lp
 * @CreateTime: 2024-02-28  15:47
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private Long userId;
    private String orderName;
    private Long itemId;
    private String itemName;
}
