package com.happyprog.tdgotchi.level;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.eclipse.swt.graphics.Image;
import org.junit.Before;
import org.junit.Test;

public class TamagotchiLevelsTest {

	private Levels levels;
	private Level firstLevel;
	private Level zombieLevel;

	@Before
	public void before() {
		firstLevel = mock(Level.class);
		zombieLevel = mock(Level.class);

		levels = new TamagotchiLevels(firstLevel, zombieLevel);
	}

	@Test
	public void getFirstLevel_returnsCorrectLevel() throws Exception {
		TamagotchiLevels levels = new TamagotchiLevels();
		assertTrue(levels.getFirstLevel() instanceof FirstLevel);
	}

	@Test
	public void getZombieLevel_returnsCorrectLevel() throws Exception {
		TamagotchiLevels levels = new TamagotchiLevels();
		assertTrue(levels.getZombieLevel() instanceof ZombieLevel);
	}

	@Test
	public void getFirstLevelHealh_returnsCorrectHealth() throws Exception {
		Image image = new Image(null, "icons/level1-health.png");
		when(firstLevel.getHealth()).thenReturn(image);

		assertEquals(image, levels.getFirstLevelHealth());
	}

	@Test
	public void getZombieLevelHealh_returnsCorrectHealth() throws Exception {
		Image image = new Image(null, "icons/level0-health.png");
		when(zombieLevel.getHealth()).thenReturn(image);

		assertEquals(image, levels.getZombieLevelHealth());
	}
}
