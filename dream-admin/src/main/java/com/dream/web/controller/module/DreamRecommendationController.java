package com.dream.web.controller.module;

import java.util.ArrayList;
import java.util.List;

import com.dream.common.core.redis.RedisCache;
import com.dream.common.utils.SecurityUtils;
import com.dream.module.domain.DreamTodo;
import com.dream.module.domain.DreamUserdiseasehistory;
import com.dream.module.service.IDreamDiseaseinfoService;
import com.dream.module.service.IDreamTodoService;
import com.dream.module.service.IDreamUserdiseasehistoryService;
import com.sun.xml.bind.v2.TODO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private IDreamTodoService dreamTodoService;

    @Autowired
    private IDreamUserdiseasehistoryService dreamUserdiseasehistoryService;

    @Autowired
    private IDreamDiseaseinfoService dreamDiseaseinfoService;


    /**
     * 查看建议关联的代办
     */
    @PreAuthorize("@ss.hasPermi('module:recommendation:getTodo')")
    @GetMapping("/todo/{recommendation_id}")
    public TableDataInfo getTodo(@PathVariable Long recommendation_id)
    {

        DreamTodo dreamTodo = new DreamTodo();
        dreamTodo.setRecommendationId(recommendation_id);
        return getDataTable(dreamTodoService.selectDreamTodoList(dreamTodo));
    }

    /**
     * 查询推荐计划列表
     */
    @PreAuthorize("@ss.hasPermi('module:recommendation:list')")
    @GetMapping("/list")
    public TableDataInfo list(DreamRecommendation dreamRecommendation)
    {
        startPage();
        dreamRecommendation.setUserId(SecurityUtils.getLoginUser().getUserId());
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

    //TODO 添加选择代办接口功能（结合ai）（由前端还是后端做）


    //TODO 生成推荐计划（先生成，再新增）
    /**
     * 生成推荐计划列表
     */
    //TODO 关联userid
    @PreAuthorize("@ss.hasPermi('module:recommendation:generate')")
    @Transactional
    @GetMapping("/generate")
    public List<DreamRecommendation> generate()
    {
        Long userId = SecurityUtils.getLoginUser().getUserId();
        //获取病例
        DreamUserdiseasehistory dreamUserdiseasehistory = dreamUserdiseasehistoryService.selectDreamUserdiseasehistoryByUserId(userId);

        //获取睡眠参数

        //进行ai调用分析出建议

        //给出代办

        //缓存生成的代办

        return null;
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

        //获取缓存的计划

        //添加计划

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
        //删除关联代办
        dreamTodoService.deleteDreamTodoByRecommendationIds(new Long[]{dreamRecommendation.getId()});
        //TODO 重新生成代办

        return toAjax(dreamRecommendationService.updateDreamRecommendation(dreamRecommendation));
    }

    /**
     * 删除推荐计划
     */
    @Transactional
    @PreAuthorize("@ss.hasPermi('module:recommendation:remove')")
    @Log(title = "推荐计划", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {

        //先删除Recommendation，再考虑Todo
        int isDeleteRecomendation = dreamRecommendationService.deleteDreamRecommendationByIds(ids);
        int isDeleteTodo = dreamTodoService.deleteDreamTodoByRecommendationIds(ids);
        if (isDeleteRecomendation > 0 || isDeleteTodo > 0) {
            return toAjax(isDeleteRecomendation);
        } else {
            return toAjax(0);
        }

    }
}
