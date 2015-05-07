package de.uniwue.cs.ir.vsr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
		// TODO Auto-generated method stub
		return null;
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
		terme = Arrays.asList(temp.split(" "));
	}

	@Override
	public int getTermCount(String term) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector<Integer> getTermPositions(String term) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
