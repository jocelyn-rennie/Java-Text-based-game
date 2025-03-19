package org.uob.a1;
// test format map class
public class Map
{
    private int width;
    private int height;
    final private char EMPTY = '.';
    char[][] mapArray;

    public Map(int width, int height)
    {
        this.width = width;
        this.height = height;
        mapArray = new char[width][height];
        
        //populates map array with empty character
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                mapArray[x][y] = EMPTY;
            }
        }
    }

    public void placeRoom(Position pos, char symbol)
    {        
        mapArray[pos.x][pos.y] = symbol;
    }

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
}