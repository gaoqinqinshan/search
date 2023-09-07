package com.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TreeNode {
    String id;
    String pid;
    String name;
    String isLeaf;
    String url;
}
