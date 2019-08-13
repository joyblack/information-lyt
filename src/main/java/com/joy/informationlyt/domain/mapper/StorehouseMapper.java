package com.joy.informationlyt.domain.mapper;

import com.joy.informationlyt.domain.entity.Storehouse;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface StorehouseMapper extends Mapper<Storehouse> {
    /**
     * 查询id不为id，名称为name的记录信息
     */
    Storehouse selectOneByNameAndIdNot(@Param("name") String name, @Param("id") Long id);

    /**
     * 根据仓库名查询仓库信息
     */
    Storehouse selectOneByName(@Param("name") String name);
}