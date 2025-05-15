package com.dream.module.service;

import java.util.List;
import com.dream.module.domain.DreamRecommendation;

/**
 * 推荐计划Service接口
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
public interface IDreamRecommendationService 
{
    /**
     * 查询推荐计划
     * 
     * @param id 推荐计划主键
     * @return 推荐计划
     */
    public DreamRecommendation selectDreamRecommendationById(Long id);

    /**
     * 查询推荐计划列表
     * 
     * @param dreamRecommendation 推荐计划
     * @return 推荐计划集合
     */
    public List<DreamRecommendation> selectDreamRecommendationList(DreamRecommendation dreamRecommendation);

    /**
     * 新增推荐计划
     * 
     * @param dreamRecommendation 推荐计划
     * @return 结果
     */
    public int insertDreamRecommendation(DreamRecommendation dreamRecommendation);

    /**
     * 修改推荐计划
     * 
     * @param dreamRecommendation 推荐计划
     * @return 结果
     */
    public int updateDreamRecommendation(DreamRecommendation dreamRecommendation);

    /**
     * 批量删除推荐计划
     * 
     * @param ids 需要删除的推荐计划主键集合
     * @return 结果
     */
    public int deleteDreamRecommendationByIds(Long[] ids);

    /**
     * 删除推荐计划信息
     * 
     * @param id 推荐计划主键
     * @return 结果
     */
    public int deleteDreamRecommendationById(Long id);
}
