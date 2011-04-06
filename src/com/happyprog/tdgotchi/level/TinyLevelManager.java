package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.scoreboard.LevelManager;

public class TinyLevelManager implements LevelManager {

	private final Level beginner;
	private final Level zombie;
	private final Level intermediate;
	private final Level pro;

	public TinyLevelManager() {
		this(new Beginner(), new Intermediate(), new Pro(), new Zombie());
	}

	public TinyLevelManager(Level beginner, Level intermediate, Level pro, Level zombie) {
		this.beginner = beginner;
		this.intermediate = intermediate;
		this.pro = pro;
		this.zombie = zombie;
	}

	@Override
	public Level getBeginner() {
		return beginner;
	}

	@Override
	public Level getZombie() {
		return zombie;
	}

	@Override
	public Image getBeginnerHealth() {
		return beginner.getHealth();
	}

	@Override
	public Image getZombieHealth() {
		return zombie.getHealth();
	}

	@Override
	public Level getIntermediate() {
		return intermediate;
	}

	@Override
	public Image getIntermediateHealth() {
		return intermediate.getHealth();
	}

	@Override
	public Level getPro() {
		return pro;
	}

	@Override
	public Image getProHealth() {
		return pro.getHealth();
	}

}
