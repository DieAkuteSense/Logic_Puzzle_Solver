package Contracts;

public interface ITerminationCriteria {
    boolean shouldTerminate(IPopulation population);
    /**
     * Criteria:
     * - a solution is found
     * - fixed number of generations reached
     * - the highest rankin solution's fitness is reaching or has reached a plateau such that successive iterations longer produce better results
     */
}
