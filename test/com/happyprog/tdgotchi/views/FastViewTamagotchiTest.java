package com.happyprog.tdgotchi.views;

import static org.mockito.Mockito.*;

import org.eclipse.swt.graphics.Image;
import org.junit.Before;
import org.junit.Test;

import com.happyprog.tdgotchi.level.Level;

public class FastViewTamagotchiTest {

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

	@Before
	public void before() {
		observer = mock(TamagotchiObserver.class);
		level = mock(Level.class);
	}

	@Test
	public void whenConstructed_updatesTheView() throws Exception {
		when(level.getNormalMood()).thenReturn(DEFAULT_MOOD);

		Tamagotchi tamagotchi = new FastViewTamagotchi(level);
		tamagotchi.addObserver(observer);

		verify(observer).updateMood(DEFAULT2);
	}

	@Test
	public void beHappy_updatesViewsImage() throws Exception {
		when(level.getNormalMood()).thenReturn(new Image[] { DEFAULT1 });
		when(level.getHappyMood()).thenReturn(HAPPY_MOOD);

		Tamagotchi tamagotchi = new FastViewTamagotchi(level);
		tamagotchi.addObserver(observer);

		tamagotchi.beHappy();
		tamagotchi.onImageSetCallback();

		verify(observer).updateMood(HAPPY2);
	}

	@Test
	public void beUpset_updatesViewsImage() throws Exception {
		when(level.getNormalMood()).thenReturn(new Image[] { DEFAULT1 });
		when(level.getUpsetMood()).thenReturn(UPSET_MOOD);

		Tamagotchi tamagotchi = new FastViewTamagotchi(level);
		tamagotchi.addObserver(observer);

		tamagotchi.beUpset();
		tamagotchi.onImageSetCallback();

		verify(observer).updateMood(UPSET2);
	}

	@Test
	public void onImageSetCallback_updatesViewsImage() throws Exception {
		when(level.getNormalMood()).thenReturn(DEFAULT_MOOD);

		Tamagotchi tamagotchi = new FastViewTamagotchi(level);
		tamagotchi.addObserver(observer);

		tamagotchi.onImageSetCallback();

		verify(observer).updateMood(DEFAULT2);
	}

	@Test
	public void onChangeLevel_updatesTamagotchiLevel() throws Exception {
		when(level.getNormalMood()).thenReturn(DEFAULT_MOOD);

		Tamagotchi tamagotchi = new FastViewTamagotchi(level);
		tamagotchi.addObserver(observer);

		Level newLevel = mock(Level.class);
		when(newLevel.getNormalMood()).thenReturn(new Image[] { HAPPY1 });

		tamagotchi.onImageSetCallback();
		tamagotchi.changeLevel(newLevel);
		tamagotchi.onImageSetCallback();

		verify(observer).updateMood(HAPPY1);
	}
}
