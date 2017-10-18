package com.statis.contoller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.equipment.service.EquipmentChangeService;
import com.equipment.service.EquipmentService;
import com.usermanager.services.BsDepService;
import com.usermanager.services.BsUserRoleService;

@Controller
@RequestMapping(value = "/equipmentstatis")
public class EquipmentStatisController {

	@Autowired
	private EquipmentChangeService equipmentChangeService;
	@Autowired
	private BsDepService bsDepService;

	@Autowired
	private EquipmentService equipmentService;

	@Autowired
	private BsUserRoleService bsUserRoleService;

	private static Log logger = LogFactory.getLog(EquipmentStatisController.class);
	
	
    @RequestMapping(value = "entry.action", method = RequestMethod.GET)
    public ModelAndView entry(HttpServletRequest req,Map<String, Object> map)
    {
    	String menuId = req.getParameter("menuId");
		if (StringUtils.isNotBlank(menuId)) {
			map.put("menuId", menuId);
		}
    	ModelAndView mv = new ModelAndView("/statistics/equipment/equipmentStatistics.jsp");
        return mv;
    }


    @RequestMapping(value = "initDeptEquipmentResultChart.action", method = RequestMethod.POST)
    @ResponseBody
    public ApplyResultChartDataVO initDeptEquipmentResultChart()
    {
        logger.info("initAnalysisResultChart begin");
        ApplyResultChartDataVO applyResultChartData = new ApplyResultChartDataVO();
        List<String> deptList=new ArrayList<String>();
        
        List<DeptStatisVO> deptEquipValueList2 = equipmentService.getDeptEquipValueList();
        for (DeptStatisVO deptStatisVO : deptEquipValueList2) {
        	deptList.add(deptStatisVO.getName());
		}
        applyResultChartData.setDeptEquipValueList(deptEquipValueList2);
        applyResultChartData.setDeptList(deptList);
        
        List<String> equipChangeList = applyResultChartData.getEquipChangeList();
        List<String> dateList = applyResultChartData.getDateList();
        
       List<DeptStatisVO> equipChangeValueList = equipmentChangeService.getEquipChangeValueList();
//       equipChangeList.add(new String[]{"1412692800000","24.04"});
//       equipChangeList.add(new String[]{"1413292800000","0.6"});
//       equipChangeList.add(new String[]{"1413892800000","26.93"});
//       dateList.add("1412692800000");
//       dateList.add("1413292800000");
//       dateList.add("1413892800000");
       for (DeptStatisVO deptStatisVO : equipChangeValueList) {
    	   equipChangeList.add(deptStatisVO.getValue());
    	   dateList.add(deptStatisVO.getName());
       }

        logger.info(applyResultChartData);
        return applyResultChartData;
    }

}
