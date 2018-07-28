package com.company;

import java.io.*;

public class TryWithResourcesExample {

    public static void main(String[] args) {

        //TRY-WITH-RESOURCES - автоматический вызов метода close у тех, кого мы объявили в блоке try with resources
        //try (      here your readers/writers/input streams/output stream       ) {
        //
        //
        //} catch (IOException e) {
        //
        //}



        try (Writer writer = new FileWriter(new File("try-with-resources.txt"));
             PrintWriter printWriter = new PrintWriter(writer);
             MyClass myClass = new MyClass()) {

            //way 2
//            if (true) {
//                throw new RuntimeException();
//            }
            //Exception?
            printWriter.println("line 1");
            printWriter.println("line 2");
            printWriter.println(myClass.getWord());
            printWriter.println("end");
            //Database connection?
            //Server request?
            //"1" -> Integer.parseInt("1") : Integer.parseInt("a")
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void before() {
        Writer writer = null;
        try {
            writer = new FileWriter(new File("non-try-with-resources.txt")); //IO EXCEPTION HERE

            PrintWriter printWriter = new PrintWriter(writer); //Exception?
            printWriter.println("line 1");
            printWriter.println("line 2");
            printWriter.println("end");
            //Database connection?
            //Server request?
            //"1" -> Integer.parseInt("1") : Integer.parseInt("a")
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {

                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}


class MyClass implements AutoCloseable {
    public String getWord() {
        return "word";
    }

    @Override
    public void close() {
        System.out.println("MyClass.close()");
    }
}