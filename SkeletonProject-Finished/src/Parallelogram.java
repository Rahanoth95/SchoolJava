// CMSC 330 Advanced Programming Languages
// Project 1 Skeleton
// UMGC CITE
// Spring 2023
// Johnathan Brandstetter
// Date 2/4/2023 - 2/7/2023

import java.awt.*;
// Class that defines a Solid parallelogram object

class Parallelogram extends SolidPolygon {
    // Constructor that initializes the vertices and offset of the parallelogram

    public Parallelogram(Color color, Point upperLeft, Point lowerRight, int offset) {
        super(color, 4);
        int[] x_points = {upperLeft.x, lowerRight.x +offset, lowerRight.x, upperLeft.x - offset};
        int[] y_points = {upperLeft.y, upperLeft.y, lowerRight.y, lowerRight.y};
        createPolygon(x_points, y_points);
    }
}
