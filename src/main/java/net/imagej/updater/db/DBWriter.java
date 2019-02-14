package net.imagej.updater.db;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public interface DBWriter {

	void validate(boolean local)
			throws SAXException,
			TransformerConfigurationException, IOException,
			ParserConfigurationException;

	void write(final OutputStream out, final boolean local)
			throws SAXException, TransformerConfigurationException, IOException;

	default byte[] toCompressedByteArray(final boolean local) throws Exception {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		write(new GZIPOutputStream(out), local);
		return out.toByteArray();
	}
}
