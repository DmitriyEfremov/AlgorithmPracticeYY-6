package Lection1_Testing;

import java.io.*;
import java.util.ArrayList;

public class Task3 {

    static char[][] map;
    static ArrayList<Rect> innerRect = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Rect rect = new Rect(0,0,0,0);
        map = new char[n][];
        boolean isPlain=true;
        for(int iter=0;iter<n;iter++){
            String inp = reader.readLine();
            map[iter]= inp.toCharArray();
            if (inp.contains("#")){
                isPlain=false;
            }
        }


       out: for(int i=0;i<n;i++){
           rect.top=i;
           for(char ch: map[i]){
               if(ch=='#'){
                   break out;
               }
           }
       }
        out: for(int i=n-1;i>=0;i--){
            rect.bottom=i;
            for(char ch: map[i]){
                if(ch=='#'){
                    break out;
                }
            }
        }
        out: for(int i=0;i<n;i++){
            rect.left=i;
            for(int j=0;j<n;j++){
                if(map[j][i]=='#'){
                    break out;
                }
            }
        }
        out: for(int i=n-1;i>=0;i--){
            rect.right=i;
            for(int j=0;j<n;j++){
                if(map[j][i]=='#'){
                    break out;
                }
            }
        }
int cnt=0;
        for (int vert = rect.bottom; vert >= rect.top ; vert--) {
            for (int horiz= rect.left;horiz<=rect.right;horiz++){
                if(map[vert][horiz]=='.'){
                    cnt++;
                    int[] cur = new int[]{vert,horiz};
                    while(vert-1 >= rect.top && map[vert-1][horiz]=='.'){
                        vert--;
                    }
                    while(horiz+1 <= rect.right && map[vert][horiz+1]=='.'){
                        horiz++;
                    }
                        Rect additional = new Rect(cur[1],cur[0],horiz,vert);
                    if(isFullyBlack(additional))
                        innerRect.add(additional);
                }
            }
        }
        if(innerRect.isEmpty()&&cnt==0 && !isPlain){
            System.out.println("I");
        }else if(innerRect.size()==1){
            Rect inner = innerRect.get(0);
            if(inner.left!=rect.left && inner.bottom!=rect.bottom) {
                if (inner.top == rect.top && inner.right == rect.right) {
                    System.out.println("L");
                } else if (inner.top > rect.top) {
                    if (inner.right < rect.right) {
                        System.out.println("O");
                    } else {
                        System.out.println("C");
                    }
                }else{
                    System.out.println("X");
                }
            }
            else{
                System.out.println("X");
            }
        }
        else if(innerRect.size()==2){
            Rect lower = innerRect.get(0);
            Rect upper = innerRect.get(1);
            if(lower.left!=upper.left ||lower.left==rect.left || lower.bottom!=rect.bottom){
                System.out.println("X");
            }else if(upper.top != rect.top &&upper.right< lower.right &&lower.right==rect.right){
                System.out.println("P");
            }else if(upper.top==rect.top &&upper.right!=rect.right &&upper.right==lower.right){
                System.out.println("H");
            }else{
                System.out.println("X");
            }
        }
        else{
            System.out.println("X");
        }
    }

    static boolean isFullyBlack(Rect r){
        for(int i=r.top;i<=r.bottom;i++){
            for(int j=r.left;j<=r.right;j++){
                if(map[i][j]=='#'){
                    return false;
                }
            }
        }
        return true;
    }
}
class Rect{
    int top, bottom ,right, left;
    public Rect(int left, int bottom,int right, int top){
        this.left=left;
        this.right=right;
        this.top=top;
        this.bottom=bottom;
    }
}
