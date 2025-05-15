package com.dream.module.domain;

import com.dream.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dream.common.annotation.Excel;

/**
 * 推荐计划对象 dream_recommendation
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
public class DreamRecommendation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 建议内容 */
    @Excel(name = "建议内容")
    private String planContent;

    /** 建议标签（代办内容） */
    @Excel(name = "建议标签", readConverterExp = "代=办内容")
    private String planTags;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setPlanContent(String planContent) 
    {
        this.planContent = planContent;
    }

    public String getPlanContent() 
    {
        return planContent;
    }

    public void setPlanTags(String planTags) 
    {
        this.planTags = planTags;
    }

    public String getPlanTags() 
    {
        return planTags;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("planContent", getPlanContent())
            .append("planTags", getPlanTags())
            .toString();
    }
}
