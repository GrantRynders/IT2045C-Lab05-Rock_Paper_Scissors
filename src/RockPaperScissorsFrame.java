import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class RockPaperScissorsFrame extends JFrame
{
    private JPanel mainPanel;
    private JPanel optionsPanel;
    private JPanel statsPanel;
    private JPanel resultsPanel;
    private JButton rockButton;
    private JButton scissorsButton;
    private JButton paperButton;
    private JButton quitButton;
    private JLabel winLabel;
    private JTextField winText;
    private JLabel lossLabel;
    private JTextField lossText;
    private JLabel tieLabel;
    private JTextField tieText;
    private JScrollPane resultsScroller;
    private JTextArea resultsText;



    private int winCount = 0;
    private int lossCount = 0;
    private int tieCount = 0;
    private int gameCount = 0;

    public int playerChoice;
    public RockPaperScissorsFrame()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3,1));
        setTitle("Rock Paper Scissors: Java Edition");
        CreateOptionsPanel();
        mainPanel.add(optionsPanel);
        CreateStatsPanel();
        mainPanel.add(statsPanel);
        CreateResultsPanel();
        mainPanel.add(resultsPanel);

        add(mainPanel);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize((screenWidth / 4) * 3, screenHeight);
        setLocation(screenWidth / 8, screenHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void CreateOptionsPanel()
    {
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(1,4));
        rockButton = new JButton("ROCK");
        paperButton = new JButton("PAPER");
        scissorsButton = new JButton("SCISSORS");
        quitButton = new JButton("QUIT");
        quitButton.addActionListener(e -> System.exit(0));
        rockButton.addActionListener(e -> {playerChoice = 0;});
        paperButton.addActionListener(e -> {playerChoice = 1;});
        scissorsButton.addActionListener(e -> {playerChoice = 2;});
        optionsPanel.add(rockButton);
        optionsPanel.add(paperButton);
        optionsPanel.add(scissorsButton);
        optionsPanel.add(quitButton);
        optionsPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    }
    public void CreateStatsPanel()
    {
        statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(2,3));
        winLabel = new JLabel("Player Wins");
        lossLabel = new JLabel("Computer Wins");
        tieLabel = new JLabel("Ties");
        winText = new JTextField(winCount);
        lossText = new JTextField(lossCount);
        tieText = new JTextField(tieCount);
        statsPanel.add(winLabel);
        statsPanel.add(lossLabel);
        statsPanel.add(tieLabel);
        statsPanel.add(winText);
        statsPanel.add(lossText);
        statsPanel.add(tieText);
    }
    public void CreateResultsPanel()
    {
        resultsPanel = new JPanel();
        resultsScroller = new JScrollPane();
        resultsText = new JTextArea();

        resultsScroller.add(resultsText);
        resultsPanel.add(resultsScroller);
    }
}
