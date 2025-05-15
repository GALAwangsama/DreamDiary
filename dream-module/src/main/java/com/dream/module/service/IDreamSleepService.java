package com.dream.module.service;

import java.util.List;
import com.dream.module.domain.DreamSleep;

/**
 * 睡眠参数Service接口
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
public interface IDreamSleepService 
{
    /**
     * 查询睡眠参数
     * 
     * @param id 睡眠参数主键
     * @return 睡眠参数
     */
    public DreamSleep selectDreamSleepById(Long id);

    /**
     * 查询睡眠参数列表
     * 
     * @param dreamSleep 睡眠参数
     * @return 睡眠参数集合
     */
    public List<DreamSleep> selectDreamSleepList(DreamSleep dreamSleep);

    /**
     * 新增睡眠参数
     * 
     * @param dreamSleep 睡眠参数
     * @return 结果
     */
    public int insertDreamSleep(DreamSleep dreamSleep);

    /**
     * 修改睡眠参数
     * 
     * @param dreamSleep 睡眠参数
     * @return 结果
     */
    public int updateDreamSleep(DreamSleep dreamSleep);

    /**
     * 批量删除睡眠参数
     * 
     * @param ids 需要删除的睡眠参数主键集合
     * @return 结果
     */
    public int deleteDreamSleepByIds(Long[] ids);

    /**
     * 删除睡眠参数信息
     * 
     * @param id 睡眠参数主键
     * @return 结果
     */
    public int deleteDreamSleepById(Long id);
}
