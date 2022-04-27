package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadStack extends Stack<Object> {

    /**
     * static method opens a file whose path is passed to it as parameter and
     * reads list of numbers from a file and push it to the stack
     *
     * @param fileName
     * @return the data in object of type Stack
     */
    public static Stack load(String fileName) {
        //using Scanner Class to read File 
        Scanner sc;
        //Creates a new File instance by converting the given pathname string into an abstract pathname.
        File file = new File(fileName);
        //create a stack object to assign the data in the file in the object
        Stack st = new Stack();
        //try to open file
        try {
            sc = new Scanner(file);
        } //throw FileNotFoundException if there is no file 
        catch (FileNotFoundException e) {
            System.out.println("Opps! , Could not open file");
            return st;
        }
        //while there is another input of this scanner
        while (sc.hasNext()) {
            //push the value to Stack
            st.push(Integer.parseInt(sc.next()));
        }
        //close the file reading (close Scanner)
        sc.close();
        //return an object of type Stack contains the data in the file
        return st;
    }
}
