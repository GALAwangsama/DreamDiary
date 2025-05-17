package com.dream.module.domain;

import com.dream.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dream.common.annotation.Excel;

/**
 * 代办对象 dream_todo
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
public class DreamTodo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 代办内容 */
    @Excel(name = "代办内容")
    private String content;


    /** 代办标识，标识代办来自的建议id */
    @Excel(name="代办来源建议")
    private Long recommendationId;

    /** 代办是否完成标识，0表示未完成，1表示已完成 */
    @Excel(name = "代办是否完成标识，0表示未完成，1表示已完成")
    private Integer isCompleted;

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

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public void setIsCompleted(Integer isCompleted) 
    {
        this.isCompleted = isCompleted;
    }

    public Integer getIsCompleted() 
    {
        return isCompleted;
    }

    public Long getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(Long recommendationId) {
        this.recommendationId = recommendationId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("content", getContent())
            .append("isCompleted", getIsCompleted())
            .toString();
    }
}
