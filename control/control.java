package control;

import model.GButton;
import model.GPanel;
import model.Charact.Character;
import model.Charact.Player;
import java.awt.event.ActionListener;

import view.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;

import java.awt.*;

public class control {

    private Main main;
    private char QUARTO = 'Q';
    private char CAMINHO = '+';
    private char ENTRADA = 'E';
    private char SAIDA = 'S';
    private char VAZIO = '.';
    private int linhas = 10;
    private int colunas = 10;
    private int qtdQ = 6;

    public control(Main main) {
        this.main = main;
    }

    private Random rand = new Random();
    private boolean Defending = false;

    public String Moviments(Player striker, Character enemy, String Comand) {
        String StrikerLog;
        String EnemyLog;

        StrikerLog = Decision(striker, enemy, Comand);
        EnemyLog = Decision(enemy, striker, "Ataque");
        
        Defending = false;

        System.out.println(striker.getName()+": tá com "+ striker.getHP());
        System.out.println(enemy.getName()+": tá com "+ enemy.getHP());

        main.EnemyHP.setText("HP: " + String.valueOf(main.enemy.getHP()));
        main.EnemyLevel.setText("Lv: " + String.valueOf(main.enemy.getLevel()));

        System.out.println("-----------------------------------");

        if (striker.getHP() <= 0) {
            return "- Você morreu";
        } else if(enemy.getHP() <= 0){
            return "- Você ganhou";
        }

        return "- " + StrikerLog + "\n- " + EnemyLog;

    }

    public String Decision(Character striker, Character enemy, String Comand) {

        int Dice = rand.nextInt(19) + 1;

        if (Comand.equals("Ataque")) {
            if (Dice >= enemy.getDiceValue() && !Defending) {
                int hit = striker.Atack(enemy);
                return striker.getName() + " deu " + Integer.toString(hit);
            }
            return striker.getName() + " Falhou";
        } else {
            Defending = true;
            return striker.getName() + " ficou em posição defensiva";
        }
    }

    public void SetItenspanel(GPanel InventoryPanel, GPanel Itenspanel, GPanel InfoPanel, GPanel ActionPanel, Player player) {

        Itenspanel.setLayout(new BoxLayout(Itenspanel, BoxLayout.Y_AXIS));

        GButton CloseBtn = new GButton("<");
        Itenspanel.add(CloseBtn);

        // Adicionando um ActionListener ao botão de fechamento
        CloseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                InventoryPanel.setVisible(false);  // Esconde o painel de inventário
                ActionPanel.setVisible(true);      // Mostra o painel de ação
            }
        });

        // Adicionando os itens do jogador ao painel
        for (int i = 0; i < player.getInventeorySize(); i++) {
            GButton ItemBtn = new GButton(player.getItem(i), InfoPanel, player, i);
            Itenspanel.add(ItemBtn);

            // Ajustando o tamanho dos botões dos itens
            ItemBtn.setPreferredSize(new Dimension(100, 30));  // Ajuste o tamanho conforme necessário
        }
    }
    public void criarMapa(int linhas, int colunas, int qtdQ) {
        char[][] matriz = new char[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = VAZIO;
            }
        }

        Random random = new Random();
        List<int[]> quartos = new ArrayList<>();
        
        // Adiciona os quartos "Q"
        while (quartos.size() < qtdQ) {
            int linha = random.nextInt(linhas);
            int coluna = random.nextInt(colunas);
            if (matriz[linha][coluna] == VAZIO) {
                matriz[linha][coluna] = QUARTO;
                quartos.add(new int[]{linha, coluna});
            }
        }

        // Ordena os quartos (opcional)
        Collections.sort(quartos, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        // Adiciona a entrada (E) e a saída (S) nas bordas
        int[] entrada = sorteiaPosicaoBorda(linhas, colunas, random);
        int[] saida = sorteiaPosicaoBorda(linhas, colunas, random);

        // Evita que E e S estejam adjacentes
        while (saoAdjacentes(entrada, saida)) {
            entrada = sorteiaPosicaoBorda(linhas, colunas, random);
            saida = sorteiaPosicaoBorda(linhas, colunas, random);
        }

        matriz[entrada[0]][entrada[1]] = ENTRADA;
        matriz[saida[0]][saida[1]] = SAIDA;

        // Conecta os quartos com caminhos "+"
        for (int i = 1; i < quartos.size(); i++) {
            conectarPontos(matriz, quartos.get(i - 1), quartos.get(i));
        }

        // Conectar E ao primeiro quarto
        conectarPontos(matriz, entrada, quartos.get(0));

        // Conectar S ao último quarto
        conectarPontos(matriz, saida, quartos.get(quartos.size() - 1));

        // Imprime a matriz
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[] sorteiaPosicaoBorda(int linhas, int colunas, Random random) {
        if (random.nextBoolean()) { // Primeira ou última linha
            return new int[]{random.nextBoolean() ? 0 : linhas - 1, random.nextInt(colunas)};
        } else { // Primeira ou última coluna
            return new int[]{random.nextInt(linhas), random.nextBoolean() ? 0 : colunas - 1};
        }
    }

    public boolean saoAdjacentes(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]) <= 1;
    }

    public void conectarPontos(char[][] matriz, int[] p1, int[] p2) {
        int x1 = p1[0], y1 = p1[1];
        int x2 = p2[0], y2 = p2[1];

        // Caminho horizontal
        for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
            if (matriz[x1][y] == VAZIO) {
                matriz[x1][y] = CAMINHO;
            }
        }

        // Caminho vertical
        for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
            if (matriz[x][y2] == VAZIO) {
                matriz[x][y2] = CAMINHO;
            }
        }
    }

}
