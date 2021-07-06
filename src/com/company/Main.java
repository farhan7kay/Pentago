package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of first player");
        String name1 = scan.next();
        /**Creat a Player object. First and second must be supplied, but
         * all can be null.
         * @param name is the name of player.
         * @param color is the color of the player's nut.
         */
        Player player1 = new Player(name1,1);
        System.out.println("Enter the name of second player");
        String name2 = scan.next();
        /**Creat a Player object. First and second must be supplied, but
         * all can be null.
         * @param name is the name of player.
         * @param color is the color of the player's nut.
         */
        Player player2 = new Player(name2,0);
        /**Creat a Map object.
         */
        Map map = new Map();
        int counter = 0;
        int horizontal;
        int vertical;
        int area;
        int direction;
        Boolean winCheck1 = true;
        Boolean winCheck2 = true;
        map.printMap();
        while(winCheck1 && winCheck2){
            if(counter % 2 == 0){
                while(true) {
                    do {
                        System.out.println(player1.name + " your turn! Select a coordinate : ");
                        horizontal = scan.nextInt();
                        vertical = scan.nextInt();
                    }
                    while(!(vertical > 0 && vertical <= 6 && horizontal > 0 && horizontal <= 6));
                    if(map.emptyHouse(vertical,horizontal))
                        break;
                }
                map.locateNut(vertical,horizontal,1);
                winCheck1 = !map.winCheck(1);
                if(map.winCheck(1))
                    break;
                map.printMap();
                do{
                    System.out.println(player1.name + " select an area and a direction to rotate : ");
                    System.out.print("1-\u25F0   ");
                    System.out.print("2-\u25F3   ");
                    System.out.print("3-\u25F1   ");
                    System.out.println("4-\u25F2   ");
                    System.out.print("1 : clockwise   ");
                    System.out.println("-1 : counter clockwise");
                    area = scan.nextInt();
                    direction = scan.nextInt();
                }
                while(!(area > 0 && area <= 4 && direction == 1 || direction == -1));
                map.editMap(area,direction);
                winCheck1 = !map.winCheck(1);
                winCheck2 = !map.winCheck(0);
                if(map.winCheck(1) || map.winCheck(0))
                    break;
                map.printMap();
                counter++;
            }
            if(counter % 2 == 1){
                while(true) {
                    do {
                        System.out.println(player2.name + " your turn! Select a coordinate : ");
                        horizontal = scan.nextInt();
                        vertical = scan.nextInt();
                    }
                    while(!(vertical > 0 && vertical <= 6 && horizontal > 0 && horizontal <= 6));
                    if(map.emptyHouse(vertical,horizontal))
                        break;
                }
                map.locateNut(vertical,horizontal,0);
                winCheck2 = !map.winCheck(0);
                if(map.winCheck(0))
                    break;
                map.printMap();
                do{
                    System.out.println(player2.name + " select an area and a direction to rotate : ");
                    System.out.print("1-\u25F0   ");
                    System.out.print("2-\u25F3   ");
                    System.out.print("3-\u25F1   ");
                    System.out.println("4-\u25F2  ");
                    System.out.print("1 : clockwise   ");
                    System.out.println("-1 : counter clockwise");
                    area = scan.nextInt();
                    direction = scan.nextInt();
                }
                while(!(area > 0 && area <= 4 && direction == 1 || direction == -1));
                map.editMap(area,direction);
                winCheck2 = !map.winCheck(0);
                winCheck1 = !map.winCheck(1);
                if(map.winCheck(1) || map.winCheck(0))
                    break;
                map.printMap();
                counter++;
            }
        }
        map.printMap();
        System.out.println("game ended");
        if(!winCheck1 && !winCheck2){
            System.out.println("draw");
        }
        else if(!winCheck1)
            System.out.println(player1.name + " won");
        else if(!winCheck2)
            System.out.println(player2.name + " won");
    }
}
