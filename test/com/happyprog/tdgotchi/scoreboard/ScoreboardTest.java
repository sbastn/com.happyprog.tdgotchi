package com.happyprog.tdgotchi.scoreboard;

import static org.mockito.Mockito.*;

import org.eclipse.swt.graphics.Image;
import org.junit.Before;
import org.junit.Test;

import com.happyprog.tdgotchi.level.Level;
import com.happyprog.tdgotchi.subscriber.TestSubscriber;
import com.happyprog.tdgotchi.views.Tamagotchi;
import com.happyprog.tdgotchi.views.View;

public class ScoreboardTest {

	private TestSubscriber subscriber;
	private Tamagotchi tamagotchi;
	private View view;

	private Scoreboard scoreboard;
	private Level zombieLevel;
	private Level firstLevel;

	@Before
	public void before() {
		view = mock(View.class);
		tamagotchi = mock(Tamagotchi.class);
		subscriber = mock(TestSubscriber.class);
		zombieLevel = mock(Level.class);
		firstLevel = mock(Level.class);
		scoreboard = new Scoreboard(view, tamagotchi, subscriber, zombieLevel, firstLevel);
	}

	@Test
	public void subscribesToTestEvents() throws Exception {
		verify(subscriber).subscribe(scoreboard);
	}

	@Test
	public void whenStartingGame_tamagotchiLevelIsOne() throws Exception {
		verify(tamagotchi).setLevel(firstLevel);
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

		verify(tamagotchi).setLevel(zombieLevel);
	}

	@Test
	public void whenScoreChanges_viewIsUpdated() throws Exception {
		Image image = new Image(null, "icons/health-zombie.png");
		when(zombieLevel.getHealth()).thenReturn(image);

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
}
