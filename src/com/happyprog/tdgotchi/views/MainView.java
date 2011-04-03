package com.happyprog.tdgotchi.views;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.happyprog.tdgotchi.controller.Controller;
import com.happyprog.tdgotchi.subscriber.JUnitTestSubscriber;

public class MainView extends ViewPart implements View {

	@Override
	public void createPartControl(Composite parent) {
		new Controller(new FastViewTamagotchi(this, new TamagotchiImageRegistry()), new JUnitTestSubscriber());
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setImage(final Image image) {
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

			@Override
			public void run() {
				setTitleImage(image);
			}
		});
	}

}