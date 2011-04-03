package com.happyprog.tdgotchi.views;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.Activator;

public class TamagotchiImageRegistry implements ImageRegistry {

	@Override
	public Image get(String path) {
		return Activator.getImageDescriptor(path).createImage();
	}

}
