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
import com.dream.module.domain.DreamUserdiseasehistory;
import com.dream.module.service.IDreamUserdiseasehistoryService;
import com.dream.common.utils.poi.ExcelUtil;
import com.dream.common.core.page.TableDataInfo;

/**
 * 用户病史，存储用户与疾病信息的关联关系Controller
 * 
 * @author ruoyi
 * @date 2025-05-17
 */
@RestController
@RequestMapping("/module/userdiseasehistory")
public class DreamUserdiseasehistoryController extends BaseController
{
    @Autowired
    private IDreamUserdiseasehistoryService dreamUserdiseasehistoryService;

    //TODO 前端传入的为下拉栏列表

    /**
     * 查询用户病史，存储用户与疾病信息的关联关系列表
     */
    //TODO 添加userid，疾病查询
    @PreAuthorize("@ss.hasPermi('module:userdiseasehistory:list')")
    @GetMapping("/list")
    public TableDataInfo list(DreamUserdiseasehistory dreamUserdiseasehistory)
    {
        startPage();
        List<DreamUserdiseasehistory> list = dreamUserdiseasehistoryService.selectDreamUserdiseasehistoryList(dreamUserdiseasehistory);
        return getDataTable(list);
    }

    /**
     * 导出用户病史，存储用户与疾病信息的关联关系列表
     */
    @PreAuthorize("@ss.hasPermi('module:userdiseasehistory:export')")
    @Log(title = "用户病史，存储用户与疾病信息的关联关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DreamUserdiseasehistory dreamUserdiseasehistory)
    {
        List<DreamUserdiseasehistory> list = dreamUserdiseasehistoryService.selectDreamUserdiseasehistoryList(dreamUserdiseasehistory);
        ExcelUtil<DreamUserdiseasehistory> util = new ExcelUtil<DreamUserdiseasehistory>(DreamUserdiseasehistory.class);
        util.exportExcel(response, list, "用户病史，存储用户与疾病信息的关联关系数据");
    }

    /**
     * 获取用户病史，存储用户与疾病信息的关联关系详细信息
     */
    //TODO 添加病史数据库关联查询
    @PreAuthorize("@ss.hasPermi('module:userdiseasehistory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dreamUserdiseasehistoryService.selectDreamUserdiseasehistoryById(id));
    }

    /**
     * 新增用户病史，存储用户与疾病信息的关联关系
     */
    //TODO 添加时间上的设置
    @PreAuthorize("@ss.hasPermi('module:userdiseasehistory:add')")
    @Log(title = "用户病史，存储用户与疾病信息的关联关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DreamUserdiseasehistory dreamUserdiseasehistory)
    {
        return toAjax(dreamUserdiseasehistoryService.insertDreamUserdiseasehistory(dreamUserdiseasehistory));
    }

    /**
     * 修改用户病史，存储用户与疾病信息的关联关系
     */
    //TODO 添加时间上的设置
    @PreAuthorize("@ss.hasPermi('module:userdiseasehistory:edit')")
    @Log(title = "用户病史，存储用户与疾病信息的关联关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DreamUserdiseasehistory dreamUserdiseasehistory)
    {
        return toAjax(dreamUserdiseasehistoryService.updateDreamUserdiseasehistory(dreamUserdiseasehistory));
    }

    /**
     * 删除用户病史，存储用户与疾病信息的关联关系
     */
    @PreAuthorize("@ss.hasPermi('module:userdiseasehistory:remove')")
    @Log(title = "用户病史，存储用户与疾病信息的关联关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dreamUserdiseasehistoryService.deleteDreamUserdiseasehistoryByIds(ids));
    }
}
