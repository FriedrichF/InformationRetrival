package de.uniwue.cs.ir.vsr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class DocumentImpl implements IDocument {
	
	private String name;
	private List<String> terme;

	public DocumentImpl(String name) {
		this.name = name;
	}

	@Override
	public Iterator<String> iterator() {
		List<String> termeEinzeln = new ArrayList<String>();
		
		for (String term : terme) {
			if(!termeEinzeln.contains(term))
				termeEinzeln.add(term);
		}
		
		return termeEinzeln.iterator();
	}

	@Override
	public String getId() {
		return name;
	}

	@Override
	public void read(InputStream input) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		String temp = reader.readLine();
		reader.close();
		
		String[] termArray = temp.split(" ");
		
		terme = Arrays.asList(termArray);
	}

	@Override
	public int getTermCount(String suchTerm) {
		int counter = 0;
		for (String term : terme) {
			if(term.equals(suchTerm))
				counter++;
		}
		
		return counter;
	}

	@Override
	public Vector<Integer> getTermPositions(String suchTerm) {
		Vector<Integer> positions = new Vector<Integer>();
		for (int i = 0; i <= terme.size(); i++) {
			if(terme.get(i).equals(suchTerm))
				positions.add(i);
		}
		
		return positions;
	}
	
	@Override public String toString(){
		String ausgabe = "<pre>/n[ ";
		boolean first = true;
		for (String term : terme) {
			if(!first)
				ausgabe += ", ";
			ausgabe += term+" -> "+ getTermCount(term);
		}
		
		ausgabe += " ]\n</pre>";
		
		return ausgabe;
	}

	@Override
	public int size() {
		return terme.size();
	}

}
