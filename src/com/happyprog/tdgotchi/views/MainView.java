package com.happyprog.tdgotchi.views;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.happyprog.tdgotchi.controller.Controller;
import com.happyprog.tdgotchi.level.LevelOne;
import com.happyprog.tdgotchi.subscriber.JUnitTestSubscriber;

public class MainView extends ViewPart implements View {

	private static final int ONE_SECOND = 1000;
	private Tamagotchi tamagotchi;

	@Override
	public void createPartControl(Composite parent) {
		tamagotchi = new FastViewTamagotchi(this, new LevelOne());
		new Controller(tamagotchi, new JUnitTestSubscriber());
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setImage(final Image image) {
		PlatformUI.getWorkbench().getDisplay().timerExec(ONE_SECOND, new Runnable() {

			@Override
			public void run() {
				setTitleImage(image);
				tamagotchi.onImageSetCallback();
			}
		});
	}

}