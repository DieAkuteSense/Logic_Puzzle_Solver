import Contracts.IEntity;

import java.util.List;

public class Field implements IEntity {
    private List<Integer> genes;
    private int fitness = Integer.MAX_VALUE;

    @Override
    public List<Integer> getGenes() {
        return genes;
    }

    @Override
    public void setGenes(List<Integer> genes) {
        this.genes = genes;
    }

    @Override
    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    @Override
    public int getFitness() {
        return fitness;
    }
}
