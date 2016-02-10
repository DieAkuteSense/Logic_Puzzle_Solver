import Contracts.IEntity;

import java.util.Comparator;

public class FieldComporator implements Comparator<IEntity> {
    @Override
    public int compare(IEntity o1, IEntity o2) {
        return o1.getFitness() - o2.getFitness();
    }
}
