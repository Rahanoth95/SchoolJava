// CMSC 330 Advanced Programming Languages
// Project 1 Skeleton
// UMGC CITE
// Spring 2023
// Johnathan Brandstetter
// Date 2/4/2023 - 2/7/2023

import java.awt.*;

// Class that defines a Solid  Polygon object
class RegularPolygon extends SolidPolygon {
    // Constructor that initializes the Sides and radius of the polygon.

    public RegularPolygon(Color color, int sides, Point upperLeft, int radius) {
        super(color, sides);
        int[] x_points = new int[sides];
        int[] y_points = new int[sides];
        double angle = 2 * Math.PI / sides;
        for (int i = 0; i < sides; i++) {
            x_points[i] = (int) (upperLeft.x + radius * Math.cos(angle * i));
            y_points[i] = (int) (upperLeft.y + radius * Math.sin(angle * i));
            createPolygon(x_points, y_points);
        }
    }
}
