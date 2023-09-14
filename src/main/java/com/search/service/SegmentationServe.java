package com.search.service;

import com.search.common.SegResult;
import com.search.entity.Segmentation;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface SegmentationServe {
    List<Segmentation> queryAllSeg();

    Boolean addSeg(String word, Integer recordId, Double tidifValue);

    Boolean addSeg(String word, Integer recordId);

    Boolean addSeg(List<SegResult> segResults);

    int getMaxId();

    boolean insertBatchSeg(List<String> segs);

    List<String> getAllByWords(@Param("word") String word);
}
