package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.view.graphics.Graphics;
import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LeaderboardView extends SuperView<View> implements View {
    private final Graphics graphics;
    private final Dimensions gameDimensions;
    List<Pair<String, Integer>> leaderboard;

    public LeaderboardView(Graphics graphics, Dimensions gameDimensions, PriorityQueue<Pair<String, Integer>> pq) {
        this.graphics = graphics;
        this.gameDimensions = gameDimensions;

        leaderboard = new ArrayList<>();
        while(!pq.isEmpty()) {
            Pair<String, Integer> p = pq.poll();
            leaderboard.add(p);
        }

        pq.addAll(leaderboard);

    }

    public void draw() {
        Position prevOffset = graphics.setOffset(new Position(0, 0));

        graphics.drawRectangle(new Position(0, 0), gameDimensions, ' ', "#000000");
        graphics.drawCenteredString(new Position(gameDimensions.getDiscreteX()/2., 10), "Leaderboard", "#ffffff", "#000000");

        int i = 0;
        for(Pair<String, Integer> p : leaderboard) {
            if (i >= 10) break;
            graphics.drawString(new Position(gameDimensions.getDiscreteX() / 4., 13+(2*i)), p.fst, "#ffffff", "#000000");
            String n = Integer.toString(p.snd);
            graphics.drawString(new Position(3*gameDimensions.getDiscreteX() / 4. - n.length(), 13+(2*i)), n, "#ffffff", "#000000");
            i++;
        }

        drawViews();

        graphics.setOffset(prevOffset);
    }
}
