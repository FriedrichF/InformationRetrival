package de.uniwue.cs.ir.vsr;

import java.util.Iterator;
import java.util.SortedSet;

import de.uniwue.cs.ir.vsr.TokenOccurrenceImpl;

/**
/**
 * Informationen über einen Term in der Posting-Liste. Enthält IDF und 
 * eine (sortierte) Menge von Postings.
 * 
 * @author Beate Navarro
 */
public interface ITokenInfo {
	
	/**
	 * Iterator über TokenOccurrences
	 * @return Iterator
	 */
	public Iterator<TokenOccurrenceImpl> iterator();
	
	/**
	 * Fügt eine TokenOccurrence zur Menge der TokenOccurrences hinzu
	 * @param posting
	 */
	public void addPosting(TokenOccurrenceImpl posting);
	
	/**
	 * IDF Wert: 
	 * log(Korpusgröße / Anzahl Dokumente, in denen der Term vorkommt) 
	 * @param idf
	 */
	public void setIdf(double idf);
	
	/**
	 * @return IDF Wert
	 */
	public double getIdf();
	
	/**
	 * Menge der TokenOccurrences
	 * @return
	 */
	public SortedSet<TokenOccurrenceImpl> get_postings();

}