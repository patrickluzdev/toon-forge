package dev.patrickluz.character.parts;

import dev.patrickluz.character.CharacterPart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

public class Arm extends CharacterPart {

    private final Direction direction;
    private int length;
    private int curveIntensity;

    public Arm(int x, int y, int length, Direction direction) {
        super(x, y, Color.BLACK, null);
        this.length = length;
        this.direction = direction;
        this.curveIntensity = 30;
    }

    @Override
    public void draw(Graphics2D g2d) {
        int startX = getPosX();
        int startY = getPosY();

        int horizontalOffset = direction == Direction.LEFT ? -50 : 50;
        int endX = startX + horizontalOffset;
        int endY = startY + length;

        int curveOffset = direction == Direction.LEFT ? -curveIntensity : curveIntensity;
        int controlX = startX + curveOffset;
        int controlY = startY + length / 2;

        QuadCurve2D curve = new QuadCurve2D.Double(
                startX, startY,
                controlX, controlY,
                endX, endY
        );

        g2d.setColor(getStrokeColor());
        g2d.setStroke(new BasicStroke(getStrokeWidth(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.draw(curve);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCurveIntensity() {
        return curveIntensity;
    }

    public void setCurveIntensity(int curveIntensity) {
        this.curveIntensity = curveIntensity;
    }

    public Direction getDirection() {
        return direction;
    }
}
