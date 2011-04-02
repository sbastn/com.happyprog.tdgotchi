package com.happyprog.tdgotchi.controller;

import static org.mockito.Mockito.*;

import org.junit.Test;

public class ControllerTest {

	@Test
	public void subscribesToJUnitEvents() throws Exception {
		TestSubscriber subscriber = mock(TestSubscriber.class);
		Controller controller = new Controller(null, subscriber);

		verify(subscriber).subscribe(controller);
	}

	@Test
	public void onPassingTest_tamagotchiIsHappy() throws Exception {
		TestSubscriber subscriber = mock(TestSubscriber.class);
		Tamagotchi tamagotchi = mock(Tamagotchi.class);
		Controller controller = new Controller(tamagotchi, subscriber);

		controller.onPassingTest();

		verify(tamagotchi).beHappy();
	}
}
