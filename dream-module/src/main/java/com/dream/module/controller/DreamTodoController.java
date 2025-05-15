package com.dream.module.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.dream.module.domain.DreamTodo;
import com.dream.module.service.IDreamTodoService;
import com.dream.common.utils.poi.ExcelUtil;
import com.dream.common.core.page.TableDataInfo;

/**
 * 代办Controller
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
@RestController
@RequestMapping("/module/todo")
public class DreamTodoController extends BaseController
{
    @Autowired
    private IDreamTodoService dreamTodoService;

    /**
     * 查询代办列表
     */
    @PreAuthorize("@ss.hasPermi('module:todo:list')")
    @GetMapping("/list")
    public TableDataInfo list(DreamTodo dreamTodo)
    {
        startPage();
        List<DreamTodo> list = dreamTodoService.selectDreamTodoList(dreamTodo);
        return getDataTable(list);
    }

    /**
     * 导出代办列表
     */
    @PreAuthorize("@ss.hasPermi('module:todo:export')")
    @Log(title = "代办", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DreamTodo dreamTodo)
    {
        List<DreamTodo> list = dreamTodoService.selectDreamTodoList(dreamTodo);
        ExcelUtil<DreamTodo> util = new ExcelUtil<DreamTodo>(DreamTodo.class);
        util.exportExcel(response, list, "代办数据");
    }

    /**
     * 获取代办详细信息
     */
    @PreAuthorize("@ss.hasPermi('module:todo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dreamTodoService.selectDreamTodoById(id));
    }

    /**
     * 新增代办
     */
    @PreAuthorize("@ss.hasPermi('module:todo:add')")
    @Log(title = "代办", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DreamTodo dreamTodo)
    {
        return toAjax(dreamTodoService.insertDreamTodo(dreamTodo));
    }

    /**
     * 修改代办
     */
    @PreAuthorize("@ss.hasPermi('module:todo:edit')")
    @Log(title = "代办", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DreamTodo dreamTodo)
    {
        return toAjax(dreamTodoService.updateDreamTodo(dreamTodo));
    }

    /**
     * 删除代办
     */
    @PreAuthorize("@ss.hasPermi('module:todo:remove')")
    @Log(title = "代办", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dreamTodoService.deleteDreamTodoByIds(ids));
    }
}
