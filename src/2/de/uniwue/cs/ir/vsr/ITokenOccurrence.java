/*
 * Created on 30.11.2005
 */
package de.uniwue.cs.ir.vsr;

import java.util.List;

import de.uniwue.cs.ir.vsr.IDocument;

/**
 * Tokenvorkommen aus der Vorlesung. 
 * Enthält eine Referenz auf ein bestimmtes Dokument, das Gewicht eines Terms in Bezug 
 * auf dieses Dokument und die Positionen des Termes im Dokument.
 * TokenOccurrences werden in Reihenfolge <em>absteigender</em> Gewichte sortiert!
 * Entweder kann die Häufigkeit des Termes im Dokument gespeichert werden,
 * oder direkt der berechnete tf-idf Wert. 
 * 
 * @author Christoph Schmitz
 * @author Beate Navarro
 */
public interface ITokenOccurrence extends Comparable<ITokenOccurrence> {

	/**
	 * @return das Dokument
	 */
	public abstract IDocument getDocument();

	/**
	 * @return das Gewicht
	 */
	public abstract double getWeight();

	/**
	 * @return String-Repräsentation dieses Gewichts
	 */
	public abstract String toString();
	
	/**
	 * 
	 * @return die Positionen, an denen der Term vorkommt, aufsteigend 
	 * sortiert und ab 0 gezählt.
	 */
	public abstract List<Integer> getPositions();

}