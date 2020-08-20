package me.sdevil507.supports.region.config;

import me.sdevil507.supports.region.controller.RegionController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件上传场景启动器自动发现配置
 *
 * @author sdevil507
 */
@Configuration
public class RegionAutoConfiguration {

    /**
     * 创建通用地区查询的Controller给调用者调用
     *
     * @return 地区查询Controller
     */
    @Bean
    public RegionController regionController() {
        return new RegionController();
    }
}
