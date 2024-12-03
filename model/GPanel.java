//GPanel.java
package model;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;

import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;

public class GPanel extends JPanel {

    private BufferedImage BackGround;
    private BufferedImage Sprite_C;
    private Font TextFont = new Font("Times New Romans", Font.PLAIN, 26);

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

        int x1 = 0, y1 = 0, width1 = 400, height1 = 300;
        g2d.drawImage(BackGround, x1, y1, width1, height1, null);

        int x2 = 100, y2 = 150, width2 = 200, height2 = 150;
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

    public GPanel(JLabel label1, JLabel label2, int x, int y) {
        super();
        // Status do jogador
        setBackground(Color.blue);

        label1.setForeground(Color.WHITE);
        label2.setForeground(Color.WHITE);
        label1.setFont(TextFont);
        label2.setFont(TextFont);

        setLayout(new GridLayout(x, y));
        add(label1);
        add(label2);
    }

}
