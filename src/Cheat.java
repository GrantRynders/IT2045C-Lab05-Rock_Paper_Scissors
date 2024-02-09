public class Cheat implements Strategy
{

    @Override
    public int determineMove(int playerChoice)
    {
        RockPaperScissorsRunner rps = new RockPaperScissorsRunner();
        rps.setComputerStrategy("Computer used Cheat");
        System.out.println("COMPUTER CHEATS LIKE THE JERK IT IS");
        return rps.CounterTo(playerChoice);
    }
}
