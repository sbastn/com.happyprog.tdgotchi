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
		return moodManager.getNormalMoodForLevel(MoodManager.Level.Pro);
	}

	@Override
	public Image[] getHappyMood() {
		return moodManager.getHappyMoodForLevel(MoodManager.Level.Pro);
	}

	@Override
	public Image[] getUpsetMood() {
		return moodManager.getUpsetMoodForLevel(MoodManager.Level.Pro);
	}

	@Override
	public Image getHealth() {
		return moodManager.getHealthForLevel(MoodManager.Level.Pro);
	}

}
