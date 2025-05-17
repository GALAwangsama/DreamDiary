package com.dream.web.controller.module;

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
import com.dream.module.domain.DreamEnvironment;
import com.dream.module.service.IDreamEnvironmentService;
import com.dream.common.utils.poi.ExcelUtil;
import com.dream.common.core.page.TableDataInfo;

/**
 * 环境参数Controller
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
@RestController
@RequestMapping("/module/environment")
public class DreamEnvironmentController extends BaseController
{
    @Autowired
    private IDreamEnvironmentService dreamEnvironmentService;

    /**
     * 查询环境参数列表
     */
    //TODO 添加userid关联
    @PreAuthorize("@ss.hasPermi('module:environment:list')")
    @GetMapping("/list")
    public TableDataInfo list(DreamEnvironment dreamEnvironment)
    {
        startPage();
        List<DreamEnvironment> list = dreamEnvironmentService.selectDreamEnvironmentList(dreamEnvironment);
        return getDataTable(list);
    }

    /**
     * 导出环境参数列表
     */
    @PreAuthorize("@ss.hasPermi('module:environment:export')")
    @Log(title = "环境参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DreamEnvironment dreamEnvironment)
    {
        List<DreamEnvironment> list = dreamEnvironmentService.selectDreamEnvironmentList(dreamEnvironment);
        ExcelUtil<DreamEnvironment> util = new ExcelUtil<DreamEnvironment>(DreamEnvironment.class);
        util.exportExcel(response, list, "环境参数数据");
    }

    /**
     * 获取环境参数详细信息
     */
    @PreAuthorize("@ss.hasPermi('module:environment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dreamEnvironmentService.selectDreamEnvironmentById(id));
    }

    /**
     * 新增环境参数
     */
    //TODO 添加userid关联
    @PreAuthorize("@ss.hasPermi('module:environment:add')")
    @Log(title = "环境参数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DreamEnvironment dreamEnvironment)
    {
        return toAjax(dreamEnvironmentService.insertDreamEnvironment(dreamEnvironment));
    }

    /**
     * 修改环境参数
     */
    @PreAuthorize("@ss.hasPermi('module:environment:edit')")
    @Log(title = "环境参数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DreamEnvironment dreamEnvironment)
    {
        return toAjax(dreamEnvironmentService.updateDreamEnvironment(dreamEnvironment));
    }

    /**
     * 删除环境参数
     */
    @PreAuthorize("@ss.hasPermi('module:environment:remove')")
    @Log(title = "环境参数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dreamEnvironmentService.deleteDreamEnvironmentByIds(ids));
    }
}
