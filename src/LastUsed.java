public class LastUsed implements Strategy
{

    @Override
    public int determineMove(int playerChoice)
    {
        RockPaperScissorsRunner rps = new RockPaperScissorsRunner();
        System.out.println("COMPUTER USES LAST USED");
        return rps.getLastPlayerChoice();
    }
}
