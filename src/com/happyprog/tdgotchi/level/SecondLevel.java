package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

public class SecondLevel implements Level {

	private final MoodManager moodManager;

	public SecondLevel() {
		this(new TinyMoodManager());
	}

	public SecondLevel(MoodManager moodManager) {
		this.moodManager = moodManager;
	}

	@Override
	public Image[] getNormalMood() {
		return moodManager.getNormalMoodForLevel(2);
	}

	@Override
	public Image[] getHappyMood() {
		return moodManager.getHappyMoodForLevel(2);
	}

	@Override
	public Image[] getUpsetMood() {
		return moodManager.getUpsetMoodForLevel(2);
	}

	@Override
	public Image getHealth() {
		return moodManager.getHealthForLevel(2);
	}

}
