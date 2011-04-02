package com.happyprog.tdgotchi.controller;

public class JUnitTestSubscriber implements TestSubscriber {

	private TestObserver observer;

	@Override
	public void subscribe(TestObserver observer) {
		this.observer = observer;
	}

	public void onPassingTest() {
		observer.onPassingTest();
	}

	public void onFailingTest() {
		observer.onFailingTest();
	}

}
