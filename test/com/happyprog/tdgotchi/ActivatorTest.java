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

		assertNotNull(registry.get("Beginner-default1"));
		assertNotNull(registry.get("Intermediate-default1"));
		assertNotNull(registry.get("Pro-default1"));
		assertNotNull(registry.get("Zombie-default1"));
	}
}
