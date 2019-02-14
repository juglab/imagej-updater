package net.imagej.updater.db;

import net.imagej.updater.FilesCollection;
import net.imagej.updater.db.v1.XMLFileReaderV1;
import net.imagej.updater.db.v1.XMLFileWriterV1;
import org.scijava.plugin.Plugin;
import org.scijava.service.AbstractService;
import org.scijava.service.Service;

@Plugin(type = Service.class)
public class DefaultDBHandlerService extends AbstractService implements DBHandlerService {
	@Override
	public DBWriter getDBWriter(FilesCollection files) {
		return new XMLFileWriterV1(files);
	}

	@Override
	public DBReader getDBReader(FilesCollection files) {
		return new XMLFileReaderV1(files);
	}
}
