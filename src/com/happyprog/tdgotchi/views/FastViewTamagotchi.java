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
		moodStack.push(level.getNormalMood());

		updateMood();
	}

	private void updateMood() {
		view.setImage(moodStack.pop());
	}

	@Override
	public void beHappy() {
		moodStack.push(level.getHappyMood());

		updateMood();
	}

	@Override
	public void beUpset() {
		moodStack.push(level.getUpsetMood());

		updateMood();
	}

}
