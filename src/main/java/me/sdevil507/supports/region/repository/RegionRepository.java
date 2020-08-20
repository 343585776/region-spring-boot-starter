package me.sdevil507.supports.region.repository;

import me.sdevil507.supports.region.po.RegionPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 地区码表[CommonAreaRepository]
 *
 * @author sdevil507
 * created on 2020-07-02 14:15:17
 */
public interface RegionRepository extends JpaRepository<RegionPo, Integer> , JpaSpecificationExecutor<RegionPo> {

}