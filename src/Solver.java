import Contracts.*;

public class Solver {

    /**
     * Matrikel
     * 2525388
     */

    private int HEIGHT_WIDTH = 10;

    int[][] field = new int[HEIGHT_WIDTH][HEIGHT_WIDTH];

    public static void main(String[] args) {
        System.out.println("Solver for problem: \"Neighbours\"\n\n");

        ITerminationCriteria terminationCriteria = new OptimumSolutionTerminator();
        IFitnessCalculator fitnessCalculator = new FitnessCalculator();
        IPopulator populator = new FieldPopulator(Configuration.startPopulation);

        ISelector selector = new RouletteWheelSelection();
        ICrossOver crossOver = new CrossOver();
        IMutation mutator = new Mutation();

        IPopulation population = new Population(populator, fitnessCalculator, selector, crossOver, mutator);

        population.initialize();
        population.evaluate();

        while(!terminationCriteria.shouldTerminate(population)) {
            population.increaseGenerationCounter();
            population.selectAndAlter();
            population.evaluate();
        }
    }

    public int getHEIGHT_WIDTH() {
        return HEIGHT_WIDTH;
    }
}
