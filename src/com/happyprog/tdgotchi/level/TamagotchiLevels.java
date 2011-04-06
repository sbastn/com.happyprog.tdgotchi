package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

public class TamagotchiLevels implements Levels {

	private final Level firstLevel;
	private final Level zombieLevel;

	public TamagotchiLevels() {
		this(new FirstLevel(), new ZombieLevel());
	}

	public TamagotchiLevels(Level firstLevel, Level zombieLevel) {
		this.firstLevel = firstLevel;
		this.zombieLevel = zombieLevel;
	}

	@Override
	public Level getFirstLevel() {
		return firstLevel;
	}

	@Override
	public Level getZombieLevel() {
		return zombieLevel;
	}

	@Override
	public Image getFirstLevelHealth() {
		return firstLevel.getHealth();
	}

	@Override
	public Image getZombieLevelHealth() {
		return zombieLevel.getHealth();
	}

}
