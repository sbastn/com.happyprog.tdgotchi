package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.scoreboard.MoodManager;

public class Zombie implements Level {

	private final MoodManager moodManager;

	public Zombie() {
		this(new TinyMoodManager());
	}

	public Zombie(MoodManager moodManager) {
		this.moodManager = moodManager;
	}

	@Override
	public Image[] getNormalMood() {
		return moodManager.getNormalMoodForLevel(MoodManager.Level.Zombie);
	}

	@Override
	public Image[] getHappyMood() {
		return moodManager.getHappyMoodForLevel(MoodManager.Level.Zombie);
	}

	@Override
	public Image[] getUpsetMood() {
		return moodManager.getUpsetMoodForLevel(MoodManager.Level.Zombie);
	}

	@Override
	public Image getHealth() {
		return moodManager.getHealthForLevel(MoodManager.Level.Zombie);
	}

}
