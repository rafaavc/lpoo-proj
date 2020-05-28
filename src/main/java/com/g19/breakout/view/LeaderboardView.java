package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.view.graphics.Graphics;
import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LeaderboardView extends SuperView<View> {
    private final Dimensions gameDimensions;
    private final String backgroundColor;
    List<Pair<String, Integer>> leaderboard;

    public LeaderboardView(Graphics graphics, Dimensions gameDimensions, PriorityQueue<Pair<String, Integer>> pq, String backgroundColor) {
        super(graphics, new Position(0, 0));
        this.gameDimensions = gameDimensions;
        this.backgroundColor = backgroundColor;

        leaderboard = new ArrayList<>();
        while(!pq.isEmpty()) {
            Pair<String, Integer> p = pq.poll();
            leaderboard.add(p);
        }

        pq.addAll(leaderboard);
    }

    public void drawSelf() {
        graphics.drawCenteredString(new Position(gameDimensions.getDiscreteX()/2., 6), "Leaderboard", "#ffffff", backgroundColor);

        int counter = 0;
        for(Pair<String, Integer> p : leaderboard) {
            if (counter >= 13) break;
            graphics.drawString(new Position(gameDimensions.getDiscreteX() / 4., 10+(2*counter)), p.fst, "#ffffff", backgroundColor);
            String place = (counter+1) + ". ";
            graphics.drawString(new Position(gameDimensions.getDiscreteX() / 4. - place.length(), 10+(2*counter)), place, "#ffffff", backgroundColor);

            String n = Integer.toString(p.snd);
            graphics.drawString(new Position(3*gameDimensions.getDiscreteX() / 4. - n.length(), 10+(2*counter)), n, "#ffffff", backgroundColor);
            counter++;
        }
    }
}
