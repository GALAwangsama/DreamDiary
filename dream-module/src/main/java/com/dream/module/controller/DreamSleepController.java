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
import com.dream.module.domain.DreamSleep;
import com.dream.module.service.IDreamSleepService;
import com.dream.common.utils.poi.ExcelUtil;
import com.dream.common.core.page.TableDataInfo;

/**
 * 睡眠参数Controller
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
@RestController
@RequestMapping("/module/sleep")
public class DreamSleepController extends BaseController
{
    @Autowired
    private IDreamSleepService dreamSleepService;

    /**
     * 查询睡眠参数列表
     */
    @PreAuthorize("@ss.hasPermi('module:sleep:list')")
    @GetMapping("/list")
    public TableDataInfo list(DreamSleep dreamSleep)
    {
        startPage();
        List<DreamSleep> list = dreamSleepService.selectDreamSleepList(dreamSleep);
        return getDataTable(list);
    }

    /**
     * 导出睡眠参数列表
     */
    @PreAuthorize("@ss.hasPermi('module:sleep:export')")
    @Log(title = "睡眠参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DreamSleep dreamSleep)
    {
        List<DreamSleep> list = dreamSleepService.selectDreamSleepList(dreamSleep);
        ExcelUtil<DreamSleep> util = new ExcelUtil<DreamSleep>(DreamSleep.class);
        util.exportExcel(response, list, "睡眠参数数据");
    }

    /**
     * 获取睡眠参数详细信息
     */
    @PreAuthorize("@ss.hasPermi('module:sleep:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dreamSleepService.selectDreamSleepById(id));
    }

    /**
     * 新增睡眠参数
     */
    @PreAuthorize("@ss.hasPermi('module:sleep:add')")
    @Log(title = "睡眠参数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DreamSleep dreamSleep)
    {
        return toAjax(dreamSleepService.insertDreamSleep(dreamSleep));
    }

    /**
     * 修改睡眠参数
     */
    @PreAuthorize("@ss.hasPermi('module:sleep:edit')")
    @Log(title = "睡眠参数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DreamSleep dreamSleep)
    {
        return toAjax(dreamSleepService.updateDreamSleep(dreamSleep));
    }

    /**
     * 删除睡眠参数
     */
    @PreAuthorize("@ss.hasPermi('module:sleep:remove')")
    @Log(title = "睡眠参数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dreamSleepService.deleteDreamSleepByIds(ids));
    }
}
