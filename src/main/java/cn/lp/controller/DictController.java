package cn.lp.controller;

import cn.lp.bean.Dict;
import cn.lp.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: sharedingtest
 * @BelongsPackage: cn.lp.controller
 * @Author: lp
 * @CreateTime: 2024-02-28  16:55
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("DictController")
@Slf4j
public class DictController {
    @Autowired
    private DictService dictService;
    /**
     * 这个表只存在于 shardingsphere0 数据库
     * shardSphere 5.0.0 版本不用配置 default-datasource，它会自动判断这个表在那个数据库
     * 之前版本( < 5.0.0)的需要配置该参数，标识单个表的默认数据库位置
     *
     * @return
     */
    @GetMapping("/mock")
    public String mock() {
        for (int i = 0; i < 100; i++) {
            Dict dict = new Dict();
            dict.setType(String.valueOf(i));
            dictService.save(dict);
            System.out.println();
        }
        return "ok";
    }

}
