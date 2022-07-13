package com.epam.rd.autotasks;

public class CarouselRun {
    private final DecrementingCarousel carousel;

    public CarouselRun(DecrementingCarousel carousel) {
        this.carousel=carousel;
    }

    public int next() {
        if (isFinished())
            return -1;
        return carousel.nextResult();
    }

    public boolean isFinished() {
        for (int i:carousel.values) {
            if (i>0)
                return false;
        }
        return true;
    }
}