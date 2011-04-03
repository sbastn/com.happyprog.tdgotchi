package com.happyprog.tdgotchi.controller;

import com.happyprog.tdgotchi.subscriber.TestObserver;
import com.happyprog.tdgotchi.subscriber.TestSubscriber;
import com.happyprog.tdgotchi.views.Tamagotchi;

public class Controller implements TestObserver {

	private final TestSubscriber subscriber;
	private final Tamagotchi tamagotchi;
	private TestRun previousTestRun;

	private enum TestRun {
		PASS, FAIL
	}

	public Controller(Tamagotchi tamagotchi, TestSubscriber subscriber) {
		this.tamagotchi = tamagotchi;
		this.subscriber = subscriber;

		subscribeToJUnitEvents();
	}

	private void subscribeToJUnitEvents() {
		subscriber.subscribe(this);
	}

	@Override
	public void onPassingTest() {
		if (TestRun.FAIL.equals(previousTestRun)) {
			tamagotchi.beHappy();
		}
		previousTestRun = TestRun.PASS;
	}

	@Override
	public void onFailingTest() {
		if (TestRun.FAIL.equals(previousTestRun)) {
			tamagotchi.beUpset();
		}
		previousTestRun = TestRun.FAIL;
	}
}
