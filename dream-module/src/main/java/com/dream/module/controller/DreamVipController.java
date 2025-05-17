package com.dream.module.controller;

import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dream.common.annotation.Log;
import com.dream.common.core.controller.BaseController;
import com.dream.common.core.domain.AjaxResult;
import com.dream.common.enums.BusinessType;
import com.dream.module.domain.DreamVip;
import com.dream.module.service.IDreamVipService;
import com.dream.common.utils.poi.ExcelUtil;
import com.dream.common.core.page.TableDataInfo;

/**
 * 会员标记Controller
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
@RestController
@RequestMapping("/module/vip")
public class DreamVipController extends BaseController
{
    @Autowired
    private IDreamVipService dreamVipService;

    /**
     * 查询会员标记列表
     */
    @PreAuthorize("@ss.hasPermi('module:vip:list')")
    @GetMapping("/list")
    public TableDataInfo list(DreamVip dreamVip)
    {
        startPage();
        List<DreamVip> list = dreamVipService.selectDreamVipList(dreamVip);
        return getDataTable(list);
    }

    /**
     * 导出会员标记列表
     */
    @PreAuthorize("@ss.hasPermi('module:vip:export')")
    @Log(title = "会员标记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DreamVip dreamVip)
    {
        List<DreamVip> list = dreamVipService.selectDreamVipList(dreamVip);
        ExcelUtil<DreamVip> util = new ExcelUtil<DreamVip>(DreamVip.class);
        util.exportExcel(response, list, "会员标记数据");
    }

    /**
     * 获取会员标记详细信息
     */
    @PreAuthorize("@ss.hasPermi('module:vip:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dreamVipService.selectDreamVipById(id));
    }

    /**
     * 新增会员标记
     */
    @PreAuthorize("@ss.hasPermi('module:vip:add')")
    @Log(title = "会员标记", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DreamVip dreamVip)
    {
        return toAjax(dreamVipService.insertDreamVip(dreamVip));
    }

    /**
     * 修改会员标记
     */
    @PreAuthorize("@ss.hasPermi('module:vip:edit')")
    @Log(title = "会员标记", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DreamVip dreamVip)
    {
        return toAjax(dreamVipService.updateDreamVip(dreamVip));
    }

    /**
     * 删除会员标记
     */
    @PreAuthorize("@ss.hasPermi('module:vip:remove')")
    @Log(title = "会员标记", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dreamVipService.deleteDreamVipByIds(ids));
    }
}
