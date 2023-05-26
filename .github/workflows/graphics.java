import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JPanel;

public class graphics extends JPanel implements MouseListener {
    private static final long serialVersionUID = 7148504528835036003L;
    Minesweeper m = new Minesweeper();
    private boolean flagging = false;
    private boolean lost = false;
    private int x;
    private int y;
    private int cX;
    private int cY;
    private boolean won = false;
    private boolean justFlagged = false;

    public graphics() {
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
    }

    public void setFlagging(boolean flagging) {
        this.flagging = flagging;
    }

    public boolean getFlagging() {
        return flagging;
    }
    public void setJustFlagging(boolean flagging){
        setJustFlagging(true);
    }
    public void resetcoords(){
        cX = 0;
        cY = 0;
        x = 0;
        y = 0;
    }
    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (getFlagging()) {
                setFlagging(false);
            } else {
                setFlagging(true);
                resetcoords();
            }
            System.out.println(flagging);
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        JLabel label = new JLabel();
        label.setBounds(0, 0, 460, 600);
        add(label);
        label.addMouseListener(this);
        JLabel label1 = new JLabel();
        label1.setBounds(23, 480, 26, 26);
        label1.addMouseListener(this);
        for (int l = 0; l < 10; l++) {
            for (int w = 0; w < 10; w++) {
                TileGraphics t = new TileGraphics(20 + 40 * l, w * 40 + 20, m.getGrid(w, l).getNumber(), g,
                        m.getGrid(w, l).isRevealed(),m.getGrid(w,l).getFlag());
                

            }
        }
        if(m.isCompletelyRevealed() && won == false && lost == false){
            g.drawString("YOU WIN",150,500);
            won = true;
            m.revealBoard();
            repaint();
        }
        if(won){
            g.drawString("YOU WIN",150,500);
        }
        if(m.getGrid(cY,cX).getMine() && lost == false && flagging == false && justFlagged == false){
            lost = true;
            g.drawString("YOU LOSE",150,500);
            m.revealBoard();
            repaint();
        }
        else if(justFlagged){
            justFlagged = false;
        }
        if(lost){
            g.drawString("YOU LOSE",150,500);
        }

        Font stringFont = new Font("SansSerif", Font.PLAIN, 13);
        g.setFont(stringFont);
        g.drawString("Press any key to toggle flagging (click on different tile before toggling off)",20,550);
        if(flagging){
            g.setColor(Color.RED);
            g.fillRect(23,480,25,25);
            g.setColor(Color.BLACK);
            g.drawRect(23,480,25,25);
        }
        else{
            g.setColor(Color.BLACK);
            g.drawRect(23,480,25,25);
        }
    }

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
        cX = (x - 30) / 40;
        cY = (y - 30) / 40;
        System.out.println(cX);
        System.out.println(cY);
        if (flagging == false) {
            m.appear(cY, cX);
        } else {
            if (m.getGrid(cY, cX).getFlag()) {
                m.getGrid(cY, cX).setFlag(false);
            } else {
                m.getGrid(cY, cX).setFlag(true);
            }
        }
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
