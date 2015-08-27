package avonbo.snippets.java.agents.agentone;

import java.lang.instrument.Instrumentation;

public class AgentOne {

	public static void premain(String agentArgument, Instrumentation instrumentation) {

		System.out.println("Test Java Agent One");

	}
}
