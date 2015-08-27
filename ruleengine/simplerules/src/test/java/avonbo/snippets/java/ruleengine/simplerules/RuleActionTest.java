package avonbo.snippets.java.ruleengine.simplerules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class RuleActionTest {

	@Test
	public void enumAction() {

		final Rule r1 = new Rule("firstRule", 0, "true", "avonbo.snippets.java.ruleengine.simplerules.EnumAction.Rock");

		final RuleEngine engine = new RuleEngine();
		engine.addRule(r1);

		final String in = "";

		final ExecutionResultSet resultSet = engine.execute(in);

		final List<Object> outs = resultSet.getOutputs();
		assertTrue(outs != null);
		assertEquals(1, outs.size());
		final String resultString = outs.get(0).toString();
		assertEquals("Rock", resultString);

	}

	@Test
	public void fullQualifiedPathAction() {

		final Rule r1 = new Rule("firstRule", 0, "true",
				"avonbo.snippets.java.ruleengine.simplerules.ActionFactory.getRockAction()");

		final RuleEngine engine = new RuleEngine();
		engine.addRule(r1);

		final String in = "";

		final ExecutionResultSet resultSet = engine.execute(in);

		final List<Object> outs = resultSet.getOutputs();
		assertTrue(outs != null);
		assertEquals(1, outs.size());
		final String resultString = outs.get(0).toString();
		assertEquals("Rock Action", resultString);

	}

	@Test
	public void fullString() {

		final Rule r1 = new Rule("firstRule", 0, "true", "'TEST'");

		final RuleEngine engine = new RuleEngine();
		engine.addRule(r1);

		final String in = "";

		final ExecutionResultSet resultSet = engine.execute(in);

		final List<Object> outs = resultSet.getOutputs();
		assertTrue(outs != null);
		assertEquals(1, outs.size());
		final String resultString = outs.get(0).toString();
		assertEquals("TEST", resultString);

	}

}
