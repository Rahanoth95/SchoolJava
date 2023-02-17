// CMSC 330 Advanced Programming Languages
// Project 1 Skeleton
// UMGC CITE
// Spring 2023
// Johnathan Brandstetter
// Date 2/4/2023 - 2/7/2023

import java.awt.*;

// Abstract class that defines all Solid polygons

class SolidPolygon extends Polygon_ {

    private int vertexCount;
    private Polygon polygon;

    // Constructor that initializes color and vertexCount of a polygon

    public SolidPolygon(Color color, int vertexCount) {
        super(color, vertexCount);
        this.vertexCount = vertexCount;
    }

    // Creates a polygon object given its vertices
    public void createPolygon(int[] x_points, int[] y_points) {
        polygon = new Polygon(x_points, y_points, vertexCount);
    }

    // Draws polygon using polygon object

    @Override
    public void draw(Graphics graphics) {
        colorDrawing(graphics);
        graphics.fillPolygon(polygon);
    }
}