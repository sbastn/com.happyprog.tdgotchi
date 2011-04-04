package com.happyprog.tdgotchi.views;

import com.happyprog.tdgotchi.level.Level;

public interface Tamagotchi {

	void beHappy();

	void beUpset();

	void onImageSetCallback();

	void changeLevel(Level level);

}
