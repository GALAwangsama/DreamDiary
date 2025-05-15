package com.dream.module.domain;

import java.util.Date;

import com.dream.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dream.common.annotation.Excel;

/**
 * 会员标记对象 dream_vip
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
public class DreamVip extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 用户VIP等级 */
    @Excel(name = "用户VIP等级")
    private Long vipLevel;

    /** 用户VIP过期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "用户VIP过期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date vipExpiryDate;

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

    public void setVipLevel(Long vipLevel) 
    {
        this.vipLevel = vipLevel;
    }

    public Long getVipLevel() 
    {
        return vipLevel;
    }

    public void setVipExpiryDate(Date vipExpiryDate) 
    {
        this.vipExpiryDate = vipExpiryDate;
    }

    public Date getVipExpiryDate() 
    {
        return vipExpiryDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("vipLevel", getVipLevel())
            .append("vipExpiryDate", getVipExpiryDate())
            .toString();
    }
}
