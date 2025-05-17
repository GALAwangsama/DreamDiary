package com.dream.web.controller.module;

import java.util.List;

import com.sun.xml.bind.v2.TODO;
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
import com.dream.module.domain.DreamRecommendation;
import com.dream.module.service.IDreamRecommendationService;
import com.dream.common.utils.poi.ExcelUtil;
import com.dream.common.core.page.TableDataInfo;

/**
 * 推荐计划Controller
 * 
 * @author ruoyi
 * @date 2025-05-15
 */
@RestController
@RequestMapping("/module/recommendation")
public class DreamRecommendationController extends BaseController
{
    @Autowired
    private IDreamRecommendationService dreamRecommendationService;

    //TODO 添加选择代办接口功能（结合ai）

    //TODO 查看建议关联的代办

    /**
     * 查询推荐计划列表
     */
    //TODO 关联userid
    @PreAuthorize("@ss.hasPermi('module:recommendation:list')")
    @GetMapping("/list")
    public TableDataInfo list(DreamRecommendation dreamRecommendation)
    {
        startPage();
        List<DreamRecommendation> list = dreamRecommendationService.selectDreamRecommendationList(dreamRecommendation);
        return getDataTable(list);
    }

    /**
     * 导出推荐计划列表
     */
    @PreAuthorize("@ss.hasPermi('module:recommendation:export')")
    @Log(title = "推荐计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DreamRecommendation dreamRecommendation)
    {
        List<DreamRecommendation> list = dreamRecommendationService.selectDreamRecommendationList(dreamRecommendation);
        ExcelUtil<DreamRecommendation> util = new ExcelUtil<DreamRecommendation>(DreamRecommendation.class);
        util.exportExcel(response, list, "推荐计划数据");
    }

    /**
     * 获取推荐计划详细信息
     */
    @PreAuthorize("@ss.hasPermi('module:recommendation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dreamRecommendationService.selectDreamRecommendationById(id));
    }

    /**
     * 新增推荐计划
     */
    //TODO 添加根据模型分析生成建议接口（结合ai）
    //TODO 考虑将此接口改为ai接口
    @PreAuthorize("@ss.hasPermi('module:recommendation:add')")
    @Log(title = "推荐计划", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DreamRecommendation dreamRecommendation)
    {
        return toAjax(dreamRecommendationService.insertDreamRecommendation(dreamRecommendation));
    }

    /**
     * 修改推荐计划
     */
    //TODO 考虑将此接口转为重新生成（如果添加过代办，考虑同时删除代办）
    @PreAuthorize("@ss.hasPermi('module:recommendation:edit')")
    @Log(title = "推荐计划", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DreamRecommendation dreamRecommendation)
    {
        return toAjax(dreamRecommendationService.updateDreamRecommendation(dreamRecommendation));
    }

    /**
     * 删除推荐计划
     */
    //TODO 需关联代办
    @PreAuthorize("@ss.hasPermi('module:recommendation:remove')")
    @Log(title = "推荐计划", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dreamRecommendationService.deleteDreamRecommendationByIds(ids));
    }
}
