package com.dream.module.mapper;

import java.util.List;
import com.dream.module.domain.DreamSleep;
import org.apache.ibatis.annotations.Mapper;

/**
 * 睡眠参数Mapper接口
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
@Mapper
public interface DreamSleepMapper 
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
     * 删除睡眠参数
     * 
     * @param id 睡眠参数主键
     * @return 结果
     */
    public int deleteDreamSleepById(Long id);

    /**
     * 批量删除睡眠参数
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDreamSleepByIds(Long[] ids);
}
