package net.imagej.updater.db;

import net.imagej.ImageJService;
import net.imagej.updater.FilesCollection;

/**
 * Interface for a service handling the reading and writing
 * of the database file for an update site or Fiji installation (db.xml.gz)
 *
 * @author Deborah Schmidt
 */
public interface DBHandlerService extends ImageJService {

	/**
	 * This function returns a writer that is used to document an
	 * update site or the state of an ImageJ installation.
	 * The writer will depend on the current updater version.
	 * @param files The FileCollection that should be written into the database file
	 * @return The writer for the current version of the updater
	 */
	DBWriter getDBWriter(FilesCollection files);


	/**
	 * This function return the reader that is used to process an
	 * update site or the state of an ImageJ installation via it's
	 * database file.
	 * The reader will depend on the version of the original writer
	 * of the database file.
	 * @param files The FileCollection that should be processed
	 * @return The reader matching the version the database file was written in
	 */
	DBReader getDBReader(FilesCollection files);


}
