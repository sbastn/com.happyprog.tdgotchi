package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

public class TamagotchiLevels implements Levels {

	private static final FirstLevel FIRST_LEVEL = new FirstLevel();
	private static final ZombieLevel ZOMBIE_LEVEL = new ZombieLevel();

	@Override
	public Level getFirstLevel() {
		return FIRST_LEVEL;
	}

	@Override
	public Level getZombieLevel() {
		return ZOMBIE_LEVEL;
	}

	@Override
	public Image getFirstLevelHealth() {
		return FIRST_LEVEL.getHealth();
	}

	@Override
	public Image getZombieLevelHealth() {
		return ZOMBIE_LEVEL.getHealth();
	}

}
