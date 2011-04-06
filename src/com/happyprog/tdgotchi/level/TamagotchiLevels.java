package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

public class TamagotchiLevels implements Levels {

	private final Level firstLevel;
	private final Level zombieLevel;
	private final Level secondLevel;
	private final Level thirdLevel;

	public TamagotchiLevels() {
		this(new FirstLevel(), new SecondLevel(), new ThirdLevel(), new ZombieLevel());
	}

	public TamagotchiLevels(Level firstLevel, Level secondLevel, Level thirdLevel, Level zombieLevel) {
		this.firstLevel = firstLevel;
		this.secondLevel = secondLevel;
		this.thirdLevel = thirdLevel;
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

	@Override
	public Level getSecondLevel() {
		return secondLevel;
	}

	@Override
	public Image getSecondLevelHealth() {
		return secondLevel.getHealth();
	}

	@Override
	public Level getThirdLevel() {
		return thirdLevel;
	}

	@Override
	public Image getThirdLevelHealth() {
		return thirdLevel.getHealth();
	}

}
