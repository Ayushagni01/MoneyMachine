package com.learning.demo.Java.coding;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZero {
    public static void main(String[] args) {
        int a [][] = {{0,1,2,0},{3,0,5,2},{1,3,1,5}};
        //worst solution
        //worstSolutionComplexityWise(a);
        //betterThan worst solution
       // betterThanWorstSolution(a);
        //optimal solution
        optimal(a);


        printMatrix(a);


    }

    //Time: o(m*n)
    //Space: o(m+n)
    private static void betterThanWorstSolution(int[][] a) {
        int[] rowArray = new int[a.length];
        int[] colArray = new int[a[0].length];
        //traverse
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j] == 0) {
                    rowArray[i] = 1;
                    colArray[j] = 1;
                }
            }
        }

        //now transform the array
        for ( int i  = 0 ; i < rowArray.length ; i++) {
            if(rowArray[i] == 1) {
                for (int y = 0; y  < a[0].length ; y++ ){
                    a[i][y] = 0;
                }
            }
        }

        for ( int i  = 0 ; i < colArray.length ; i++) {
            if(colArray[i] == 1) {
                for (int y = 0; y  < a.length ; y++ ){
                    a[y][i] = 0;
                }
            }
        }
    }


    //Time: o(m*n)
    //Space: o(1)
    private static void optimal(int[][] a) {
        //traverse
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[i].length; j++) {
               if(a[i][j] == 0) {
                   a[i][0] = 0;
                   a[0][j] = 0;
               }
            }
            System.out.println();
        }

        //now transform the array
        for ( int i  = 0 ; i < a.length ; i++) {
            if(a[i][0] == 0) {
                for (int y = 0; y  < a[0].length ; y++ ){
                    if(a[i][y] != 0) {
                        a[i][y] = Integer.MAX_VALUE;
                    }
                }
            }
        }
//
        for ( int i  = 0 ; i < a[0].length ; i++) {
            if(a[0][i] == 0) {
                for (int y = 0; y  < a.length ; y++ ){
                    if(a[y][i] != 0) {
                        a[y][i] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
            if(a[i][j] == Integer.MAX_VALUE){
                a[i][j] = 0;
            }
            }
            }
    }

    private static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Time : o(mn) + (o(m*n) * (om+n))
    //Space : o(m*n)
    private static void worstSolutionComplexityWise(int[][] a) {
        List<Pair> alist = new ArrayList<>();
        for(int i = 0; i < a.length ; i++ ) {
            for (int j = 0; j < a[0].length; j++){
                if( a[i][j] == 0 ) {
                  alist.add(new Pair(i,j));
                }
            }
        }

        for( int i = 0; i < alist.size() ; i++){

         //right
            int right = alist.get(i).y;
            int xX = alist.get(i).x;
          while (  right <= a.length-1 ) {
              System.out.println("ayush");
              if(a[xX][right] != 0 ) {
                  a[xX][right] = -1;
              }
             right = right + 1;
          }

          //left
            int leftX = alist.get(i).y;
            int yY = alist.get(i).x;
            while (  leftX >=0  ) {
                System.out.println("agnihotri");
                if(a[yY][leftX] != 0) {
                    a[yY][leftX] = -1;
                }
                leftX = leftX - 1;
            }
         //up and down
            //down
            int down = alist.get(i).x;
            int yYY = alist.get(i).y;
            while (  down <= a.length-1 ) {
                System.out.println("ayush");
                if(a[down][yYY] != 0 ) {
                    a[down][yYY] = -1;
                }
                down = down + 1;
            }

            //up
            int up = alist.get(i).x;
            int xXX = alist.get(i).y;
            while (  up >= 0) {
                System.out.println("ayush");
                if(a[up][xXX] != 0 ) {
                    a[up][xXX] = -1;
                }
                up = up - 1;
            }
        }

        //retransform :
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j] == -1) {
                    a[i][j] = 0;
                }
            }
        }
    }

    static class Pair {
        int x,y;
        public Pair (int x, int y){
           this.x = x;
           this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
