package com.company;

import java.util.EmptyStackException;
import java.util.Vector;

public class Stack<type> extends Vector<type> {

    public Stack() {
    }

    public type push(type item) {
        addElement(item);
        return item;
    }


    public type pop() {
        //EmptyStackException is an error we throw if the stack is empty
        if (elementCount == 0) {
            throw new EmptyStackException();
        }

        type topElement = (type) elementData[--elementCount];

        // Set topMost element to null to assist the gc(garbage collector) in cleanup.
        elementData[elementCount] = null;

        return topElement;
    }


    public type peek() {
        //EmptyStackException is an error we throw if the stack is empty         
        if (elementCount == 0) {
            throw new EmptyStackException();
        }

        return (type) elementData[elementCount - 1];
    }


    @Override
    public boolean isEmpty() {
        return elementCount == 0;
    }


    public int getsize() {
        return elementCount;
    }

    public Stack<Integer> sortAscending(Stack<Integer> input) {
        //copy the original stack and sort the copied
        Stack<Integer> copy = new Stack<>();
        for (int i = 0; i < input.getsize(); i++) {
            copy.push(input.get(i));
        }

        //create temp Stack to sort the items in it
        Stack<Integer> tmpStack = new Stack<>();
        while (!copy.isEmpty()) {
            // pop out the first element 
            int tmp = copy.pop();

            // while temporary stack is not empty and 
            // top of stack is greater than temp 
            while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
                // pop from temporary stack and  
                // push it to the input stack 
                copy.push(tmpStack.pop());
            }


            tmpStack.push(tmp);
        }
        return tmpStack;
    }
}
