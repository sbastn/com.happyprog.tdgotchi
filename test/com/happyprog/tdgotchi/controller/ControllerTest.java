package com.happyprog.tdgotchi.controller;

import static org.mockito.Mockito.*;

import org.junit.Test;

public class ControllerTest {
	@Test
	public void subscribesToJUnitEvents() throws Exception {
		TestSubscriber subscriber = mock(TestSubscriber.class);
		Controller controller = new Controller(subscriber);

		verify(subscriber).subscribe(controller);
	}
}
