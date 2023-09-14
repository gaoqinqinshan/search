package com.search.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.search.dao.RecordDao;
import com.search.dto.RecordDto;
import com.search.entity.Record;
import com.search.entity.RecordSeg;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecordServe {

    /**
     * 查询所有的记录
     *
     * @return
     */
    List<Record> queryAllRecord();

    /**
     * 选择查询部分记录
     *
     * @param limit
     * @param offset
     * @return
     */
    List<Record> selectPartialRecords(int limit, int offset);

    /**
     * 根据单词查询记录
     *
     * @param word
     * @return
     */
    List<Record> queryRecordByWord(String word);

    /**
     * 查询过滤记录
     *
     * @param word
     * @return
     */
    List<Record> queryRecordFilter(String word);

    List<RecordDto> search(String searchInfo);

    /**
     * 添加记录
     *
     * @param record
     * @return
     */
    Boolean addRecord(Record record);
}
