package test.Jordan;

import static org.junit.Assert.*;

import org.junit.Test;

import application.MainMenuCreator;
import application.Observer;
import application.SceneCreator;
import application.UIDriver;

/**
 * SceneCreator Test
 * @author Jordan
 *
 */
public class SceneCreatorTester {

	@Test
	public void testObserver() {
		Observer o = new UIDriver(null, null);
		SceneCreator sc = new MainMenuCreator(o);
		
		assertSame(o, sc.getObserver());
	}

}
