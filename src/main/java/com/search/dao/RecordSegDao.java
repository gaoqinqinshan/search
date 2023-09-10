package com.search.dao;

import com.search.entity.Record;
import com.search.entity.RecordSeg;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordSegDao {
    /**
     * 查询所有
     *
     * @return
     */
    List<RecordSeg> selectAllRecordSeg();

    /**
     * 根据 redordId segId查询单个关系
     *
     * @param recordId
     * @param segId
     * @return
     */
    RecordSeg selectOneRecordSeg(@Param("dataId") Integer recordId, @Param("segId") Integer segId);

    /**
     * 根据segId查询对应关系
     *
     * @param segId
     * @return
     */
    List<RecordSeg> selectRecordSeg(@Param("segId") Integer segId);

    /**
     * 插入关系表
     *
     * @param recordSeg
     * @return
     */
    int insertRecordSeg(RecordSeg recordSeg);

    /**
     * 更新关系表
     *
     * @param recordSeg
     * @return
     */
    int updataRecordSeg(RecordSeg recordSeg);

    /**
     * 批量插入关系表
     *
     * @param relations
     * @return
     */
    boolean insertBatch(@Param("relations") List<RecordSeg> relations);
}
