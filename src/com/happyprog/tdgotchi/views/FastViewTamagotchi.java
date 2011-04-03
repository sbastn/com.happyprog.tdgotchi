package com.happyprog.tdgotchi.views;

public class FastViewTamagotchi implements Tamagotchi {

	public static final String HAPPY = "icons/level1-happy1.png";
	public static final String UPSET = "icons/level1-upset1.png";
	private final View view;
	private final ImageRegistry imageRegistry;

	public FastViewTamagotchi(View view, ImageRegistry imageRegistry) {
		this.view = view;
		this.imageRegistry = imageRegistry;
	}

	@Override
	public void beHappy() {
		view.setImage(imageRegistry.get(HAPPY));
	}

	@Override
	public void beUpset() {
		view.setImage(imageRegistry.get(UPSET));
	}

}
