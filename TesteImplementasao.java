import java.awt.*;
import javax.swing.*;
import model.ResponsiveImagePanel;

public class TesteImplementasao extends JPanel {
    
    public JPanel ButtonP,TextP,TurnP,StatusPlayer, SouthPanel;
    public ResponsiveImagePanel RIP = new  ResponsiveImagePanel("./image/BackGround_Sprite.png");
    public JButton Botao1,Botao2,Botao3;
    public JTextArea txt;

    public TesteImplementasao(){
        setLayout(new BorderLayout());

        Botao1 = new JButton("Atack");
        Botao2 = new JButton("Defend");
        Botao3 = new JButton("Run");

        ButtonP = new JPanel(new FlowLayout());
        ButtonP.add(Botao1);
        ButtonP.add(Botao2);
        ButtonP.add(Botao3);

        txt = new JTextArea();
        txt.setText("-Atack\n-Defesa");
        TextP = new JPanel();
        TextP.add(txt);

        StatusPlayer = new JPanel();
        StatusPlayer.add(new JLabel("Aqui tem o hp do player"));

        TurnP = new JPanel();
        TurnP.add(new JLabel("Aqui tem o hp"));

        SouthPanel = new JPanel();
        SouthPanel.add(StatusPlayer);
        SouthPanel.add(ButtonP);

        add(SouthPanel, BorderLayout.SOUTH);
        add(TextP,BorderLayout.EAST);
        add(TurnP,BorderLayout.NORTH);
        add(RIP,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // Criando o JFrame
        JFrame frame = new JFrame("BorderLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new TesteImplementasao());

        // Tornando o JFrame visível
        frame.setVisible(true);
    }

}

