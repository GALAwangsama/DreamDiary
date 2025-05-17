package com.dream.module.service;

import java.util.List;
import com.dream.module.domain.DreamDiseaseinfo;

/**
 * 病例数据库，存储疾病相关信息及建议Service接口
 * 
 * @author ruoyi
 * @date 2025-05-17
 */
public interface IDreamDiseaseinfoService 
{
    /**
     * 查询病例数据库，存储疾病相关信息及建议
     * 
     * @param id 病例数据库，存储疾病相关信息及建议主键
     * @return 病例数据库，存储疾病相关信息及建议
     */
    public DreamDiseaseinfo selectDreamDiseaseinfoById(Long id);

    /**
     * 查询病例数据库，存储疾病相关信息及建议列表
     * 
     * @param dreamDiseaseinfo 病例数据库，存储疾病相关信息及建议
     * @return 病例数据库，存储疾病相关信息及建议集合
     */
    public List<DreamDiseaseinfo> selectDreamDiseaseinfoList(DreamDiseaseinfo dreamDiseaseinfo);

    /**
     * 新增病例数据库，存储疾病相关信息及建议
     * 
     * @param dreamDiseaseinfo 病例数据库，存储疾病相关信息及建议
     * @return 结果
     */
    public int insertDreamDiseaseinfo(DreamDiseaseinfo dreamDiseaseinfo);

    /**
     * 修改病例数据库，存储疾病相关信息及建议
     * 
     * @param dreamDiseaseinfo 病例数据库，存储疾病相关信息及建议
     * @return 结果
     */
    public int updateDreamDiseaseinfo(DreamDiseaseinfo dreamDiseaseinfo);

    /**
     * 批量删除病例数据库，存储疾病相关信息及建议
     * 
     * @param ids 需要删除的病例数据库，存储疾病相关信息及建议主键集合
     * @return 结果
     */
    public int deleteDreamDiseaseinfoByIds(Long[] ids);

    /**
     * 删除病例数据库，存储疾病相关信息及建议信息
     * 
     * @param id 病例数据库，存储疾病相关信息及建议主键
     * @return 结果
     */
    public int deleteDreamDiseaseinfoById(Long id);
}
