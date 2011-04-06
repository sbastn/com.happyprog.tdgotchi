package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

public interface Levels {

	Level getFirstLevel();

	Level getZombieLevel();

	Level getSecondLevel();

	Image getFirstLevelHealth();

	Image getZombieLevelHealth();

	Image getSecondLevelHealth();

	Level getThirdLevel();

	Image getThirdLevelHealth();

}
