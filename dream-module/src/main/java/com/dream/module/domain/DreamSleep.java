package com.dream.module.domain;

import java.util.Date;

import com.dream.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dream.common.annotation.Excel;

/**
 * 睡眠参数对象 dream_sleep
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
public class DreamSleep extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 心率 */
    @Excel(name = "心率")
    private Long heartRate;

    /** 血氧 */
    @Excel(name = "血氧")
    private Long oxygenLevel;

    /** 体温 */
    @Excel(name = "体温")
    private Long bodyTemperature;

    /** 乳酸 */
    @Excel(name = "乳酸")
    private Long lactate;

    /** 浅睡时长 */
    @Excel(name = "浅睡时长")
    private Long lightSleepDuration;

    /** 深度睡眠时长 */
    @Excel(name = "深度睡眠时长")
    private Long deepSleepDuration;

    /** 快速眼动期 */
    @Excel(name = "快速眼动期")
    private Long rapidEyeMovementDuration;

    /** 清醒次数 */
    @Excel(name = "清醒次数")
    private Long wakeUpCount;

    /** 睡眠呼吸质量 */
    @Excel(name = "睡眠呼吸质量")
    private String sleepBreathingQuality;

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

    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }

    public void setHeartRate(Long heartRate) 
    {
        this.heartRate = heartRate;
    }

    public Long getHeartRate() 
    {
        return heartRate;
    }

    public void setOxygenLevel(Long oxygenLevel) 
    {
        this.oxygenLevel = oxygenLevel;
    }

    public Long getOxygenLevel() 
    {
        return oxygenLevel;
    }

    public void setBodyTemperature(Long bodyTemperature) 
    {
        this.bodyTemperature = bodyTemperature;
    }

    public Long getBodyTemperature() 
    {
        return bodyTemperature;
    }

    public void setLactate(Long lactate) 
    {
        this.lactate = lactate;
    }

    public Long getLactate() 
    {
        return lactate;
    }

    public void setLightSleepDuration(Long lightSleepDuration) 
    {
        this.lightSleepDuration = lightSleepDuration;
    }

    public Long getLightSleepDuration() 
    {
        return lightSleepDuration;
    }

    public void setDeepSleepDuration(Long deepSleepDuration) 
    {
        this.deepSleepDuration = deepSleepDuration;
    }

    public Long getDeepSleepDuration() 
    {
        return deepSleepDuration;
    }

    public void setRapidEyeMovementDuration(Long rapidEyeMovementDuration) 
    {
        this.rapidEyeMovementDuration = rapidEyeMovementDuration;
    }

    public Long getRapidEyeMovementDuration() 
    {
        return rapidEyeMovementDuration;
    }

    public void setWakeUpCount(Long wakeUpCount) 
    {
        this.wakeUpCount = wakeUpCount;
    }

    public Long getWakeUpCount() 
    {
        return wakeUpCount;
    }

    public void setSleepBreathingQuality(String sleepBreathingQuality) 
    {
        this.sleepBreathingQuality = sleepBreathingQuality;
    }

    public String getSleepBreathingQuality() 
    {
        return sleepBreathingQuality;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("date", getDate())
            .append("heartRate", getHeartRate())
            .append("oxygenLevel", getOxygenLevel())
            .append("bodyTemperature", getBodyTemperature())
            .append("lactate", getLactate())
            .append("lightSleepDuration", getLightSleepDuration())
            .append("deepSleepDuration", getDeepSleepDuration())
            .append("rapidEyeMovementDuration", getRapidEyeMovementDuration())
            .append("wakeUpCount", getWakeUpCount())
            .append("sleepBreathingQuality", getSleepBreathingQuality())
            .toString();
    }
}
