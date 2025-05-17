package com.dream.module.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dream.module.mapper.DreamUserdiseasehistoryMapper;
import com.dream.module.domain.DreamUserdiseasehistory;
import com.dream.module.service.IDreamUserdiseasehistoryService;

/**
 * 用户病史，存储用户与疾病信息的关联关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-17
 */
@Service
public class DreamUserdiseasehistoryServiceImpl implements IDreamUserdiseasehistoryService 
{
    @Autowired
    private DreamUserdiseasehistoryMapper dreamUserdiseasehistoryMapper;

    /**
     * 查询用户病史，存储用户与疾病信息的关联关系
     * 
     * @param id 用户病史，存储用户与疾病信息的关联关系主键
     * @return 用户病史，存储用户与疾病信息的关联关系
     */
    @Override
    public DreamUserdiseasehistory selectDreamUserdiseasehistoryById(Long id)
    {
        return dreamUserdiseasehistoryMapper.selectDreamUserdiseasehistoryById(id);
    }

    /**
     * 查询用户病史，存储用户与疾病信息的关联关系列表
     * 
     * @param dreamUserdiseasehistory 用户病史，存储用户与疾病信息的关联关系
     * @return 用户病史，存储用户与疾病信息的关联关系
     */
    @Override
    public List<DreamUserdiseasehistory> selectDreamUserdiseasehistoryList(DreamUserdiseasehistory dreamUserdiseasehistory)
    {
        return dreamUserdiseasehistoryMapper.selectDreamUserdiseasehistoryList(dreamUserdiseasehistory);
    }

    /**
     * 新增用户病史，存储用户与疾病信息的关联关系
     * 
     * @param dreamUserdiseasehistory 用户病史，存储用户与疾病信息的关联关系
     * @return 结果
     */
    @Override
    public int insertDreamUserdiseasehistory(DreamUserdiseasehistory dreamUserdiseasehistory)
    {
        return dreamUserdiseasehistoryMapper.insertDreamUserdiseasehistory(dreamUserdiseasehistory);
    }

    /**
     * 修改用户病史，存储用户与疾病信息的关联关系
     * 
     * @param dreamUserdiseasehistory 用户病史，存储用户与疾病信息的关联关系
     * @return 结果
     */
    @Override
    public int updateDreamUserdiseasehistory(DreamUserdiseasehistory dreamUserdiseasehistory)
    {
        return dreamUserdiseasehistoryMapper.updateDreamUserdiseasehistory(dreamUserdiseasehistory);
    }

    /**
     * 批量删除用户病史，存储用户与疾病信息的关联关系
     * 
     * @param ids 需要删除的用户病史，存储用户与疾病信息的关联关系主键
     * @return 结果
     */
    @Override
    public int deleteDreamUserdiseasehistoryByIds(Long[] ids)
    {
        return dreamUserdiseasehistoryMapper.deleteDreamUserdiseasehistoryByIds(ids);
    }

    /**
     * 删除用户病史，存储用户与疾病信息的关联关系信息
     * 
     * @param id 用户病史，存储用户与疾病信息的关联关系主键
     * @return 结果
     */
    @Override
    public int deleteDreamUserdiseasehistoryById(Long id)
    {
        return dreamUserdiseasehistoryMapper.deleteDreamUserdiseasehistoryById(id);
    }
}
