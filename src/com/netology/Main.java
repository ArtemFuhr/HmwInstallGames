package com.netology;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        List<String> path = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        FileWriter out = null;
        File fileTemp = null;
        path.add("C:\\Gamess\\src\\main");
        path.add("C:\\Gamess\\src\\test");
        path.add("C:\\Gamess\\res\\drawables");
        path.add("C:\\Gamess\\res\\vectors");
        path.add("C:\\Gamess\\res\\icons");
        path.add("C:\\Gamess\\savegames");
        path.add("C:\\Gamess\\temp");

        try {
            for (String s : path) {
                File file = new File(s);
                if (file.mkdirs()) {
                    writeLog(temp, file, true);
                    if (s.equals("C:\\Gamess\\temp")) {
                        fileTemp = new File(s + "\\temp.txt");
                        if (fileTemp.createNewFile()) {
                            writeLog(temp, fileTemp, true);
                        } else {
                            writeLog(temp, fileTemp, false);
                        }
                        out = new FileWriter(s + "temp.txt");
                    }
                } else {
                    writeLog(temp, file, false);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (fileTemp != null) {
                if (out != null) {
                    out.write(temp.toString());
                    out.close();
                }
            } else {
                System.out.println(temp);
            }
        }
    }
    private static void writeLog(StringBuilder temp, File file, boolean b) {
                    temp.append("\n")
                            .append(b ? " " : "Error")
                            .append(file.isDirectory() ? "Dir " : "File")
                            .append(file.getAbsolutePath())
                            .append(b ? " - created" : " - not created");
                }
            }
