package com.happyprog.tdgotchi.scoreboard;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.eclipse.swt.graphics.Image;
import org.junit.Before;
import org.junit.Test;

import com.happyprog.tdgotchi.level.Beginner;
import com.happyprog.tdgotchi.level.Intermediate;
import com.happyprog.tdgotchi.level.Pro;
import com.happyprog.tdgotchi.level.Zombie;
import com.happyprog.tdgotchi.subscriber.TestSubscriber;
import com.happyprog.tdgotchi.views.Tamagotchi;
import com.happyprog.tdgotchi.views.View;

public class ScoreboardTest {

	private TestSubscriber subscriber;
	private Tamagotchi tamagotchi;
	private View view;

	private Scoreboard scoreboard;
	private LevelManager levels;

	@Before
	public void before() {
		view = mock(View.class);
		tamagotchi = mock(Tamagotchi.class);
		subscriber = mock(TestSubscriber.class);
		levels = mock(LevelManager.class);

		when(levels.getZombie()).thenReturn(new Zombie());
		when(levels.getBeginner()).thenReturn(new Beginner());
		when(levels.getIntermediate()).thenReturn(new Intermediate());
		when(levels.getPro()).thenReturn(new Pro());

		scoreboard = new Scoreboard(view, tamagotchi, subscriber, levels);
	}

	@Test
	public void subscribesToTestEvents() throws Exception {
		verify(subscriber).subscribe(scoreboard);
	}

	@Test
	public void whenStartingGame_tamagotchiLevelIsOne() throws Exception {
		verify(tamagotchi).setLevel(levels.getBeginner());
	}

	@Test
	public void onRedToGreen_tamagotchiIsHappy() throws Exception {
		scoreboard.onFailingTest();
		scoreboard.onPassingTest();

		verify(tamagotchi).beHappy();
	}

	@Test
	public void onDoubleRed_tamagotchiIsUpset() throws Exception {
		scoreboard.onFailingTest();
		scoreboard.onFailingTest();

		verify(tamagotchi).beUpset();
	}

	@Test
	public void onDoubleGreen_tamagotchiDoesNotChangeMood() throws Exception {
		scoreboard.onPassingTest();
		scoreboard.onPassingTest();

		verify(tamagotchi, never()).beHappy();
		verify(tamagotchi, never()).beUpset();
	}

	@Test
	public void onGreenToRed_tamagotchiDoesNotChangeMood() throws Exception {
		scoreboard.onPassingTest();
		scoreboard.onFailingTest();

		verify(tamagotchi, never()).beHappy();
		verify(tamagotchi, never()).beUpset();
	}

	@Test
	public void ifScoreLessThanZero_tamagotchiLevelIsZombie() throws Exception {
		scoreboard.onFailingTest();
		scoreboard.onFailingTest();

		verify(tamagotchi).beUpset();
		verify(tamagotchi, times(1)).setLevel(isA(Zombie.class));
	}

	@Test
	public void ifScoreBetweenZeroAndTen_tamagotchiLevelIsOne() throws Exception {
		for (int i = 0; i < 8; i++) {
			scoreboard.onFailingTest();
			scoreboard.onPassingTest();
		}

		verify(tamagotchi, times(8)).beHappy();
		verify(tamagotchi, times(9)).setLevel(isA(Beginner.class));
	}

	@Test
	public void ifScoreIsBetweenFiveAndTwenty_tamagotchiLevelIsTwo() throws Exception {
		for (int i = 0; i < 12; i++) {
			scoreboard.onFailingTest();
			scoreboard.onPassingTest();
		}

		verify(tamagotchi, times(12)).beHappy();
		// One more invocation for the level one since it is set at the start
		verify(tamagotchi, times(11)).setLevel(isA(Beginner.class));
		verify(tamagotchi, times(2)).setLevel(isA(Intermediate.class));
	}

	@Test
	public void ifScoreIsGreaterThanTwenty_tamagotchiLevelIsThree() throws Exception {
		for (int i = 0; i < 22; i++) {
			scoreboard.onFailingTest();
			scoreboard.onPassingTest();
		}

		verify(tamagotchi, times(22)).beHappy();
		verify(tamagotchi, times(11)).setLevel(isA(Beginner.class));
		verify(tamagotchi, times(10)).setLevel(isA(Intermediate.class));
		verify(tamagotchi, times(2)).setLevel(isA(Pro.class));
	}

	@Test
	public void whenScoreChanges_viewIsUpdated() throws Exception {
		Image image = new Image(null, "icons/level0-health.png");
		when(levels.getZombieHealth()).thenReturn(image);

		scoreboard.onFailingTest();
		scoreboard.onFailingTest();

		verify(view).updateScore(-5);
		verify(view).updateHealth(image);
	}

	@Test
	public void onUpdateMood_viewIsUpdated() throws Exception {
		scoreboard.updateMood(null);

		verify(view).setImage(null);
	}

	@Test
	public void onSetImageCallback_tamagotchiIsNotified() throws Exception {
		scoreboard.onImageSetCallback();

		verify(tamagotchi).onImageSetCallback();
	}

	@Test
	public void getDefaultHealth_returnsFirstLevelHealth() throws Exception {
		scoreboard.getDefaultHealth();

		verify(levels).getBeginnerHealth();
	}
}
