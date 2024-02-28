package cn.lp.controller;

import cn.hutool.core.util.RandomUtil;
import cn.lp.bean.Problem;
import cn.lp.bean.TProblem0;
import cn.lp.service.TProblem0Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject: sharedingtest
 * @BelongsPackage: cn.lp.controller
 * @Author: lp
 * @CreateTime: 2024-02-27  17:23
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("ShardingTestController")
public class ShardingTestController {
    @Autowired
    private TProblem0Service tProblem0Service;

    @GetMapping("/getTProblemList")
    public List<TProblem0> getTProblemList() {
        return tProblem0Service.getTProblemList();
    }
    @GetMapping("/mock")
    public String mock() {
        for (int i = 0; i < 12; i++) {
            TProblem0 tProblem0 = new TProblem0();
            tProblem0.setContent(RandomUtil.randomString(20));
            tProblem0Service.save(tProblem0);
        }
        return "SUCCESS";
    }

}
