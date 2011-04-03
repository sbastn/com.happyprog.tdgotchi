package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.Activator;

public class LevelOne implements Level {

	private static final Image NORMAL1 = Activator.getImageDescriptor("icons/level1-default1.png").createImage();
	private static final Image NORMAL2 = Activator.getImageDescriptor("icons/level1-default2.png").createImage();

	private static final Image HAPPY1 = Activator.getImageDescriptor("icons/level1-happy1.png").createImage();
	private static final Image HAPPY2 = Activator.getImageDescriptor("icons/level1-happy2.png").createImage();

	private static final Image UPSET1 = Activator.getImageDescriptor("icons/level1-upset1.png").createImage();
	private static final Image UPSET2 = Activator.getImageDescriptor("icons/level1-upset2.png").createImage();

	@Override
	public Image[] getNormalMood() {
		return new Image[] { NORMAL1, NORMAL2 };
	}

	@Override
	public Image[] getHappyMood() {
		return new Image[] { HAPPY1, HAPPY2, HAPPY1, HAPPY2, HAPPY1, HAPPY2, HAPPY1, HAPPY2 };
	}

	@Override
	public Image[] getUpsetMood() {
		return new Image[] { UPSET1, UPSET2, UPSET1, UPSET2, UPSET1, UPSET2, UPSET1, UPSET2 };
	}

}