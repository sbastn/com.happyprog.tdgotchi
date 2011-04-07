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
		return moodManager.getNormalMoodForLevel(MoodManager.Level.Beginner);
	}

	@Override
	public Image[] getHappyMood() {
		return moodManager.getHappyMoodForLevel(MoodManager.Level.Beginner);
	}

	@Override
	public Image[] getUpsetMood() {
		return moodManager.getUpsetMoodForLevel(MoodManager.Level.Beginner);
	}

	@Override
	public Image getHealth() {
		return moodManager.getHealthForLevel(MoodManager.Level.Beginner);
	}

}
