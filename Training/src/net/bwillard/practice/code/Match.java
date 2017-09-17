package net.bwillard.practice.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Match {

	public void playMatch(int teamA, int teamB, ArrayList<String> groups) {
		Random scoreA = new Random();
		int score1 = scoreA.nextInt(5) + 0;
		int score2 = scoreA.nextInt(5) + 0;
		System.out.println("Qtr 1: " + score1 + "   " + score2);

		if (score1 > score2) {
			System.out.println(groups.get(teamA) + " win " + score1 + " to "
					+ score2 + " " + groups.get(teamB) + " eliminated.");
			groups.remove(teamB);
		} else if (score2 > score1) {
			System.out.println(groups.get(teamB) + " win " + score2 + " to "
					+ score1 + " " + groups.get(teamA) + " eliminated.");
			groups.remove(teamA);
		} else if (score1 == score2) {
			System.out.println(groups.get(teamA) + " tie " + score1 + " to " +
					groups.get(teamB) + " " + score2 + " no team was eliminated.");
		}
	}

	public static void main(String[] args) {
		Match game1 = new Match();
		ArrayList<String> groups = new ArrayList<String>(Arrays.asList("team1",
				"team2", "team3"));
		System.out.println(groups);
		System.out.println("Round 1");
		game1.playMatch(0, 1, groups);
		System.out.println(groups);

	}
}