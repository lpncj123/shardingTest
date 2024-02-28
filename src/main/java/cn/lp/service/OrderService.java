package cn.lp.service;

import cn.hutool.json.JSON;
import cn.lp.bean.Order;
import cn.lp.bean.dto.OrderDTO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @BelongsProject: sharedingtest
 * @BelongsPackage: cn.lp.service
 * @Author: lp
 * @CreateTime: 2024-02-28  15:21
 * @Description: TODO
 * @Version: 1.0
 */
public interface OrderService {
    long save(Order orderMock);

    OrderDTO bindTableByOrderId(Long orderId);

    List<OrderDTO> bindTableByOrderIdWithIn(Long orderId);

    List<Order> list(LambdaQueryWrapper<Order> lambdaQueryWrapper);

    List<Order> page(Page<Order> objectPage, LambdaQueryWrapper<Order> lambdaQueryWrapper);
}
