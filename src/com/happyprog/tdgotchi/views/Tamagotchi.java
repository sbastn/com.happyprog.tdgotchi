package com.happyprog.tdgotchi.views;

import com.happyprog.tdgotchi.level.Level;
import com.happyprog.tdgotchi.scoreboard.TamagotchiObserver;

public interface Tamagotchi {

	void beHappy();

	void beUpset();

	void onImageSetCallback();

	void changeLevel(Level level);

	void addObserver(TamagotchiObserver observer);

}
