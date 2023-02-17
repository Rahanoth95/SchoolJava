// CMSC 330 Advanced Programming Languages
// Project 1 Skeleton
// UMGC CITE
// Spring 2023
// Johnathan Brandstetter
// Date 2/4/2023 - 2/7/2023

import java.awt.*;

// Class that defines a Solid Isosceles object

class IsoscelesTriangle extends SolidPolygon {

    // Constructor that initializes the vertices of the Iso triangle

    public IsoscelesTriangle(Color color, Point topVertex, int height, int width) {
        super(color, 3);
        int[] x_points = {topVertex.x, topVertex.x - (width / 2), topVertex.x + width /2};
        int[] y_points = {topVertex.y, topVertex.y + height, topVertex.y + height};
        createPolygon(x_points, y_points);
    }
}