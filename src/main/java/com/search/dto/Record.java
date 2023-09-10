package com.search.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Dto定义实体类（.class文件）
 */
@Data
@AllArgsConstructor
public class Record {
    private String url;
    private String caption;
}
