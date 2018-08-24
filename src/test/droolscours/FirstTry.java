package droolscours;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import util.KnowledgeSessionHelper;

@SuppressWarnings("restriction")
public class FirstTry {
	
	StatelessKieSession sessionStateless = null;
	KieSession sessionStatefull = null;
	static KieContainer kieContainer;
	
	@BeforeClass
	public static void beforeClass() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}

	@Test
	public void test() {
		sessionStatefull = KnowledgeSessionHelper.getStatefullKnowledgeSession(kieContainer, "ksession-rules");
		sessionStatefull.fireAllRules();
	}

}
