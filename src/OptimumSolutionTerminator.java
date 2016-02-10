import Contracts.IPopulation;
import Contracts.ITerminationCriteria;

public class OptimumSolutionTerminator implements ITerminationCriteria {
    private int generationWithLastFitnessIncrease = 0;
    private int bestFitness = Integer.MAX_VALUE;
    private long startTime;

    public OptimumSolutionTerminator() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public boolean shouldTerminate(IPopulation population) {
        int currentGeneration = population.getGeneration();
        int fitnessOfFittestEntity = population.getFittestEntity().getFitness();

        if(currentGeneration > Configuration.MaximumAmountOfGenerations) {
            Logger.log("Stopping program: amount of generations expired!");
            Logger.logFittestEntity(population.getFittestEntity());
            Logger.log("Crossovers: " + population.getCrossOverCount() + " Mutation: " + population.getMutationCount());
            Logger.logTime(startTime, population.getGeneration());
            return true;
        }

        if (fitnessOfFittestEntity < bestFitness) {
            generationWithLastFitnessIncrease = currentGeneration;
            bestFitness = fitnessOfFittestEntity;
        }

        if(currentGeneration - generationWithLastFitnessIncrease > Configuration.MaximumAmountOfGenerationsWithoutFitnessChange) {
            Logger.log("Stopping program: fitness did not increase for the last generations!");
            Logger.logFittestEntity(population.getFittestEntity());
            Logger.log("Crossovers: " + population.getCrossOverCount() + " Mutation: " + population.getMutationCount());
            Logger.logTime(startTime, population.getGeneration());
            return true;
        }

        return false;
    }
}
