package model;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class GPanel extends JPanel {

    private BufferedImage BackGround;
    private BufferedImage Sprite_C;

    public GPanel(String BQGround, String Sprite) {
        try {
            // Carregue as duas imagens
            BackGround = ImageIO.read(new File(BQGround));
            Sprite_C = ImageIO.read(new File(Sprite));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Defina a posição e o tamanho da primeira imagem
        int x1 = 0, y1 = 0, width1 = 400, height1 = 300;
        g2d.drawImage(BackGround, x1, y1, width1, height1, null);

        // Defina a posição e o tamanho da segunda imagem
        int x2 = 100, y2 = 100, width2 = 200, height2 = 150;
        g2d.drawImage(Sprite_C, x2, y2, width2, height2, null);
    }

    public GPanel() {
        super();
        setBackground(Color.BLACK);
    }

    public GPanel(JButton but1, JButton but2, JButton but3, JButton but4) {
        super();
        // Painel dos butões de ação
        setBackground(Color.BLACK);
        setLayout(new GridLayout(4, 1));
        add(but1);
        add(but2);
        add(but3);
        add(but4);
    }

    public GPanel(JLabel label1, JLabel label2) {
        super();
        // Status do jogador
        setBackground(Color.blue);
        setLayout(new GridLayout(2, 1));
        add(label1);
        add(label2);
    }

}
