package com.usermanager.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usermanager.model.BsUserloginRecord;
import com.usermanager.services.BsUserloginRecordService;

@Controller
@RequestMapping(value = "usermanager/bsuserloginrecord")
public class BsUserloginRecordController {
	private BsUserloginRecord bsUserloginRecord;
	private BsUserloginRecordService bsUserloginRecordService;

	public BsUserloginRecordService getBsUserloginRecordService() {
		return bsUserloginRecordService;
	}

	public void setBsUserloginRecordService(BsUserloginRecordService bsUserloginRecordService) {
		this.bsUserloginRecordService = bsUserloginRecordService;
	}

	@RequestMapping(value = "bsUserloginRecordLoad.action")
	public String bsUserloginRecordLoad(Map<String, Object> map, Long pid) {
		if (pid != null) {
			bsUserloginRecord = this.bsUserloginRecordService.getBsUserloginRecordById(pid);
			map.put("bsUserloginRecord", bsUserloginRecord);
		}
		return "bsUserloginRecordSave.jsp";
	}

	@RequestMapping(value = "bsUserloginRecordSave.action")
	public String bsUserloginRecordSave(BsUserloginRecord bsUserloginRecord) {
		if (bsUserloginRecordService.saveOrUpdateBsUserloginRecord(bsUserloginRecord)) {
		}
		return "";
	}

	@RequestMapping(value = "bsUserloginRecordDel.action")
	public String bsUserloginRecordDel() {
		return "";
	}

	@RequestMapping(value = "bsUserloginRecordList.action")
	public String bsUserloginRecordList() {
		return "bsUserloginRecordList.jsp";
	}
}
