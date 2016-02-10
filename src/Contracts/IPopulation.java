package Contracts;

import java.util.List;

public interface IPopulation {
    void evaluate();
    void selectAndAlter();
    void initialize();
    void increaseGenerationCounter();
    int getCompleteFitness();
    int getGeneration();
    int getNumberOfEntities();
    int getCrossOverCount();
    int getMutationCount();
    IEntity getFittestEntity();
    List<IEntity> getAllEntities();
}
