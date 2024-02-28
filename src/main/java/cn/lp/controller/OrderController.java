package cn.lp.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import cn.lp.bean.Order;
import cn.lp.bean.OrderItem;
import cn.lp.bean.dto.OrderDTO;
import cn.lp.service.OrderItemService;
import cn.lp.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: sharedingtest
 * @BelongsPackage: cn.lp.controller
 * @Author: lp
 * @CreateTime: 2024-02-28  15:20
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("OrderController")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;
    @GetMapping("/bindTable/mock")
    public String mockWithBindTable() {
        for (int i = 0; i < 1; i++) {
            // 1、插入order 表
            Order orderMock = new Order();
            // 这个order id 不用我们设置，我们在shardingSphere 时设置了该表的主键使用 shardingSphere 内置的雪花算法
//            orderMock.setOrderId();
            orderMock.setUserId((long) i);
            orderMock.setOrderName(RandomUtil.randomString(20));
            long l = orderService.save(orderMock);
            log.info("返回主键");
//            orderService.selfInsert(orderMock);


            // 2、插入t_order_item 表
            OrderItem orderItemMock = new OrderItem();
            // id 也不需要我们设置，我们在shardingSphere 时设置了该表的主键使用 shardingSphere 内置的雪花算法
//            orderItemMock.setItemId();
            orderItemMock.setOrderId(orderMock.getId());
            orderItemMock.setName(RandomUtil.randomString(20));
            orderItemService.save(orderItemMock);
        }
        return "ok";
    }
//需要配置绑定表，不然会遍历查询
    @GetMapping("bindTable/{orderId}")
    public OrderDTO bindTableByOrderId(@PathVariable("orderId") Long orderId) {
        OrderDTO orderDTO = orderService.bindTableByOrderId(orderId);
        return orderDTO;
    }

    @GetMapping("bindTableWithIn/{orderId}")
    public OrderDTO bindTableByOrderIdWithIn(@PathVariable("orderId") Long orderId) {
        List<OrderDTO> orderDTOS = orderService.bindTableByOrderIdWithIn(orderId);
        return orderDTOS.get(0);
    }

    @GetMapping("/mock")
    public String mock() {
        for (int i = 0; i < 12; i++) {
            final Order order = new Order();
            order.setUserId((long) i);
            order.setOrderName(RandomUtil.randomString(20));
            this.orderService.save(order);
        }
        return "SUCCESS";
    }

    @GetMapping("/orderBy")
    public String orderBy(@RequestParam(value = "page", required = false) Integer page,
                          @RequestParam(value = "limit", required = false) Integer limit) {
        LambdaQueryWrapper<Order> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 比如我这里只是查询 order_name列，但是因为你排序用到的是OrderId，而且最后要合并6张表的数据，再根据order_id排序，所以，
        // 即使你没有说查询这个列，sharding-sphere 也会加上这个字段的。 如下
        //  SELECT
        //      order_name
        //      , order_id AS ORDER_BY_DERIVED_0   FROM t_order0
        //
        //  ORDER BY order_id ASC LIMIT ?,? ::: [0, 12]
        lambdaQueryWrapper.select(Order::getOrderName);
        lambdaQueryWrapper.orderByAsc(Order::getId);
        if (page == null || limit == null) {
            return JSONUtil.toJsonStr(orderService.list(lambdaQueryWrapper));
        }
        return JSONUtil.toJsonStr(orderService.page(new Page<>(page, limit), lambdaQueryWrapper));
    }




}
