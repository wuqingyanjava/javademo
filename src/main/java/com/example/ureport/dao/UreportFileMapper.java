package com.example.ureport.dao;

import com.example.ureport.entity.UreportFileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/8/2 10:20
 * Modify Log
 **/
@Mapper
@Repository
public interface UreportFileMapper {
    /**
     *  根据报表名称检查报表是否存在
     * @param name 报表名称
     * @return
     */
    public int checkExistByName(String name);

    /**
     *  根据报表名称查询报表
     * @param name 报表名称
     * @return
     */
    public UreportFileEntity queryUreportFileEntityByName(String name);

    /**
     * 查询全部报表
     * @return
     */
    public List<UreportFileEntity> queryReportFileList();

    /**
     * 根据报表名称删除报表
     * @param name
     * @return
     */
    public int deleteReportFileByName(String name);


    /**
     *  保存报表
     */
    public int insertReportFile(UreportFileEntity entity);

    /**
     *  更新报表
     * @param entity
     * @return
     */
    public int updateReportFile(UreportFileEntity entity);
}
