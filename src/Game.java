package org.uob.a1;

import java.util.Scanner; 

public class Game {

    // room keeps track of the room the player is currently in
    static int room = 1;

    //player starting position
    static Position playerPos = new Position(0,0);

    //initialise map 
    static Map1 map = new Map1(21, 21);

    //initialise score
    static Score score = new Score(0);

    // creating rooms
    static Room room1 = new Room("The Basement", "You have woken up in the basement with a coin in your pocket, there is a door ahead.", '*', playerPos);
    
    static Room room2 = new Room("Corridor 1","You have made it into the corridor, make your way to the door at the end.",'-',playerPos);
    
    static Room room3 = new Room("The storage room","You are now in the storage room, your neighbour hoards all her items here.",',',playerPos);
    
    static Room room4 = new Room("Corridor 2","You have broken through the old lady's traps and are now in another corridor, make your way through the corridoor.",';',playerPos);
        
    static Room room5 = new Room("The Pantry","You are now in the pantry, your neighbour loves to snack so keeps an assortment of treats down here. Don't be tempted, she comes here often so get out fast!",':',playerPos);
        
    static Room room6 = new Room("The Stairs","Well done for resisiting the pantry! You have made it to the stairs but the old lady is coming for a snack so be quick!",'+',playerPos);
        
    static Room room7 = new Room("The Toilet","You made it into the toilet, this is a good place to hide.",'=',playerPos);
        
    static Room room8 = new Room("Corridor 3","The old lady is downstairs, you have made it to the last corridor. ",'^',playerPos);
        
    static Room room9 = new Room("The Living room","You have made it to the living room, the old lady's dog is sat in the corner near the door.",'<',playerPos);
        
    static Room room10 = new Room("The Porch","You have made it to the front door, escape!",'>',playerPos);
    
