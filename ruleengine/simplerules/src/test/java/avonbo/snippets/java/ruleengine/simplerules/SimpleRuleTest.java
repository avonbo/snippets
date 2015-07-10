package avonbo.snippets.java.ruleengine.simplerules;

import org.junit.Test;

public class SimpleRuleTest {

    @Test
    public void aTest() {

        final Rule r1 = new Rule("aName", "age > 18", null, 0, null);

        final RuleEngine engine = new RuleEngine();
        engine.addRule(r1);

        final Person p = new Person();
        p.setAge(5);
        p.setName("Alex");

        engine.execute(p);

    }
}
