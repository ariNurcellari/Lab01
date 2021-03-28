package it.polito.tdp.parole.model;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	List<String> paroleList ;
		
	public Parole() {
		paroleList = new LinkedList<String>() ;	
	}
	
	public void addParola(String p) {
		paroleList.add(p) ;
	}
	
	public List<String> getElenco() {
		List<String> tempList = new LinkedList<String>(paroleList) ;
		Collections.sort(tempList, new ComparatoreParolePerOrdineAlfabetico());
		return tempList;
	}
	class ComparatoreParolePerOrdineAlfabetico implements Comparator<String>{
		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
	}
	
	public void cancellaParola(String parola) {
		paroleList.remove(parola);
	}
	
	public void reset() {
		paroleList.clear();
	}
}
