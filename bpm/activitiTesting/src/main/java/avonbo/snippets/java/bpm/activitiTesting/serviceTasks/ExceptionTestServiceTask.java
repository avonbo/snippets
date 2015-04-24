package avonbo.snippets.java.bpm.activitiTesting.serviceTasks;

import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;


public class ExceptionTestServiceTask implements JavaDelegate {
	
	static int i = 0;

	public void execute(DelegateExecution execution) throws Exception {
		i++;	
		String activitiID = execution.getCurrentActivityId();
		execution.setVariable(activitiID, i);
		
		if("servicetask1".equals(activitiID)){
			if(i==1){
				createTechError();
			} else  if (i==2){
				createFuncError();
			}
		} else if("servicetask2".equals(activitiID)){
			createTechError();
		}
		
		
		
	}

	private void createFuncError() {
		BpmnError ex = new BpmnError("FUNC_ERROR");
		
		System.out.println("throw error with code " + ex.getErrorCode());
		throw ex;
	}

	private void createTechError() {
		BpmnError ex = new BpmnError("TECH_ERROR");
		System.out.println("throw error with code " + ex.getErrorCode());
		throw ex;
	}

}
