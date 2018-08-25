package droolscours;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.FactHandle;

import util.KnowledgeSessionHelper;
import util.OutputDisplay;

@SuppressWarnings("restriction")
public class TestLesson1 {
	
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
		
		sessionStatefull.addEventListener( new RuleRuntimeEventListener() {
			public void objectInserted(ObjectInsertedEvent event) {
				System.out.println("Object inserted \n" + event.getObject().toString());
			}
			public void objectUpdated(ObjectUpdatedEvent event) {
				System.out.println("Object updated \n" + event.getObject().toString());
			}
			public void objectDeleted(ObjectDeletedEvent event) {
				System.out.println("Object deleted \n" + event.getOldObject().toString());
			}
		});
		
		OutputDisplay outputDisplay = new OutputDisplay();
		sessionStatefull.setGlobal("showResults", outputDisplay);
		
		Account account = new Account();
		account.setAccountNo(10);
		FactHandle handler = sessionStatefull.insert(account);
		account.setBalance(12.0);
		sessionStatefull.update(handler, account);
		sessionStatefull.delete(handler);
		
		sessionStatefull.fireAllRules();
		System.out.println("rules fired");
	}

}
