package com.example.ioscalculator;

public class stack {
    private int top;
    private int size;
    private double[] array;

    // Constructor
    public stack(int capacity) {
        size = capacity;
        array = new double[size];
        top = -1; // Stack is initially empty
    }

    public void push(double value) {
        if (top == size - 1) {
            return;
        }
        top++;
        array[top] = value;
    }
    public double pop() {
        if (top == -1) {

            return Double.NaN; // Return NaN (Not a Number) indicating stack underflow
        }
        double poppedValue = array[top];
        top--;
        return poppedValue;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == size - 1;
    }

}
