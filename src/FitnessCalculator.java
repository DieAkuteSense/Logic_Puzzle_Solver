import Contracts.IEntity;
import Contracts.IFitnessCalculator;

import java.util.List;

public class FitnessCalculator implements IFitnessCalculator{


    @Override
    public int calculateFitness(IEntity entity) {
        return this.calculateFitness(entity.getGenes());
    }

    @Override
    public int calculateFitness(List<Integer> integerList) { // TODO Die Integer Liste ist bei mir wahrscheinlich später ein Array, das das Spielfeld abbildet...
        int calculatedFitness = 0;
        // TODO implement fitness function
        // vielleicht die Anzahl richtiger Felder

        return calculatedFitness;

        // Testing Git connection
    }
}
