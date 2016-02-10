package Contracts;

public interface IRandomNumberGenerator {
    double getRandomNumber();
    int nextInt(int minimum, int maximum);
    int nextInt(int maximum);
}
