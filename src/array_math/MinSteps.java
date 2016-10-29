package array_math;

import java.util.ArrayList;

/**
 * Created by bhargav on 10/28/16.
 */
public class MinSteps {

    /*
    You are in an infinite 2D grid where you can move in any of the 8 directions :

 (x,y) to
    (x+1, y),
    (x - 1, y),
    (x, y+1),
    (x, y-1),
    (x-1, y-1),
    (x+1,y+1),
    (x-1,y+1),
    (x+1,y-1)
You are given a sequence of points and the order in which you need to cover the points.
Give the minimum number of steps
in which you can achieve it. You start from the first point.

Example :

Input : [(0, 0), (1, 1), (1, 2)]
Output : 2
It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).

     */


    public static void main(String[] args) {

        MinSteps minSteps = new MinSteps();

        ArrayList<Integer> x = new ArrayList<>();
        x.add(0);
        x.add(1);
        x.add(2);

        ArrayList<Integer> y = new ArrayList<>();
        y.add(0);
        y.add(1);
        y.add(2);

        System.out.println(minSteps.coverPoints(x, y));

    }

    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {

        int steps = 0;
        int size = X.size();

        if (size == 0) {
            return 0;
        }


        /* Logic:
        In order to find the minimum steps taken to reach from point A to point B:
        Minimum would be possible only if one takes the maximum diagonal steps.

        To reach from (0,0) to (5,9), min steps would be taken if one travels from (0,0) to (5,5)
        And then vertically travels from (5,5) to (5,9).

        So, the minimum steps would be, max(horizontal-distance, vertical-distance)
        */
        for (int i = 1; i < size; i++) {

            int x_diff = Math.abs(X.get(i) - X.get(i - 1));
            int y_diff = Math.abs(Y.get(i) - Y.get(i - 1));

            steps += Math.max(x_diff, y_diff);

        }

        return steps;

    }

}
