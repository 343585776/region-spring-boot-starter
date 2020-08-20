package me.sdevil507.supports.region.service.impl;

import me.sdevil507.supports.region.dto.RegionParamsDto;
import me.sdevil507.supports.region.po.RegionPo;
import me.sdevil507.supports.region.repository.RegionRepository;
import me.sdevil507.supports.region.service.RegionService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 地区码表[CommonAreaServiceImpl]
 *
 * @author sdevil507
 * created on 2020-07-02 14:15:15
 */
@Service
public class RegionServiceImpl implements RegionService {

    @Resource
    private RegionRepository regionRepository;

    @Override
    public List<RegionPo> readAll(RegionParamsDto searchParamsDto) {
        //noinspection Convert2Lambda
        return regionRepository.findAll(new Specification<RegionPo>() {
            @Override
            public Predicate toPredicate(Root<RegionPo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                // 地区id
                Integer regionId = searchParamsDto.getRegionId();
                if (null != regionId) {
                    list.add(criteriaBuilder.equal(root.get("regionId"), regionId));
                }
                // 地区级别（1:省份province,2:市city,3:区县district,4:街道street）
                Integer level = searchParamsDto.getLevel();
                if (null != level) {
                    list.add(criteriaBuilder.equal(root.get("level"), level));
                }
                // 父id
                Integer parentId = searchParamsDto.getParentId();
                if (null != parentId) {
                    list.add(criteriaBuilder.equal(root.get("parentId"), parentId));
                }
                // 地区名称
                String regionName = searchParamsDto.getRegionName();
                if (!StringUtils.isEmpty(regionName)) {
                    list.add(criteriaBuilder.like(root.get("regionName"), regionName));
                }
                // 地区编码
                String regionCode = searchParamsDto.getRegionCode();
                if (!StringUtils.isEmpty(regionCode)) {
                    list.add(criteriaBuilder.like(root.get("regionCode"), regionCode));
                }
                // 城市编码
                String cityCode = searchParamsDto.getCityCode();
                if (!StringUtils.isEmpty(cityCode)) {
                    list.add(criteriaBuilder.like(root.get("cityCode"), cityCode));
                }
                Predicate[] array = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(array));
            }
        });
    }

}