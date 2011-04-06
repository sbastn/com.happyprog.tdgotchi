package com.happyprog.tdgotchi.level;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class FirstLevelTest {

	private MoodManager moodManager;
	private FirstLevel level;

	@Before
	public void before() {
		moodManager = mock(MoodManager.class);
		level = new FirstLevel(moodManager);
	}

	@Test
	public void getNormalMood_loadsMoodFromManager() throws Exception {
		level.getNormalMood();

		verify(moodManager).getNormalMoodForLevel(1);
	}

	@Test
	public void getHappyMood_loadsMoodForManager() throws Exception {
		level.getHappyMood();

		verify(moodManager).getHappyMoodForLevel(1);
	}

	@Test
	public void getUpsetMood_loadsMoodForManager() throws Exception {
		level.getUpsetMood();

		verify(moodManager).getUpsetMoodForLevel(1);
	}

	@Test
	public void getHealth_loadsHealthFromManager() throws Exception {
		level.getHealth();

		verify(moodManager).getHealthForLevel(1);
	}
}
