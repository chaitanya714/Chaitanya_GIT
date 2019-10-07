package com.evm.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class BloomFilter {

	public void populateFilter(Set<Integer> validVoters) throws FileNotFoundException, IOException {

		File file = new File("files/validVotersList.txt");
		FileReader fileReader;
		String current;

		fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while ((current = bufferedReader.readLine()) != null) {
			validVoters.add(Integer.parseInt(current));
		}
		bufferedReader.close();
	}

}
