package com.happyprog.tdgotchi.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.happyprog.tdgotchi.scoreboard.Scoreboard;

public class MainView extends ViewPart implements View {

	private static final int ONE_SECOND = 1000;
	private Label scoreLabel;
	private Scoreboard scoreboard;
	private Label healthLabel;

	@Override
	public void createPartControl(Composite parent) {
		createScoreboard();

		createLayout(parent);
		createScoreLabel(parent);
		createHealthLabel(parent);
	}

	private void createLayout(Composite parent) {
		RowLayout layout = new RowLayout();
		layout.wrap = true;
		layout.pack = true;
		layout.justify = false;
		layout.type = SWT.VERTICAL;
		parent.setLayout(layout);
	}

	private void createScoreboard() {
		scoreboard = new Scoreboard(this);
	}

	private void createScoreLabel(Composite parent) {
		scoreLabel = new Label(parent, SWT.NONE);
		scoreLabel.setLayoutData(new RowData(100, 20));
		updateScore(0);
	}

	private void createHealthLabel(Composite parent) {
		healthLabel = new Label(parent, SWT.NONE);
		healthLabel.setLayoutData(new RowData(48, 16));
		updateHealth(scoreboard.getDefaultHealth());
	}

	@Override
	public void setImage(final Image image) {
		PlatformUI.getWorkbench().getDisplay().timerExec(ONE_SECOND, new Runnable() {

			@Override
			public void run() {
				setTitleImage(image);
				scoreboard.onImageSetCallback();
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
	public void updateHealth(final Image image) {
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

			@Override
			public void run() {
				healthLabel.setImage(image);
			}
		});
	}

	@Override
	public void setFocus() {
		// Nothing to focus on here...
	}

}