package com.dream.module.service;

import java.util.List;
import com.dream.module.domain.DreamEnvironment;

/**
 * 环境参数Service接口
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
public interface IDreamEnvironmentService 
{
    /**
     * 查询环境参数
     * 
     * @param id 环境参数主键
     * @return 环境参数
     */
    public DreamEnvironment selectDreamEnvironmentById(Long id);

    /**
     * 查询环境参数列表
     * 
     * @param dreamEnvironment 环境参数
     * @return 环境参数集合
     */
    public List<DreamEnvironment> selectDreamEnvironmentList(DreamEnvironment dreamEnvironment);

    /**
     * 新增环境参数
     * 
     * @param dreamEnvironment 环境参数
     * @return 结果
     */
    public int insertDreamEnvironment(DreamEnvironment dreamEnvironment);

    /**
     * 修改环境参数
     * 
     * @param dreamEnvironment 环境参数
     * @return 结果
     */
    public int updateDreamEnvironment(DreamEnvironment dreamEnvironment);

    /**
     * 批量删除环境参数
     * 
     * @param ids 需要删除的环境参数主键集合
     * @return 结果
     */
    public int deleteDreamEnvironmentByIds(Long[] ids);

    /**
     * 删除环境参数信息
     * 
     * @param id 环境参数主键
     * @return 结果
     */
    public int deleteDreamEnvironmentById(Long id);
}
