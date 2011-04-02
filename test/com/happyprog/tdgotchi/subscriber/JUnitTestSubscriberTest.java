package com.happyprog.tdgotchi.subscriber;

import static org.mockito.Mockito.*;

import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jdt.junit.model.ITestRunSession;
import org.junit.Before;
import org.junit.Test;

public class JUnitTestSubscriberTest {

	private TestObserver observer;
	private JUnitTestSubscriber subscriber;
	private ITestRunSession session;

	@Before
	public void before() {
		session = mock(ITestRunSession.class);
		observer = mock(TestObserver.class);

		subscriber = spy(new JUnitTestSubscriber());
		doNothing().when(subscriber).addAsTestListener();

		subscriber.subscribe(observer);
	}

	@Test
	public void onPassingTest_updateObserver() throws Exception {
		when(session.getTestResult(true)).thenReturn(ITestElement.Result.OK);

		subscriber.sessionFinished(session);

		verify(observer).onPassingTest();
	}

	@Test
	public void onFailingTest_updateObserver() throws Exception {
		when(session.getTestResult(true)).thenReturn(ITestElement.Result.FAILURE);

		subscriber.sessionFinished(session);

		verify(observer).onFailingTest();
	}

}
