package de.uniwue.cs.ir.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import junit.framework.TestCase;
import de.uniwue.cs.ir.common.Config;
import de.uniwue.cs.ir.vsr.ICorpus;
import de.uniwue.cs.ir.vsr.CorpusImpl;
import de.uniwue.cs.ir.vsr.IDocument;
import de.uniwue.cs.ir.vsr.DocumentImpl;
import de.uniwue.cs.ir.vsr.InvertedIndexImpl;
import de.uniwue.cs.ir.vsr.ITokenOccurrence;

/**
 * Test für den invertierten Index
 * Eventuell muss das Verzeichnis angepasst werden, indem Texte liegen
 * 
 * @author Christoph Schmitz
 * @author Beate Krause
 */

public class IndexTest extends TestCase {
	private InvertedIndexImpl index;

	public void setUp() {
		ICorpus corpus = new CorpusImpl();

		File dir = Config.getCorpusDir();
		for (File file : dir.listFiles()) {
			try {
				if (!file.isDirectory()) { // CVS-Zeug ueberspringen ;-)
					FileInputStream stream = new FileInputStream(file);
					IDocument doc = new DocumentImpl(file.getName());
					doc.read(stream);
					stream.close();
					corpus.addDocument(doc);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		index = new InvertedIndexImpl(corpus);
	}

	public void testResults() {
		/*
		 * Resultate für die drei Terme "november", "shipbuilding", "sugarcane"
		 * vorgeben und mit den Resultaten des Index vergleichen
		 */
		Map<String, Double> novemberResult = new HashMap<String, Double>();
		Map<String, Double> shipbuildingResult = new HashMap<String, Double>();
		Map<String, Double> sugarcaneResult = new HashMap<String, Double>();

		Map<String, Map<String, Double>> results = new HashMap<String, Map<String, Double>>();

		novemberResult.put("Reut_8683.txt", 0.5245860368750322);
		novemberResult.put("Reut_3639.txt", 0.1748620122916774);
		novemberResult.put("Reut_10302.txt", 0.0874310061458387);
		novemberResult.put("Reut_4898.txt", 0.0874310061458387);
		novemberResult.put("Reut_5175.txt", 0.0874310061458387);
		novemberResult.put("Reut_11173.txt", 0.0874310061458387);
		novemberResult.put("Reut_4470.txt", 0.0874310061458387);
		results.put("november", novemberResult);

		shipbuildingResult.put("Reut_6541.txt", 0.2622930184375161);
		shipbuildingResult.put("Reut_1902.txt", 0.2622930184375161);
		shipbuildingResult.put("Reut_5818.txt", 0.1748620122916774);
		shipbuildingResult.put("Reut_11251.txt", 0.0874310061458387);
		shipbuildingResult.put("Reut_3046.txt", 0.0874310061458387);
		shipbuildingResult.put("Reut_4640.txt", 0.0874310061458387);
		shipbuildingResult.put("Reut_677.txt", 0.0874310061458387);
		results.put("shipbuilding", shipbuildingResult);

		sugarcaneResult.put("Reut_10306.txt", 0.27360110765801343);
		sugarcaneResult.put("Reut_11173.txt", 0.27360110765801343);
		sugarcaneResult.put("Reut_259.txt", 0.18240073843867563);
		sugarcaneResult.put("Reut_4630.txt", 0.18240073843867563);
		sugarcaneResult.put("Reut_11330.txt", 0.09120036921933782);
		sugarcaneResult.put("Reut_9069.txt", 0.09120036921933782);
		results.put("sugarcane", sugarcaneResult);

		// für alle drei Terme Resultate vergleichen
		for (String term : results.keySet()) {

			// erwartete Resultate für diesen Term holen
			Map<String, Double> expectedResults = results.get(term);

			double lastWeight = -1d;
			// Über alle Vorkommen gehen und Gewichte abgleichen
			for (Iterator<? extends ITokenOccurrence> docWeights = index
					.getWeightsForTerm(term); docWeights.hasNext();) {
				ITokenOccurrence tokenOcc = docWeights.next();
				Double weight = tokenOcc.getWeight();
				String docId = tokenOcc.getDocument().getId();

				// Gewichte prüfen gegen Referenzdaten
				Double expectedWeight = expectedResults.get(docId);
				assertEquals(expectedWeight, weight, 1E-7);

				// Sicherstellen, daß Gewichte absteigend sortiert sind,
				// außer beim ersten
				if (lastWeight > 0d) {
					assertTrue(weight - lastWeight < 1e-7);
				}
				lastWeight = weight;
			}
		}
	}
}
