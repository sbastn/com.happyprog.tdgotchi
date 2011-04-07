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
	public void getNormalMoodForBeginner_returnsBeginnerImages() throws Exception {
		manager.getNormalMoodForLevel(MoodManager.Level.Beginner);

		assertEquals("*Beginner-default1**Beginner-default2*", activator.key.toString());
	}

	@Test
	public void getNormalMoodForIntermediate_returnsIntermediateImages() throws Exception {
		Image[] images = manager.getNormalMoodForLevel(MoodManager.Level.Intermediate);

		assertEquals("*Intermediate-default1**Intermediate-default2*", activator.key.toString());
		assertEquals(2, images.length);
	}

	@Test
	public void getHappyMoodForBeginner_returnsSixHappyMoodImages() throws Exception {
		Image[] images = manager.getHappyMoodForLevel(MoodManager.Level.Beginner);

		assertEquals("*Beginner-happy1**Beginner-happy2*", activator.key.toString());
		assertEquals(6, images.length);
	}

	@Test
	public void getHappyMoodForIntermediate_returnsSixHappyMoodImages() throws Exception {
		Image[] images = manager.getHappyMoodForLevel(MoodManager.Level.Intermediate);

		assertEquals("*Intermediate-happy1**Intermediate-happy2*", activator.key.toString());
		assertEquals(6, images.length);
	}

	@Test
	public void getUpsetMoodForBeginner_returnsSixUpsetMoodImages() throws Exception {
		Image[] images = manager.getUpsetMoodForLevel(MoodManager.Level.Beginner);

		assertEquals("*Beginner-upset1**Beginner-upset2*", activator.key.toString());
		assertEquals(6, images.length);
	}

	@Test
	public void getHealthForBeginner_returnsOneHealthImage() throws Exception {
		Image image = manager.getHealthForLevel(MoodManager.Level.Beginner);

		assertEquals("*Beginner-health*", activator.key.toString());
		assertNotNull(image);
	}

	@Test
	public void getHealthForIntermediate_returnsOneHealthImage() throws Exception {
		Image image = manager.getHealthForLevel(MoodManager.Level.Intermediate);

		assertEquals("*Intermediate-health*", activator.key.toString());
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
