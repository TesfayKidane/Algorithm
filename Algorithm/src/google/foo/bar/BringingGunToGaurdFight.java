/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package google.foo.bar;

/**
 *
 * @author Tesfay
 */
import java.util.*;

public class BringingGunToGaurdFight {

    static int rM;
    static int lM;
    static int tM;
    static int dM;

    static LinkedList<int[]> linkedList = new LinkedList<int[]>();

    static int yAxis;
    static int xAxis;

    static int byAxis;
    static int bxAxis;

    static Map<String, Integer> slp = new HashMap<String, Integer>();
    static int dist;

    public static int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        } else {
            return Math.abs(gcd(b, a % b));
        }
    }

    public static int answer(int[] dimensions, int[] cap_pos, int[] enemy_pos, int _distance) {

        // Your code goes here.
        dist = _distance;

        Map<String, Integer> caught = new HashMap<String, Integer>();
        Map<String, Integer> allVectors = new HashMap<String, Integer>();

        int widthExtendedEnd = 1 + ((dist + cap_pos[0]) / dimensions[0]);
        int heightExtendedEnd = 1 + ((dist + cap_pos[1]) / dimensions[1]);

        xAxis = cap_pos[0];
        yAxis = cap_pos[1];

        bxAxis = enemy_pos[0];
        byAxis = enemy_pos[1];

        // ====================
        int yDifference = byAxis - yAxis;
        int xDifference = bxAxis - xAxis;
        int differenceGcd = gcd(xDifference, yDifference);
        double differenceD = Math.sqrt(Math.pow(yDifference, 2) + Math.pow(xDifference, 2));

        yDifference /= differenceGcd;
        xDifference /= differenceGcd;

        int count = 0;

        if (dist - differenceD >= 0) {
            count = 1;
            caught.put(bxAxis + "-" + byAxis, 1);
            slp.put(yDifference + "-" + xDifference, differenceGcd);
            allVectors.put(yDifference + "-" + xDifference, 1);
        }

       
        populateHorizontal(xAxis, yAxis, heightExtendedEnd, dimensions, true);
        populateVertical(xAxis, yAxis, heightExtendedEnd, widthExtendedEnd, dimensions, true);

        populateHorizontal(enemy_pos[0], enemy_pos[1], heightExtendedEnd, dimensions, false);
        populateVertical(enemy_pos[0], enemy_pos[1], heightExtendedEnd, widthExtendedEnd, dimensions, false);

       Integer slpX;

        int[] m;

        for (int i = 0; i < linkedList.size(); i++) {

            m = linkedList.get(i);

            if (caught.get(m[0] + "-" + m[1]) == null) {

                yDifference = m[1] - yAxis;
                xDifference = m[0] - xAxis;
                //deltaD = Math.sqrt(Math.pow(yDifference,2) + Math.pow(xDifference,2));
                differenceGcd = gcd(xDifference, yDifference);
                xDifference /= differenceGcd;
                yDifference /= differenceGcd;

                slpX = slp.get(yDifference + "-" + xDifference);
                if (allVectors.get(yDifference + "-" + xDifference) == null) {
                    if (slpX == null) {

                        count++;
                        allVectors.put(yDifference + "-" + xDifference, 1);

                    } else {

                        if (differenceGcd < slpX) {
                            count++;
                            allVectors.put(yDifference + "-" + xDifference, 1);
                        }
                    }
                }
                caught.put(m[0] + "-" + m[1], 1);
            }
        }

        slp.clear();
        linkedList.clear();
        caught.clear();
        allVectors.clear();

        return count;
    }

    public static void putToMap(int currentX, int currentY) {

        int deltaY = currentY - yAxis;
        int deltaX = currentX - xAxis;

        int[] target = {currentX, currentY};

        double deltaD = Math.sqrt(Math.pow(deltaY, 2) + Math.pow(deltaX, 2));

        if (dist - deltaD >= 0) {
            linkedList.add(target);
        }

    }

    public static void putToSlp(int currentX, int currentY) {

        int deltaY = currentY - yAxis;
        int deltaX = currentX - xAxis;
        int deltaGCD = gcd(deltaX, deltaY);

        double deltaD = Math.sqrt(Math.pow(deltaY, 2) + Math.pow(deltaX, 2));

        deltaX /= deltaGCD;
        deltaY /= deltaGCD;

        if (dist - deltaD >= 0) {
            if (slp.get(deltaY + "-" + deltaX) == null) {
                slp.put(deltaY + "-" + deltaX, deltaGCD);
            } else if (deltaGCD < slp.get(deltaY + "-" + deltaX)) // un ?
            {
                slp.put(deltaY + "-" + deltaX, deltaGCD);
            }
        }

    }

    public static void populateVertical(int _currentX, int currentY, int hExtend, int wExtend, int[] dimensions, boolean isHero) {

        if (isHero) {

            rM = dimensions[0] - xAxis;
            lM = xAxis;

        } else {

            rM = dimensions[0] - bxAxis;
            lM = bxAxis;
        }

        int currentX = _currentX;

        for (int i = 1; i <= wExtend; i++) {

            currentX += rM * 2;
            rM = dimensions[0] - rM;

            if (isHero) {
                putToSlp(currentX, currentY);
            } else {
                putToMap(currentX, currentY);
            }

            populateHorizontal(currentX, currentY, hExtend, dimensions, isHero);

        }

        currentX = _currentX;

        for (int i = 1; i <= wExtend; i++) {

            currentX -= lM * 2;
            lM = dimensions[0] - lM;

            if (isHero) {
                putToSlp(currentX, currentY);
            } else {
                putToMap(currentX, currentY);
            }

            populateHorizontal(currentX, currentY, hExtend, dimensions, isHero);

        }

    }

    public static void populateHorizontal(int currentX, int _currentY, int hExtend, int[] dimensions, boolean isHero) {

        if (isHero) {

            tM = dimensions[1] - yAxis;
            dM = yAxis;

        } else {

            tM = dimensions[1] - byAxis;
            dM = byAxis;

        }

        int currentY = _currentY;

        for (int i = 1; i <= hExtend; i++) {

            currentY += tM * 2;
            tM = dimensions[1] - tM;

            if (isHero) {
                putToSlp(currentX, currentY);
            } else {
                putToMap(currentX, currentY);
            }

        }

        currentY = _currentY;

        for (int i = 1; i <= hExtend; i++) {

            currentY -= dM * 2;
            dM = dimensions[1] - dM;

            if (isHero) {
                putToSlp(currentX, currentY);
            } else {
                putToMap(currentX, currentY);
            }
        }

    }
}
