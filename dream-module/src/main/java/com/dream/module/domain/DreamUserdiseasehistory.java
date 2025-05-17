package com.dream.module.domain;

import java.util.Date;

import com.dream.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dream.common.annotation.Excel;

/**
 * 用户病史，存储用户与疾病信息的关联关系对象 dream_userdiseasehistory
 * 
 * @author ruoyi
 * @date 2025-05-17
 */
public class DreamUserdiseasehistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID，自动生成 */
    private Long id;

    /** 用户ID，关联用户表 */
    @Excel(name = "用户ID，关联用户表")
    private Long userId;

    /** 疾病ID，关联疾病信息表 */
    @Excel(name = "疾病ID，关联疾病信息表")
    private Long diseaseId;

    /** 填写日期，记录用户填写病史的日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "填写日期，记录用户填写病史的日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fillDate;

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

    public void setDiseaseId(Long diseaseId) 
    {
        this.diseaseId = diseaseId;
    }

    public Long getDiseaseId() 
    {
        return diseaseId;
    }

    public void setFillDate(Date fillDate) 
    {
        this.fillDate = fillDate;
    }

    public Date getFillDate() 
    {
        return fillDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("diseaseId", getDiseaseId())
            .append("fillDate", getFillDate())
            .toString();
    }
}
