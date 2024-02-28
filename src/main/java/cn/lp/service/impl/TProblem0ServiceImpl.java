package cn.lp.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.lp.bean.Problem;
import cn.lp.bean.TProblem0;
import cn.lp.dal.mapper.TProblem0Mapper;
import cn.lp.dal.mapper.TProblemMapper;
import cn.lp.service.TProblem0Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    @Autowired
    private TProblemMapper tProblemMapper;
    @Override
    public List<TProblem0> getTProblemList() {
        return tProblem0Mapper.selectList(null);
    }

    @Override
    public void save(TProblem0 tProblem0) {
        tProblem0Mapper.insert(tProblem0);
    }

    @Override
    public Integer count() {
        return tProblem0Mapper.count();
    }

    @Override
    public Page<Problem> page(Page<Problem> objectPage) {
        Page<Problem> page = tProblemMapper.selectPage(objectPage, null);
        return page;
    }

    @Override
    public Problem getById(Long id) {
        return tProblemMapper.selectById(id);
    }

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int datacenterId = 2;
            int workerId = 2;
            long id = IdUtil.getSnowflake(datacenterId, workerId).nextId();
            System.out.println(id);
        }

    }
}
