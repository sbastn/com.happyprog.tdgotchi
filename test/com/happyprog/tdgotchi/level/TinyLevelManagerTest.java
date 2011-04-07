package com.happyprog.tdgotchi.level;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.eclipse.swt.graphics.Image;
import org.junit.Before;
import org.junit.Test;

import com.happyprog.tdgotchi.scoreboard.LevelManager;

public class TinyLevelManagerTest {

	private LevelManager levels;
	private Level beginner;
	private Level zombie;
	private Level intermediate;
	private Level pro;

	@Before
	public void before() {
		beginner = mock(Level.class);
		zombie = mock(Level.class);
		intermediate = mock(Level.class);
		pro = mock(Level.class);

		levels = new TinyLevelManager(beginner, intermediate, pro, zombie);
	}

	@Test
	public void getBeginner_returnsBeginnerLevel() throws Exception {
		TinyLevelManager levels = new TinyLevelManager();
		assertTrue(levels.getBeginner() instanceof Beginner);
	}

	@Test
	public void getIntermediate_returnsIntermediateLevel() throws Exception {
		TinyLevelManager levels = new TinyLevelManager();
		assertTrue(levels.getIntermediate() instanceof Intermediate);
	}

	@Test
	public void getPro_returnsProLevel() throws Exception {
		TinyLevelManager levels = new TinyLevelManager();
		assertTrue(levels.getPro() instanceof Pro);
	}

	@Test
	public void getZombie_returnsZombieLevel() throws Exception {
		TinyLevelManager levels = new TinyLevelManager();
		assertTrue(levels.getZombie() instanceof Zombie);
	}

	@Test
	public void getBeginnerHealh_returnsImage() throws Exception {
		Image image = new Image(null, "icons/Beginner-health.png");
		when(beginner.getHealth()).thenReturn(image);

		assertEquals(image, levels.getBeginnerHealth());
	}

	@Test
	public void getIntermediateHealth_returnsImage() throws Exception {
		Image image = new Image(null, "icons/Intermediate-health.png");
		when(intermediate.getHealth()).thenReturn(image);

		assertEquals(image, levels.getIntermediateHealth());
	}

	@Test
	public void getProHealth_returnsImage() throws Exception {
		Image image = new Image(null, "icons/Pro-health.png");
		when(pro.getHealth()).thenReturn(image);

		assertEquals(image, levels.getProHealth());
	}

	@Test
	public void getZombieHealh_returnsImage() throws Exception {
		Image image = new Image(null, "icons/Zombie-health.png");
		when(zombie.getHealth()).thenReturn(image);

		assertEquals(image, levels.getZombieHealth());
	}
}
