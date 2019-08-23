package com.beifangfazhanlu.shengsheng;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.util.stream.IntStream;

public class Bit {
    public static void main(String[] args) {
        //打印 ASCII 字符集

        System.out.println("====================================打印 ASCII 字符集=========================================");
        char index = 0;
        String s = "";
        while (index < 128){
            s += " ";
            s += index;
            index++;

        }

        System.out.println("ASCII 字符集序列： " + s);

        index = 0;
        s = "";
        while (index < 128){
            s += " ";

            byte[] b = new byte[2];
            b[0] = (byte) ((index & 0xFF00) >> 8);
            b[1] = (byte) (index & 0xFF);
            String hex = HexBin.encode(b);
            s += index;
            s += " - [" + hex + "]";
            index++;
        }


        System.out.println("ASCII 字符集序列(16进制编码)： " + s);
        System.out.println("ASCII 字符集序列(2进制编码)： ");

        index = 0;
        s = "";
        while (index < 128){
            s += " ";
            int i = (int)index;
            String hint = HexBin.encode(Integer.valueOf(i).toString().getBytes());
            byte[] b = new byte[2];
            b[0] = (byte) ((index & 0xFF00) >> 8);
            b[1] = (byte) (index & 0xFF);
            String hex = HexBin.encode(b);
            System.out.println( hint + "   -  " + i +  "   -  " + index + "  -  " + byteToBit(b[0]) + "  " + byteToBit(b[1]) + "  -  " + hex);
            s += index;
            index++;
        }
        System.out.println("====================================打印 UNICODE 字符集=========================================");
        IntStream.range(0, 19000)
                .mapToObj(i -> "Char: " + i + " ==> " + new String(Character.toChars(i)))
                .forEach(System.out::println);

        index = 0;
        s = "";
        while (index <19000){
           s= new String(Character.toChars(index));
            System.out.println(s.getBytes());
            System.out.println(s);
            String hex = HexBin.encode(s.getBytes());
            System.out.println(hex);
            index++;
        }

    }

    public static String byteToBit(byte b) {
        return ""
                + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
                + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
                + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
                + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
    }
}
