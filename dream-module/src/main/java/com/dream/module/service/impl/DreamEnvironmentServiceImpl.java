package com.dream.module.service.impl;

import java.util.List;

import com.dream.module.mapper.DreamEnvironmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dream.module.domain.DreamEnvironment;
import com.dream.module.service.IDreamEnvironmentService;

/**
 * 环境参数Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
@Service
public class DreamEnvironmentServiceImpl implements IDreamEnvironmentService 
{
    @Autowired
    private DreamEnvironmentMapper dreamEnvironmentMapper;

    /**
     * 查询环境参数
     * 
     * @param id 环境参数主键
     * @return 环境参数
     */
    @Override
    public DreamEnvironment selectDreamEnvironmentById(Long id)
    {
        return dreamEnvironmentMapper.selectDreamEnvironmentById(id);
    }

    /**
     * 查询环境参数列表
     * 
     * @param dreamEnvironment 环境参数
     * @return 环境参数
     */
    @Override
    public List<DreamEnvironment> selectDreamEnvironmentList(DreamEnvironment dreamEnvironment)
    {
        return dreamEnvironmentMapper.selectDreamEnvironmentList(dreamEnvironment);
    }

    /**
     * 新增环境参数
     * 
     * @param dreamEnvironment 环境参数
     * @return 结果
     */
    @Override
    public int insertDreamEnvironment(DreamEnvironment dreamEnvironment)
    {
        return dreamEnvironmentMapper.insertDreamEnvironment(dreamEnvironment);
    }

    /**
     * 修改环境参数
     * 
     * @param dreamEnvironment 环境参数
     * @return 结果
     */
    @Override
    public int updateDreamEnvironment(DreamEnvironment dreamEnvironment)
    {
        return dreamEnvironmentMapper.updateDreamEnvironment(dreamEnvironment);
    }

    /**
     * 批量删除环境参数
     * 
     * @param ids 需要删除的环境参数主键
     * @return 结果
     */
    @Override
    public int deleteDreamEnvironmentByIds(Long[] ids)
    {
        return dreamEnvironmentMapper.deleteDreamEnvironmentByIds(ids);
    }

    /**
     * 删除环境参数信息
     * 
     * @param id 环境参数主键
     * @return 结果
     */
    @Override
    public int deleteDreamEnvironmentById(Long id)
    {
        return dreamEnvironmentMapper.deleteDreamEnvironmentById(id);
    }
}
