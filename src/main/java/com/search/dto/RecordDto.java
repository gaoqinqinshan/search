package com.search.dto;

import com.search.entity.Record;
import com.search.entity.RecordSeg;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 把前端数据得到的用DTO发送到后台
 */
@Data
public class RecordDto extends Record {
    private List<RecordSeg> recordSegs = new ArrayList<>();
    private double weight;
}
