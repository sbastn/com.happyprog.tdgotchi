package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.scoreboard.MoodManager;

public class Pro implements Level {

	private final MoodManager moodManager;

	public Pro() {
		this(new TinyMoodManager());
	}

	public Pro(MoodManager moodManager) {
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
