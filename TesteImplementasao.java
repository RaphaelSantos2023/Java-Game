import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.GPanelButton;
import model.GTextArea;

public class TesteImplementasao extends JPanel{

    public JTextArea Log = new JTextArea();
    public JLabel ImagemEnemy,StatusPlayer, EnemyHealth, BackGround;

    public JButton Ch1,Ch2,Ch3;

    public GPanelButton CombatPanel = new GPanelButton();
    public GPanelButton BackGroundPanel = new GPanelButton();
    public GPanelButton ImagemPlayerPanel;
    public GPanelButton CombatLogPanel = new GPanelButton(Log);
    public GPanelButton ButtonsPanel;

    public GridBagConstraints constraints = new GridBagConstraints();
    public GPanelButton StatusPlayerPanel = new GPanelButton();
    public GPanelButton PlayerImage = new GPanelButton();
    public GPanelButton EnemyPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TesteImplementasao T = new TesteImplementasao();
        T.testeDecombat();

        frame.add(T);
        frame.pack();
        frame.setVisible(true);
    }

    public void testeDecombat(){
        CombatLogPanel.setBackground(Color.BLUE);
        StatusPlayerPanel.setBackground(Color.GREEN);
        PlayerImage.add(new JLabel(new ImageIcon("image/Goblin.jpeg")));
        GTextArea CombatLog = new GTextArea("Textao ssdgsdfghsgsdfgtdsfgsdgagsgag");
        Ch1 = new JButton("fd");
        Ch2 = new JButton("gfh");
        Ch3 = new JButton("sdf");

        ButtonsPanel = new GPanelButton();
        ButtonsPanel.add(Ch1);
        ButtonsPanel.add(Ch2);
        ButtonsPanel.add(Ch3);
        
        StatusPlayerPanel.add(new JLabel("sdsdasdgsdgsadfgdssdgfa"));

        constraints.gridx = 0;
        constraints.gridy = 1;
        BackGround = new JLabel(new ImageIcon("image/GateBackGround_Sprite.png"));
        BackGroundPanel.add(BackGround);
        CombatPanel.add(BackGroundPanel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 5;
        CombatLogPanel.add(CombatLog);
        CombatPanel.add(CombatLogPanel,constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        StatusPlayerPanel.add(PlayerImage,constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        StatusPlayerPanel.add(ButtonsPanel,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        CombatPanel.add(StatusPlayerPanel,constraints);

    }
}
