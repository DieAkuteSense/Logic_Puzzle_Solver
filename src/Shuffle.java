import Contracts.IRandomNumberGenerator;

import java.util.List;

public class Shuffle {

    public static void ShuffleArray(Integer[] array, IRandomNumberGenerator rng)
    {
        for (int i = array.length - 1; i > 0; i--)
        {
            int index = rng.nextInt(i + 1);
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
    }

    public static void ShuffleList(List<Integer> list, IRandomNumberGenerator rng){

        for (int i = list.size() - 1; i > 0; i--)
        {
            int index = rng.nextInt(i + 1);
            int a = list.get(index);
            list.set(index,i);
            list.set(i,a);
        }

    }

}