package cn.lp.service;

import cn.lp.bean.Problem;
import cn.lp.bean.TProblem0;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @BelongsProject: sharedingtest
 * @BelongsPackage: cn.lp.service.impl
 * @Author: lp
 * @CreateTime: 2024-02-27  17:26
 * @Description: TODO
 * @Version: 1.0
 */
public interface TProblem0Service {
    List<TProblem0> getTProblemList();

    void save(TProblem0 tProblem0);

    Integer count();

    Page<Problem> page(Page<Problem> objectPage);

    Problem getById(Long id);
}
