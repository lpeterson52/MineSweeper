import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
// import javax.swing.SwingUtilities;
// import javax.swing.JFrame;
// import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.JLabel;

/**
 * A panel maintaining a picture of a Do Not Enter sign.
 */
public class graphics extends JPanel implements MouseListener {
    private static final long serialVersionUID = 7148504528835036003L;
    Minesweeper m = new Minesweeper();
    boolean flagging = false;

    /**
     * Called by the runtime system whenever the panel needs painting.
     */
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        JLabel label = new JLabel();
        label.setBounds(20 + 40 * 0,0 * 40 + 20,40,40);
        String s = "" + m.getGrid(0,0).getNumber();
        label.setText(s);
        label.setBackground(Color.GRAY);
        label.setOpaque(true);
        label.addMouseListener(this);
        this.add(label);
        for (int l = 0; l < 10; l++) {
            for (int w = 0; w < 10; w++) {
                // TileGraphics t = new TileGraphics(20 + 40 * l, w * 40 + 20, m.getGrid(l, w).getNumber(), g,
                //         m.getGrid(l, w).isRevealed());
                        // t.addMouseListener(this);
                        // t.setBounds(20 + 40 * l, w * 40 + 20,60+40*l,60+40*w);
                        // JLabel label = new JLabel();
                        // label.setBounds(20 + 40 * l,w * 40 + 20,40,40);
                        // String s = "" + m.getGrid(l,w).getNumber();
                        // label.setText(s);
                        // label.setBackground(Color.GRAY);
                        // label.setOpaque(true);
                        // label.addMouseListener(this);
                        // this.add(label);
                        
            

            }
        }
    }

    /**
     * A little driver in case you want a stand-alone application.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            graphics panel = new graphics();
            panel.setBackground(Color.WHITE);
            JFrame frame = new JFrame("Minesweeper");
            frame.setSize(460, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(panel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("1");
    }   

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
