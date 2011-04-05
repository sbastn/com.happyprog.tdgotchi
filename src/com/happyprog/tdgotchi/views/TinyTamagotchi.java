package com.happyprog.tdgotchi.views;

import java.util.Stack;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.level.Level;
import com.happyprog.tdgotchi.scoreboard.TamagotchiObserver;

public class TinyTamagotchi implements Tamagotchi {

	private TamagotchiObserver observer;
	private Level level;
	private Stack<Image> moodStack = new Stack<Image>();

	@Override
	public void start() {
		pushToStack(level.getNormalMood());
		updateMood();
	}

	@Override
	public void beHappy() {
		pushToStack(level.getHappyMood());
	}

	@Override
	public void beUpset() {
		pushToStack(level.getUpsetMood());
	}

	@Override
	public void onImageSetCallback() {
		updateMood();
	}

	@Override
	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public void addObserver(TamagotchiObserver observer) {
		this.observer = observer;
	}

	private void updateMood() {
		if (moodStack.empty()) {
			pushToStack(level.getNormalMood());
		}

		observer.updateMood(moodStack.pop());
	}

	private void pushToStack(Image... images) {
		for (Image image : images) {
			moodStack.push(image);
		}
	}

}
