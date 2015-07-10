package avonbo.snippets.java.ruleengine.eventbus.service;

import java.util.concurrent.Executor;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless(name = ExecutorServiceImpl.EXECUTOR_JNDINAME)
public class ExecutorServiceImpl implements Executor {

	public static final String EXECUTOR_JNDINAME = "eventengine/executor";

	@Asynchronous
	@Override
	public void execute(Runnable command) {
		command.run();
	}

}
