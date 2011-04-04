package com.happyprog.tdgotchi.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.happyprog.tdgotchi.controller.Controller;

public class MainView extends ViewPart implements View {

	private static final int ONE_SECOND = 1000;
	private Label scoreLabel;
	private Controller controller;

	@Override
	public void createPartControl(Composite parent) {
		createController();
		createScoreLabel(parent);
	}

	private void createController() {
		controller = new Controller(this);
	}

	private void createScoreLabel(Composite parent) {
		scoreLabel = new Label(parent, SWT.NONE);
		updateScore(0);
	}

	@Override
	public void setImage(final Image image) {
		PlatformUI.getWorkbench().getDisplay().timerExec(ONE_SECOND, new Runnable() {

			@Override
			public void run() {
				setTitleImage(image);
				controller.onImageSetCallback();
			}
		});
	}

	@Override
	public void updateScore(final int points) {
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

			@Override
			public void run() {
				scoreLabel.setText(String.format("Score: %d", points));
			}
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

}