package com.happyprog.tdgotchi.scoreboard;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.level.TinyLevelManager;
import com.happyprog.tdgotchi.subscriber.JUnitTestSubscriber;
import com.happyprog.tdgotchi.subscriber.TestSubscriber;
import com.happyprog.tdgotchi.views.Tamagotchi;
import com.happyprog.tdgotchi.views.TinyTamagotchi;
import com.happyprog.tdgotchi.views.View;

public class Scoreboard implements TestObserver, TamagotchiObserver {

	private final View view;
	private final TestSubscriber subscriber;
	private final Tamagotchi tamagotchi;

	private TestRun previousTestRun;
	private int score;
	private final LevelManager levels;

	private enum TestRun {
		PASS, FAIL
	}

	public Scoreboard(View view) {
		this(view, new TinyTamagotchi(), new JUnitTestSubscriber(), new TinyLevelManager());
	}

	public Scoreboard(View view, Tamagotchi tamagotchi, TestSubscriber subscriber, LevelManager levels) {
		this.view = view;
		this.tamagotchi = tamagotchi;
		this.subscriber = subscriber;
		this.levels = levels;

		subscribeToJUnitEvents();
		startTamagotchi(tamagotchi);
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
		updateTamagoshiAndHealthLevel();
	}

	private void updateTamagoshiAndHealthLevel() {
		if (score < 0) {
			tamagotchi.setLevel(levels.getZombie());
			view.updateHealth(levels.getZombieHealth());
			return;
		}

		if (score >= 0 && score <= 10) {
			tamagotchi.setLevel(levels.getBeginner());
			view.updateHealth(levels.getBeginnerHealth());
			return;
		}

		if (score > 10 && score <= 20) {
			tamagotchi.setLevel(levels.getIntermediate());
			view.updateHealth(levels.getIntermediateHealth());
			return;
		}

		tamagotchi.setLevel(levels.getPro());
		view.updateHealth(levels.getProHealth());
	}

	private void startTamagotchi(Tamagotchi tamagotchi) {
		tamagotchi.setLevel(levels.getBeginner());
		tamagotchi.addObserver(this);
		tamagotchi.start();
	}

	private void subscribeToJUnitEvents() {
		subscriber.subscribe(this);
	}

	public void onImageSetCallback() {
		tamagotchi.onImageSetCallback();
	}

	public Image getDefaultHealth() {
		return levels.getBeginnerHealth();
	}
}
