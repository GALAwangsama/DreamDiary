package com.dream.module.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dream.module.mapper.DreamVipMapper;
import com.dream.module.domain.DreamVip;
import com.dream.module.service.IDreamVipService;

/**
 * 会员标记Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
@Service
public class DreamVipServiceImpl implements IDreamVipService 
{
    @Autowired
    private DreamVipMapper dreamVipMapper;

    /**
     * 查询会员标记
     * 
     * @param id 会员标记主键
     * @return 会员标记
     */
    @Override
    public DreamVip selectDreamVipById(Long id)
    {
        return dreamVipMapper.selectDreamVipById(id);
    }

    /**
     * 查询会员标记列表
     * 
     * @param dreamVip 会员标记
     * @return 会员标记
     */
    @Override
    public List<DreamVip> selectDreamVipList(DreamVip dreamVip)
    {
        return dreamVipMapper.selectDreamVipList(dreamVip);
    }

    /**
     * 新增会员标记
     * 
     * @param dreamVip 会员标记
     * @return 结果
     */
    @Override
    public int insertDreamVip(DreamVip dreamVip)
    {
        return dreamVipMapper.insertDreamVip(dreamVip);
    }

    /**
     * 修改会员标记
     * 
     * @param dreamVip 会员标记
     * @return 结果
     */
    @Override
    public int updateDreamVip(DreamVip dreamVip)
    {
        return dreamVipMapper.updateDreamVip(dreamVip);
    }

    /**
     * 批量删除会员标记
     * 
     * @param ids 需要删除的会员标记主键
     * @return 结果
     */
    @Override
    public int deleteDreamVipByIds(Long[] ids)
    {
        return dreamVipMapper.deleteDreamVipByIds(ids);
    }

    /**
     * 删除会员标记信息
     * 
     * @param id 会员标记主键
     * @return 结果
     */
    @Override
    public int deleteDreamVipById(Long id)
    {
        return dreamVipMapper.deleteDreamVipById(id);
    }
}
