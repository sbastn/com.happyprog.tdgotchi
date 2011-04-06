package com.happyprog.tdgotchi.level;

import static org.junit.Assert.*;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.junit.Before;
import org.junit.Test;

import com.happyprog.tdgotchi.Activator;
import com.happyprog.tdgotchi.scoreboard.MoodManager;

public class TinyMoodManagerTest {

	private ActivatorSpy activator;
	private MoodManager manager;

	@Before
	public void before() {
		activator = new ActivatorSpy();
		manager = new TinyMoodManager(activator);
	}

	@Test
	public void getNormalMoodForLevelOne_returnsTwoNormalMoodImages() throws Exception {
		manager.getNormalMoodForLevel(1);

		assertEquals("*level1-default1**level1-default2*", activator.key.toString());
	}

	@Test
	public void getNormalMoodForLevelTwo_returnsTwoNormalMoodImages() throws Exception {
		Image[] images = manager.getNormalMoodForLevel(2);

		assertEquals("*level2-default1**level2-default2*", activator.key.toString());
		assertEquals(2, images.length);
	}

	@Test
	public void getHappyMoodForLevelOne_returnsSixHappyMoodImages() throws Exception {
		Image[] images = manager.getHappyMoodForLevel(1);

		assertEquals("*level1-happy1**level1-happy2*", activator.key.toString());
		assertEquals(6, images.length);
	}

	@Test
	public void getHappyMoodForLevelTwo_returnsSixHappyMoodImages() throws Exception {
		Image[] images = manager.getHappyMoodForLevel(2);

		assertEquals("*level2-happy1**level2-happy2*", activator.key.toString());
		assertEquals(6, images.length);
	}

	@Test
	public void getUpsetMoodForLevelOne_returnsSixUpsetMoodImages() throws Exception {
		Image[] images = manager.getUpsetMoodForLevel(1);

		assertEquals("*level1-upset1**level1-upset2*", activator.key.toString());
		assertEquals(6, images.length);
	}

	@Test
	public void getHealthForLevelOne_returnsOneHealthImage() throws Exception {
		Image image = manager.getHealthForLevel(1);

		assertEquals("*level1-health*", activator.key.toString());
		assertNotNull(image);
	}

	@Test
	public void getHealthForLevelTwo_returnsOneHealthImage() throws Exception {
		Image image = manager.getHealthForLevel(2);

		assertEquals("*level2-health*", activator.key.toString());
		assertNotNull(image);
	}

	class ActivatorSpy extends Activator {

		StringBuffer key = new StringBuffer();

		public ActivatorSpy() {
			initializeImageRegistry(new ImageRegistry());
		}

		@Override
		public Image getImageFromKey(String key) {
			this.key.append(String.format("*%s*", key));
			return super.getImageFromKey(key);
		}
	}
}
