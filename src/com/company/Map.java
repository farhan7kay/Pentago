package com.company;

public class Map {
    public Nuts[][] nuts;

    /**
     * class of the map.
     * nuts is an array of class Nut.
     */
    public Map() {
        nuts = new Nuts[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                nuts[i][j] = new Nuts(-1);
            }
        }
    }

    /**
     * method to locate the player's nut.
     * @param horizontal is the coordinate of the map where player want to locate nut.
     * @param vertical is the coordinate of the map where player want to locate nut.
     * @param color is the color of the nut that is located.
     */
    public void locateNut(int horizontal,int vertical,int color){
        int x = horizontal - 1;
        int y = vertical - 1;
        while(nuts[x][y].getColor() == -1 && x >= 0 && x < 6 && y >= 0 && y < 6){
            nuts[x][y].color = color;
        }
    }

    /**
     * the method check the coordinate that nut is going to be located is empty or not.
     * @param horizontal the coordinate to check.
     * @param vertical the coordinate to check.
     * @return Boolean to show the availablity of the house.
     */
    public Boolean emptyHouse(int horizontal,int vertical){
        int x = horizontal - 1;
        int y = vertical - 1;
        if(nuts[x][y].getColor() == -1) {
            return true;
        }
        return false;
    }

    /**
     * check the possibility of win
     * @param color color of the nut to check.
     * @return Boolean to show the game finished or not.
     */
    public Boolean winCheck(int color){
        int k;
        int l;
        for (int i = 0;i < 6;i++){
            for(int j = 0;j < 6;j++){
                k = i;
                l = j;
                do{
                    k++;
                    l++;
                    if (!(k >= 0 && k < 6 && l >= 0 && l < 6)){
                        k--;
                        l--;
                        break;
                    }
                }
                while(nuts[k][l].color == color);
                if(k - i == 5)
                    return true;
                k = i;
                l = j;

                do{
                    k++;
                    if (!(k >= 0 && k < 6 && l >= 0 && l < 6)){
                        k--;
                        break;
                    }
                }
                while(nuts[k][l].color == color);
                if(k - i == 5)
                    return true;
                l = j;
                k = i;

                do{
                    l++;
                    if (!(k >= 0 && k < 6 && l >= 0 && l < 6)){
                        l--;
                        break;
                    }
                }
                while(nuts[k][l].color == color);
                if(l - j == 5)
                    return true;
                }
            }
        for (int i = 5;i >= 0;i--){
            for(int j = 0;j <= 5;j++){
                k = i;
                l = j;
                do{
                    k++;
                    l--;
                    if (!(k >= 0 && k < 6 && l >= 0 && l < 6)){
                        k--;
                        l++;
                        break;
                    }
                }
                while (nuts[k][l].color == color);
                if(k - i == 5)
                    return true;
            }
        }

        return false;
    }

    /**
     * method to rotate the map.
     * @param area one of the four areas wants to be rotated.
     * @param direction the direction of the rotation.
     */
    public void editMap(int area,int direction){
        int tmp;
        switch (area) {
            case 1 :
                if(direction == 1){
                    tmp = nuts[0][2].color;
                    nuts[0][2].color = nuts[0][0].color;
                    nuts[0][0].color = nuts[2][0].color;
                    nuts[2][0].color = nuts[2][2].color;
                    nuts[2][2].color = tmp;
                    tmp = nuts[0][1].color;
                    nuts[0][1].color = nuts[1][0].color;
                    nuts[1][0].color = nuts[2][1].color;
                    nuts[2][1].color = nuts[1][2].color;
                    nuts[1][2].color = tmp;
                }
                if(direction == -1){
                    tmp = nuts[0][0].color;
                    nuts[0][0].color = nuts[0][2].color;
                    nuts[0][2].color = nuts[2][2].color;
                    nuts[2][2].color = nuts[2][0].color;
                    nuts[2][0].color = tmp;
                    tmp = nuts[1][0].color;
                    nuts[1][0].color = nuts[0][1].color;
                    nuts[0][1].color = nuts[1][2].color;
                    nuts[1][2].color = nuts[2][1].color;
                    nuts[2][1].color = tmp;
                    tmp = 0;
                }
                break;
            case 2:
                if(direction == 1){
                    tmp = nuts[0][5].color;
                    nuts[0][5].color = nuts[0][3].color;
                    nuts[0][3].color = nuts[2][3].color;
                    nuts[2][3].color = nuts[2][5].color;
                    nuts[2][5].color = tmp;
                    tmp = nuts[0][4].color;
                    nuts[0][4].color = nuts[1][3].color;
                    nuts[1][3].color = nuts[2][4].color;
                    nuts[2][4].color = nuts[1][5].color;
                    nuts[1][5].color = tmp;
                }
                if(direction == -1){
                    tmp = nuts[0][3].color;
                    nuts[0][3].color = nuts[0][5].color;
                    nuts[0][5].color = nuts[2][5].color;
                    nuts[2][5].color = nuts[2][3].color;
                    nuts[2][3].color = tmp;
                    tmp = nuts[1][3].color;
                    nuts[1][3].color = nuts[0][4].color;
                    nuts[0][4].color = nuts[1][5].color;
                    nuts[1][5].color = nuts[2][4].color;
                    nuts[2][4].color = tmp;
                }
                break;
            case 3:
                if(direction == 1){
                    tmp = nuts[3][2].color;
                    nuts[3][2].color = nuts[3][0].color;
                    nuts[3][0].color = nuts[5][0].color;
                    nuts[5][0].color = nuts[5][2].color;
                    nuts[5][2].color = tmp;
                    tmp = nuts[3][1].color;
                    nuts[3][1].color = nuts[4][0].color;
                    nuts[4][0].color = nuts[5][1].color;
                    nuts[5][1].color = nuts[4][2].color;
                    nuts[4][2].color = tmp;
                }
                if(direction == -1){
                    tmp = nuts[3][0].color;
                    nuts[3][0].color = nuts[3][2].color;
                    nuts[3][2].color = nuts[5][2].color;
                    nuts[5][2].color = nuts[5][0].color;
                    nuts[5][0].color = tmp;
                    tmp = nuts[4][0].color;
                    nuts[4][0].color = nuts[3][1].color;
                    nuts[3][1].color = nuts[4][2].color;
                    nuts[4][2].color = nuts[5][1].color;
                    nuts[5][1].color = tmp;
                    tmp = 0;
                }
                break;
            case 4:
                if(direction == 1){
                    tmp = nuts[3][5].color;
                    nuts[3][5].color = nuts[3][3].color;
                    nuts[3][3].color = nuts[5][3].color;
                    nuts[5][3].color = nuts[5][5].color;
                    nuts[5][5].color = tmp;
                    tmp = nuts[3][4].color;
                    nuts[3][4].color = nuts[4][3].color;
                    nuts[4][3].color = nuts[5][4].color;
                    nuts[5][4].color = nuts[4][5].color;
                    nuts[4][5].color = tmp;
                }
                if(direction == -1){
                    tmp = nuts[3][3].color;
                    nuts[3][3].color = nuts[3][5].color;
                    nuts[3][5].color = nuts[5][5].color;
                    nuts[5][5].color = nuts[5][3].color;
                    nuts[5][3].color = tmp;
                    tmp = nuts[4][3].color;
                    nuts[4][3].color = nuts[3][4].color;
                    nuts[3][4].color = nuts[4][5].color;
                    nuts[4][5].color = nuts[5][4].color;
                    nuts[5][4].color = tmp;
                }
                break;
        }
    }

    /**
     * method to print the map.
     */
    public void printMap(){
        System.out.println("      1       2        3            4        5       6");
        System.out.println("   ------------------------     -------------------------");
        //System.out.printf("\n");
        for (int i = 0; i < 6; i++) {
            if(i == 3)
                System.out.println("  -------------------------     -------------------------");
            System.out.printf("\n");
            System.out.print((i + 1) + " |");
            for (int j = 0; j < 6; j++) {
                System.out.printf("   %s ", nuts[i][j].toString());
                if(j == 2 || j == 5)
                    System.out.printf("|    ");

            }
            System.out.printf("\n");
            System.out.printf("\n");
        }
        System.out.println("   ------------------------    --------------------------");
    }
}
