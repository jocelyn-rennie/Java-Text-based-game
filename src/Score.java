package org.uob.a1;

public class Score 
{
    private int startingScore;
    private int currentScore;
    private int roomsVisited;
    private int puzzlesSolved;
    private final int PUZZLE_VALUE = 10;

    // constructor
    public Score(int startingScore)
    {
        this.startingScore = startingScore;
        this.currentScore = startingScore;
        this.roomsVisited = 0;
        this.puzzlesSolved = 0;
    }

    public void visitRoom()
    {
        this.roomsVisited++;
    }

    public void solvePuzzle()
    {
        this.puzzlesSolved++;
    }

    public double getScore()
    {
        currentScore = (startingScore - roomsVisited) + (puzzlesSolved * PUZZLE_VALUE);
        double returnScore = currentScore;
        return currentScore;
    }
        
}
