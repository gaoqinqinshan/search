package com.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * id  和 word 的具体实例化
 */
@Data
@AllArgsConstructor
public class Segmentation {
    private int id;
    private String word;
}
