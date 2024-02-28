package cn.lp.service.impl;

import cn.hutool.json.JSON;
import cn.lp.bean.Order;
import cn.lp.bean.dto.OrderDTO;
import cn.lp.dal.mapper.OrderMapper;
import cn.lp.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: sharedingtest
 * @BelongsPackage: cn.lp.service.impl
 * @Author: lp
 * @CreateTime: 2024-02-28  15:21
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public long save(Order orderMock) {
        return orderMapper.selfInsert(orderMock);
    }

    @Override
    public OrderDTO bindTableByOrderId(Long orderId) {
        return orderMapper.bindTableByOrderId(orderId);
    }

    @Override
    public List<OrderDTO> bindTableByOrderIdWithIn(Long orderId) {
        return orderMapper.bindTableByOrderIdWithIn(orderId);
    }

    @Override
    public List<Order> list(LambdaQueryWrapper<Order> lambdaQueryWrapper) {
        return orderMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public List<Order> page(Page<Order> objectPage, LambdaQueryWrapper<Order> lambdaQueryWrapper) {
        return orderMapper.selectPage(objectPage,lambdaQueryWrapper).getRecords();
    }
}
