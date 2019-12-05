package app;

import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static final String FILE_NAME = "day3";

    private static final char RIGHT = 'R';
    private static final char UP = 'U';
    private static final char LEFT = 'L';
    private static final char DOWN = 'D';

    List<Point> paths = new ArrayList<>();
    List<Intersection> intersections = new ArrayList<>();

    public int part2(List<String> input) {
        Point current = new Point(0, 0, 0, 0);
        paths.add(current);

        int pathNumber = 0, totalSteps = 0;
        for (String pathInput : input) {
            String[] steps = pathInput.split(",");

            for (int i = 0; i < steps.length; i++) {
                totalSteps = addStepToPath(pathNumber, steps[i], current, totalSteps);
            }
            current = new Point(++pathNumber, 0, 0, 0);
            totalSteps = 0;
        }

        return findShortestIntersection();
    }

    private int findShortestIntersection() {
        int shorter = Integer.MAX_VALUE, token;
 
        for (Intersection i : intersections) {
            Point point1 = i.points.get(0);
            Point point2 = i.points.get(1);

            token = point1.steps + point2.steps;
            if(token < shorter){
                shorter = token;
            }
        }
        return shorter;
    }

    public int part1(List<String> input) {
        Point current = new Point(0, 0, 0, 0);
        paths.add(current);

        int pathNumber = 0, totalSteps = 0;
        for (String pathInput : input) {
            String[] steps = pathInput.split(",");

            for (int i = 0; i < steps.length; i++) {
                totalSteps = addStepToPath(pathNumber, steps[i], current, totalSteps);
            }
            current = new Point(++pathNumber, 0, 0, 0);
        }

        Point p = findClosestIntersection();
        return p.x + p.y;
    }

    private Point findClosestIntersection() {
        int shorter = Integer.MAX_VALUE, token;
        Point closest = null;

        for (Intersection i : intersections) {
            Point point = i.points.get(0);
            token = Math.abs(point.x) + Math.abs(point.y);
            if(token < shorter){
                shorter = token;
                closest = point;
            }
        }
        return closest;
    }

    private int addStepToPath(int pathNumber, String step, Point currentPoint, int steps) {
        int number = Integer.valueOf(step.substring(1));
        int x = currentPoint.x, y = currentPoint.y;

        switch (step.charAt(0)) {
        case RIGHT:
            for (int i = 1; i < number; i++) {
                addPoint(new Point(pathNumber, x + i, y, steps + i));
            }
            currentPoint.x = x + number;
            break;
        case UP:
            for (int i = 1; i < number; i++) {
                addPoint(new Point(pathNumber, x, y + i, steps + i));
            }
            currentPoint.y = y + number;
            break;
        case LEFT:
            for (int i = 1; i < number; i++) {
                addPoint(new Point(pathNumber, x - i, y, steps + i));
            }
            currentPoint.x = x - number;
            break;
        case DOWN:
            for (int i = 1; i < number; i++) {
                addPoint(new Point(pathNumber, x, y - i, steps + i));
            }
            currentPoint.y = y - number;
            break;
        }

        return steps + number;
    }

    private void addPoint(Point p) {
        for (Point point : paths) {
            if (point.x == p.x && point.y == p.y && point.path != p.path) {
                Intersection i = new Intersection();
                i.addPoint(point);
                i.addPoint(p);

                intersections.add(i);
            }
        }

        paths.add(p);
    }

    class Point {
        public Point(int path, int x, int y, int steps) {
            this.path = path;
            this.x = x;
            this.y = y;
            this.steps = steps;
        }

        int path;
        int x;
        int y;
        int steps;

        public String toString() {
            return "Point X:" + x + " Y:" + y + " in path " + path;
        }
    }

    class Intersection {
        List<Point> points = new ArrayList<>();

        public void addPoint(Point point){
            points.add(point);
        }
    }
}