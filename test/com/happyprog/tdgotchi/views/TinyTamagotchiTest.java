package com.happyprog.tdgotchi.views;

import static org.mockito.Mockito.*;

import org.eclipse.swt.graphics.Image;
import org.junit.Before;
import org.junit.Test;

import com.happyprog.tdgotchi.level.Level;
import com.happyprog.tdgotchi.scoreboard.TamagotchiObserver;

public class TinyTamagotchiTest {

	private static final Image DEFAULT1 = new Image(null, "icons/level1-default1.png");
	private static final Image DEFAULT2 = new Image(null, "icons/level1-default2.png");

	private static final Image HAPPY1 = new Image(null, "icons/level1-happy1.png");
	private static final Image HAPPY2 = new Image(null, "icons/level1-happy2.png");

	private static final Image UPSET1 = new Image(null, "icons/level1-upset1.png");
	private static final Image UPSET2 = new Image(null, "icons/level1-upset2.png");

	private static final Image[] DEFAULT_MOOD = new Image[] { DEFAULT1, DEFAULT2 };
	private static final Image[] HAPPY_MOOD = new Image[] { HAPPY1, HAPPY2 };
	private static final Image[] UPSET_MOOD = new Image[] { UPSET1, UPSET2 };

	private TamagotchiObserver observer;
	private Level level;
	private Tamagotchi tamagotchi;

	@Before
	public void before() {
		observer = mock(TamagotchiObserver.class);
		level = mock(Level.class);
		tamagotchi = new TinyTamagotchi();
		tamagotchi.setLevel(level);
		tamagotchi.addObserver(observer);
	}

	@Test
	public void whenStarted_ObserverIsNotifiedOfMoodChange() throws Exception {
		when(level.getNormalMood()).thenReturn(DEFAULT_MOOD);

		tamagotchi.start();

		verify(observer).updateMood(DEFAULT2);
	}

	@Test
	public void beHappy_updatesObserver() throws Exception {
		when(level.getNormalMood()).thenReturn(new Image[] { DEFAULT1 });
		when(level.getHappyMood()).thenReturn(HAPPY_MOOD);

		tamagotchi.start();

		tamagotchi.beHappy();
		tamagotchi.onImageSetCallback();

		verify(observer).updateMood(HAPPY2);
	}

	@Test
	public void beUpset_updatesObserver() throws Exception {
		when(level.getNormalMood()).thenReturn(new Image[] { DEFAULT1 });
		when(level.getUpsetMood()).thenReturn(UPSET_MOOD);

		tamagotchi.start();

		tamagotchi.beUpset();
		tamagotchi.onImageSetCallback();

		verify(observer).updateMood(UPSET2);
	}

	@Test
	public void onImageSetCallback_updatesObserver() throws Exception {
		when(level.getNormalMood()).thenReturn(DEFAULT_MOOD);

		tamagotchi.start();
		tamagotchi.onImageSetCallback();

		verify(observer).updateMood(DEFAULT2);
	}

	@Test
	public void onChangeLevel_updatesObserverWithNewMoodImage() throws Exception {
		when(level.getNormalMood()).thenReturn(DEFAULT_MOOD);

		tamagotchi.start();

		Level newLevel = mock(Level.class);
		when(newLevel.getNormalMood()).thenReturn(new Image[] { HAPPY1 });

		tamagotchi.onImageSetCallback();
		tamagotchi.setLevel(newLevel);
		tamagotchi.onImageSetCallback();

		verify(observer).updateMood(HAPPY1);
	}
}
