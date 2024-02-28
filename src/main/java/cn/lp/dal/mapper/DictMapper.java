package cn.lp.dal.mapper;

import cn.lp.bean.Dict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @BelongsProject: sharedingtest
 * @BelongsPackage: cn.lp.dal.mapper
 * @Author: lp
 * @CreateTime: 2024-02-28  16:59
 * @Description: TODO
 * @Version: 1.0
 */
@Mapper
public interface DictMapper extends BaseMapper<Dict> {
    void insertSelf(Dict dict);
}
