package com.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 记录
 * id url 图片
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {

    private Integer id;

    private String url;

    private String caption;
}
