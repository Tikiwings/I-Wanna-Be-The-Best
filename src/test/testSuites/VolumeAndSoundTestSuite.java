package test.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.unit.TestImageSettings;
import test.unit.TestVolumeSetting;

@RunWith(Suite.class)
@SuiteClasses({ TestImageSettings.class,
				TestVolumeSetting.class})
public class VolumeAndSoundTestSuite {

}
