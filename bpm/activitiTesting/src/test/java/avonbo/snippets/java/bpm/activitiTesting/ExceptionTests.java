package avonbo.snippets.java.bpm.activitiTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;


public class ExceptionTests {

	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();


	@Test
	@Deployment(resources = { "ExceptionTestProcess.bpmn" })
	public void testBPMErrorBoundaries() {

		ProcessInstance processInstance = activitiRule.getRuntimeService()
				.startProcessInstanceByKey("exceptiontest");

		assertNotNull(processInstance);
		assertTrue(processInstance.isEnded());
		assertEquals("errorend", processInstance.getActivityId());

	}

}
