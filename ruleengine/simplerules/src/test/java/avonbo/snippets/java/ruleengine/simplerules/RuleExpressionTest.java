package avonbo.snippets.java.ruleengine.simplerules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class RuleExpressionTest {

    @Test
    public void checkOneRuleFired() {

        final Rule r1 = new Rule("firstRule", 0, "age > 18", null);

        final RuleEngine engine = new RuleEngine();
        engine.addRule(r1);

        final Person p = new Person();
        p.setAge(20);
        p.setName("Alex");

        final ExecutionResultSet resultSet = engine.execute(p);

        final List<String> firedRuleNames = resultSet.getFiredRuleNames();

        final boolean firstRuleFired = firedRuleNames.contains("firstRule");

        assertTrue("Rule with name firstRule not fired", firstRuleFired);

    }

    @Test
    public void checkOneRuleNotFired() {

        final Rule r1 = new Rule("firstRule", 0, "age > 18", null);

        final RuleEngine engine = new RuleEngine();
        engine.addRule(r1);

        final Person p = new Person();
        p.setAge(5);
        p.setName("Otto");

        final ExecutionResultSet resultSet = engine.execute(p);

        final List<String> firedRuleNames = resultSet.getFiredRuleNames();

        final boolean firstRuleFired = firedRuleNames.contains("firstRule");

        assertFalse("Rule with name firstRule  fired", firstRuleFired);

    }

    @Test
    public void checkMultipleConditionFired() {

        final Rule r1 = new Rule("firstRule", 0, "age > 18 && name == 'Alex'", null);

        final RuleEngine engine = new RuleEngine();
        engine.addRule(r1);

        final Person p = new Person();
        p.setAge(20);
        p.setName("Alex");

        final ExecutionResultSet resultSet = engine.execute(p);

        final List<String> firedRuleNames = resultSet.getFiredRuleNames();

        final boolean firstRuleFired = firedRuleNames.contains("firstRule");

        assertTrue("Rule with name firstRule not fired", firstRuleFired);

    }

    @Test
    public void checkMultipleRulesFired() {

        final Rule r1 = new Rule("firstRule", 0, "age > 18", null);
        final Rule r2 = new Rule("secondRule", 0, "name == 'Alex'", null);

        final RuleEngine engine = new RuleEngine();
        engine.addRule(r1);
        engine.addRule(r2);

        final Person p = new Person();
        p.setAge(20);
        p.setName("Alex");

        final ExecutionResultSet resultSet = engine.execute(p);

        final List<String> firedRuleNames = resultSet.getFiredRuleNames();

        assertEquals("Expected two fired rules", 2, firedRuleNames.size());

        final boolean firstRuleFired = firedRuleNames.contains("firstRule");
        assertTrue("Rule with name firstRule not fired", firstRuleFired);

        final boolean secondRuleFired = firedRuleNames.contains("secondRule");
        assertTrue("Rule with name secondRule not fired", secondRuleFired);

    }

    @Test
    public void checkPriorityRulesFired() {

        final Rule r1 = new Rule("firstRule", 0, "age > 18", null);
        final Rule r2 = new Rule("secondRule", 10, "name == 'Alex'", null);

        final RuleEngine engine = new RuleEngine();
        engine.addRule(r1);
        engine.addRule(r2);

        final Person p = new Person();
        p.setAge(20);
        p.setName("Alex");

        final ExecutionResultSet resultSet = engine.execute(p);

        final List<String> firedRuleNames = resultSet.getFiredRuleNames();

        assertEquals("Expected two fired rules", 2, firedRuleNames.size());

        final String firstFiredRule = firedRuleNames.get(0);
        assertTrue("Rule with name firstRule not fired as first", "secondRule".equals(firstFiredRule));

        final String secondFiredRule = firedRuleNames.get(1);
        assertTrue("Rule with name secondRule not fired as second", "firstRule".equals(secondFiredRule));

    }

}
