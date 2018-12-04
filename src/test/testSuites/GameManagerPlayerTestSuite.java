// Written by Daniel Tseng (Test suite)

package test.testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.unit.TestGameManagerLoadPlayerStats;
import test.unit.TestGameManagerSetPlayerInitialStats;

@RunWith(Suite.class)

@SuiteClasses({
	TestGameManagerLoadPlayerStats.class, 
	TestGameManagerSetPlayerInitialStats.class})

public class GameManagerPlayerTestSuite {

}
