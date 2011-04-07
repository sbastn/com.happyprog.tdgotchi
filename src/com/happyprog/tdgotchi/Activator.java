package com.happyprog.tdgotchi;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.happyprog.tdgotchi.scoreboard.MoodManager;
import com.happyprog.tdgotchi.scoreboard.MoodManager.Level;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.happyprog.tdgotchi"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *          the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		loadImagesForLevels(reg);
	}

	private void loadImagesForLevels(ImageRegistry reg) {
		for (Level level : MoodManager.Level.values()) {
			String name = level.name();
			reg.put(String.format("%s-default1", name), getImageDescriptor(String.format("icons/%s-default1.png", name)));
			reg.put(String.format("%s-default2", name), getImageDescriptor(String.format("icons/%s-default2.png", name)));
			reg.put(String.format("%s-happy1", name), getImageDescriptor(String.format("icons/%s-happy1.png", name)));
			reg.put(String.format("%s-happy2", name), getImageDescriptor(String.format("icons/%s-happy2.png", name)));
			reg.put(String.format("%s-upset1", name), getImageDescriptor(String.format("icons/%s-upset1.png", name)));
			reg.put(String.format("%s-upset2", name), getImageDescriptor(String.format("icons/%s-upset2.png", name)));
			reg.put(String.format("%s-health", name), getImageDescriptor(String.format("icons/%s-health.png", name)));
		}
	}

	public Image getImageFromKey(String key) {
		return getImageRegistry().get(key);
	}
}
