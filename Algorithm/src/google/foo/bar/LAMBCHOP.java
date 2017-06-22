/*
As Commander Lambda's personal assistant, you've been assigned the task of configuring the LAMBCHOP doomsday device's axial orientation gears.
It should be pretty simple - just add gears to create the appropriate rotation ratio. But the problem is, due to the layout of the LAMBCHOP and
the complicated system of beams and pipes supporting it, the pegs that will support the gears are fixed in place.

The LAMBCHOP's engineers have given you lists identifying the placement of groups of pegs along various support beams. You need to place a gear on 
each pegIndex (otherwise the gears will collide with unoccupied pegs). The engineers have plenty of gears in all different sizes stocked up, so you can
choose gears of any size, from a radius of 1 on up. Your goal is to build a system where the last gear rotates at twice the rate (in revolutions per
minute, or rpm) of the first gear, no matter the direction. Each gear (except the last) touches and turns the gear on the next pegIndex to the right.

Given a list of distinct positive integers named pegs representing the location of each pegIndex along the support beam, write a function answer(pegs) which,
if there is a solution, returns a list of two positive integers a and b representing the numerator and denominator of the first gear's radius in its
simplest form in order to achieve the goal above, such that radius = a/b. The ratio a/b should be greater than or equal to 1. Not all support configurations 
will necessarily be capable of creating the proper rotation ratio, so if the task is impossible, the function answer(pegs) should return the list [-1, -1].

For example, if the pegs are placed at [4, 30, 50], then the first gear could have a radius of 12, the second gear could have a radius of 14, and the last one 
a radius of 6. Thus, the last gear would rotate twice as fast as the first one. In this case, pegs would be [4, 30, 50] and answer(pegs) should return [12, 1].

The list pegs will be given sorted in ascending order and will contain at least 2 and no more than 20 distinct positive integers, all between 1 and 10000 inclusive.

 */
package google.foo.bar;

/**
 *
 * @author Tesfay
 */
public class LAMBCHOP {

    public static int[] answer(int[] pegs) {
        int maxRadius = pegs[1] - pegs[0] - 1;
        int length = pegs.length;
        for (int firstGearRadius = 1; firstGearRadius <= maxRadius; firstGearRadius++) {
            int[] allGearsRadius = new int[length];
            boolean illegalRadiusFound = false;
            allGearsRadius[0] = firstGearRadius;
            for (int pegIndex = 1; pegIndex < length; pegIndex++) {
                int covered = (pegs[pegIndex - 1] + allGearsRadius[pegIndex - 1]);
                int currentPegLoc = pegs[pegIndex];
                if ((currentPegLoc - covered) <= 0) {
                    illegalRadiusFound = true;
                    break;
                }
                allGearsRadius[pegIndex] = currentPegLoc - covered;
            }

            if (illegalRadiusFound) {
                continue;
            }

            int lastGearRadius = allGearsRadius[length - 1];
            if (firstGearRadius == 2 * lastGearRadius) {
                return new int[]{firstGearRadius, 1};
            }

            if (firstGearRadius + 1 == 2 * lastGearRadius) {
                return new int[]{(firstGearRadius * 3) + 1, 3};
            }

            if (firstGearRadius + 2 == 2 * lastGearRadius) {
                return new int[]{(firstGearRadius * 3) + 2, 3};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        //Output:    (int list) [12, 1]
        int[] result = LAMBCHOP.answer(new int[]{4, 30, 50});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        //Output:    (int list) [-1, -1]
        result = LAMBCHOP.answer(new int[]{4, 17, 50});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
