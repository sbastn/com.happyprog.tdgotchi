package com.happyprog.tdgotchi.level;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.eclipse.swt.graphics.Image;
import org.junit.Before;
import org.junit.Test;

import com.happyprog.tdgotchi.scoreboard.LevelManager;

public class TinyLevelManagerTest {

	private LevelManager levels;
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

		levels = new TinyLevelManager(firstLevel, secondLevel, thirdLevel, zombieLevel);
	}

	@Test
	public void getFirstLevel_returnsCorrectLevel() throws Exception {
		TinyLevelManager levels = new TinyLevelManager();
		assertTrue(levels.getBeginner() instanceof Beginner);
	}

	@Test
	public void getZombieLevel_returnsCorrectLevel() throws Exception {
		TinyLevelManager levels = new TinyLevelManager();
		assertTrue(levels.getZombie() instanceof Zombie);
	}

	@Test
	public void getSecondLevel_returnCorrectLevel() throws Exception {
		TinyLevelManager levels = new TinyLevelManager();
		assertTrue(levels.getIntermediate() instanceof Intermediate);
	}

	@Test
	public void getThirdLevel_returnCorrectLevel() throws Exception {
		TinyLevelManager levels = new TinyLevelManager();
		assertTrue(levels.getPro() instanceof Pro);
	}

	@Test
	public void getFirstLevelHealh_returnsCorrectHealth() throws Exception {
		Image image = new Image(null, "icons/level1-health.png");
		when(firstLevel.getHealth()).thenReturn(image);

		assertEquals(image, levels.getBeginnerHealth());
	}

	@Test
	public void getZombieLevelHealh_returnsCorrectHealth() throws Exception {
		Image image = new Image(null, "icons/level0-health.png");
		when(zombieLevel.getHealth()).thenReturn(image);

		assertEquals(image, levels.getZombieHealth());
	}

	@Test
	public void getSecondLevel_returnsCorrectHealth() throws Exception {
		Image image = new Image(null, "icons/level2-health.png");
		when(secondLevel.getHealth()).thenReturn(image);

		assertEquals(image, levels.getIntermediateHealth());
	}

	@Test
	public void getThirdLevel_returnsCorrectHealth() throws Exception {
		Image image = new Image(null, "icons/level3-health.png");
		when(thirdLevel.getHealth()).thenReturn(image);

		assertEquals(image, levels.getProHealth());
	}
}
