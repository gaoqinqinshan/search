package com.search.service.impl;

import com.search.common.SegResult;
import com.search.entity.Segmentation;
import com.search.service.SegmentationServe;

import java.util.List;

/**
 * 分词的具体实现
 */
public class SegmentationServeImpl implements SegmentationServe {
    @Override
    public List<Segmentation> queryAllSeg() {
        return null;
    }

    @Override
    public Boolean addSeg(String word, Integer recordId, Double tidifValue) {
        return null;
    }

    @Override
    public Boolean addSeg(String word, Integer recordId) {
        return null;
    }

    @Override
    public Boolean addSeg(List<SegResult> segResults) {
        return null;
    }

    @Override
    public int getMaxId() {
        return 0;
    }

    @Override
    public boolean insertBatchSeg(List<String> segs) {
        return false;
    }

    @Override
    public List<String> getAllByWords(String word) {
        return null;
    }
}
