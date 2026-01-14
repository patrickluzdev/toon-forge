package dev.patrickluz.character.parts;

import dev.patrickluz.character.CharacterPart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

public class Body extends CharacterPart {
    private final int topWidth;
    private final int bottomWidth;
    private final int height;

    public Body(int posX, int posY, int topWidth, int bottomWidth, int height, Color strokeColor, Color fillColor) {
        super(posX, posY, strokeColor, fillColor);
        this.topWidth = topWidth;
        this.bottomWidth = bottomWidth;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g2d) {
        int centerX = getPosX() + topWidth / 2;
        int topY = getPosY();
        int bottomY = getPosY() + height;

        int extraWidth = (bottomWidth - topWidth) / 2;
        int bottomLeftX = getPosX() - extraWidth;
        int bottomRightX = getPosX() + topWidth + extraWidth;

        Path2D body = new Path2D.Double();
        body.moveTo(getPosX(), topY);
        body.lineTo(getPosX() + topWidth, topY);
        body.quadTo(getPosX() + topWidth + extraWidth / 2, topY + height / 2, bottomRightX, bottomY);
        body.quadTo(centerX, bottomY + 10, bottomLeftX, bottomY);
        body.quadTo(getPosX() - extraWidth / 2, topY + height / 2, getPosX(), topY);
        body.closePath();

        g2d.setColor(getFillColor());
        g2d.fill(body);
        g2d.setColor(getStrokeColor());
        g2d.setStroke(new BasicStroke(getStrokeWidth()));
        g2d.draw(body);

    }
}
