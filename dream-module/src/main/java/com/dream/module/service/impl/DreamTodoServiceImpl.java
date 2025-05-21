package com.dream.module.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dream.module.mapper.DreamTodoMapper;
import com.dream.module.domain.DreamTodo;
import com.dream.module.service.IDreamTodoService;

/**
 * 代办Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
@Service
public class DreamTodoServiceImpl implements IDreamTodoService 
{
    @Autowired
    private DreamTodoMapper dreamTodoMapper;

    /**
     * 查询代办
     * 
     * @param id 代办主键
     * @return 代办
     */
    @Override
    public DreamTodo selectDreamTodoById(Long id)
    {
        return dreamTodoMapper.selectDreamTodoById(id);
    }

    /**
     * 查询代办列表
     * 
     * @param dreamTodo 代办
     * @return 代办
     */
    @Override
    public List<DreamTodo> selectDreamTodoList(DreamTodo dreamTodo)
    {
        return dreamTodoMapper.selectDreamTodoList(dreamTodo);
    }

    /**
     * 新增代办
     * 
     * @param dreamTodo 代办
     * @return 结果
     */
    @Override
    public int insertDreamTodo(DreamTodo dreamTodo)
    {
        return dreamTodoMapper.insertDreamTodo(dreamTodo);
    }

    /**
     * 修改代办
     * 
     * @param dreamTodo 代办
     * @return 结果
     */
    @Override
    public int updateDreamTodo(DreamTodo dreamTodo)
    {
        return dreamTodoMapper.updateDreamTodo(dreamTodo);
    }

    /**
     * 批量删除代办
     * 
     * @param ids 需要删除的代办主键
     * @return 结果
     */
    @Override
    public int deleteDreamTodoByIds(Long[] ids)
    {
        return dreamTodoMapper.deleteDreamTodoByIds(ids);
    }

    /**
     * 删除代办信息
     * 
     * @param id 代办主键
     * @return 结果
     */
    @Override
    public int deleteDreamTodoById(Long id)
    {
        return dreamTodoMapper.deleteDreamTodoById(id);
    }

    /**
     * 根据recommendation批量删除代办
     *
     * @param recommendationIds 需要删除的代办主键
     * @return 结果
     */
    @Override
    public int deleteDreamTodoByRecommendationIds(Long[] recommendationIds) {
        return dreamTodoMapper.deleteDreamTodoByRecommendationIds(recommendationIds);
    }
}
