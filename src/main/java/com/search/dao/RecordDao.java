package com.search.dao;

import com.search.entity.Record;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 对于记录的功能包括如下；
 * 1.查询所有的记录
 * 2.查询部分记录
 * 3.根据单词查询
 * 4.根据id查询
 * 5.添加记录
 */
@Repository
public interface RecordDao {

    /**
     * 查询所有记录
     *
     * @return
     */
    List<Record> selectAllRecord();

    /**
     * 查询部分记录
     *
     * @param limit
     * @param offset
     * @return
     */
    List<Record> selectPartialRecords(@Param("limit") int limit, @Param("offset") int offset);

    /**
     * 根据单词查询
     *
     * @param word
     * @return
     */
    List<Record> selectRecordsByWord(String word);

    /**
     * 根据 id查询记录
     *
     * @param id
     * @return
     */
    Record selectById(@Param("id") int id);

    /**
     * 添加记录
     *
     * @param record
     * @return
     */
    int insertRecord(Record record);

}
