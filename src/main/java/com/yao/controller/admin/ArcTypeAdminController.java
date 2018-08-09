package com.yao.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;

import com.yao.entity.ArcType;
import com.yao.entity.PageBean;
import com.yao.service.ArcTypeService;
import com.yao.service.ArticleService;
import com.yao.service.impl.InitComponent;
import com.yao.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 帖子类别后台管理Controller层
 * @author user
 *
 */
@Controller
@RequestMapping("/admin/arcType")
public class ArcTypeAdminController {

	@Resource
	private ArcTypeService arcTypeService;
	
	@Resource
	private ArticleService articleService;
	
	@Resource
	private InitComponent initComponent;
	
	/**
	 * 根据条件分页查询帖子类别信息
	 * @param page
	 * @param rows
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,HttpServletResponse response)throws Exception{
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<ArcType> arcTypeList=arcTypeService.list(map);
		Long total=arcTypeService.getTotal(map);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(arcTypeList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 添加或者修改帖子类别信息
	 * @param arcType
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(ArcType arcType,HttpServletResponse response,HttpServletRequest request)throws Exception{
		int resultTotal=0; // 操作的记录条数
		if(arcType.getId()==null){ // 添加
			resultTotal=arcTypeService.add(arcType);
		}else{ // 修改
			resultTotal=arcTypeService.update(arcType);
		}
		JSONObject result=new JSONObject();
		if(resultTotal>0){
			initComponent.refreshSystem(ContextLoader.getCurrentWebApplicationContext().getServletContext());
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 删除帖子类别信息
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
		String []idsStr=ids.split(",");
		JSONObject result=new JSONObject();
		for(int i=0;i<idsStr.length;i++){
			if(articleService.getNumByTypeId(Integer.parseInt(idsStr[i]))>0){
				result.put("exist", "帖子类别下有帖子，不能删除！");
			}else{
				arcTypeService.delete(Integer.parseInt(idsStr[i]));				
			}
		}
		initComponent.refreshSystem(ContextLoader.getCurrentWebApplicationContext().getServletContext());
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
