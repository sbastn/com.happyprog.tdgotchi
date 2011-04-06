package com.happyprog.tdgotchi;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

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
		for (int i = 0; i < 4; i++) {
			reg.put(String.format("level%d-default1", i), getImageDescriptor(String.format("icons/level%d-default1.png", i)));
			reg.put(String.format("level%d-default2", i), getImageDescriptor(String.format("icons/level%d-default2.png", i)));
			reg.put(String.format("level%d-happy1", i), getImageDescriptor(String.format("icons/level%d-happy1.png", i)));
			reg.put(String.format("level%d-happy2", i), getImageDescriptor(String.format("icons/level%d-happy2.png", i)));
			reg.put(String.format("level%d-upset1", i), getImageDescriptor(String.format("icons/level%d-upset1.png", i)));
			reg.put(String.format("level%d-upset2", i), getImageDescriptor(String.format("icons/level%d-upset2.png", i)));
			reg.put(String.format("level%d-health", i), getImageDescriptor(String.format("icons/level%d-health.png", i)));
		}
	}

	public Image getImageFromKey(String key) {
		return getImageRegistry().get(key);
	}
}
