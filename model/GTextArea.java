package model;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;

public class GTextArea extends JTextArea{
    
    private JFrame window;

    public GTextArea(JFrame window){
        super();
        this.window = window;
        setFont( new Font("Times New Romans", Font.PLAIN, 28));
        setForeground(Color.WHITE);
        setBackground(Color.red);
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                resizeComponents();
            }
        });
    }
    
    public GTextArea(JFrame window, String txt){
        super();
        setText(txt);
        setFont( new Font("Times New Romans", Font.PLAIN, 28));
        setLineWrap(true);
        setForeground(Color.WHITE);
        setBackground(Color.BLACK);
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                resizeComponents();
            }
        });
    }

    private void resizeComponents() {

        Dimension newSize = window.getSize();
        int width = newSize.width;
        int height = newSize.height;

        // Redimensionando o painel fixo proporcionalmente à largura da janela
        window.getContentPane().setPreferredSize(new Dimension(width / 3, height));
        
        // Revalidando o layout para que as alterações tenham efeito
        revalidate();
    }
}
