package cn.lp.dal.mapper;

import cn.lp.bean.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @BelongsProject: sharedingtest
 * @BelongsPackage: cn.lp.dal.mapper
 * @Author: lp
 * @CreateTime: 2024-02-28  15:17
 * @Description: TODO
 * @Version: 1.0
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    Long selfInsert(Order order);
}
