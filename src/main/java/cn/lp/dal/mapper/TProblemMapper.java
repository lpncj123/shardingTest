package cn.lp.dal.mapper;

import cn.lp.bean.Problem;
import cn.lp.bean.TProblem0;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TProblemMapper extends BaseMapper<Problem> {

}