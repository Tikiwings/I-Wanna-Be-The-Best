package test.testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.unit.TestEvents;
import test.unit.TestTypingSceneAttributes;

@RunWith(Suite.class)
@SuiteClasses({ TestEvents.class,
				TestTypingSceneAttributes.class})
public class EventsTypingSceneTests {

}
