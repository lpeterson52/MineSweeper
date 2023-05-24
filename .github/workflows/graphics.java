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
    private int x;
    private int y;
    private int cX;
    private int cY;
    private boolean won = false;
    /**
     * Called by the runtime system whenever the panel needs painting.
     */

    public void paint(Graphics g) {
        super.paint(g);
        JLabel label = new JLabel();
        label.setBounds(0, 0, 460, 600);
        add(label);
        label.addMouseListener(this);
        for (int l = 0; l < 10; l++) {
            for (int w = 0; w < 10; w++) {
                TileGraphics t = new TileGraphics(20 + 40 * l, w * 40 + 20, m.getGrid(w, l).getNumber(), g,
                        m.getGrid(w, l).isRevealed());

            }
        }
        if(m.isCompletelyRevealed() && won == false){
            g.drawString("YOU WIN",150,500);
            won = true;
            m.revealBoard();
            repaint();
        }
        if(won){
            g.drawString("YOU WIN",150,500);
        }
        if(m.getGrid(cY,cX).getMine()){
            g.drawString("YOU LOSE",150,500);
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
        x = e.getX();
        y = e.getY();
        cX =  (x - 30) / 40;
        cY =  (y - 30) / 40;
        System.out.println(cX);
        System.out.println(cY);
        m.appear(cY, cX);
        repaint();
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
