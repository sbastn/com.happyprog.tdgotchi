package com.happyprog.tdgotchi.controller;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.happyprog.tdgotchi.level.LevelOne;
import com.happyprog.tdgotchi.level.ZombieLevel;
import com.happyprog.tdgotchi.subscriber.TestSubscriber;
import com.happyprog.tdgotchi.views.Tamagotchi;

public class ControllerTest {

	private TestSubscriber subscriber;
	private Tamagotchi tamagotchi;

	private Controller controller;

	@Before
	public void before() {
		subscriber = mock(TestSubscriber.class);
		tamagotchi = mock(Tamagotchi.class);
		controller = new Controller(tamagotchi, subscriber);
	}

	@Test
	public void subscribesToTestEvents() throws Exception {
		verify(subscriber).subscribe(controller);
	}

	@Test
	public void onRedToGreen_tamagotchiIsHappy() throws Exception {
		controller.onFailingTest();
		controller.onPassingTest();

		verify(tamagotchi).beHappy();
	}

	@Test
	public void onDoubleRed_tamagotchiIsUpset() throws Exception {
		controller.onFailingTest();
		controller.onFailingTest();

		verify(tamagotchi).beUpset();
	}

	@Test
	public void onDoubleGreen_tamagotchiDoesNotChangeMood() throws Exception {
		controller.onPassingTest();
		controller.onPassingTest();

		verifyZeroInteractions(tamagotchi);
	}

	@Test
	public void onGreenToRed_tamagotchiDoesNotChangeMood() throws Exception {
		controller.onPassingTest();
		controller.onFailingTest();

		verifyZeroInteractions(tamagotchi);
	}

	@Test
	public void ifScoreLessThanZero_tamagotchiLevelIsZombie() throws Exception {
		controller.onFailingTest();
		controller.onFailingTest();

		verify(tamagotchi).changeLevel(isA(ZombieLevel.class));
	}

	@Test
	public void ifScoreEqualsZero_tamagotchiLevelIsOne() throws Exception {
		controller.onFailingTest();
		controller.onPassingTest();

		verify(tamagotchi).changeLevel(isA(LevelOne.class));
	}
}
