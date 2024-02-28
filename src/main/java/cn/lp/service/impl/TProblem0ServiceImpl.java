package cn.lp.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.lp.bean.Problem;
import cn.lp.bean.TProblem0;
import cn.lp.dal.mapper.TProblem0Mapper;
import cn.lp.service.TProblem0Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @BelongsProject: sharedingtest
 * @BelongsPackage: cn.lp.service.impl
 * @Author: lp
 * @CreateTime: 2024-02-27  17:26
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class TProblem0ServiceImpl implements TProblem0Service {
    @Autowired
    private TProblem0Mapper tProblem0Mapper;
    @Override
    public List<TProblem0> getTProblemList() {
        return tProblem0Mapper.selectList(null);
    }

    @Override
    public void save(TProblem0 tProblem0) {
        Random random = new Random();
        int datacenterId = random.nextInt(31);
        int workerId = random.nextInt(31);

        long id = IdUtil.getSnowflake(datacenterId, workerId).nextId();
        tProblem0.setId(id);
        tProblem0Mapper.insert(tProblem0);
    }
}
