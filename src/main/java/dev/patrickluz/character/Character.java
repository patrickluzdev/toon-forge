package dev.patrickluz.character;

import dev.patrickluz.character.parts.Body;
import dev.patrickluz.character.parts.Head;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedHashMap;
import java.util.Map;

public class Character {
    private final int posX, posY;
    private final Map<String, CharacterPart> parts = new LinkedHashMap<>();

    public Character(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;

        int headRadius = 80;
        Head head = new Head(this.posX, this.posY, headRadius);

        int bodyTopWidth = 110;
        int bodyBottomWidth = 150;
        int bodyHeight = 210;

        int centerX = this.posX + headRadius;
        int bodyPosX = centerX - bodyTopWidth / 2;
        int bodyPosY = this.posY + headRadius + headRadius / 2;

        Body body = new Body(bodyPosX, bodyPosY, bodyTopWidth, bodyBottomWidth, bodyHeight, Color.BLACK, Color.GRAY);

        parts.put("body", body);
        parts.put("head", head);
    }

    public void draw(Graphics2D g2d) {
        parts.forEach((_, part) -> part.draw(g2d));
    }
}
