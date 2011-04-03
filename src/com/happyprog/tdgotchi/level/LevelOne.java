package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.Activator;

public class LevelOne implements Level {

	@Override
	public Image getNormalMood() {
		return Activator.getImageDescriptor("icons/level1-default1.png").createImage();
	}

	@Override
	public Image getHappyMood() {
		return Activator.getImageDescriptor("icons/level1-happy1.png").createImage();
	}

	@Override
	public Image getUpsetMood() {
		return Activator.getImageDescriptor("icons/level1-upset1.png").createImage();
	}

}
