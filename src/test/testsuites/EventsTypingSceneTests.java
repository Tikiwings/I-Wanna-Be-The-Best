//Zachary Barram
package test.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.integration.TestEvents;
import test.unit.TestTypingSceneSound;
import test.unit.TestTypingScenePause;

@RunWith(Suite.class)
@SuiteClasses({ TestEvents.class,
				TestTypingScenePause.class,
				TestTypingSceneSound.class})
public class EventsTypingSceneTests {

}
