package com.happyprog.tdgotchi.controller;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.level.LevelOne;
import com.happyprog.tdgotchi.level.ZombieLevel;
import com.happyprog.tdgotchi.subscriber.JUnitTestSubscriber;
import com.happyprog.tdgotchi.subscriber.TestObserver;
import com.happyprog.tdgotchi.subscriber.TestSubscriber;
import com.happyprog.tdgotchi.views.FastViewTamagotchi;
import com.happyprog.tdgotchi.views.Tamagotchi;
import com.happyprog.tdgotchi.views.TamagotchiObserver;
import com.happyprog.tdgotchi.views.View;

public class Controller implements TestObserver, TamagotchiObserver {

	private final View view;
	private final TestSubscriber subscriber;
	private final Tamagotchi tamagotchi;

	private TestRun previousTestRun;
	private int score;

	private enum TestRun {
		PASS, FAIL
	}

	public Controller(View view) {
		this(view, new FastViewTamagotchi(new LevelOne()), new JUnitTestSubscriber());
	}

	public Controller(View view, Tamagotchi tamagotchi, TestSubscriber subscriber) {
		this.view = view;
		this.tamagotchi = tamagotchi;
		this.subscriber = subscriber;

		subscribeToJUnitEvents();
		subscribeToTamagotchiEvents(tamagotchi);
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

	@Override
	public void updateMood(Image image) {
		view.setImage(image);
	}

	private void updateScoreWith(int points) {
		score += points;

		view.updateScore(score);
		changeTamagotchiLevelBasedOnScore();
	}

	private void changeTamagotchiLevelBasedOnScore() {
		if (score < 0) {
			tamagotchi.changeLevel(new ZombieLevel());
			return;
		}

		if (score >= 0 && score <= 5) {
			tamagotchi.changeLevel(new LevelOne());
			return;
		}
	}

	private void subscribeToTamagotchiEvents(Tamagotchi tamagotchi) {
		tamagotchi.addObserver(this);
	}

	private void subscribeToJUnitEvents() {
		subscriber.subscribe(this);
	}

	public void onImageSetCallback() {
		tamagotchi.onImageSetCallback();
	}
}
