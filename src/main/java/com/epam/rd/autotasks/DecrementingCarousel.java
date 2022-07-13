package com.epam.rd.autotasks;

public class DecrementingCarousel {
    final int capacity;
    int position, currentPosition;
    final int[] values;
    private boolean carouselCondition=false;

    public DecrementingCarousel(int capacity) {
        this.capacity=capacity;
        values=new int[this.capacity];
    }

    public boolean addElement(int element){

        if (!carouselCondition && element>0 && position<capacity ) {
            values[position++] = element;
            return true;
        }

        return false;
    }

    public CarouselRun run(){

        if (carouselCondition)
            return null;

        carouselCondition = true;
        return new CarouselRun(this);
    }

    public int nextResult(){
        if (currentPosition >= capacity)
            currentPosition = 0;

        while (values[currentPosition]==0){
            currentPosition++;
            if (currentPosition >= capacity)
                currentPosition = 0;
        }
        return values[currentPosition++]--;
    }
}