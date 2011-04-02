package com.happyprog.tdgotchi.controller;

public class Controller {

	private final TestSubscriber subscriber;

	public Controller(TestSubscriber subscriber) {
		this.subscriber = subscriber;

		subscribeToJUnitEvents();
	}

	private void subscribeToJUnitEvents() {
		subscriber.subscribe(this);
	}

}
