package com.happyprog.tdgotchi.scoreboard;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.level.Level;
import com.happyprog.tdgotchi.level.LevelOne;
import com.happyprog.tdgotchi.level.ZombieLevel;
import com.happyprog.tdgotchi.subscriber.JUnitTestSubscriber;
import com.happyprog.tdgotchi.subscriber.TestSubscriber;
import com.happyprog.tdgotchi.views.TinyTamagotchi;
import com.happyprog.tdgotchi.views.Tamagotchi;
import com.happyprog.tdgotchi.views.View;

public class Scoreboard implements TestObserver, TamagotchiObserver {

	private final View view;
	private final TestSubscriber subscriber;
	private final Tamagotchi tamagotchi;

	private TestRun previousTestRun;
	private int score;
	private final Level zombieLevel;
	private final Level firstLevel;

	private enum TestRun {
		PASS, FAIL
	}

	public Scoreboard(View view) {
		this(view, new TinyTamagotchi(new LevelOne()), new JUnitTestSubscriber(), new ZombieLevel(), new LevelOne());
	}

	public Scoreboard(View view, Tamagotchi tamagotchi, TestSubscriber subscriber, Level zombieLevel, Level firstLevel) {
		this.view = view;
		this.tamagotchi = tamagotchi;
		this.subscriber = subscriber;
		this.zombieLevel = zombieLevel;
		this.firstLevel = firstLevel;

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
		updateTamagoshiAndHealthLevel();
	}

	private void updateTamagoshiAndHealthLevel() {
		if (score < 0) {
			tamagotchi.changeLevel(zombieLevel);
			view.updateHealth(zombieLevel.getHealth());
			return;
		}

		if (score >= 0 && score <= 5) {
			tamagotchi.changeLevel(firstLevel);
			view.updateHealth(firstLevel.getHealth());
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

	public Image getDefaultHealth() {
		return firstLevel.getHealth();
	}
}
