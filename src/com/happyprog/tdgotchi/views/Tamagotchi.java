package com.happyprog.tdgotchi.views;

import com.happyprog.tdgotchi.level.Level;
import com.happyprog.tdgotchi.scoreboard.TamagotchiObserver;

public interface Tamagotchi {

	void beHappy();

	void beUpset();

	void onImageSetCallback();

	void setLevel(Level level);

	void addObserver(TamagotchiObserver observer);

	void start();

}
