package Contracts;

import java.util.List;

public interface IEntity {
    List<Integer> getGenes();
    void setGenes(List<Integer> genes);
    void setFitness(int fitness);
    int getFitness();
}
