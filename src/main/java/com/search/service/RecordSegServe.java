package com.search.service;

import com.search.entity.RecordSeg;
import com.search.entity.Segmentation;

import java.util.List;

public interface RecordSegServe {

    List<Integer> queryRecordBySeg(Segmentation segmentation);

    boolean addBatch(List<RecordSeg> recordSegs);
}
