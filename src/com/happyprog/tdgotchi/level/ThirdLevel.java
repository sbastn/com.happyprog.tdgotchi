package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

public class ThirdLevel implements Level {

	private final MoodManager moodManager;

	public ThirdLevel() {
		this(new TinyMoodManager());
	}

	public ThirdLevel(MoodManager moodManager) {
		this.moodManager = moodManager;
	}

	@Override
	public Image[] getNormalMood() {
		return moodManager.getNormalMoodForLevel(3);
	}

	@Override
	public Image[] getHappyMood() {
		return moodManager.getHappyMoodForLevel(3);
	}

	@Override
	public Image[] getUpsetMood() {
		return moodManager.getUpsetMoodForLevel(3);
	}

	@Override
	public Image getHealth() {
		return moodManager.getHealthForLevel(3);
	}

}
