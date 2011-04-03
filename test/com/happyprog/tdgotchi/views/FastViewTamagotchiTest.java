package com.happyprog.tdgotchi.views;

import static org.mockito.Mockito.*;

import org.eclipse.swt.graphics.Image;
import org.junit.Before;
import org.junit.Test;

public class FastViewTamagotchiTest {

	private View view;
	private FastViewTamagotchi tamagotchi;
	private ImageRegistry imageRegistry;

	@Before
	public void before() {
		view = mock(View.class);
		imageRegistry = mock(ImageRegistry.class);
		tamagotchi = new FastViewTamagotchi(view, imageRegistry);
	}

	@Test
	public void beHappy_updatesTheViewIcon() throws Exception {
		Image image = new Image(null, "icons/level1-happy1.png");

		when(imageRegistry.get(FastViewTamagotchi.HAPPY)).thenReturn(image);

		tamagotchi.beHappy();

		verify(view).setImage(image);
	}

	@Test
	public void beUpset_updatesTheViewIcon() throws Exception {
		Image image = new Image(null, "icons/level1-upset1.png");

		when(imageRegistry.get(FastViewTamagotchi.UPSET)).thenReturn(image);

		tamagotchi.beUpset();

		verify(view).setImage(image);
	}
}
