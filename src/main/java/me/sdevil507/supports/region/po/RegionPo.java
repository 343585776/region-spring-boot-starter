package me.sdevil507.supports.region.po;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 省市区地区码表[RegionPo]
 *
 * @author sdevil507
 * created on 2020-07-02 14:15:16
 */
@Entity
@Table(name = "common_region")
@Data
public class RegionPo {

    /**
     * 主键id
     */
    @Id
    @Column
    private Integer regionId;

    /**
     * 地区编码
     */
    @Column
    private String regionCode;

    /**
     * 地区名
     */
    @Column
    private String regionName;

    /**
     * 地区级别（1:省份province,2:市city,3:区县district,4:街道street）
     */
    @Column
    private Integer level;

    /**
     * 城市编码
     */
    @Column
    private String cityCode;

    /**
     * 城市中心经度
     */
    @Column
    private String lng;

    /**
     * 城市中心纬度
     */
    @Column
    private String lat;

    /**
     * 地区父节点
     */
    @Column
    private Integer parentId;

}