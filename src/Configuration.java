public class Configuration {
    public static final int startPopulation = 50;
    public static final double MutationProbability = 0.1;
    public static final double CrossOverProbability = 0.8;
//    public static final SelectionMode selectionMode = SelectionMode.RouletteWheelSelection;
//    public static final CrossOverMode crossOverMode = CrossOverMode. ;
//    public static final MutationMode mutationMode = MutationMode. ;
    public static final int MaximumAmountOfGenerations = 1000000;
    public static final int bestKnownOptimum = 509;
    public static final int MaximumAmountOfGenerationsWithoutFitnessChange = 3000;
    public static final int amountOfGenes = 100; // TODO should be HEIGHT_WIDTH * HEIGHT_WIDTH
    public static final double elitismSize = 0.04;
    public static final int MaximumPopulationSize = 50;
}
