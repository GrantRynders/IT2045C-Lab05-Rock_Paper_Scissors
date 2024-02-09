import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class RockPaperScissorsRunner
{
    private static RockPaperScissorsFrame rps;
    private int winCount = 0;
    private int lossCount = 0;
    private int tieCount = 0;
    private int gameCount = 0;
    public int playerChoice;
    public String computerStrategy;

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public int getLossCount() {
        return lossCount;
    }

    public void setLossCount(int lossCount) {
        this.lossCount = lossCount;
    }

    public int getTieCount() {
        return tieCount;
    }

    public void setTieCount(int tieCount) {
        this.tieCount = tieCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public int getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(int playerChoice) {
        this.playerChoice = playerChoice;
    }

    public int getLastPlayerChoice() {
        return lastPlayerChoice;
    }

    public void setLastPlayerChoice(int lastPlayerChoice) {
        this.lastPlayerChoice = lastPlayerChoice;
    }

    public int getRockCount() {
        return rockCount;
    }

    public void setRockCount(int rockCount) {
        this.rockCount = rockCount;
    }

    public int getPaperCount() {
        return paperCount;
    }

    public void setPaperCount(int paperCount) {
        this.paperCount = paperCount;
    }

    public int getScissorsCount() {
        return scissorsCount;
    }

    public void setScissorsCount(int scissorsCount) {
        this.scissorsCount = scissorsCount;
    }

    public String getComputerStrategy() {
        return computerStrategy;
    }

    public void setComputerStrategy(String computerStrategy) {
        this.computerStrategy = computerStrategy;
    }

    public int lastPlayerChoice;
    public int rockCount;
    public int paperCount;
    public int scissorsCount;
    public String[] choiceIndex = {"Rock", "Paper", "Scissors"};
    public static void main(String[] args)
    {
        rps = new RockPaperScissorsFrame();
    }
    public void NewGame(int playerChoice)
    {
        gameCount +=1;
        int computerChoice = ComputerChoice(playerChoice);
        DetermineWinner(playerChoice, computerChoice);
        lastPlayerChoice = playerChoice; //sets the last player choice to player choice as the game is ended

    }
    private int ComputerChoice(int playerChoice)
    {
        LeastUsed leastUsed = new LeastUsed();
        MostUsed mostUsed = new MostUsed();
        LastUsed lastUsed = new LastUsed();
        RandomChoice random = new RandomChoice();
        Cheat cheat = new Cheat();
        ArrayList<Strategy> strategies = new ArrayList<>();
        if (gameCount <= 1)
        { //on the first game there will be no player data to work with, so I removed those strategies
            strategies.add(random);
            strategies.add(random);
            strategies.add(random);
            strategies.add(random);
            strategies.add(random);
            strategies.add(random);
            strategies.add(random);
            strategies.add(random);
            strategies.add(random);
            strategies.add(cheat); //10% chance
        }
        if (gameCount > 1)
        {
            strategies.add(leastUsed);
            strategies.add(mostUsed);
            strategies.add(leastUsed);
            strategies.add(mostUsed);
            strategies.add(lastUsed);
            strategies.add(lastUsed);
            strategies.add(random);
            strategies.add(random);
            strategies.add(random);
            strategies.add(cheat); //10% chance
        }

        int randomNum = GenerateRandom(strategies.size() - 1, 0);
        int computerChoice = strategies.get(randomNum).determineMove(playerChoice);//chooses and implements a random strategy, returns an int
        computerStrategy = strategies.get(randomNum).getClass().getSimpleName();
        return computerChoice;
    }
    public int GenerateRandom(int max, int min)
    {
        Random rand = new Random();
        return (rand.nextInt(max - min + 1) + min);
    }
    public int GetMostUsed()
    {
        if ((rockCount > scissorsCount) && (rockCount > paperCount))
        {
            return 0;
        }
        else if ((paperCount > scissorsCount) && (paperCount > rockCount))
        {
            return 1;
        }
        else if ((scissorsCount > rockCount) && (scissorsCount > paperCount))
        {
            return 2;
        }
        else
        {
            return GenerateRandom(2, 0);
        }
    }
    public int GetLeastUsed()
    {
        if ((rockCount < scissorsCount) && (rockCount < paperCount))
        {
            return 0;
        }
        else if ((paperCount < scissorsCount) && (paperCount < rockCount))
        {
            return 1;
        }
        else if ((scissorsCount < rockCount) && (scissorsCount < paperCount))
        {
            return 2;
        }
        else
        {
            return GenerateRandom(2, 0);
        }
    }
    public int CounterTo(int inputMove)
    {
        //int[] inputIndex = {0, 1, 2};
        int[] counterIndex = {1, 2, 0};
        return counterIndex[inputMove];
    }
    private void UpdateWins()
    {
        winCount += 1;
        rps.winText.setText(String.valueOf(winCount));
    }
    private void UpdateLosses()
    {
        lossCount += 1;
        rps.lossText.setText(String.valueOf(lossCount));
    }
    private void UpdateTies()
    {
        tieCount += 1;
        rps.tieText.setText(String.valueOf(tieCount));
    }
    public int DetermineWinner(int playerChoice, int computerChoice)
    {
        //computerStrategy = "";
        if (playerChoice == computerChoice)
        {
            UpdateTies();
            rps.resultsText.append("\n" + choiceIndex[playerChoice] + " tied with " + choiceIndex[computerChoice] + " (Neither Wins) Computer Used: " + computerStrategy);
            System.out.println("\n" + choiceIndex[playerChoice] + " tied with " + choiceIndex[computerChoice] + " (Neither Wins)");
            return 2; //tie
        }
        else if (playerChoice == 0) //rock
        {
            if(computerChoice == 1) //paper
            {
                rps.resultsText.append("\n" + choiceIndex[computerChoice] + " covers " + choiceIndex[playerChoice] + " (Computer Wins) Computer Used: " + computerStrategy);
                System.out.println("\n" + choiceIndex[computerChoice] + " covers " + choiceIndex[playerChoice] + " (Computer Wins)");
                UpdateLosses();
                return 1; //Computer wins
            }
            if(computerChoice == 2) //scissors
            {
                rps.resultsText.append("\n" + choiceIndex[playerChoice] + " breaks " + choiceIndex[computerChoice] + " (Player Wins) Computer Used: " + computerStrategy);
                System.out.println("\n" + choiceIndex[playerChoice] + " breaks " + choiceIndex[computerChoice] + " (Player Wins)");
                UpdateWins();
                return 0; //player wins
            }
        }
        else if (playerChoice == 1)//paper
        {
            if(computerChoice == 0)//rock
            {
                rps.resultsText.append("\n" + choiceIndex[playerChoice] + " covers " + choiceIndex[computerChoice] + " (Player Wins) Computer Used: " + computerStrategy);
                System.out.println("\n" + choiceIndex[playerChoice] + " covers " + choiceIndex[computerChoice] + " (Player Wins)");
                UpdateWins();
                return 0; //player wins
            }
            if(computerChoice == 2)//scissors
            {
                rps.resultsText.append("\n" + choiceIndex[computerChoice] + " cuts " + choiceIndex[playerChoice] + " (Computer Wins) Computer Used: " + computerStrategy);
                System.out.println("\n" + choiceIndex[computerChoice] + " cuts " + choiceIndex[playerChoice] + " (Computer Wins)");
                UpdateLosses();
                return 1; //Computer wins
            }
        }
        else //(player choice == 2) scissors
        {
            if(computerChoice == 0)//rock
            {

                rps.resultsText.append("\n" + choiceIndex[computerChoice] + " breaks " + choiceIndex[playerChoice] + " (Computer Wins) Computer Used: " + computerStrategy);
                System.out.println("\n" + choiceIndex[computerChoice] + " breaks " + choiceIndex[playerChoice] + " (Computer Wins)");
                UpdateLosses();
                return 1; //Computer wins
            }
            if(computerChoice == 1)//paper
            {
                rps.resultsText.append("\n" + choiceIndex[playerChoice] + " cuts " + choiceIndex[computerChoice] + " (Player Wins) Computer Used: " + computerStrategy);
                System.out.println("\n" + choiceIndex[playerChoice] + " cuts " + choiceIndex[computerChoice] + " (Player Wins)");
                UpdateWins();
                return 0; //player wins
            }
        }
        return 3; //failsafe. if it returns 3 something is fricked
    }
}
