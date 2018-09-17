package com.solo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.solo.model.Schedule;
import com.solo.service.DoctorService;
import com.solo.service.ScheduleService;

@Controller
@RequestMapping("/chart")
public class ChartController {

	@Resource
	private DoctorService doctorService;
	@Resource
	private ScheduleService scheduleService;
	
	
	@RequestMapping("/")
	public String index(){
		return "chart/chartTest";
	}
	
	@RequestMapping("/getLineData")
	@ResponseBody
	public Map<String,Object> lineData(long pipelineId){
		System.out.println("pipelineId is:" + pipelineId);
		
		List<Integer> candidateNum = new ArrayList<>();
		candidateNum.add(100);
		candidateNum.add(90);
		candidateNum.add(50);
		candidateNum.add(20);
		candidateNum.add(18);
		candidateNum.add(10);
		List<String> candidateNumLabel = new ArrayList<>();
		candidateNumLabel.add("participate");
		candidateNumLabel.add("certified_resume");
		candidateNumLabel.add("pass_writtenTest");
		candidateNumLabel.add("pass_interview");
		candidateNumLabel.add("pass_personality");
		candidateNumLabel.add("accept_offer");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("linedata", candidateNum);
		map.put("linedataLabel", candidateNumLabel);
		
		return map;
	}
	
	
	
}
