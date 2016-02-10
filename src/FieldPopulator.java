import Contracts.IEntity;
import Contracts.IPopulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FieldPopulator implements IPopulator {
    private final int startPopulation;
    private Integer[] fieldsToFill = null;
    private RandomNumberGenerator rng = new RandomNumberGenerator();

    public FieldPopulator(int startPopulation) {
        this.startPopulation = startPopulation;
        int amountOfGenes = Configuration.amountOfGenes;
        this.fieldsToFill = new Integer[amountOfGenes];
        for(int i = 0; i < fieldsToFill.length; i++) {
            fieldsToFill[i] = i;
        }
    }

    @Override
    public List<IEntity> populate() {
        List<IEntity> population = new ArrayList<>(startPopulation);
        for(int i = 0; i < startPopulation; i++) {
            IEntity fieldToAdd = new Field();
            List<Integer> genes = createGenes();
            fieldToAdd.setGenes(genes);
            population.add(fieldToAdd);
        }
        return population;
    }

    private List<Integer> createGenes() {
        Shuffle.ShuffleArray(fieldsToFill, rng);
        return getListOfFieldsToFill();
    }

    private List<Integer> getListOfFieldsToFill() {
        List<Integer> genes = new ArrayList<>(fieldsToFill.length);
        Collections.addAll(genes, fieldsToFill);
        return genes;
    }
}
