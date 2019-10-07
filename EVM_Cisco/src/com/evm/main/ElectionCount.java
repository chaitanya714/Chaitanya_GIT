package com.evm.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class ElectionCount {
	
	public void populateVoterCandidate(Set<Integer> validVoters,
			Map<Integer,Integer> validVotersCandidates,
			Map<Integer,Integer> votesCount) throws NumberFormatException, IOException {
		
		File file = new File("files/votersCandList.txt");
		FileReader fileReader;
		String current;
		String[] keyValue = new String[2];
		int key,value;
		fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while ((current = bufferedReader.readLine()) != null) {
			keyValue = current.split(" ");
			key = Integer.parseInt(keyValue[0]);
			try {
			value = Integer.parseInt(keyValue[1]);
			}
			catch(ArrayIndexOutOfBoundsException e){
				
				continue;
				
			}
			if(validVoters.contains(key)) {
				validVotersCandidates.put(key, value);
				
				if(votesCount.containsKey(value)) {
					votesCount.put(value, (votesCount.get(value))+1);
				}
				else {
					votesCount.put(value, 1);
				}
			}
				
		}
		bufferedReader.close();
	}


}
