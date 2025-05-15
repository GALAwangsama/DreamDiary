package com.dream.module.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dream.module.mapper.DreamRecommendationMapper;
import com.dream.module.domain.DreamRecommendation;
import com.dream.module.service.IDreamRecommendationService;

/**
 * 推荐计划Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
@Service
public class DreamRecommendationServiceImpl implements IDreamRecommendationService 
{
    @Autowired
    private DreamRecommendationMapper dreamRecommendationMapper;

    /**
     * 查询推荐计划
     * 
     * @param id 推荐计划主键
     * @return 推荐计划
     */
    @Override
    public DreamRecommendation selectDreamRecommendationById(Long id)
    {
        return dreamRecommendationMapper.selectDreamRecommendationById(id);
    }

    /**
     * 查询推荐计划列表
     * 
     * @param dreamRecommendation 推荐计划
     * @return 推荐计划
     */
    @Override
    public List<DreamRecommendation> selectDreamRecommendationList(DreamRecommendation dreamRecommendation)
    {
        return dreamRecommendationMapper.selectDreamRecommendationList(dreamRecommendation);
    }

    /**
     * 新增推荐计划
     * 
     * @param dreamRecommendation 推荐计划
     * @return 结果
     */
    @Override
    public int insertDreamRecommendation(DreamRecommendation dreamRecommendation)
    {
        return dreamRecommendationMapper.insertDreamRecommendation(dreamRecommendation);
    }

    /**
     * 修改推荐计划
     * 
     * @param dreamRecommendation 推荐计划
     * @return 结果
     */
    @Override
    public int updateDreamRecommendation(DreamRecommendation dreamRecommendation)
    {
        return dreamRecommendationMapper.updateDreamRecommendation(dreamRecommendation);
    }

    /**
     * 批量删除推荐计划
     * 
     * @param ids 需要删除的推荐计划主键
     * @return 结果
     */
    @Override
    public int deleteDreamRecommendationByIds(Long[] ids)
    {
        return dreamRecommendationMapper.deleteDreamRecommendationByIds(ids);
    }

    /**
     * 删除推荐计划信息
     * 
     * @param id 推荐计划主键
     * @return 结果
     */
    @Override
    public int deleteDreamRecommendationById(Long id)
    {
        return dreamRecommendationMapper.deleteDreamRecommendationById(id);
    }
}
