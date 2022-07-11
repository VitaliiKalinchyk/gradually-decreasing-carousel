package com.epam.rd.autotasks;

public class CarouselRun {
    private final DecrementingCarousel carousel;
    private int currentPosition=0, increasingCoefficient=1;

    public CarouselRun(DecrementingCarousel carousel) {
        this.carousel=carousel;
    }

    public int next() {
        if (isFinished())
            return -1;

        if (currentPosition >= carousel.capacity) {
            currentPosition = 0;
            increasingCoefficient++;
        }

        while (carousel.values[currentPosition] < 1){
            currentPosition++;
            if (currentPosition >= carousel.capacity) {
                currentPosition = 0;
                increasingCoefficient++;
            }
        }
        if (carousel instanceof GraduallyDecreasingCarousel) {
            int temporary = carousel.values[currentPosition];
            carousel.values[currentPosition++] -= increasingCoefficient;
            return temporary;
        }
        return carousel.values[currentPosition++]--;
    }

    public boolean isFinished() {
        for (int i:carousel.values) {
            if (i>0)
                return false;
        }
        return true;
    }
}

