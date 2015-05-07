/*
  * Created on 01.11.2005
 */
package de.uniwue.cs.ir.vsr;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Vector;

/**
 * Repräsentiert ein Dokument als Abbildung von Termen auf Gewichte.
 * 
 * @author Christoph Schmitz
 */
public interface IDocument extends Iterable<String> {
	
	/**
	 * @see java.util.Iterable
	 * @return Iterator, in dem jeder vorkommende String <b>genau ein Mal</b> vorkommt. 
	 */

	public Iterator<String> iterator();
	
	/**
	 * @return die ID dieses Dokuments
	 */
	public String getId();
	
	/**
	 * Liest ein Dokument aus dem angegebenen Stream.
	 * 
	 * @param input
	 * @throws IOException
	 */
	public void read(InputStream input) throws IOException;

	/**
	 * Liefert Anzahl für einen Term.
	 * 
	 * @param term
	 * @return Anzahl der Vorkommen für den Term, 0 falls nicht vorkommend
	 */
	public int getTermCount(String term);
	
	/**
	 * Liefert die Positionen zurück, an denen der Term im Dokument
	 * vorkommt, ab 0 gezählt und aufsteigend sortiert.
	 * 
	 * @param term
	 * @return
	 */
	public Vector<Integer> getTermPositions(String term);
	
	/**
	 * Erzeugt eine menschenlesbare String-Repräsentation der Form
	 * 
	 * <pre>
	 * [ Term -> Gewicht, ... Term -> Gewicht ]
	 * </pre>
	 * 
	 * @return String-Darstellung des Dokuments
	 */
	public String toString();

	/**
	 * Anzahl der Terme (mit Mehrfachzählung) im Dokument
	 * 
	 * @return Anzahl Terme im Dokument
	 */
	public int size();
}