    public static void main(String[] args) 
    {
        // using map class template for tests
        Map testMap = new Map(21,21);
        testMap.display();
        testMap.placeRoom(playerPos,'x');
        testMap.display();

        
        // used to collect user input
        Scanner inputDevice = new Scanner(System.in);
        String input = "";

        // x controls if the user wants to exit
        
        Boolean x = false;
        
        // initialise inventoy
        Inventory inventory = new Inventory();

        // in subroutine at bottom, general game info and commands
        info();

        // gives player coin in inventory
        // sets player position in map, shows starting map (room1) and gives a descripton of the room.
        inventory.addItem("coin");
        whichRoom();
        System.out.println(room1.getName()+"\n");
        System.out.println(map.display());
        System.out.println(room1.getDescription());

        // main game loop
        while (x == false)
        {
            // allows for inputs
            System.out.println("\nEnter a command: ");
            input = inputDevice.nextLine();

            //responds to inputs
            switch(input)
            {
                // moves player
                case "move up" : 
                    // cant go off map
                    if(playerPos.y == 0)
                    {
                        System.out.println("You can't move out of rooms or off the map, try another input.");
                    }
                    else
                    {
                        playerPos.y--; whichRoom();  
                    }; break;
                case "move left" : 
                    // cant go off map
                    if(playerPos.x == 0)
                    {
                        System.out.println("You can't move out of rooms or off the map, try another input.");
                    }
                    else
                    {
                        playerPos.x--; whichRoom();  
                    }; break;
                case "move down" : 
                // cant go off map
                if(playerPos.y == 20)
                    {
                        System.out.println("You can't move out of rooms or off the map, try another input.");
                    }
                    else
                    {
                        playerPos.y++; whichRoom();  
                    }; break;
                case "move right" : 
                    // cant go off map
                    if(playerPos.x == 20)
                    {
                        System.out.println("You can't move out of rooms or off the map, try another input.");
                    }
                    else
                    {
                        playerPos.x++; whichRoom();  
                    }; break;
                // room descriptions
                case "look" : switch(room)
                {
                    case 1 : System.out.println(room1.getDescription()); break;
                    case 2 : System.out.println(room2.getDescription()); break;
                    case 3 : System.out.println(room3.getDescription()); break;
                    case 4 : System.out.println(room4.getDescription()); break;
                    case 5 : System.out.println(room5.getDescription()); break;
                    case 6 : System.out.println(room6.getDescription()); break;
                    case 7 : System.out.println(room7.getDescription()); break;
                    case 8 : System.out.println(room8.getDescription()); break;
                    case 9 : System.out.println(room9.getDescription()); break;
                    case 10 : System.out.println(room10.getDescription()); break;
                }; break;
                // look door for each room
                case "look door" : switch(room)
                {
                    case 1: System.out.println("The doors are locked, look around the room for something to unlock it."); break;
                    case 2: System.out.println("The old lady has locked these doors too, you should pick the lock."); break;
                    case 3: System.out.println("The doors are chained in this room, the old lady wanted to protect her prized possesions. Look around the room of junk for something to help."); break;
                    case 4: System.out.println("Your nextdoor neighbour thought she put in enough protection. The doors ahead are unlocked, walk through the corridoor and open the doors."); break;
                    case 5: System.out.println("The doors ahead are unlocked, get out quick before the old lady comes."); break;
                    case 6: System.out.println("The doors at the top of the stairs are unlocked and lead to the toilet, hurry up to hide while the old lady goes to eat."); break;
                    case 7: System.out.println("The toilet doors are unlocked, leave when its safe"); break;
                    case 8: System.out.println("Ahead are the doors to the living room, they can be opened freely. Look out for what's behind them."); break;
                    case 9: System.out.println("The door to the porch is unlocked but beware the dog!"); break;
                    case 10: System.out.println("This is the final door, you need a key to open it."); break;
                        
                }; break;
                // rest of the look at features of a room
                case "look clawmachine" : System.out.println("The clawmachine holds a series of tool prizes, you need money to play the game. A prize could help you cut the chains."); break;
                case "look dog" : System.out.println("The dog protects the door, befriend the dog (he's hungry). Something around his neck looks a bit like a key."); break;
                case "look front door" : System.out.println("This is the final door before escape! It looks like it needs a key to open it."); break;
                // object descriptions
                case "look coin" : System.out.println("This could be used to pay for something or use in something."); break;
                case "look paperclip" : System.out.println("This is a useful tool, it can be bent into shapes that can pick things."); break;
                case "look axe" : System.out.println("This is useful for breaking things"); break;
                case "look dogfood" : System.out.print("The old lady has a dog, this could be useful later.\n"); break;
                case "look key" : System.out.println("This is the key for the front door."); break;
                // outputs inventory with spaces
                case "inventory" : System.out.println(inventory.displayInventory()); break;
                // outputs current score
                case "score" : System.out.println(score.getScore()); break;
                // shows current map
                case "map": System.out.println(map.display()); break;
                // displays game information
                case "help": info(); break;
                //exits game and shows their score
                case "quit" : System.out.println("Your final score was: " + score.getScore()); x = true; break;
                // customised commands
                case "pickup paperclip" : if((inventory.hasItem("paperclip") == -1) && (playerPos.x == 4) && (playerPos.y == 0))
                {
                    inventory.addItem("paperclip");
                    System.out.println("paperclip added to inventory");
                }
                else
                {
                    System.out.println("You either already have a paperclip or you are not standing on it.");
                }; break;
                case "pick lock" : 
                    if(room == 1)
                    {
                        if((inventory.hasItem("paperclip") != -1) && ((playerPos.x == 2 && playerPos.y == 3) || (playerPos.x == 3 && playerPos.y == 3)))
                        {
                        score.solvePuzzle();
                        score.visitRoom();
                        room++;
                        map.setRoom(room);
                        playerPos.y++;
                        whichRoom();
                        System.out.println("\n"+room2.getName()+"\n");
                        System.out.println(map.display());
                        System.out.println(room2.getDescription());
                        }
                    
                
                        else
                        {
                            System.out.println("You don't have something to unlock the door or you are not standing on a door.");
                        }
                    }
                    else
                    {
                        if((inventory.hasItem("paperclip") != -1) && ((playerPos.x == 2 && playerPos.y == 8) || (playerPos.x == 3 && playerPos.y == 8)))
                        {
                        score.solvePuzzle();
                        score.visitRoom();
                        room++;
                        map.setRoom(room);
                        playerPos.y++;
                        whichRoom();
                        System.out.println("\n"+room3.getName()+"\n");
                        System.out.println(map.display());
                        inventory.removeItem("paperclip");
                        System.out.println("The paperclip broke in the lock.\n");
                        System.out.println(room3.getDescription());
                        }
                    
                
                        else
                        {
                            System.out.println("You don't have something to unlock the door or you are not standing on a door.");
                        }
                    }; break;
                case "play clawmachine": if ((playerPos.x == 2) && (playerPos.y == 11) && (inventory.hasItem("coin") != -1))
                    {
                        inventory.removeItem("coin");
                        System.out.println("\nYou have used your coin to play the clawmachine.");
                        inventory.addItem("axe");
                        System.out.println("axe added to inventory.");
                        score.solvePuzzle();
                    }
                    else
                    {
                        System.out.print("You have already used your coin or you are not standing on the clawmachine.");
                    }; break;
                case "cut chains" : if((inventory.hasItem("axe") != -1) && ((playerPos.x == 3 && playerPos.y == 13) || (playerPos.x == 4 && playerPos.y == 13)))
                        {
                        score.solvePuzzle();
                        score.visitRoom();
                        room++;
                        map.setRoom(room);
                        playerPos.y++;
                        whichRoom();
                        System.out.println("\n"+room4.getName()+"\n");
                        System.out.println(map.display());
                        inventory.removeItem("axe");
                        System.out.println("The axe broke cutting the chain.\n");
                        System.out.println(room4.getDescription());
                        }
                    
                
                        else
                        {
                            System.out.println("You don't have something to break the chain or you are not standing on a door.");
                        }; break;
                case "open door" : if((room == 4) && ((playerPos.x == 3 && playerPos.y == 17) || (playerPos.x == 4 && playerPos.y == 17)))
                    {
                        score.visitRoom();
                        room++;
                        map.setRoom(room);
                        playerPos.y++;
                        whichRoom();
                        System.out.println("\n"+room5.getName()+"\n");
                        System.out.println(map.display());
                        System.out.println(room5.getDescription());
                    }
                    else if((room == 5) && ((playerPos.x == 5 && playerPos.y == 18) || (playerPos.x == 5 && playerPos.y == 19)))
                    {
                        score.visitRoom();
                        room++;
                        map.setRoom(room);
                        playerPos.x++;
                        whichRoom();
                        System.out.println("\n"+room6.getName()+"\n");
                        System.out.println(map.display());
                        System.out.println(room6.getDescription());
                    }
                    else if((room == 6) && ((playerPos.x == 14 && playerPos.y == 11) || (playerPos.x == 14 && playerPos.y == 12)))
                    {
                        score.visitRoom();
                        room++;
                        map.setRoom(room);
                        playerPos.x++;
                        whichRoom();
                        System.out.println("\n"+room7.getName()+"\n");
                        System.out.println(map.display());
                        System.out.println(room7.getDescription());
                    }
                    else if((room == 7) && ((playerPos.x == 15 && playerPos.y == 10) || (playerPos.x == 16 && playerPos.y == 10)))
                    {
                        score.visitRoom();
                        room++;
                        map.setRoom(room);
                        playerPos.y--;
                        whichRoom();
                        System.out.println("\n"+room8.getName()+"\n");
                        System.out.println(map.display());
                        System.out.println(room8.getDescription());
                    }
                    else if((room == 8) && ((playerPos.x == 15 && playerPos.y == 5) || (playerPos.x == 16 && playerPos.y == 5)))
                    {
                        score.visitRoom();
                        room++;
                        map.setRoom(room);
                        playerPos.y--;
                        whichRoom();
                        System.out.println("\n"+room9.getName()+"\n");
                        System.out.println(map.display());
                        System.out.println(room9.getDescription());
                    }
                    else if((room == 9) && (playerPos.x == 18 && playerPos.y == 3))
                    {
                        if(inventory.hasItem("key") != -1)
                        {
                            score.visitRoom();
                            room++;
                            map.setRoom(room);
                            playerPos.x++;
                            whichRoom();
                            System.out.println("\n"+room10.getName()+"\n");
                            System.out.println(map.display());
                            System.out.println(room10.getDescription());
                        }
                        else
                        {
                            System.out.println("You are not friends with the dog, you can't get through the door.");
                        }
                    }
                    else
                    {
                        System.out.println("You are not standing on an unlocked door.");
                    }; break;
                case "pickup dogfood" : if((inventory.hasItem("dogfood") == -1) && (playerPos.x == 2) && (playerPos.y == 19))
                    {
                    inventory.addItem("dogfood");
                    System.out.println("dogfood added to inventory.");
                    }
                    else
                    {
                        System.out.println("You already have dogfood or you are not standing on the dog.");
                    }; break;
                case "feed dog" : if((inventory.hasItem("dogfood") != -1) && (playerPos.x == 17) && (playerPos.y == 2))
                    {
                        inventory.removeItem("dogfood");
                        score.solvePuzzle();
                        System.out.println("You fed the dog and are now friends.");
                        inventory.addItem("key");
                        System.out.println("key added to inventory.");
                    }
                    else
                    {
                        System.out.println("You are don't have dogfood or you are not standing on the dog.");
                    }; break;
                case "unlock front door" : if((inventory.hasItem("key") != -1) && (playerPos.x == 20 && playerPos.y == 3))
                    {
                        score.solvePuzzle();
                        score.visitRoom();
                        System.out.println("Well done, you completed the game and escaped your neighbour!");
                        System.out.println("Your final score was: " + score.getScore());
                        x = true;
                    }
                    else
                    {
                        System.out.println("You are not standing on the front door");
                    }; break;
                default : System.out.println("Invalid command entered, try again."); break;
                    
            
            
            }//switch close
        }//while close

        System.out.println("\nGame over.");
        
    }//main close

