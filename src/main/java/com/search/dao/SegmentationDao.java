package com.search.dao;


import com.search.entity.Segmentation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SegmentationDao {

    //查询所有的分词
    List<Segmentation> SelectAllSeg();

    //加入新分词
    int insertSeg(String word);

    //查询单个分词对应的id
    Segmentation selectOneOneSeg(String word);

    //根据id查询
    Segmentation selectOneById(@Param("id") int id);

    //查询最大的id
    int getMaxId();

    //批量插入分词
    boolean insertBatchSeg(@org.apache.ibatis.annotations.Param("seg") List<String> segs);

    List<Segmentation> getAllByWord(String word);
}
