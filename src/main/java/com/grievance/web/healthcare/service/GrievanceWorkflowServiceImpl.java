package com.grievance.web.healthcare.service;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GrievanceWorkflowServiceImpl implements GrievanceWorkflowService {

	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private ManagementService managementService;
	
	@Override
	public void startGrievanceWorkflow() {
		// TODO Auto-generated method stub
		
		System.out.println("*********** Started WORKFLOW ************");

	}

}
