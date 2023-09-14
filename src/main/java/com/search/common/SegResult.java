package com.search.common;

import lombok.Data;

/**
 * 分词的使用---分词的说明（这个就是把文本的关键字提取出来
 * 并且统计他的次数  这个时候就可以
 * 把权重前一点的好进行搜索）
 */
@Data
public class SegResult {
    int recordId;            //文本数据id

    String word;             //分词

    int count;               //分词出现次数

    double tidifValue;       //分词对应该文本的权重值
}
