package com.dream.module.domain;

import com.dream.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dream.common.annotation.Excel;

/**
 * 病例数据库，存储疾病相关信息及建议对象 dream_diseaseinfo
 * 
 * @author ruoyi
 * @date 2025-05-17
 */
public class DreamDiseaseinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 疾病名 */
    @Excel(name = "疾病名")
    private String diseaseName;

    /** 疾病症状描述 */
    @Excel(name = "疾病症状描述")
    private String diseaseSymptom;

    /** 疾病影响的主要器官 */
    @Excel(name = "疾病影响的主要器官")
    private String damagedOrgan;

    /** 疾病对睡眠的具体影响 */
    @Excel(name = "疾病对睡眠的具体影响")
    private String sleepEffects;

    /** 针对该疾病患者的睡眠建议 */
    @Excel(name = "针对该疾病患者的睡眠建议")
    private String sleepAdvice;

    /** 针对该疾病患者的运动建议 */
    @Excel(name = "针对该疾病患者的运动建议")
    private String sportsAdvice;

    /** 针对该疾病患者的饮食建议 */
    @Excel(name = "针对该疾病患者的饮食建议")
    private String dietaryAdvice;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setDiseaseName(String diseaseName) 
    {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseName() 
    {
        return diseaseName;
    }

    public void setDiseaseSymptom(String diseaseSymptom) 
    {
        this.diseaseSymptom = diseaseSymptom;
    }

    public String getDiseaseSymptom() 
    {
        return diseaseSymptom;
    }

    public void setDamagedOrgan(String damagedOrgan) 
    {
        this.damagedOrgan = damagedOrgan;
    }

    public String getDamagedOrgan() 
    {
        return damagedOrgan;
    }

    public void setSleepEffects(String sleepEffects) 
    {
        this.sleepEffects = sleepEffects;
    }

    public String getSleepEffects() 
    {
        return sleepEffects;
    }

    public void setSleepAdvice(String sleepAdvice) 
    {
        this.sleepAdvice = sleepAdvice;
    }

    public String getSleepAdvice() 
    {
        return sleepAdvice;
    }

    public void setSportsAdvice(String sportsAdvice) 
    {
        this.sportsAdvice = sportsAdvice;
    }

    public String getSportsAdvice() 
    {
        return sportsAdvice;
    }

    public void setDietaryAdvice(String dietaryAdvice) 
    {
        this.dietaryAdvice = dietaryAdvice;
    }

    public String getDietaryAdvice() 
    {
        return dietaryAdvice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("diseaseName", getDiseaseName())
            .append("diseaseSymptom", getDiseaseSymptom())
            .append("damagedOrgan", getDamagedOrgan())
            .append("sleepEffects", getSleepEffects())
            .append("sleepAdvice", getSleepAdvice())
            .append("sportsAdvice", getSportsAdvice())
            .append("dietaryAdvice", getDietaryAdvice())
            .toString();
    }
}
