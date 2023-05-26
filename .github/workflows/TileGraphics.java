
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;    
import javax.swing.*;

public class TileGraphics implements MouseListener{
    public TileGraphics(int x, int y, int num,Graphics g,boolean revealed,boolean hasFlag) {
        drawTile(x,y,num,g,revealed);
        if(hasFlag){
            drawFlag(x+25,y+15,g);
        }
    }
    JLabel label;
    public TileGraphics(){
        
    }
    public void drawTile(int x, int y, int num, Graphics g,boolean revealed) {
        // set font and size
        Font stringFont = new Font("SansSerif", Font.PLAIN, 30);
        g.setFont(stringFont);
        // create grey background for tile
        if(revealed == false){
            g.setColor(Color.WHITE);
            g.fillRect(x, y, 40, 40);
            // draws border of rectangle
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 40, 40);
        }
        else{
        g.setColor(Color.GRAY);
        g.fillRect(x, y, 40, 40);
        // draws border of rectangle
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 40, 40);
        // draw number
        if (num == 1) {
            g.setColor(Color.BLUE);
            g.drawString("1", x + 13, y + 31);
        }
        if (num == 2) {
            g.setColor(Color.GREEN);
            g.drawString("2", x + 13, y + 31);
        }
        if (num == 3) {
            g.setColor(Color.RED);
            g.drawString("3", x + 13, y + 31);
        }
        if (num == 4) {
            g.setColor(Color.BLUE.darker());
            g.drawString("4", x + 13, y + 31);
        }
        if (num == 5) {
            g.setColor(Color.RED.darker());
            g.drawString("5", x + 13, y + 31);
        }
        if (num == 6) {
            Color c = new Color(51, 204, 255);
            g.setColor(c);
            g.drawString("6", x + 13, y + 31);
        }
        if (num == 7) {
            g.setColor(Color.BLACK);
            g.drawString("7", x + 13, y + 31);
        }
        if(num == -1){
            g.setColor(Color.RED);
            g.drawString("X", x + 13, y + 31);
        }
    }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("clicked");
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

    public void drawFlag(int xLocation, int yLocation, Graphics graphics){

        graphics.setColor(Color.BLACK);
        graphics.fillRect( xLocation-3,  yLocation,  3,  15);
        graphics.fillRect( xLocation - 9,  yLocation + 12,  14,  3);
        graphics.setColor(Color.RED);
        graphics.fillPolygon(new int[] {xLocation, xLocation - 15, xLocation}, new int[] {yLocation + 8, yLocation, yLocation-8}, 3);
        
    }
}
