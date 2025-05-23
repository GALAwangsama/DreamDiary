package com.dream.module.service;

import java.util.List;
import com.dream.module.domain.DreamUserdiseasehistory;

/**
 * 用户病史，存储用户与疾病信息的关联关系Service接口
 * 
 * @author ruoyi
 * @date 2025-05-17
 */
public interface IDreamUserdiseasehistoryService 
{
    /**
     * 查询用户病史，存储用户与疾病信息的关联关系
     * 
     * @param id 用户病史，存储用户与疾病信息的关联关系主键
     * @return 用户病史，存储用户与疾病信息的关联关系
     */
    public DreamUserdiseasehistory selectDreamUserdiseasehistoryById(Long id);

    /**
     * 查询用户病史，存储用户与疾病信息的关联关系列表
     * 
     * @param dreamUserdiseasehistory 用户病史，存储用户与疾病信息的关联关系
     * @return 用户病史，存储用户与疾病信息的关联关系集合
     */
    public List<DreamUserdiseasehistory> selectDreamUserdiseasehistoryList(DreamUserdiseasehistory dreamUserdiseasehistory);

    /**
     * 新增用户病史，存储用户与疾病信息的关联关系
     * 
     * @param dreamUserdiseasehistory 用户病史，存储用户与疾病信息的关联关系
     * @return 结果
     */
    public int insertDreamUserdiseasehistory(DreamUserdiseasehistory dreamUserdiseasehistory);

    /**
     * 修改用户病史，存储用户与疾病信息的关联关系
     * 
     * @param dreamUserdiseasehistory 用户病史，存储用户与疾病信息的关联关系
     * @return 结果
     */
    public int updateDreamUserdiseasehistory(DreamUserdiseasehistory dreamUserdiseasehistory);

    /**
     * 批量删除用户病史，存储用户与疾病信息的关联关系
     * 
     * @param ids 需要删除的用户病史，存储用户与疾病信息的关联关系主键集合
     * @return 结果
     */
    public int deleteDreamUserdiseasehistoryByIds(Long[] ids);

    /**
     * 删除用户病史，存储用户与疾病信息的关联关系信息
     * 
     * @param id 用户病史，存储用户与疾病信息的关联关系主键
     * @return 结果
     */
    public int deleteDreamUserdiseasehistoryById(Long id);

    /**
     * 根据用户id查询用户病史，存储用户与疾病信息的关联关系
     * @param userId 用户病史，存储用户与疾病信息的关联关系主键
     * @return 结果
     */
    DreamUserdiseasehistory selectDreamUserdiseasehistoryByUserId(Long userId);
}
