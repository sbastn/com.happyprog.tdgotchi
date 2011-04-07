package com.happyprog.tdgotchi.level;

import org.eclipse.swt.graphics.Image;

import com.happyprog.tdgotchi.Activator;
import com.happyprog.tdgotchi.scoreboard.MoodManager;

public class TinyMoodManager implements MoodManager {

	private final Activator activator;

	public TinyMoodManager() {
		this(Activator.getDefault());
	}

	public TinyMoodManager(Activator activator) {
		this.activator = activator;
	}

	@Override
	public Image[] getNormalMoodForLevel(Level level) {
		Image image1 = activator.getImageFromKey(String.format("%s-default1", level));
		Image image2 = activator.getImageFromKey(String.format("%s-default2", level));
		return new Image[] { image1, image2 };
	}

	@Override
	public Image[] getHappyMoodForLevel(Level level) {
		Image image1 = activator.getImageFromKey(String.format("%s-happy1", level));
		Image image2 = activator.getImageFromKey(String.format("%s-happy2", level));
		return new Image[] { image1, image2, image1, image2, image1, image2 };
	}

	@Override
	public Image[] getUpsetMoodForLevel(Level level) {
		Image image1 = activator.getImageFromKey(String.format("%s-upset1", level));
		Image image2 = activator.getImageFromKey(String.format("%s-upset2", level));
		return new Image[] { image1, image2, image1, image2, image1, image2 };
	}

	@Override
	public Image getHealthForLevel(Level level) {
		return activator.getImageFromKey(String.format("%s-health", level));
	}

}
