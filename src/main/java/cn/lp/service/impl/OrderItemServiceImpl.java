package cn.lp.service.impl;

import cn.lp.bean.OrderItem;
import cn.lp.dal.mapper.OrderItemMapper;
import cn.lp.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: sharedingtest
 * @BelongsPackage: cn.lp.service.impl
 * @Author: lp
 * @CreateTime: 2024-02-28  15:28
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Override
    public void save(OrderItem orderItemMock) {
        orderItemMapper.selfInsert(orderItemMock);
    }
}
