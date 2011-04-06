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
	private Level secondLevel;
	private Level thirdLevel;

	@Before
	public void before() {
		firstLevel = mock(Level.class);
		zombieLevel = mock(Level.class);
		secondLevel = mock(Level.class);
		thirdLevel = mock(Level.class);

		levels = new TamagotchiLevels(firstLevel, secondLevel, thirdLevel, zombieLevel);
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
	public void getSecondLevel_returnCorrectLevel() throws Exception {
		TamagotchiLevels levels = new TamagotchiLevels();
		assertTrue(levels.getSecondLevel() instanceof SecondLevel);
	}

	@Test
	public void getThirdLevel_returnCorrectLevel() throws Exception {
		TamagotchiLevels levels = new TamagotchiLevels();
		assertTrue(levels.getThirdLevel() instanceof ThirdLevel);
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

	@Test
	public void getSecondLevel_returnsCorrectHealth() throws Exception {
		Image image = new Image(null, "icons/level2-health.png");
		when(secondLevel.getHealth()).thenReturn(image);

		assertEquals(image, levels.getSecondLevelHealth());
	}

	@Test
	public void getThirdLevel_returnsCorrectHealth() throws Exception {
		Image image = new Image(null, "icons/level3-health.png");
		when(thirdLevel.getHealth()).thenReturn(image);

		assertEquals(image, levels.getThirdLevelHealth());
	}
}
