package dev.patrickluz.character.parts;

import dev.patrickluz.character.CharacterPart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Head extends CharacterPart {
    private final int diameter;

    public Head(int posX, int posY, int radius) {
        super(posX, posY, Color.BLACK, Color.WHITE);
        int radius1 = Math.max(radius, 0);
        this.diameter = radius1 * 2;
    }

    @Override
    public void draw(Graphics2D g2d) {
        if (getFillColor() != null) {
            g2d.setColor(getFillColor());
            g2d.fillRect(getPosX(), getPosY(), this.diameter, this.diameter);
        }
        g2d.setColor(getStrokeColor());
        g2d.setStroke(new BasicStroke(getStrokeWidth()));
        g2d.drawOval(getPosX(), getPosY(), this.diameter, this.diameter);
    }

    public int getDiameter() {
        return diameter;
    }
}
