import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

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
    private ImageIcon rockImage;
    private ImageIcon scissorsImage;
    private ImageIcon paperImage;
    private ImageIcon quitImage;
    private JLabel winLabel;
    public JTextField winText;
    private JLabel lossLabel;
    public JTextField lossText;
    private JLabel tieLabel;
    public JTextField tieText;
    private JScrollPane resultsScroller;
    public JTextArea resultsText;

    private RockPaperScissorsRunner rps = new RockPaperScissorsRunner();

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
        setLocation(screenWidth / 8, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void CreateOptionsPanel()
    {
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(1,4));
        rockImage = new ImageIcon("src\\0rock.jpg");
        Image rockTemp = rockImage.getImage();
        Image scalableRock = rockTemp.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        rockImage = new ImageIcon(scalableRock);
        paperImage = new ImageIcon("src\\0paper.jpg");
        Image paperTemp = paperImage.getImage();
        Image scalablePaper = paperTemp.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        paperImage = new ImageIcon(scalablePaper);
        scissorsImage = new ImageIcon("src\\0scissors.jpg");
        Image scissorsTemp = scissorsImage.getImage();
        Image scalableScissors = scissorsTemp.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        scissorsImage = new ImageIcon(scalableScissors);
        quitImage = new ImageIcon("src\\0quit.jpg");
        Image image = quitImage.getImage();
        Image scalableImg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        quitImage = new ImageIcon(scalableImg);
        rockButton = new JButton(rockImage);
        paperButton = new JButton(paperImage);
        scissorsButton = new JButton(scissorsImage);
        quitButton = new JButton(quitImage);
        quitButton.addActionListener(e -> System.exit(0));
        rockButton.addActionListener(e ->
        {
            rps.playerChoice = 0;
            rps.rockCount += 1;
            rps.NewGame(rps.playerChoice);
        });
        paperButton.addActionListener(e ->
        {
            rps.playerChoice = 1;
            rps.paperCount += 1;
            rps.NewGame(rps.playerChoice);
        });
        scissorsButton.addActionListener(e ->
        {
            rps.playerChoice = 2;
            rps.scissorsCount += 1;
            rps.NewGame(rps.playerChoice);
        });
        optionsPanel.add(rockButton);
        optionsPanel.add(paperButton);
        optionsPanel.add(scissorsButton);
        optionsPanel.add(quitButton);
        optionsPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    }
    private void CreateStatsPanel()
    {
        statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(2,3));
        winLabel = new JLabel("Player Wins");
        winLabel.setHorizontalTextPosition(JLabel.CENTER);
        lossLabel = new JLabel("Computer Wins");
        lossLabel.setHorizontalTextPosition(JLabel.CENTER);
        tieLabel = new JLabel("Ties");
        tieLabel.setHorizontalTextPosition(JLabel.CENTER);
        winText = new JTextField(rps.getWinCount());
        lossText = new JTextField(rps.getLossCount());
        tieText = new JTextField(rps.getTieCount());
        statsPanel.add(winLabel);
        statsPanel.add(lossLabel);
        statsPanel.add(tieLabel);
        statsPanel.add(winText);
        statsPanel.add(lossText);
        statsPanel.add(tieText);
    }
    private void CreateResultsPanel()
    {
        resultsPanel = new JPanel();
        resultsText = new JTextArea(10, 50);
        resultsScroller = new JScrollPane(resultsText);
        resultsPanel.add(resultsScroller);
    }
}
