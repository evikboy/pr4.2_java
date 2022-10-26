package CharacterCreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dice {
    public static int roll() {
        return  1 + (int) (Math.random() * (6 - 1) + 1);
    }

    public static int rollStat() {
        int tries = 6;
        int max1, max2, max3;
        List<Integer> list = new ArrayList<>(tries);

        for (int i = 0; i < tries; i++) {
            list.add(roll());
        }

        max1 = Collections.max(list);
        list.remove(Integer.valueOf(max1));

        max2 = Collections.max(list);
        list.remove(Integer.valueOf(max2));

        max3 = Collections.max(list);

        return max1 + max2 + max3;
   }
}
