//Zachary Barram
package test.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.integration.TestEvents;
import test.unit.TestTypingSceneAttributes;

@RunWith(Suite.class)
@SuiteClasses({ TestEvents.class,
				TestTypingSceneAttributes.class})
public class EventsTypingSceneTests {

}
