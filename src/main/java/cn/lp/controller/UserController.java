package cn.lp.controller;

import cn.hutool.core.util.RandomUtil;
import cn.lp.bean.User;
import cn.lp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: sharedingtest
 * @BelongsPackage: cn.lp.controller
 * @Author: lp
 * @CreateTime: 2024-02-28  16:34
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("UserController")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/mock")
    public String mock() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName(RandomUtil.randomString(10));
            user.setSex(RandomUtil.randomString(1));
            userService.save(user);
            log.info("insert success");
        }
        return "ok";
    }
    @GetMapping("{userId}")
    public User getById(@PathVariable("userId") Long userId) {
        return userService.getById(userId);
    }

    @GetMapping("update/{userId}/{sex}")
    public String update(@PathVariable("userId") Long userId,
                         @PathVariable("sex") String sex) {
        User user = new User();
        user.setId(userId);
        user.setSex(sex);
        userService.updateById(user);
        return "ok";
    }


}
