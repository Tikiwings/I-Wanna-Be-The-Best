// Written by John Luu (Test suite)

package test.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.unit.TestLoadFile;
import test.unit.TestSaveFile;

@RunWith(Suite.class)

@SuiteClasses({
	TestLoadFile.class, 
	TestSaveFile.class})

public class FileLoadSaveTestSuite {

}
