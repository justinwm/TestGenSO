package generics;

import java.util.HashMap;
import java.util.HashSet;

import utils.Pair;

public class MutantPerClass {
	
	public HashSet<String> mutations;
	public HashMap<String, Integer> mutationIndex;
	public HashMap<Integer,Integer> mutationStatus;
	public HashMap<Integer,String> mutationTestCase;
	
	public MutantPerClass() {
		mutations = new HashSet<String>();
		mutationIndex = new HashMap<String,Integer>();
		mutationStatus = new HashMap<Integer,Integer>();
		mutationTestCase = new HashMap<Integer,String>();
		
	}
	
	
	public void updateMutation(String mutant, String status, String TestCase) {
		if (!mutations.contains(mutant)) {
			mutationIndex.put(mutant, mutations.size());
			mutations.add(mutant);
		} else {
			System.out.println("Contains:\t" + mutant);
		}
		
		int index = mutationIndex.get(mutant);
		int statusId = 0;
		
		
		/*
		 * The Id of different status
		 * 0: Timed_out
		 * 1: No_Coverage
		 * 2: Survived
		 * 3: Killed
		 * 
		 * */
		if (status.equals("NO_COVERAGE")) statusId = 1;
		else if (status.equals("SURVIVED")) statusId = 2;
		else if (status.equals("KILLED")) statusId = 3;
		
		mutationStatus.put(index, statusId);
		mutationTestCase.put(index, TestCase);
	}
	
	public void updateMutation(String mutant, int status, String TestCase) {
		if (!mutations.contains(mutant)) {
			mutationIndex.put(mutant, mutations.size());
			mutations.add(mutant);
		}
		
		int index = mutationIndex.get(mutant);
		if (!mutationStatus.containsKey(index) || status > mutationStatus.get(index)) mutationStatus.put(index, status);
		if (TestCase.equals(""))
			mutationTestCase.put(index, TestCase);
	}
	
	public Pair<Integer,Integer> mutationScore() {
		int killed = 0;
		for (int index : mutationStatus.keySet()) {
			if (mutationStatus.get(index) == 3)
				killed++;
		}
		return new Pair<Integer,Integer>(killed, mutations.size());
	}
}
