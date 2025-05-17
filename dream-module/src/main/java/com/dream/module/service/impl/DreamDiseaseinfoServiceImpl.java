package com.dream.module.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dream.module.mapper.DreamDiseaseinfoMapper;
import com.dream.module.domain.DreamDiseaseinfo;
import com.dream.module.service.IDreamDiseaseinfoService;

/**
 * 病例数据库，存储疾病相关信息及建议Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-17
 */
@Service
public class DreamDiseaseinfoServiceImpl implements IDreamDiseaseinfoService 
{
    @Autowired
    private DreamDiseaseinfoMapper dreamDiseaseinfoMapper;

    /**
     * 查询病例数据库，存储疾病相关信息及建议
     * 
     * @param id 病例数据库，存储疾病相关信息及建议主键
     * @return 病例数据库，存储疾病相关信息及建议
     */
    @Override
    public DreamDiseaseinfo selectDreamDiseaseinfoById(Long id)
    {
        return dreamDiseaseinfoMapper.selectDreamDiseaseinfoById(id);
    }

    /**
     * 查询病例数据库，存储疾病相关信息及建议列表
     * 
     * @param dreamDiseaseinfo 病例数据库，存储疾病相关信息及建议
     * @return 病例数据库，存储疾病相关信息及建议
     */
    @Override
    public List<DreamDiseaseinfo> selectDreamDiseaseinfoList(DreamDiseaseinfo dreamDiseaseinfo)
    {
        return dreamDiseaseinfoMapper.selectDreamDiseaseinfoList(dreamDiseaseinfo);
    }

    /**
     * 新增病例数据库，存储疾病相关信息及建议
     * 
     * @param dreamDiseaseinfo 病例数据库，存储疾病相关信息及建议
     * @return 结果
     */
    @Override
    public int insertDreamDiseaseinfo(DreamDiseaseinfo dreamDiseaseinfo)
    {
        return dreamDiseaseinfoMapper.insertDreamDiseaseinfo(dreamDiseaseinfo);
    }

    /**
     * 修改病例数据库，存储疾病相关信息及建议
     * 
     * @param dreamDiseaseinfo 病例数据库，存储疾病相关信息及建议
     * @return 结果
     */
    @Override
    public int updateDreamDiseaseinfo(DreamDiseaseinfo dreamDiseaseinfo)
    {
        return dreamDiseaseinfoMapper.updateDreamDiseaseinfo(dreamDiseaseinfo);
    }

    /**
     * 批量删除病例数据库，存储疾病相关信息及建议
     * 
     * @param ids 需要删除的病例数据库，存储疾病相关信息及建议主键
     * @return 结果
     */
    @Override
    public int deleteDreamDiseaseinfoByIds(Long[] ids)
    {
        return dreamDiseaseinfoMapper.deleteDreamDiseaseinfoByIds(ids);
    }

    /**
     * 删除病例数据库，存储疾病相关信息及建议信息
     * 
     * @param id 病例数据库，存储疾病相关信息及建议主键
     * @return 结果
     */
    @Override
    public int deleteDreamDiseaseinfoById(Long id)
    {
        return dreamDiseaseinfoMapper.deleteDreamDiseaseinfoById(id);
    }
}
