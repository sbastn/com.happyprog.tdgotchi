package com.happyprog.tdgotchi.scoreboard;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.happyprog.tdgotchi.level.LevelOne;
import com.happyprog.tdgotchi.level.ZombieLevel;
import com.happyprog.tdgotchi.scoreboard.Scoreboard;
import com.happyprog.tdgotchi.subscriber.TestSubscriber;
import com.happyprog.tdgotchi.views.Tamagotchi;
import com.happyprog.tdgotchi.views.View;

public class ScoreboardTest {

	private TestSubscriber subscriber;
	private Tamagotchi tamagotchi;
	private View view;

	private Scoreboard scoreboard;

	@Before
	public void before() {
		subscriber = mock(TestSubscriber.class);
		tamagotchi = mock(Tamagotchi.class);
		view = mock(View.class);
		scoreboard = new Scoreboard(view, tamagotchi, subscriber);
	}

	@Test
	public void subscribesToTestEvents() throws Exception {
		verify(subscriber).subscribe(scoreboard);
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

		verify(tamagotchi).changeLevel(isA(ZombieLevel.class));
	}

	@Test
	public void ifScoreEqualsZero_tamagotchiLevelIsOne() throws Exception {
		scoreboard.onFailingTest();
		scoreboard.onPassingTest();

		verify(tamagotchi).changeLevel(isA(LevelOne.class));
	}

	@Test
	public void whenScoreChanges_viewIsUpdated() throws Exception {
		scoreboard.onFailingTest();
		scoreboard.onFailingTest();

		verify(view).updateScore(-5);
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
}
