package dev.patrickluz.character;

import dev.patrickluz.character.parts.Body;
import dev.patrickluz.character.parts.Head;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedHashMap;
import java.util.Map;

public class Character {
    private final int posX, posY;
    private final int bodyHeight = 60, headRadius = 20;
    private final Map<String, CharacterPart> parts = new LinkedHashMap<>();

    public Character(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;


        Head head = new Head(this.posX, this.posY, headRadius);

        int bodyWidth = 20;
        int bodyPosY = this.posY + head.getDiameter() - 5;
        int bodyPosX = this.posX + (head.getDiameter() - bodyWidth) / 2;
        Body body = new Body(bodyPosX, bodyPosY, bodyWidth, this.bodyHeight, Color.BLACK, null);

        parts.put("body", body);
        parts.put("head", head);

    }

    public void draw(Graphics2D g2d) {
        parts.forEach((_, part) -> part.draw(g2d));
    }
}
