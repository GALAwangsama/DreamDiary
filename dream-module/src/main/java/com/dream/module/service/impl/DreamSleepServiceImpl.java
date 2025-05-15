package com.dream.module.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dream.module.mapper.DreamSleepMapper;
import com.dream.module.domain.DreamSleep;
import com.dream.module.service.IDreamSleepService;

/**
 * 睡眠参数Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
@Service
public class DreamSleepServiceImpl implements IDreamSleepService 
{
    @Autowired
    private DreamSleepMapper dreamSleepMapper;

    /**
     * 查询睡眠参数
     * 
     * @param id 睡眠参数主键
     * @return 睡眠参数
     */
    @Override
    public DreamSleep selectDreamSleepById(Long id)
    {
        return dreamSleepMapper.selectDreamSleepById(id);
    }

    /**
     * 查询睡眠参数列表
     * 
     * @param dreamSleep 睡眠参数
     * @return 睡眠参数
     */
    @Override
    public List<DreamSleep> selectDreamSleepList(DreamSleep dreamSleep)
    {
        return dreamSleepMapper.selectDreamSleepList(dreamSleep);
    }

    /**
     * 新增睡眠参数
     * 
     * @param dreamSleep 睡眠参数
     * @return 结果
     */
    @Override
    public int insertDreamSleep(DreamSleep dreamSleep)
    {
        return dreamSleepMapper.insertDreamSleep(dreamSleep);
    }

    /**
     * 修改睡眠参数
     * 
     * @param dreamSleep 睡眠参数
     * @return 结果
     */
    @Override
    public int updateDreamSleep(DreamSleep dreamSleep)
    {
        return dreamSleepMapper.updateDreamSleep(dreamSleep);
    }

    /**
     * 批量删除睡眠参数
     * 
     * @param ids 需要删除的睡眠参数主键
     * @return 结果
     */
    @Override
    public int deleteDreamSleepByIds(Long[] ids)
    {
        return dreamSleepMapper.deleteDreamSleepByIds(ids);
    }

    /**
     * 删除睡眠参数信息
     * 
     * @param id 睡眠参数主键
     * @return 结果
     */
    @Override
    public int deleteDreamSleepById(Long id)
    {
        return dreamSleepMapper.deleteDreamSleepById(id);
    }
}
