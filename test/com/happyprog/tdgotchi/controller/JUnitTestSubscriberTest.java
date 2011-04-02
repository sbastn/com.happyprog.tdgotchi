package com.happyprog.tdgotchi.controller;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class JUnitTestSubscriberTest {

	private TestObserver observer;
	private JUnitTestSubscriber subscriber;

	@Before
	public void before() {
		observer = mock(TestObserver.class);
		subscriber = new JUnitTestSubscriber();

		subscriber.subscribe(observer);
	}

	@Test
	public void onPassingTest_updateObserver() throws Exception {
		subscriber.onPassingTest();

		verify(observer).onPassingTest();
	}

	@Test
	public void onFailingTest_updateObserver() throws Exception {
		subscriber.onFailingTest();

		verify(observer).onFailingTest();
	}
}
