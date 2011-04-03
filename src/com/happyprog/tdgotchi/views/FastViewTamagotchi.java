package com.happyprog.tdgotchi.views;

import java.util.Stack;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.level.Level;

public class FastViewTamagotchi implements Tamagotchi {

	private final View view;
	private final Level level;
	private Stack<Image> moodStack;

	public FastViewTamagotchi(View view, Level level) {
		this.view = view;
		this.level = level;

		moodStack = new Stack<Image>();
		pushToStack(level.getNormalMood());

		updateMood();
	}

	private void updateMood() {
		if (moodStack.empty()) {
			pushToStack(level.getNormalMood());
		}

		view.setImage(moodStack.pop());
	}

	@Override
	public void beHappy() {
		pushToStack(level.getHappyMood());

		updateMood();
	}

	@Override
	public void beUpset() {
		pushToStack(level.getUpsetMood());

		updateMood();
	}

	@Override
	public void onImageSetCallback() {
		updateMood();
	}

	private void pushToStack(Image... images) {
		for (Image image : images) {
			moodStack.push(image);
		}
	}

}
