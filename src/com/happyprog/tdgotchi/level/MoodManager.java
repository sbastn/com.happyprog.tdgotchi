package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

public interface MoodManager {

	Image[] getNormalMoodForLevel(int level);

	Image[] getHappyMoodForLevel(int level);

	Image[] getUpsetMoodForLevel(int level);

	Image getHealthForLevel(int level);

}
