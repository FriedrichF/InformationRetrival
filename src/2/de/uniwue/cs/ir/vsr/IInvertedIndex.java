/*
 * Created on 03.11.2005
 */
package de.uniwue.cs.ir.vsr;

import java.util.Iterator;

import de.uniwue.cs.ir.vsr.ICorpus;
import de.uniwue.cs.ir.vsr.IDocument;

/**
 * Interface für einen invertierten Index auf einer Menge von Dokumenten. Diese Menge
 * soll als {@link ICorpus} im Konstruktor übergeben werden. Die Gewichte sollen
 * nach dem Einlesen über TF/IDF berechnet werden. 
 * Enthält eine Datenstruktur der Form Term -> Liste mit TokenInfos
 * TokenInfo muss noch angelegt werden
 * Achtung: Die Termfrequenzen werden über den gesamten Korpus normiert (d.h. maxTf wird nicht für einzelne
 * Dokumente, sondern über den Korpus errechnet).
 * 
 * @author Christoph Schmitz
 * @author Beate Navarro
 */
public interface IInvertedIndex {
	
	/**
	 * Gib die Dokument-Term-Gewichte für diesen Term zurück,
	 * sortiert in absteigender Reihenfolge. 
	 * 
	 * @param term
	 * @return
	 */
	public Iterator<? extends ITokenOccurrence> getWeightsForTerm(String term);
	
	/**
	 * @param term
	 * @return TokenInfo des Terms
	 */
	public ITokenInfo getTokenInfo(String term);
	
	/**
	 * @param term
	 * @return IDF Wert des Terms
	 */
	public double getIdf(String term);
	
	/**
	 * @return Maximale Term Frequenz (errechnet über den gesamten Korpus)
	 */
	public int getMaxTf();
	
	/**
	 * @param doc
	 * @return Norm eines Dokumentes
	 */
	public double getNormDoc(IDocument doc);
	
	/**
	 * Gibt den Index formatiert zurück in der Form
	 * 
	 * <pre>
	 * [
	 *   term -> [ docId -> tfidf,  docId -> tfidf, ... ]
	 *   term -> [ docId -> tfidf,  docId -> tfidf, ... ]
	 *   term -> [ docId -> tfidf,  docID -> tfidf, ... ]
	 * ]
	 * </pre>
	 */	
	public String toString();
}
