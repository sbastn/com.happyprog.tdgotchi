package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.scoreboard.MoodManager;

public class Intermediate implements Level {

	private final MoodManager moodManager;

	public Intermediate() {
		this(new TinyMoodManager());
	}

	public Intermediate(MoodManager moodManager) {
		this.moodManager = moodManager;
	}

	@Override
	public Image[] getNormalMood() {
		return moodManager.getNormalMoodForLevel(MoodManager.Level.Intermediate);
	}

	@Override
	public Image[] getHappyMood() {
		return moodManager.getHappyMoodForLevel(MoodManager.Level.Intermediate);
	}

	@Override
	public Image[] getUpsetMood() {
		return moodManager.getUpsetMoodForLevel(MoodManager.Level.Intermediate);
	}

	@Override
	public Image getHealth() {
		return moodManager.getHealthForLevel(MoodManager.Level.Intermediate);
	}

}
