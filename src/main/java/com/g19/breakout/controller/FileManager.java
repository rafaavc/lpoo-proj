package com.g19.breakout.controller;



import com.sun.tools.javac.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FileManager {

    public List<String> getFileContent(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("leaderboard.txt")));

        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);

        br.close();
        return lines;
    }

    public PriorityQueue<Pair<String, Integer>> getLeaderboard() throws IOException {
        Comparator<Pair<String, Integer>> cmp = (p1, p2) -> p2.snd - p1.snd;
        PriorityQueue<Pair<String, Integer>> q = new PriorityQueue<>(cmp);

        List<String> lines = getFileContent("leaderboard.txt");

        for (int i = 0; i < lines.size(); i += 2) {
            q.add(new Pair<>(lines.get(i), Integer.valueOf(lines.get(i+1))));
        }

        return q;
    }

    public void writeLeaderboard(PriorityQueue<Pair<String, Integer>> leaderboard) throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter(new File("leaderboard.txt")));

        for (Pair<String, Integer> pair : leaderboard) {
            br.write(pair.fst + '\n');
            br.write(pair.snd.toString() + '\n');
        }

        br.close();
    }
}
