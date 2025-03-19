package org.uob.a1;
// this is the map I use because I have modified it, another map class if of test format
public class Map1 
{
    private int width;
    private int height;
    final private char EMPTY = '.';
    String[][] mapArray;
    int room = 1;

    public Map1(int width, int height)
    {
        this.width = width;
        this.height = height;
        mapArray = new String[width][height];
        String empty = Character.toString(EMPTY);
        
        //populates map array with empty character
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                mapArray[x][y] = " " + empty + " ";
            }
        }
    }

    public void placeRoom(Position pos, char symbol)
    {
        String symbolStr = Character.toString(symbol);
        // adds individual rooms
        if(room == 1)
        {
            for (int y = 0; y < 4; y++)
            {
            for (int x = 0; x < 6; x++)
            {
                if( pos.x == x && pos.y == y)
                {
                    mapArray[x][y] = " P ";
                }
                else
                {
                        mapArray[x][y] = " " + symbolStr + " ";
                }
            }            
            }
            // items and doors in room1
            mapArray[4][0] = " @ ";
            mapArray[2][3] = " # ";
            mapArray[3][3] = " # ";
        }

        if(room == 2)
        {
            for (int y = 4; y < 9; y++)
            {
            for (int x = 2; x < 4; x++)
            {
                if( pos.x == x && pos.y == y)
                {
                    mapArray[x][y] = " P ";
                }
                else
                {
                        mapArray[x][y] = " " + symbolStr + " ";
                }
            }            
            }
            //doors in room2
            mapArray[2][8] = " # ";
            mapArray[3][8] = " # ";
        }

        if(room == 3)
        {
            for (int y = 9; y < 14; y++)
            {
            for (int x = 1; x < 7; x++)
            {
                if( pos.x == x && pos.y == y)
                {
                    mapArray[x][y] = " P ";
                }
                else
                {
                        mapArray[x][y] = " " + symbolStr + " ";
                }
            }            
            }
            // items and doors in room3
            mapArray[2][11] = "[] ";
            mapArray[3][13] = " # ";
            mapArray[4][13] = " # ";
        }

        if(room == 4)
        {
            for (int y = 14; y < 18; y++)
            {
            for (int x = 3; x < 5; x++)
            {
                if( pos.x == x && pos.y == y)
                {
                    mapArray[x][y] = " P ";
                }
                else
                {
                        mapArray[x][y] = " " + symbolStr + " ";
                }
            }            
            }
            //doors in room4
            mapArray[3][17] = " # ";
            mapArray[4][17] = " # ";
        }

        if(room == 5)
        {
            for (int y = 18; y < 21; y++)
            {
            for (int x = 1; x < 6; x++)
            {
                if( pos.x == x && pos.y == y)
                {
                    mapArray[x][y] = " P ";
                }
                else
                {
                        mapArray[x][y] = " " + symbolStr + " ";
                }
            }            
            }
            // items and doors in room5
            mapArray[2][19] = " D ";
            mapArray[5][18] = " # ";
            mapArray[5][19] = " # ";
        }

        // redo to make stairs, will use more efficient method next time
        if(room == 6)
        {
            //stairs
            mapArray[6][18] = " " + symbolStr + " ";
            mapArray[6][19] = " " + symbolStr + " ";

            mapArray[7][17] = " " + symbolStr + " ";
            mapArray[7][18] = " " + symbolStr + " ";

            mapArray[8][16] = " " + symbolStr + " ";
            mapArray[8][17] = " " + symbolStr + " ";

            mapArray[9][15] = " " + symbolStr + " ";
            mapArray[9][16] = " " + symbolStr + " ";

            mapArray[10][14] = " " + symbolStr + " ";
            mapArray[10][15] = " " + symbolStr + " ";

            mapArray[11][13] = " " + symbolStr + " ";
            mapArray[11][14] = " " + symbolStr + " "; 
            
            mapArray[12][12] = " " + symbolStr + " ";
            mapArray[12][13] = " " + symbolStr + " ";

            mapArray[13][11] = " " + symbolStr + " ";
            mapArray[13][12] = " " + symbolStr + " ";

            //make sure character is placed
            mapArray[pos.x][pos.y] = " P ";

            // items and doors in room6
            mapArray[14][11] = " # ";
            mapArray[14][12] = " # ";
        }

        if(room == 7)
        {
            for (int y = 10; y < 13; y++)
            {
            for (int x = 15; x < 17; x++)
            {
                if( pos.x == x && pos.y == y)
                {
                    mapArray[x][y] = " P ";
                }
                else
                {
                        mapArray[x][y] = " " + symbolStr + " ";
                }
            }            
            }
            // items and doors in room7
            mapArray[15][10] = " # ";
            mapArray[16][10] = " # ";
        }

        if(room == 8)
        {
            for (int y = 5; y < 10; y++)
            {
            for (int x = 15; x < 17; x++)
            {
                if( pos.x == x && pos.y == y)
                {
                    mapArray[x][y] = " P ";
                }
                else
                {
                        mapArray[x][y] = " " + symbolStr + " ";
                }
            }            
            }
            //doors in room8
            mapArray[15][5] = " # ";
            mapArray[16][5] = " # ";
        }

        if(room == 9)
        {
            for (int y = 2; y < 5; y++)
            {
            for (int x = 13; x < 19; x++)
            {
                if( pos.x == x && pos.y == y)
                {
                    mapArray[x][y] = " P ";
                }
                else
                {
                        mapArray[x][y] = " " + symbolStr + " ";
                }
            }            
            }
            //doors and symbols in room9
            mapArray[17][2] = "\"!\"";
            mapArray[18][3] = " # ";
        }

        if(room == 10)
        {
            mapArray[19][3] = " " + symbolStr + " ";
            
            //make sure character is placed
            mapArray[pos.x][pos.y] = " P ";
            
            //final door in room10
            mapArray[20][3] = "  ]";
            
        }
        
    }

    //returns map
    public String display()
    {
        String result = "";
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                result = result + mapArray[x][y];
            }
            
            result = result + "\n";
        }
        
        return result;
    }

    // makes sure the map knows what room the player is in in the game class
    public void setRoom(int room)
    {
        this.room = room;
    }

}