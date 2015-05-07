/*
 * Created on 01.11.2005
 */
package de.uniwue.cs.ir.vsr;

import java.util.Collection;
import java.util.Iterator;

/**
 * Repräsentiert eine Sammlung von Dokumenten.
 * 
 * @author Christoph Schmitz
 */
public interface ICorpus extends Iterable<IDocument> {
	
	/**
	 * Füge ein Dokument in die Sammlung ein.
	 * 
	 * @param doc das einzufügende Dokument
	 */
	public void addDocument(IDocument doc);
	
	/**
	 * Liefert Iterator über alle Dokumente.
	 * 
	 * @return Iterator über alle Dokumente.
	 */
	public Iterator<IDocument> iterator();
	
	/**
	 * Liefert Dokumente, die alle genannten Terme enthalten (AND).
	 * 
	 * @param terms einer oder mehrere Terme
	 * @return Iterator über alle Dokumente, die <em>alle</em> der Terme enthalten
	 */
	public Collection<IDocument> getDocumentsContainingAll(String... terms);
	
	/**
	 * Liefert Dokumente, die mindestens einen der genannten Terme enthalten (OR).
	 * 
	 * @param terms einer oder mehrere Terme
	 * @return Iterator über alle Dokumente, die <em>mindestens einen</em> der Terme enthalten
	 */
	public Collection<IDocument> getDocumentsContainingAny(String... terms);

	/**
	 * Liefert die Größe (Anzahl Dokumente) des Korpus.
	 * 
	 * @return Anzahl der Dokumente im Korpus
	 */
	public int size();
}
