package com.happyprog.tdgotchi.scoreboard;

import org.eclipse.swt.graphics.Image;

public interface MoodManager {

	enum Level {
		Zombie, Beginner, Intermediate, Pro
	}

	Image[] getNormalMoodForLevel(Level level);

	Image[] getHappyMoodForLevel(Level level);

	Image[] getUpsetMoodForLevel(Level level);

	Image getHealthForLevel(Level level);
}
