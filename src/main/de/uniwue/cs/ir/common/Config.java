package de.uniwue.cs.ir.common;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class Config {
	/**
	 * Corpus-Ordner relativ zum Classpath.
	 */
	public static final String CORPUS_DIR = "text";
	
	public static File getCorpusDir() {
		return getResource(CORPUS_DIR);
	}
	
	public static File getResource(String path) {
	    URL url = Config.class.getClassLoader().getResource(path);

	    File file;
	    /* 
	     * Diese URISyntaxException sollte an den "Caller" weitergegeben werden,
	     * aber zum Testen ist das so OK. 
	     */
	    try {
	        file = new File(url.toURI());
	    } catch (URISyntaxException e) {
	        throw new RuntimeException(e);
	    }

	    return file;
	}
}
