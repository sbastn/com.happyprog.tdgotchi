package com.happyprog.tdgotchi.controller;

import com.happyprog.tdgotchi.level.LevelOne;
import com.happyprog.tdgotchi.level.ZombieLevel;
import com.happyprog.tdgotchi.subscriber.TestObserver;
import com.happyprog.tdgotchi.subscriber.TestSubscriber;
import com.happyprog.tdgotchi.views.Tamagotchi;

public class Controller implements TestObserver {

	private final TestSubscriber subscriber;
	private final Tamagotchi tamagotchi;
	private TestRun previousTestRun;
	private int score;

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
			updateScoreWith(1);
		}
		previousTestRun = TestRun.PASS;
	}

	@Override
	public void onFailingTest() {
		if (TestRun.FAIL.equals(previousTestRun)) {
			tamagotchi.beUpset();
			updateScoreWith(-5);
		}
		previousTestRun = TestRun.FAIL;
	}

	private void updateScoreWith(int points) {
		score += points;

		if (score < 0) {
			tamagotchi.changeLevel(new ZombieLevel());
			return;
		}

		if (score >= 0 && score <= 5) {
			tamagotchi.changeLevel(new LevelOne());
			return;
		}

	}
}
