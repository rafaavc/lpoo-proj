package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.BackgroundModel;
import com.g19.breakout.view.graphics.Graphics;
import com.g19.breakout.view.graphics.LanternaAdapter;
import com.sun.tools.javac.util.Pair;
import net.jqwik.api.*;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

public class ViewTests {

    @Provide
    Arbitrary<Integer> Between0And500() {
        return Arbitraries.integers().filter(n -> n > 0 && n < 500);
    }
     @Property
    public void BackgroundViewTests(@ForAll("Between0And500") int n){
         BackgroundModel model = Mockito.mock(BackgroundModel.class);
         Graphics graphics = Mockito.mock(LanternaAdapter.class);
         Dimensions dimensions = new Dimensions(100, 120);
         BackgroundView backgroundView = new BackgroundView(graphics, dimensions, model, "#000000");

         List<Position> particles = new ArrayList<>();
         for (int i = 0; i < n; i++){
             particles.add(new Position(Math.random()*dimensions.getDiscreteX(), Math.random()*dimensions.getDiscreteY()));
         }
         Mockito.when(model.getParticles()).thenReturn(particles);
         Mockito.doNothing().when(graphics).drawString(any(Position.class), any(String.class), any(String.class), any(String.class));
         Mockito.doNothing().when(graphics).drawRectangle(any(Position.class), any(Dimensions.class), any(Character.class), any(String.class));

         backgroundView.draw();

         Mockito.verify(graphics, Mockito.times(1)).drawRectangle(new Position(0, 0), dimensions, ' ', "#000000");
         Mockito.verify(graphics, Mockito.times(n)).drawString(any(Position.class), any(String.class), any(String.class), any(String.class));
     }

     @Property
    public void LeaderboardViewTests(@ForAll String name, @ForAll @Positive int score){
        Comparator<Pair<String, Integer>> cmp = (p1, p2) -> p2.snd - p1.snd;
         PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>(cmp);
         pq.add(new Pair<>(name, score));

         Dimensions dimensions = new Dimensions(100, 120);
         Graphics graphics = Mockito.mock(LanternaAdapter.class);

         LeaderboardView leaderboardView = new LeaderboardView(graphics, dimensions, pq, "#000000");

        Mockito.doNothing().when(graphics).drawString(any(Position.class), any(String.class), any(String.class), any(String.class));
        leaderboardView.drawSelf();

        Mockito.verify(graphics, Mockito.times(3*pq.size())).drawString(any(Position.class), any(String.class), any(String.class), any(String.class));
     }
}
