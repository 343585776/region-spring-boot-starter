package me.sdevil507.supports.region.controller;

import lombok.extern.slf4j.Slf4j;
import me.sdevil507.supports.region.dto.RegionParamsDto;
import me.sdevil507.supports.region.dto.RegionResultDto;
import me.sdevil507.supports.region.po.RegionPo;
import me.sdevil507.supports.region.service.RegionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 省市区地区码表[RegionController]
 *
 * @author sdevil507
 * created on 2020-07-02 14:15:11
 */
@RequestMapping("/supports/region")
@Slf4j
public class RegionController extends RegionBaseMarkController {

    @Autowired
    private RegionService regionService;

    /**
     * 获取全部信息列表
     *
     * @param dto 聚合查询/分页/排序参数
     * @return 信息列表
     */
    @RequestMapping(value = "/readAll", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> readAll(@RequestBody RegionParamsDto dto) {
        Map<String, Object> map = new HashMap<>(3);
        try {
            List<RegionResultDto> resultDtos = new ArrayList<>();
            List<RegionPo> regionPos = regionService.readAll(dto);
            for (RegionPo regionPo : regionPos) {
                RegionResultDto resultDto = new RegionResultDto();
                BeanUtils.copyProperties(regionPo, resultDto);
                resultDtos.add(resultDto);
            }
            map.put("code", "0000");
            map.put("message", "执行成功!");
            map.put("content", resultDtos);
        } catch (Exception e) {
            log.error("获取省市区数据失败:", e);
            map.put("code", "9999");
            map.put("message", "获取省市区数据失败!");
        }
        return map;
    }

}