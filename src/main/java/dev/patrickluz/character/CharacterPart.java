package dev.patrickluz.character;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class CharacterPart {
    private int posX, posY;
    private double rotation, pivotX, pivotY;
    private double scaleX = 1.0, scaleY = 1.0;
    private Color fillColor, strokeColor;
    private int strokeWidth = 1;

    public CharacterPart(int posX, int posY, Color strokeColor, Color fillColor) {
        this.posX = posX;
        this.posY = posY;
        this.rotation = 0.0;
        this.pivotX = 0.0;
        this.pivotY = 0.0;
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
    }

    public abstract void draw(Graphics2D g2d);

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public double getPivotX() {
        return pivotX;
    }

    public void setPivotX(double pivotX) {
        this.pivotX = pivotX;
    }

    public double getPivotY() {
        return pivotY;
    }

    public void setPivotY(double pivotY) {
        this.pivotY = pivotY;
    }

    public double getScaleX() {
        return scaleX;
    }

    public void setScaleX(double scaleX) {
        this.scaleX = scaleX;
    }

    public double getScaleY() {
        return scaleY;
    }

    public void setScaleY(double scaleY) {
        this.scaleY = scaleY;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
}
