package com.company;

import java.io.*;

public class ReaderWriterExample {

    public static void main(String[] args) throws IOException {
        //Input/Output Stream

        //IOException
        //FileNotFoundException
        //MalformedURLException -> http@google.com вместо http://google.com

        //1. Reader/Writer
        //2. Try with resources

        //Audio|Video|File|Object|ByteArray InputStream     --> по байтовое чтение (byte[])
        //Audio|Video|File|Object|ByteArray OutputStream    --> побайтовая запись (byte[])

        //Audio|Video|File|Object|ByteArray Reader      --> читает в строку/массив char (char[])
        //Audio|Video|File|Object|ByteArray Writer      --> записывает в строку/массив char (char[])

        //char []
        Reader reader = new FileReader(new File("file.txt"));

        //String
        BufferedReader bufferedReader = new BufferedReader(reader);

//        System.out.println(bufferedReader.readLine());
//        System.out.println(bufferedReader.readLine());
//        System.out.println(bufferedReader.readLine());
//        System.out.println(bufferedReader.readLine());

        String line = "";
        StringBuilder builder = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null) {
            builder.append(line);
            builder.append("\n");
        }

        //char [] / String
        Writer writer = new FileWriter(new File("file_writer.txt"));

//        BufferedWriter bufferedWriter = new BufferedWriter(writer);
//        bufferedWriter.write("1. Text from Java");
//        bufferedWriter.newLine();
//        bufferedWriter.write("2. Text from Java\n");
//        bufferedWriter.write("3. Text from Java");
//
//        bufferedWriter.flush();
//        bufferedWriter.close();


        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println("Hello");
        printWriter.flush();
        printWriter.close();



//        while (true) {
//            String currentLine = bufferedReader.readLine();
//
//            if (currentLine == null) {
//                break;
//            }
//            builder.append(currentLine);
//            builder.append("\n");
//        }
        System.out.println(builder.toString());


    }

    private static void legacy() throws IOException {


        //Это мой текст
        //??? ??? ?????


        InputStream is = new FileInputStream(new File("file.txt"));
        byte [] buffer = new byte[1000];

        while (is.available() > 0) {
            //byte by byte
//            is.read();

            //read the entire data
            is.read(buffer);
        }
        is.close();

        System.out.println(new String(buffer));
    }
}
