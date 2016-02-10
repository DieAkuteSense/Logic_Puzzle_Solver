import Contracts.IEntity;
import Contracts.IPopulation;
import Contracts.ISelector;

import java.util.ArrayList;
import java.util.List;

public class RouletteWheelSelection implements ISelector {
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private int currentGeneration = 0;
    private List<IEntity> allEntities;
    private List<Double> entityProbabilities = new ArrayList<>();

    @Override
    public IEntity selectEntities(IPopulation population) {
        if(population.getGeneration() > currentGeneration) {
            calculateProbabilities(population);
            currentGeneration++;
        }

        double randomNumber = randomNumberGenerator.getRandomNumber();

        int index = 0;
        while(entityProbabilities.get(index) < randomNumber) {
            index++;
        }

        return allEntities.get(index);
    }

    private void calculateProbabilities(IPopulation population) {
        allEntities = population.getAllEntities();
        entityProbabilities.clear();
        double sum = 0.0;

        for(int i = 0; i < allEntities.size() - 1; i++) {
            double probability = (double) allEntities.get(i).getFitness() / population.getCompleteFitness();
            probability = Math.round(probability * 1000000.0) / 1000000.0;
            sum += probability;
            entityProbabilities.add(sum);
        }
        entityProbabilities.add(1.0);
    }
}
