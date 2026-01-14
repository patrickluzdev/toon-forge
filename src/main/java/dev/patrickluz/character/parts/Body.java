package dev.patrickluz.character.parts;

import dev.patrickluz.character.CharacterPart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Body extends CharacterPart {
    private final int width, height;

    public Body(int posX, int posY, int width, int height, Color strokeColor, Color fillColor) {
        super(posX, posY, strokeColor, fillColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g2d) {
        if (getFillColor() != null) {
            g2d.setColor(getFillColor());
            g2d.fillRect(getPosX(), getPosY(), this.width, this.height);
        }

        g2d.setColor(getStrokeColor());
        g2d.setStroke(new BasicStroke(getStrokeWidth()));
        g2d.drawRect(getPosX(), getPosY(), this.width, this.height);

    }
}
