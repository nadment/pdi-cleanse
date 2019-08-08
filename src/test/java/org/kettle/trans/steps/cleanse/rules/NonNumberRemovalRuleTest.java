package org.kettle.trans.steps.cleanse.rules;

import org.junit.Test;
import org.kettle.trans.steps.cleanse.CleanseRuleTest;
import org.kettle.trans.steps.cleanse.rules.RemoveNonNumberRule;

public class NonNumberRemovalRuleTest extends CleanseRuleTest<RemoveNonNumberRule> {

	@Test
	public void test() throws Exception {

		check("<csdfgsdg12345--6789..>", "123456789");
		check("0.1.2.3.4.5.6", "0123456");
		check("௩", "௩"); // Tamil Digit Three
	}

}
