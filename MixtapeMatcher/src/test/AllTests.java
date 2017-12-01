package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.Bridget.BridgetsTestSuite;
import test.Jordan.JordansTestSuite;
import test.Matt.MattsTestSuite;
import test.Natalie.NataliesTestSuite;
import test.Tanay.TanaysTestSuite;
import test.Will.WillsTestSuite;

@RunWith(Suite.class)
@SuiteClasses({ BridgetsTestSuite.class, JordansTestSuite.class, MattsTestSuite.class, NataliesTestSuite.class, TanaysTestSuite.class, WillsTestSuite.class })
public class AllTests { 

}
