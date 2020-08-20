## 中国省市区通用查询场景启动器

1. 该场景启动器是用于中国省市区3级通用查询
2. 基于高德的API(https://restapi.amap.com/v3/config/district?keywords=中国&subdistrict=3&key=5b138cc729f37d29702ff904ca9cedeb)获取最新的省市区信息,其中subdistrict参数可以设置到4级至街道
3. 系统集成了jpa的自动建表功能,如果宿主应用中配置了```ddl-auto:update```则直接建表(但是因为jpa自动建表导致字段排序问题,所以仍然通过sql导入数据库中)
4. 系统提供了统一的查询接口(POST+JSON格式)

### 引入starter

```xml
<dependency>
    <groupId>me.sdevil507</groupId>
    <artifactId>region-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 查询

地址:`[POST+JSON]http(s)://ip:port/supports/region/readAll`

查询参数:
```
regionId:省市区表id
level:1:省份province,2:市city,3:区县district,4:街道street
parentId:省市区父id
regionName:省市区名称
regionCode:省市区编码
cityCode:城市编码
```

查询示例:

http://127.0.0.1:8080/supports/region/readAll

```json
{
  "regionId":1
}
```

### 初始化数据表

在项目工程/tools/region_data下初始化文件如下:

```
common_region_tools.py:生成sql与json数据文件
common_region.sql:生成的初始化数据sql文件(用于导入)
common_region.json:生成的json格式文件
```

注意:common_region_tools.py文件必须使用python3环境,在当前目录生成初始化文件

命令:python3 common_region_tools.py

