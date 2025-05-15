package com.dream.module.service;

import java.util.List;
import com.dream.module.domain.DreamVip;

/**
 * 会员标记Service接口
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
public interface IDreamVipService 
{
    /**
     * 查询会员标记
     * 
     * @param id 会员标记主键
     * @return 会员标记
     */
    public DreamVip selectDreamVipById(Long id);

    /**
     * 查询会员标记列表
     * 
     * @param dreamVip 会员标记
     * @return 会员标记集合
     */
    public List<DreamVip> selectDreamVipList(DreamVip dreamVip);

    /**
     * 新增会员标记
     * 
     * @param dreamVip 会员标记
     * @return 结果
     */
    public int insertDreamVip(DreamVip dreamVip);

    /**
     * 修改会员标记
     * 
     * @param dreamVip 会员标记
     * @return 结果
     */
    public int updateDreamVip(DreamVip dreamVip);

    /**
     * 批量删除会员标记
     * 
     * @param ids 需要删除的会员标记主键集合
     * @return 结果
     */
    public int deleteDreamVipByIds(Long[] ids);

    /**
     * 删除会员标记信息
     * 
     * @param id 会员标记主键
     * @return 结果
     */
    public int deleteDreamVipById(Long id);
}
