package test.Jordan;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Jordan's Test cases
 * @author Jordan
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ TestPlayer.class, TestSceneCreator.class, TestPlayerPlaylistIntegration.class, TestUIDriverGameDriverIntegration.class })
public class JordansTestSuite {

}
