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
	public Image[] getNormalMoodForLevel(int level) {
		Image image1 = activator.getImageFromKey(String.format("level%d-default1", level));
		Image image2 = activator.getImageFromKey(String.format("level%d-default2", level));
		return new Image[] { image1, image2 };
	}

	@Override
	public Image[] getHappyMoodForLevel(int level) {
		Image image1 = activator.getImageFromKey(String.format("level%d-happy1", level));
		Image image2 = activator.getImageFromKey(String.format("level%d-happy2", level));
		return new Image[] { image1, image2, image1, image2, image1, image2 };
	}

	@Override
	public Image[] getUpsetMoodForLevel(int level) {
		Image image1 = activator.getImageFromKey(String.format("level%d-upset1", level));
		Image image2 = activator.getImageFromKey(String.format("level%d-upset2", level));
		return new Image[] { image1, image2, image1, image2, image1, image2 };
	}

	@Override
	public Image getHealthForLevel(int level) {
		return activator.getImageFromKey(String.format("level%d-health", level));
	}
}
