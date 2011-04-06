package com.happyprog.tdgotchi.scoreboard;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.level.Level;

public interface LevelManager {

	Level getBeginner();

	Level getZombie();

	Level getIntermediate();

	Level getPro();

	Image getBeginnerHealth();

	Image getZombieHealth();

	Image getIntermediateHealth();

	Image getProHealth();

}
