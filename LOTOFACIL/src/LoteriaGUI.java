import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LoteriaGUI extends JFrame {

    private JButton botaoOpcao1, botaoOpcao2, botaoOpcao3;
    private JLabel resultadoLabel;

    public LoteriaGUI() {
        super("Menu LOTOFÁCIL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        botaoOpcao1 = new JButton("Apostar de 0 a 100");
        botaoOpcao2 = new JButton("Apostar de A à Z");
        botaoOpcao3 = new JButton("Apostar em par ou ímpar");
        resultadoLabel = new JLabel("");

        botaoOpcao1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                opcao1();
            }
        });

        botaoOpcao2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                opcao2();
            }
        });

        botaoOpcao3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                opcao3();
            }
        });

        painel.add(botaoOpcao1);
        painel.add(botaoOpcao2);
        painel.add(botaoOpcao3);
        painel.add(resultadoLabel);

        add(painel);
        setVisible(true);
    }

    private void opcao1() {
        Random aleatorio = new Random();
        int numeroAleatorio = aleatorio.nextInt(101);
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número entre 0 e 100: "));

        if (numero == numeroAleatorio) {
            resultadoLabel.setText("Parabéns! Você ganhou R$ 1.000,00!");
        } else {
            resultadoLabel.setText("Que pena! O número sorteado foi: " + numeroAleatorio);
        }
    }

    private void opcao2() {
        Random aleatorio = new Random();
        char letraPremiada = (char) ('A' + aleatorio.nextInt(26));
        char letra = JOptionPane.showInputDialog("Digite uma letra de A a Z: ").toUpperCase().charAt(0);

        if (letra == letraPremiada) {
            resultadoLabel.setText("Parabéns! Você ganhou R$ 500,00 reais.");
        } else {
            resultadoLabel.setText("Que pena! A letra sorteada foi: " + letraPremiada);
        }
    }

    private void opcao3() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número: "));

        if (numero % 2 == 0) {
            resultadoLabel.setText("Você ganhou R$ 100,00 reais.");
        } else {
            resultadoLabel.setText("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
        }
    }

    public static void main(String[] args) {
        new LoteriaGUI();
    }
}