    public static void whichRoom()
        {
            //sets up a new room on the map when a room is completed
            switch(room)
            {
            case 1 : map.placeRoom(room1.getPosition(), room1.getSymbol()); break;
            case 2 : map.placeRoom(room2.getPosition(), room2.getSymbol()); break;
            case 3 : map.placeRoom(room3.getPosition(), room3.getSymbol()); break;
            case 4 : map.placeRoom(room4.getPosition(), room4.getSymbol()); break;
            case 5 : map.placeRoom(room5.getPosition(), room5.getSymbol()); break;
            case 6 : map.placeRoom(room6.getPosition(), room6.getSymbol()); break;
            case 7 : map.placeRoom(room7.getPosition(), room7.getSymbol()); break;
            case 8 : map.placeRoom(room8.getPosition(), room8.getSymbol()); break;
            case 9 : map.placeRoom(room9.getPosition(), room9.getSymbol()); break;
            case 10 : map.placeRoom(room10.getPosition(), room10.getSymbol()); break;
            }
        }

    public static void info()
    {
        // introduces the game
        System.out.println("\nWelcome to the game.");
        System.out.println("You have been kidnapped by the old lady next door for always being too loud. She lives in a huge old house filled with all sorts.");
        System.out.println();
        // gives information about symbols so they understand the game
        System.out.println("Here are the symbols used in the game:");
        System.out.println("@ is a paperclip, # are doors, [] is a claw machine, D is dog food, " + "\"!\"" + " is a dog and ] is the front door.\nYou must stand on the symbols and use a command to pick them up or use them.\n");
        System.out.println("P represents you, the player.");
        System.out.println();
        //tells the user what commands they have
        System.out.println("The commands you can type in the game are: ");
        System.out.println("move <direction>- to move the character. (up, down, left, right)");
        System.out.println("look- to display a description of the room.");
        System.out.println("look <feature>- to display a more detailed description of a feature of the room. (door, clawmachine, dog, finaldoor)");
        System.out.println("look <item>- to display a description of an item. (coin, paperclip, axe, dogfood, key)");
        System.out.println("inventory- to display all items you have collected.");
        System.out.println("score- to display your current score.");
        System.out.println("map- displays a map of the current game explored.");
        System.out.println("help- to display the symbols used in the game and the commands again.");
        System.out.println("quit- to leave the game.");
        System.out.println("pickup paperclip- add paperclip to inventory.");
        System.out.println("pick lock- to open a door with a paperclip.");
        System.out.println("play clawmachine- to use the coin in the claw machine.");
        System.out.println("cut chains- to open a door with chains.");
        System.out.println("open door- opens any unlocked door.");
        System.out.println("pickup dog food- to add dog food to your inventory.");
        System.out.println("feed dog- to distract the dog to get the key.");
        System.out.println("unlock front door- use the key to unlock the final door.");
        System.out.println();
    }

    
    
}