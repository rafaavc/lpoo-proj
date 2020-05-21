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

        return lines;
    }

    public PriorityQueue<Pair<String, Integer>> getLeaderboard() throws IOException {
        Comparator<Pair<String, Integer>> cmp = (p1, p2) -> p2.snd - p1.snd;
        PriorityQueue<Pair<String, Integer>> q = new PriorityQueue<>(cmp);

        List<String> lines = getFileContent("leaderboard.txt");
        for (String l : lines) {
            StringBuilder sb = new StringBuilder(l);
            int i = sb.indexOf(";");

            String s = sb.substring(0, i);
            String n = sb.substring(i+1);

            Integer points = Integer.valueOf(n);

            q.add(new Pair<>(s, points));
        }

        return q;
    }
}
