// written by Thinh Luu (test suite)
package test.testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.unit.TestScrollSpeed;
import test.unit.TestingScreenSize;

@RunWith(Suite.class)
@SuiteClasses({ TestingScreenSize.class, TestScrollSpeed.class })
public class TestingScreenAndScroll {

}
