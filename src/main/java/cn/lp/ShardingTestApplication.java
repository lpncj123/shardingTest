package cn.lp;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @BelongsProject: sharding-test
 * @BelongsPackage: cn.lp
 * @Author: lp
 * @CreateTime: 2024-02-27  14:38
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootApplication
public class ShardingTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingTestApplication.class,args);
    }
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
