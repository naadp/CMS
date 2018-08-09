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
 * ��������̨����Controller��
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
	 * ����������ҳ��ѯ���������Ϣ
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
	 * ��ӻ����޸����������Ϣ
	 * @param arcType
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(ArcType arcType,HttpServletResponse response,HttpServletRequest request)throws Exception{
		int resultTotal=0; // �����ļ�¼����
		if(arcType.getId()==null){ // ���
			resultTotal=arcTypeService.add(arcType);
		}else{ // �޸�
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
	 * ɾ�����������Ϣ
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
				result.put("exist", "��������������ӣ�����ɾ����");
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
