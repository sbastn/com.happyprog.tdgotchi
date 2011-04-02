package com.happyprog.tdgotchi.controller;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

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
	public void onPassingTest_tamagotchiIsHappy() throws Exception {
		controller.onPassingTest();

		verify(tamagotchi).beHappy();
	}

	@Test
	public void onFailingTest_tamagotchiIsUpset() throws Exception {
		controller.onFailingTest();

		verify(tamagotchi).beUpset();
	}
}
