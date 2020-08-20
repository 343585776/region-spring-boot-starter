package me.sdevil507.supports.region.service;

import me.sdevil507.supports.region.dto.RegionParamsDto;
import me.sdevil507.supports.region.po.RegionPo;

import java.util.List;

/**
 * 省市区地区码表[RegionService]
 *
 * @author sdevil507
 * created on 2020-07-02 14:15:15
 */
public interface RegionService {

    /**
     * 查询全部记录
     *
     * @param searchParamsDto 搜索DTO
     * @return 记录列表
     */
    List<RegionPo> readAll(RegionParamsDto searchParamsDto);

}