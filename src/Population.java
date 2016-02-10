import Contracts.*;

import java.util.ArrayList;
import java.util.List;

public class Population implements IPopulation{
    private ISelector selector;
    private ICrossOver crossOver;
    private IMutation mutation;
    private IPopulator populator;
    private IFitnessCalculator fitnessCalculator;
    private int generation = 0;
    private List<IEntity> individuals;
    private IEntity fittestEntity;
    private int completeFitness;
    private IRandomNumberGenerator rng = new RandomNumberGenerator();
    private int crossOverCount = 0;
    private int mutationCount = 0;

    public Population(IPopulator populator, IFitnessCalculator fitnessCalculator, ISelector selector, ICrossOver crossOver, IMutation mutation) {
        this.populator = populator;
        this.fitnessCalculator = fitnessCalculator;
        this.selector = selector;
        this.crossOver = crossOver;
        this.mutation = mutation;
    }


    @Override
    public void evaluate() {
        fittestEntity = null;
        completeFitness = 0;

        for(IEntity individual: individuals) {
            int fitness = fitnessCalculator.calculateFitness(individual);
            individual.setFitness(fitness);
            completeFitness += fitness;

            if(fittestEntity == null || fitness < fittestEntity.getFitness()) {
                fittestEntity = individual;
            }
        }

        Logger.logPopulation(this);
    }

    @Override
    public void selectAndAlter() {
        if(individuals.size() <= 1) {
            // we don't have enough individuals left to do a crossover
            return;
        }

        List<IEntity> nextGeneration = new ArrayList<>(individuals.size());
        individuals.sort(new FieldComporator());
        CopyBestEntitiesIntoNextGeneration(nextGeneration);
        AddChildrenToNextGeneration(nextGeneration);
        individuals = nextGeneration;
    }

    public void CopyBestEntitiesIntoNextGeneration(List<IEntity> nextGeneration) {
        int amountOfEntities = (int) (individuals.size() * Configuration.elitismSize);
        for(int i = 0; i < amountOfEntities; i++) {
            nextGeneration.add(individuals.get(i));
        }
    }

    public void AddChildrenToNextGeneration(List<IEntity> nextGeneration) {
        for(int i = 0; i < individuals.size(); i++) {
            if(rng.getRandomNumber() < Configuration.CrossOverProbability) {
                IEntity parent1 = selector.selectEntities(this);
                IEntity parent2 = selector.selectEntities(this);

                IEntity[] children = crossOver.executeCorssOver(parent1, parent2);
                crossOverCount++;

                for(IEntity child: children) {
                    if(nextGeneration.size() < Configuration.MaximumPopulationSize) {
                        if(rng.getRandomNumber() < Configuration.MutationProbability) {
                            mutation.mutateEntity(child);
                            mutationCount++;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void initialize() {
        individuals = populator.populate();
    }

    @Override
    public void increaseGenerationCounter() {
        generation++;
    }

    @Override
    public int getCompleteFitness() {
        return completeFitness;
    }

    @Override
    public int getGeneration() {
        return generation;
    }

    @Override
    public int getNumberOfEntities() {
        return individuals.size();
    }

    @Override
    public int getCrossOverCount() {
        return crossOverCount;
    }

    @Override
    public int getMutationCount() {
        return mutationCount;
    }

    @Override
    public IEntity getFittestEntity() {
        return fittestEntity;
    }

    @Override
    public List<IEntity> getAllEntities() {
        return individuals;
    }
}
