package com.happyprog.tdgotchi.views;

import static org.mockito.Mockito.*;

import org.eclipse.swt.graphics.Image;
import org.junit.Before;
import org.junit.Test;

import com.happyprog.tdgotchi.level.Level;

public class FastViewTamagotchiTest {

	private View view;
	private FastViewTamagotchi tamagotchi;
	private Level level;

	@Before
	public void before() {
		view = mock(View.class);
		level = mock(Level.class);
		tamagotchi = new FastViewTamagotchi(view, level);
	}

	@Test
	public void whenConstructed_updatesTheMood() throws Exception {
		Image image = new Image(null, "icons/level1-default1.png");

		when(level.getNormalMood()).thenReturn(image);

		new FastViewTamagotchi(view, level);

		verify(view).setImage(image);
	}

	@Test
	public void beHappy_updatesTheViewIcon() throws Exception {
		Image image = new Image(null, "icons/level1-happy1.png");

		when(level.getHappyMood()).thenReturn(image);

		tamagotchi.beHappy();

		verify(view).setImage(image);
	}

	@Test
	public void beUpset_updatesTheViewIcon() throws Exception {
		Image image = new Image(null, "icons/level1-upset1.png");

		when(level.getUpsetMood()).thenReturn(image);

		tamagotchi.beUpset();

		verify(view).setImage(image);
	}
}
