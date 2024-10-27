package Lection1_Testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String result="";

        int leftX = Integer.parseInt(reader.readLine());
        int bottomY = Integer.parseInt(reader.readLine());

        int rightX = Integer.parseInt(reader.readLine());
        int topY = Integer.parseInt(reader.readLine());

        int manX = Integer.parseInt(reader.readLine());
        int manY = Integer.parseInt(reader.readLine());

        if(manY>topY) result=result.concat("N");
        else if(manY<bottomY) result = result.concat("S");

        if(manX>rightX) result=result.concat("E");
        else if(manX<leftX) result = result.concat("W");

        System.out.println(result);
        reader.close();
    }
}
