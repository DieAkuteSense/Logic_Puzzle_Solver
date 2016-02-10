import Contracts.IRandomNumberGenerator;

public class RandomNumberGenerator implements IRandomNumberGenerator {
    private static MersenneTwister mt = null;

    public RandomNumberGenerator(){
        if(mt == null){
            mt = new MersenneTwister(System.currentTimeMillis());
        }
    }

    @Override
    public double getRandomNumber() {
        return mt.nextDouble();
    }

    @Override
    public int nextInt(int minimum, int maximum) {
        return mt.nextInt(minimum, maximum);
    }

    @Override
    public int nextInt(int maximum) {
        return mt.nextInt(maximum);
    }
}
