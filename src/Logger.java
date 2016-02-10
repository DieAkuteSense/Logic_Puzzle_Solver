import Contracts.IEntity;
import Contracts.IPopulation;

import java.text.DecimalFormat;
import java.util.List;

public class Logger {

    private static DecimalFormat decimalFormat = new DecimalFormat("00.00000");

    public static void log(String logMessage) {
        System.out.println(logMessage);
    }

    public static void logFittestEntity(IEntity entity) {
        System.out.println("Fittest entity => fitness: " + entity.getFitness());

        StringBuilder builder = new StringBuilder();
        List<Integer> genes = entity.getGenes();

        for (Integer gene : genes) {
            builder.append(gene).append(",");
        }

        System.out.println("Genes: " + builder.toString());
    }

    public static void logPopulation(IPopulation population) {
        int generation = population.getGeneration();
        int count = population.getAllEntities().size();
        int completeFitness = population.getCompleteFitness();
        IEntity fittestEntity = population.getFittestEntity();

        if (fittestEntity == null) {
            System.out.println("Population died. Could not evaluate best entity...");
            return;
        }

        int maxFitness = fittestEntity.getFitness();
        String relativeFitness = decimalFormat.format(((double) Configuration.bestKnownOptimum / maxFitness) * 100) + "%";


        System.out.println("GEN: " + generation + " Count: " + count + " Complete Fitness: " + completeFitness + " fittest Entity: " + maxFitness + " solution quality: " + relativeFitness);

    }

    public static void logTime(long startTime, int generation) {

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        double durationInSeconds = (double) duration / 1000;
        double durationPerGeneration = (double) generation / duration;

        System.out.println("Completed in: " + durationInSeconds + " sec   Average time per generation: " + durationPerGeneration + " ms");
    }
}
