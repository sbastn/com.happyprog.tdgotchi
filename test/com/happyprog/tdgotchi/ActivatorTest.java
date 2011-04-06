package com.happyprog.tdgotchi;

import static org.junit.Assert.*;

import org.eclipse.jface.resource.ImageRegistry;
import org.junit.Test;

public class ActivatorTest {

	@Test
	public void initializeImageRegistry_loadsImagesForAllLevels() throws Exception {
		Activator activator = new Activator();
		ImageRegistry registry = new ImageRegistry();

		activator.initializeImageRegistry(registry);

		assertNotNull(registry.get("level0-default1"));
		assertNotNull(registry.get("level1-default1"));
		assertNotNull(registry.get("level2-default1"));
		assertNotNull(registry.get("level3-default1"));
	}
}
