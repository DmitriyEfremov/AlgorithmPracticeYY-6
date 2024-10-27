package Lection1_Testing;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int blueT = Integer.parseInt(reader.readLine());
        int redT = Integer.parseInt(reader.readLine());
        int blueS = Integer.parseInt(reader.readLine());
        int redS = Integer.parseInt(reader.readLine());


        int res1 = 0;
        int res2 = 0;
        boolean isBlueTMajority = blueT > redT;
        boolean isBlueSMajority = blueS > redS;




        if(blueT==redT){
            res1=blueT+1;
            res2=1;
        }
        else if(blueS==redS)
        {
            res2=blueS+1;
            res1=1;
        }else {
            if ((blueT == 0 || redT == 0) && (blueS == 0 || redS == 0)) {
                res1 = 1;
                res2 = 1;
            } else if (blueT != 0 && redT != 0 && blueS != 0 && redS != 0) {
                if (isBlueSMajority == isBlueTMajority) {
                    res1 = Math.min(blueT, redT) + 1;
                    res2 = Math.min(blueS, redS) + 1;
                } else {
                    if (blueT + blueS < redT + redS) {
                        res1 = (blueT + 1);
                        res2 = (blueS + 1);
                    } else {
                        res1 = (redT + 1);
                        res2 = (redS + 1);
                    }
                }
                if(Math.max(redT,blueT)+2<res1+res2)
                {
                    res1=Math.max(redT,blueT)+1;
                    res2=1;
                }
                if(Math.max(redS,blueS)+2<res1+res2) {

                    res1=1;
                    res2=Math.max(redS,blueS)+1;
                }
            } else if (blueT == 0 || redT == 0) {
                if (isBlueTMajority) {
                    res1 = 1;
                    res2 = redS + 1;

                } else {
                    res1 = 1;
                    res2 = blueS + 1;
                }
            } else {
                if (isBlueSMajority) {
                    res1 = redT + 1;
                    res2 = 1;
                } else {
                    res1 = blueT + 1;
                    res2 = 1;
                }
            }
        }

        System.out.println(res1+" "+res2);
        reader.close();
    }
}
