//Written by Donald Sanchez

package test.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses({
	test.unit.TestGetFinalScore.class, 
	test.unit.TestGetFinalGrade.class})

public class EndingScreenTestSuite {

}
