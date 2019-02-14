package net.imagej.updater.db;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public interface DBReader {
	String getWarnings();

	void read(String updateSite) throws IOException,
			ParserConfigurationException, SAXException;

	void read(final String updateSite, final InputStream in,
	          final long timestamp) throws IOException,
			ParserConfigurationException, SAXException;

	void read(final InputStream in) throws IOException,
			ParserConfigurationException, SAXException;
}
