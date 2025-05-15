package com.dream.module.domain;

import com.dream.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dream.common.annotation.Excel;

/**
 * 环境参数对象 dream_environment
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
public class DreamEnvironment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 温度 */
    @Excel(name = "温度")
    private Long temperature;

    /** 湿度 */
    @Excel(name = "湿度")
    private Long humidity;

    /** 分贝 */
    @Excel(name = "分贝")
    private Long decibel;

    /** 光线 */
    @Excel(name = "光线")
    private Long light;

    /** 空气质量 */
    @Excel(name = "空气质量")
    private String airQuality;

    /** 二氧化碳浓度 */
    @Excel(name = "二氧化碳浓度")
    private Long carbonDioxideConcentration;

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

    public void setTemperature(Long temperature) 
    {
        this.temperature = temperature;
    }

    public Long getTemperature() 
    {
        return temperature;
    }

    public void setHumidity(Long humidity) 
    {
        this.humidity = humidity;
    }

    public Long getHumidity() 
    {
        return humidity;
    }

    public void setDecibel(Long decibel) 
    {
        this.decibel = decibel;
    }

    public Long getDecibel() 
    {
        return decibel;
    }

    public void setLight(Long light) 
    {
        this.light = light;
    }

    public Long getLight() 
    {
        return light;
    }

    public void setAirQuality(String airQuality) 
    {
        this.airQuality = airQuality;
    }

    public String getAirQuality() 
    {
        return airQuality;
    }

    public void setCarbonDioxideConcentration(Long carbonDioxideConcentration) 
    {
        this.carbonDioxideConcentration = carbonDioxideConcentration;
    }

    public Long getCarbonDioxideConcentration() 
    {
        return carbonDioxideConcentration;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("temperature", getTemperature())
            .append("humidity", getHumidity())
            .append("decibel", getDecibel())
            .append("light", getLight())
            .append("airQuality", getAirQuality())
            .append("carbonDioxideConcentration", getCarbonDioxideConcentration())
            .toString();
    }
}
