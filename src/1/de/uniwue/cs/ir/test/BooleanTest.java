/*
 * Created on 01.11.2005
 */
package de.uniwue.cs.ir.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


import junit.framework.TestCase;
import de.uniwue.cs.ir.common.Config;
import de.uniwue.cs.ir.vsr.ICorpus;
import de.uniwue.cs.ir.vsr.CorpusImpl;
import de.uniwue.cs.ir.vsr.IDocument;
import de.uniwue.cs.ir.vsr.DocumentImpl;

/**
 * TestFall für einfache Boolesche Anfragen auf einem
 * {@link de.uniwue.cs.ir.vsr.ICorpus}.
 * 
 * @author Christoph Schmitz
 * @author Martin Becker
 */
public class BooleanTest extends TestCase {
	
	private ICorpus corpus;

	public void setUp() throws FileNotFoundException, IOException {
		corpus = new CorpusImpl();

		File dir = Config.getCorpusDir();
		for (File file : dir.listFiles()) {
			if (!file.isDirectory()) {
				FileInputStream stream = new FileInputStream(file);
				IDocument doc = new DocumentImpl(file.getName());
				doc.read(stream);
				stream.close();
				corpus.addDocument(doc);
			}
		}
	}

	/**
	 * Testet, ob einzelne Terme nur einemal vom Iterator zurückgegeben werden.
	 */
	public void testTermIteration() throws FileNotFoundException, IOException {
		
		File file = new File(Config.getCorpusDir(), "Reut_1.txt");
		FileInputStream stream = new FileInputStream(file);
		
		IDocument document = new DocumentImpl(file.getName());
		document.read(stream);

		List<String> terms = new LinkedList<String>();
		Set<String> termSet = new HashSet<String>();
		for (String w : document) {
			terms.add(w);
			termSet.add(w);
		}
		
		assertEquals(termSet.size(), terms.size());
		
	}
	
	public void testAndQuery() {
		
		// Folgende Anfrage sollte die Dokumente 
		// 1, 5258, 8961 und 13462 liefern.
		Set<String> expectedIDs = new HashSet<String>();
		for (String id : new String[] { "1", "5258", "8961", "13462" }) {
			expectedIDs.add("Reut_" + id + ".txt");
		}

		Set<String> resultIDs = new HashSet<String>();
		Collection<IDocument> docs = corpus.getDocumentsContainingAll(
				"cocoa",
				"shipment");
		for (IDocument doc : docs) {
			resultIDs.add(doc.getId());
		}
		assertEquals(expectedIDs, resultIDs);
	}

	public void testOrQuery() {
		Set<String> expectedIDs = new HashSet<String>();

		// Folgende Anfrage sollte die Dokumente 
		// 49, 2310, 5258, 6657, 12179, 12772, 12924, 13462 liefern.
		for (String id : new String[] { "49", "2310", "5258", "6657", "12179",
				"12772", "12924", "13462" }) {
			expectedIDs.add("Reut_" + id + ".txt");
		}

		Set<String> resultIDs = new HashSet<String>();
		Collection<IDocument> docs = corpus.getDocumentsContainingAny(
				"alternative", "daily");
		for (IDocument doc : docs) {
			resultIDs.add(doc.getId());
		}
		assertEquals(expectedIDs, resultIDs);

	}
}
