package com.happyprog.tdgotchi.controller;

import com.happyprog.tdgotchi.subscriber.TestObserver;
import com.happyprog.tdgotchi.subscriber.TestSubscriber;
import com.happyprog.tdgotchi.views.Tamagotchi;

public class Controller implements TestObserver {

	private final TestSubscriber subscriber;
	private final Tamagotchi tamagotchi;

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
		tamagotchi.beHappy();
	}

	@Override
	public void onFailingTest() {
		tamagotchi.beUpset();
	}
}
