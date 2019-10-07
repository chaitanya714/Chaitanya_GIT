package com.evm.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Integer> validVoters = new HashSet<Integer>();
		Map<Integer, Integer> validVotersCandidates = new HashMap<Integer, Integer>();
		Map<Integer, Integer> votesCount = new HashMap<Integer, Integer>();

		BloomFilter bloomFilter = new BloomFilter();
		try {
			bloomFilter.populateFilter(validVoters);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ElectionCount electionCount = new ElectionCount();
		try {
			electionCount.populateVoterCandidate(validVoters, validVotersCandidates, votesCount);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Select The option you want to perform");
		System.out.println("Enter 1 to store a valid voter id and candidateid");
		System.out.println("Enter 2 to find candidate id for voterId");
		System.out.println("Enter 3 to find the total no of votes received by a candidate");

		Scanner scn = new Scanner(System.in);
		int choice = scn.nextInt();
		
		switch(choice) {
			
		case 1:
			System.out.println("Enter the voter candidate pair");
			Scanner scn1 = new Scanner(System.in);
			String s = scn1.nextLine();
			int key, value;
			String[] keyValue = new String[2];
			keyValue = s.split(" ");
			key = Integer.parseInt(keyValue[0]);
			value = Integer.parseInt(keyValue[1]);
			if(validVoters.contains(key)) {
				validVotersCandidates.put(key, value);
			}
			else
				System.out.println("Invalid voter");

			break;
			
		case 2:
			System.out.println("Enter the voter_id");
			Scanner scn2 = new Scanner(System.in);
			int voter_id = scn2.nextInt();
			if(validVoters.contains(voter_id)) {
				System.out.println("voter casted vote to " +validVotersCandidates.get(voter_id));
			}
			
			else {
				System.out.println("Voter_id is invalid");
			}
			break;
			
		case 3:
			System.out.println("Enter the voter_id");
			Scanner scn3 = new Scanner(System.in);
			int candidate_id = scn3.nextInt();
			System.out.println("Candidate got "+votesCount.get(candidate_id)+ " votes");
			break;
			
		
		}

	}

}
