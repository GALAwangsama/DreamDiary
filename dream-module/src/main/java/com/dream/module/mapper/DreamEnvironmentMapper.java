package com.dream.module.mapper;

import java.util.List;
import com.dream.module.domain.DreamEnvironment;
import org.apache.ibatis.annotations.Mapper;

/**
 * 环境参数Mapper接口
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
@Mapper
public interface DreamEnvironmentMapper 
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
     * 删除环境参数
     * 
     * @param id 环境参数主键
     * @return 结果
     */
    public int deleteDreamEnvironmentById(Long id);

    /**
     * 批量删除环境参数
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDreamEnvironmentByIds(Long[] ids);
}
