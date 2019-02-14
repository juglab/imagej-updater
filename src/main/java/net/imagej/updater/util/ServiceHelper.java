package net.imagej.updater.util;

import net.imagej.updater.FilesUploader;
import net.imagej.updater.UploaderService;
import net.imagej.updater.db.DBHandlerService;
import org.scijava.Context;

public class ServiceHelper {


	public static UploaderService createUploaderService() {
		setClassLoaderIfNecessary();
		final Context context = new Context(UploaderService.class);
		return context.getService(UploaderService.class);
	}

	public static DBHandlerService createDBHandlerService() {
		setClassLoaderIfNecessary();
		final Context context = new Context(DBHandlerService.class);
		return context.getService(DBHandlerService.class);
	}

	/**
	 * Sets the context class loader if necessary.
	 *
	 * If the current class cannot be found by the current Thread's context
	 * class loader, we should tell the Thread about the class loader that
	 * loaded this class.
	 */
	private static void setClassLoaderIfNecessary() {
		ClassLoader thisLoader = FilesUploader.class.getClassLoader();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		for (; loader != null; loader = loader.getParent()) {
			if (thisLoader == loader) return;
		}
		Thread.currentThread().setContextClassLoader(thisLoader);
	}


}
