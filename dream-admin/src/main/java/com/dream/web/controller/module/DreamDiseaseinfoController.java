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
import com.dream.module.domain.DreamDiseaseinfo;
import com.dream.module.service.IDreamDiseaseinfoService;
import com.dream.common.utils.poi.ExcelUtil;
import com.dream.common.core.page.TableDataInfo;

/**
 * 病例数据库，存储疾病相关信息及建议Controller
 * 用于存放病例数据库
 * 
 * @author ruoyi
 * @date 2025-05-17
 */


//TODO 刘文雪负责
@RestController
@RequestMapping("/module/diseaseinfo")
public class DreamDiseaseinfoController extends BaseController
{
    @Autowired
    private IDreamDiseaseinfoService dreamDiseaseinfoService;

    //TODO 是否需要一个枚举类做字典集存储病例名

    //TODO 创建根据病症name进行匹配查询的方法


    /**
     * 查询病例数据库，存储疾病相关信息及建议列表
     */
    @PreAuthorize("@ss.hasPermi('module:diseaseinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(DreamDiseaseinfo dreamDiseaseinfo)
    {
        startPage();
        List<DreamDiseaseinfo> list = dreamDiseaseinfoService.selectDreamDiseaseinfoList(dreamDiseaseinfo);
        return getDataTable(list);
    }

    /**
     * 导出病例数据库，存储疾病相关信息及建议列表
     */
    @PreAuthorize("@ss.hasPermi('module:diseaseinfo:export')")
    @Log(title = "病例数据库，存储疾病相关信息及建议", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DreamDiseaseinfo dreamDiseaseinfo)
    {
        List<DreamDiseaseinfo> list = dreamDiseaseinfoService.selectDreamDiseaseinfoList(dreamDiseaseinfo);
        ExcelUtil<DreamDiseaseinfo> util = new ExcelUtil<DreamDiseaseinfo>(DreamDiseaseinfo.class);
        util.exportExcel(response, list, "病例数据库，存储疾病相关信息及建议数据");
    }

    /**
     * 获取病例数据库，存储疾病相关信息及建议详细信息
     */
    @PreAuthorize("@ss.hasPermi('module:diseaseinfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dreamDiseaseinfoService.selectDreamDiseaseinfoById(id));
    }

    /**
     * 新增病例数据库，存储疾病相关信息及建议
     */
    @PreAuthorize("@ss.hasPermi('module:diseaseinfo:add')")
    @Log(title = "病例数据库，存储疾病相关信息及建议", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DreamDiseaseinfo dreamDiseaseinfo)
    {
        return toAjax(dreamDiseaseinfoService.insertDreamDiseaseinfo(dreamDiseaseinfo));
    }

    /**
     * 修改病例数据库，存储疾病相关信息及建议
     */
    @PreAuthorize("@ss.hasPermi('module:diseaseinfo:edit')")
    @Log(title = "病例数据库，存储疾病相关信息及建议", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DreamDiseaseinfo dreamDiseaseinfo)
    {
        return toAjax(dreamDiseaseinfoService.updateDreamDiseaseinfo(dreamDiseaseinfo));
    }

    /**
     * 删除病例数据库，存储疾病相关信息及建议
     */
    @PreAuthorize("@ss.hasPermi('module:diseaseinfo:remove')")
    @Log(title = "病例数据库，存储疾病相关信息及建议", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dreamDiseaseinfoService.deleteDreamDiseaseinfoByIds(ids));
    }
}
