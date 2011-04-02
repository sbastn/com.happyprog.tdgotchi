package com.happyprog.tdgotchi.subscriber;

import org.eclipse.jdt.junit.JUnitCore;
import org.eclipse.jdt.junit.TestRunListener;
import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jdt.junit.model.ITestElement.Result;
import org.eclipse.jdt.junit.model.ITestRunSession;

public class JUnitTestSubscriber extends TestRunListener implements TestSubscriber {

	private TestObserver observer;

	@Override
	public void subscribe(TestObserver observer) {
		this.observer = observer;
		addAsTestListener();
	}

	void addAsTestListener() {
		JUnitCore.addTestRunListener(this);
	}

	@Override
	public void sessionFinished(ITestRunSession session) {
		Result testResult = session.getTestResult(true);
		if (testResult.equals(ITestElement.Result.OK)) {
			observer.onPassingTest();
		} else {
			observer.onFailingTest();
		}
	}

}
