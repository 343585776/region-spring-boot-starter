package me.sdevil507.supports.region.dto;


import lombok.Data;

/**
 * 省市区地区码表[RegionParamsDto]
 *
 * @author sdevil507
 * created on 2020-07-02 14:15:13
 */
@Data
public class RegionParamsDto {

    /**
     * 地区Id
     */
    private Integer regionId;

    /**
     * 地区编码
     */
    private String regionCode;

    /**
     * 地区名
     */
    private String regionName;

    /**
     * 地区级别（1:省份province,2:市city,3:区县district,4:街道street）
     */
    private Integer level;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 城市中心经度
     */
    private String lng;

    /**
     * 城市中心纬度
     */
    private String lat;

    /**
     * 地区父节点
     */
    private Integer parentId;

}