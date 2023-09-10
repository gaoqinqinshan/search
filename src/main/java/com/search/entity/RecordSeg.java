package com.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 关系表的实例化
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordSeg {

    //数据id
    private Integer dataId;

    //本身id
    private Integer segId;

    //对于时间的值
    private Double tidifValue;

    //数目
    private Integer count;
}
