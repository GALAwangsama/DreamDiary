package com.dream.module.mapper;

import java.util.List;
import com.dream.module.domain.DreamTodo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 代办Mapper接口
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
@Mapper
public interface DreamTodoMapper 
{
    /**
     * 查询代办
     * 
     * @param id 代办主键
     * @return 代办
     */
    public DreamTodo selectDreamTodoById(Long id);

    /**
     * 查询代办列表
     * 
     * @param dreamTodo 代办
     * @return 代办集合
     */
    public List<DreamTodo> selectDreamTodoList(DreamTodo dreamTodo);

    /**
     * 新增代办
     * 
     * @param dreamTodo 代办
     * @return 结果
     */
    public int insertDreamTodo(DreamTodo dreamTodo);

    /**
     * 修改代办
     * 
     * @param dreamTodo 代办
     * @return 结果
     */
    public int updateDreamTodo(DreamTodo dreamTodo);

    /**
     * 删除代办
     * 
     * @param id 代办主键
     * @return 结果
     */
    public int deleteDreamTodoById(Long id);

    /**
     * 批量删除代办
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDreamTodoByIds(Long[] ids);

    public int deleteDreamTodoByRecommendationIds(Long[] recommendationIds);
}
