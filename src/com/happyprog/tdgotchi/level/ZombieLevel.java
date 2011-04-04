package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.Activator;

public class ZombieLevel implements Level {

	@Override
	public Image[] getNormalMood() {
		Image NORMAL1 = Activator.getImageDescriptor("icons/zombie-default1.png").createImage();
		Image NORMAL2 = Activator.getImageDescriptor("icons/zombie-default2.png").createImage();
		return new Image[] { NORMAL1, NORMAL2 };
	}

	@Override
	public Image[] getHappyMood() {
		Image HAPPY1 = Activator.getImageDescriptor("icons/zombie-happy1.png").createImage();
		Image HAPPY2 = Activator.getImageDescriptor("icons/zombie-happy2.png").createImage();
		return new Image[] { HAPPY1, HAPPY2, HAPPY1, HAPPY2, HAPPY1, HAPPY2, HAPPY1, HAPPY2 };
	}

	@Override
	public Image[] getUpsetMood() {
		Image UPSET1 = Activator.getImageDescriptor("icons/zombie-upset1.png").createImage();
		Image UPSET2 = Activator.getImageDescriptor("icons/zombie-upset2.png").createImage();
		return new Image[] { UPSET1, UPSET2, UPSET1, UPSET2, UPSET1, UPSET2, UPSET1, UPSET2 };
	}

}
