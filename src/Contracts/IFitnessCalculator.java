package Contracts;

import java.util.List;

public interface IFitnessCalculator {
    int calculateFitness(IEntity entity);
    int calculateFitness(List<Integer> integerList);
}
