package cn.lp.service.impl;

import cn.lp.bean.Dict;
import cn.lp.dal.mapper.DictMapper;
import cn.lp.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: sharedingtest
 * @BelongsPackage: cn.lp.service.impl
 * @Author: lp
 * @CreateTime: 2024-02-28  17:02
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictMapper dictMapper;

    @Override
    public void save(Dict dict) {
        dictMapper.insertSelf(dict);
    }
}
