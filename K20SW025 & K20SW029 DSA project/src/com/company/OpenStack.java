package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OpenStack extends Stack<Object> {

    public static Stack load(File file) {
        //using Scanner Class to read File 
        Scanner sc = null;

        //try to open file
        try {
            sc = new Scanner(file);
        } //throw FileNotFoundException if there is no file 
        catch (FileNotFoundException e) {
            //  System.out.println("Opps! , Could not open file");
        }

        //create a stack object to assign the data in the file in the object
        Stack st = new Stack();

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
