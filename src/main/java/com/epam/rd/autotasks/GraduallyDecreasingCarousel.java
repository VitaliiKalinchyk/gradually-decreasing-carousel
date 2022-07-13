package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    private int increasingCoefficient = 1;
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }
    @Override
    public int nextResult() {
        if (currentPosition >= capacity) {
            currentPosition = 0;
            increasingCoefficient++;
        }

        while (values[currentPosition] < 1) {
            currentPosition++;
            if (currentPosition >= capacity) {
                currentPosition = 0;
                increasingCoefficient++;
            }
        }
            int temporary = values[currentPosition];
            values[currentPosition++] -= increasingCoefficient;
            return temporary;
    }
}
