package cn.lp.service;

import cn.lp.bean.User;

/**
 * @BelongsProject: sharedingtest
 * @BelongsPackage: cn.lp.service
 * @Author: lp
 * @CreateTime: 2024-02-28  16:30
 * @Description: TODO
 * @Version: 1.0
 */
public interface UserService {
    void save(User user);

    User getById(Long userId);

    void updateById(User user);
}
