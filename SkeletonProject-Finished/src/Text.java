// CMSC 330 Advanced Programming Languages
// Project 1 Skeleton
// UMGC CITE
// Spring 2023
// Johnathan Brandstetter
// Date 2/4/2023 - 2/7/2023

import java.awt.*;

// Class that defines a Text object

public class Text extends Image {

    public Color color;
    public Point position;
    public String text;

    public Text(Color color, Point upperLeft, String text) {
        super(color);
        this.position = upperLeft;
        this.text = text;
    }

    public void draw(Graphics graphics) {
        colorDrawing(graphics);
        graphics.drawString(this.text, this.position.x, this.position.y);
    }
}



