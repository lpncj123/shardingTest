package cn.lp.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.lp.bean.Problem;
import cn.lp.bean.TProblem0;
import cn.lp.service.TProblem0Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
@Slf4j
public class ShardingTestController {
    @Autowired
    private TProblem0Service tProblem0Service;

    @GetMapping("/getTProblemList")
    public List<TProblem0> getTProblemList() {
        return tProblem0Service.getTProblemList();
    }
    @GetMapping("/mock")
    public String mock() {
        List<Long> arrayList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            int datacenterId = 1;
            int workerId = 1;
            long id = IdUtil.getSnowflake(datacenterId, workerId).nextId();
            arrayList.add(id);
        }
        for (int i = 0; i < 12; i++) {
            TProblem0 tProblem0 = new TProblem0();
            tProblem0.setId(arrayList.get(i));
            tProblem0.setContent(RandomUtil.randomString(20));
            tProblem0Service.save(tProblem0);
        }
        return "SUCCESS";
    }

    @GetMapping("/count")
    public Integer getCount(){
        return tProblem0Service.count();
    }

    @GetMapping("page")
    public List<Problem> page(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        log.info("page,limit:{}",page+"****"+limit);
        Page<Problem> orderPage = tProblem0Service.page(new Page<>(page, limit));
        return orderPage.getRecords();
    }

    @GetMapping("/{id}")
    public Problem getById(@PathVariable Long id) {
        return tProblem0Service.getById(id);
    }


}
