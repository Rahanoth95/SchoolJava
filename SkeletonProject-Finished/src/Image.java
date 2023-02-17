// CMSC 330 Advanced Programming Languages
// Project 1 Skeleton
// UMGC CITE
// Spring 2023
// Johnathan Brandstetter
// Date 2/4/2023 - 2/7/2023

import java.awt.*;

// Abstract base class that defines all image objects

abstract class Image {

    private Color color;


    // Constructor that can only be called by the subclasses to initialize the color

    public Image(Color color) {
        this.color = color;
    }

    // Sets the color of the image to be drawn. Must be called first by the draw function of the subclasses

    public void colorDrawing(Graphics graphics) {
        graphics.setColor(color);
    }

    abstract void draw(Graphics graphics);
}

