package net.imagej.updater;

import org.junit.Ignore;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class InstallerTest {

	@Test
	public void testURLCheck() {
		assertTrue(urlValid("http://google.de"));
		assertFalse(urlValid("http://www.dfvlisehuflieshuvflihuvfoifhw.de/"));
	}

	@Test @Ignore
	public void urlStressTest() {
		for(int i = 0; i < 1000; i++) {
			assertTrue(urlValid("http://google.de"));
			assertFalse(urlValid("http://www.dfvlisehuflieshuvflihuvfoifhw.de/"));
			System.out.println(i);
			if(i % 20 == 0) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private boolean urlValid(String url) {
		try {
			return Installer.getStatus(new URL(url));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
