package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.Activator;

public class ZombieLevel implements Level {

	private final MoodManager moodManager;

	public ZombieLevel() {
		this(new TinyMoodManager());
	}

	public ZombieLevel(MoodManager moodManager) {
		this.moodManager = moodManager;
	}

	@Override
	public Image[] getNormalMood() {
		return moodManager.getNormalMoodForLevel(0);
	}

	@Override
	public Image[] getHappyMood() {
		return moodManager.getHappyMoodForLevel(0);
	}

	@Override
	public Image[] getUpsetMood() {
		return moodManager.getUpsetMoodForLevel(0);
	}

	@Override
	public Image getHealth() {
		return moodManager.getHealthForLevel(0);
	}

}
