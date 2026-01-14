package dev.patrickluz.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Renderer {
    private final int frameWidth;
    private final int frameHeight;
    private final BufferedImage frame;
    private final Graphics2D g2d;

    public Renderer(int width, int height) {
        frameWidth = width;
        frameHeight = height;
        frame = new BufferedImage(frameWidth, frameHeight, BufferedImage.TYPE_INT_ARGB);
        g2d = frame.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void clear() {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, frameWidth, frameHeight);
    }

    public void clear(Color color) {
        g2d.setColor(color);
        g2d.fillRect(0, 0, frameWidth, frameHeight);
    }

    public BufferedImage getFrame() {
        return frame;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public void drawOval(int x, int y, int width, int height, Color color) {
        g2d.setColor(color);
        g2d.fillOval(x, y, width, height);
    }
}
