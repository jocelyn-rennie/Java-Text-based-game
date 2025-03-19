package org.uob.a1;

public class Inventory 
{
   
    final int MAX_ITEMS;
    int currentNum;
    String[] items;

    public Inventory()
    {
        MAX_ITEMS = 4;
        int currentNum = 1;
        items = new String[MAX_ITEMS];
    }

    public void addItem(String item)
    {
        items[currentNum] = item;
        currentNum++;
    }

    public int hasItem(String item)
    {
        int found = -1;
        for(int i = 0; i < items.length; i++)
        {
            if(items[i] == item)
            {
                found = i;
            }
        }
        return found;
    }

    public void removeItem(String item){
        for (int i = 0; i < items.length; i++)
        {
            if (items[i] == item){
                items[i] = "";
                currentNum--;
            }
        }
    }

    public String displayInventory()
    {
        String output = "";
        for (int i = 0; i < currentNum; i++)
        {
            output= output + items[i] + " ";
        }
        return output;
    }
   
}