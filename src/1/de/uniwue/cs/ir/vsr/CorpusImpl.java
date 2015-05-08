/**
 * 
 */
package de.uniwue.cs.ir.vsr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author Friedrich
 *
 */
public class CorpusImpl implements ICorpus {
	
	private List<IDocument> dokumente = new ArrayList<IDocument>();

	@Override
	public void addDocument(IDocument doc) {
		dokumente.add(doc);
	}

	@Override
	public Iterator<IDocument> iterator() {
		return dokumente.iterator();
	}

	@Override
	public Collection<IDocument> getDocumentsContainingAll(String... terms) {
		
		List<IDocument> docContainingAll = new ArrayList<IDocument>();
		boolean allTermsIn = false;
		
		for (IDocument dokument : dokumente) {
			for (String term : terms) {
				if(dokument.getTermCount(term)!=0)
					allTermsIn = true;
				else{
					allTermsIn = false;
					break;
				}
			}
			if(allTermsIn)
				docContainingAll.add(dokument);
		}
		return docContainingAll;
	}

	@Override
	public Collection<IDocument> getDocumentsContainingAny(String... terms) {
		List<IDocument> docContainingAll = new ArrayList<IDocument>();
		
		for (IDocument dokument : dokumente) {
			for (String term : terms) {
				if(dokument.getTermCount(term)!=0){
					docContainingAll.add(dokument);
					break;
				}
			}
			
		}
		return docContainingAll;
	}

	@Override
	public int size() {
		return dokumente.size();
	}

}
