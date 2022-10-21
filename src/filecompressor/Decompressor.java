/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filecompressor;

import java.io.*;
import java.util.zip.GZIPInputStream;
public class Decompressor {
    public static void main(String [] args) throws IOException {
        File file = new File("G:\\newww.gz");
        method(file);
    }
    public static void method(File file) throws IOException {
        String fileDir = file.getParent();
        System.out.print(fileDir);
        FileInputStream in = new FileInputStream(file);
        FileOutputStream out = new FileOutputStream(fileDir + "\\DCompressed.txt");
        GZIPInputStream zip = new GZIPInputStream(in);
        
        byte [] read = new byte [1024];
        int len = 0;
        while((len = zip.read(read)) != -1) {
            out.write(read, 0, len);
        }
        zip.close();
        in.close();
        out.close();
    }
}
