package com.search.service.impl;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.search.dao.RecordDao;
import com.search.dao.RecordSegDao;
import com.search.dao.SegmentationDao;
import com.search.dto.RecordDto;
import com.search.entity.Record;
import com.search.entity.Segmentation;
import com.search.service.RecordSegServe;
import com.search.service.RecordServe;
import com.search.utils.RedisUtil_db0;
import com.search.utils.jieba.keyword.TFIDFAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RecordServeImpl implements RecordServe {

    @Autowired
    private SegmentationDao segmentationDao;


    @Autowired
    private RecordDao recordDao;

    @Autowired
    RecordSegServe recordSegServe;

    @Autowired
    RedisUtil_db0 redisUtil;

    //结巴分词         ======这不是我的模块
    TFIDFAnalyzer tfidfAnalyzer = new TFIDFAnalyzer();

    //                ==============这个也不是我的模块
    JiebaSegmenter segmenter = new JiebaSegmenter();

    //查询所有的记录
    @Override
    public List<Record> queryAllRecord() {
        return recordDao.selectAllRecord();
    }

    //查询部分记录
    @Override
    public List<Record> selectPartialRecords(int limit, int offset) {
        return recordDao.selectPartialRecords(limit, offset);
    }

    //根据单词查询记录
    @Override
    public List<Record> queryRecordByWord(String word) {
        word = "%" + word + "%";
        return recordDao.selectRecordsByWord(word);
    }

    @Override
    public List<Record> queryRecordFilter(String word) {
        return null;
    }

    @Override
    public List<RecordDto> search(String searchInfo) {

        // ======检查是否需要过滤======start







        return null;
    }

    @Override
    public Boolean addRecord(Record record) {
        return null;
    }
}
