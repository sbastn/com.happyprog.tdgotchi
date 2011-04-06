package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

public class FirstLevel implements Level {

	private final MoodManager moodManager;

	public FirstLevel() {
		this(new TinyMoodManager());
	}

	public FirstLevel(MoodManager moodManager) {
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
