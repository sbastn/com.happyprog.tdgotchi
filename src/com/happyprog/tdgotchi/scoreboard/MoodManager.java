package com.happyprog.tdgotchi.scoreboard;

import org.eclipse.swt.graphics.Image;

public interface MoodManager {

	Image[] getNormalMoodForLevel(int level);

	Image[] getHappyMoodForLevel(int level);

	Image[] getUpsetMoodForLevel(int level);

	Image getHealthForLevel(int level);

}
