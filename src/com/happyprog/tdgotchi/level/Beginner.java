package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.scoreboard.MoodManager;

public class Beginner implements Level {

	private final MoodManager moodManager;

	public Beginner() {
		this(new TinyMoodManager());
	}

	public Beginner(MoodManager moodManager) {
		this.moodManager = moodManager;
	}

	@Override
	public Image[] getNormalMood() {
		return moodManager.getNormalMoodForLevel(1);
	}

	@Override
	public Image[] getHappyMood() {
		return moodManager.getHappyMoodForLevel(1);
	}

	@Override
	public Image[] getUpsetMood() {
		return moodManager.getUpsetMoodForLevel(1);
	}

	@Override
	public Image getHealth() {
		return moodManager.getHealthForLevel(1);
	}

}
