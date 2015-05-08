/**
 * 
 */
package de.uniwue.cs.ir.vsr;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Friedrich
 *
 */
public class CorpusImpl implements ICorpus {
	
	private IDocument doc;

	@Override
	public void addDocument(IDocument doc) {
		this.doc = doc;
	}

	@Override
	public Iterator<IDocument> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<IDocument> getDocumentsContainingAll(String... terms) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<IDocument> getDocumentsContainingAny(String... terms) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
