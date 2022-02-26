package yumak;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JPanel;

public class Game extends JPanel implements ActionListener, KeyListener  {
    private int ret_ctrl = 0; 
    private static int density = 190; // nesnelerin gelme yoğunluğunu belirleyen değişken
    private int passed_time = 0; // geçen süreyi belirleyen değişken
    private Timer timer;
    private static final int SCREEN_SIZE = 800;
    private TheCat cat = new TheCat();
    private GameObjects objs = new GameObjects();
    
    @Override
    public void paintComponent(Graphics graphs) {
        super.paintComponent(graphs);// eklenmezse ekran sıfırlanmaz ve resimler birbirine girer.
        Graphics2D g = (Graphics2D) graphs.create();
        
        g.drawString("Geçen Süre :" + passed_time / 1000.0 + "(s)", 650, 780);
        g.drawString("Yumağın Ömrü :" + cat.getLifeCounter(), 50, 780);
        
        g.drawImage(cat.image, cat.getX(), cat.getY(), cat.getWidth(), cat.getHeight(), this);// null da kullanılabilirdi. 
        
        for (int i = 0; i < objs.getObjects().size(); i++) { // foreach kullanarak da yapılabirdi.
            if (objs.getObjects().get(i).getX() < 0) {
                objs.getObjects().remove(i--);
                continue;
            }
            objs.getObjects().get(i).setX(objs.getObjects().get(i).getX() - objs.getObjects().get(i).getSpeedFactor());// nesnelerin x konumunu azaltıyoruz.
            g.drawImage(objs.getObjects().get(i).image, objs.getObjects().get(i).getX(), objs.getObjects().get(i).getY(), objs.getObjects().get(i).getWidth(), objs.getObjects().get(i).getHeight(), this);
        }
        
    }

    public Game() {
        timer = new Timer(40, this);
        timer.start();
        addKeyListener(this);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(SCREEN_SIZE, SCREEN_SIZE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if ((int) (Math.random() * (200 - density)) <= 0) {
            objs.generateObj((int) (Math.random() * 4)); // 200 - density(yoğunluk) de 1 olasılıkla nesne üretir
        }

        // nesne çarpışma kontrolü
        ret_ctrl = cat.control(objs);

        passed_time += 40;
        cat.setLifeCounter(cat.getLifeCounter() - 40 / 1000.0);// kedinin yaşam süresini düşürüyor.
        // çizim güncelleme
        repaint();
        
        if ((ret_ctrl == -1) || (cat.getLifeCounter() <= 0)) { // oyun bitiği zaman kullanılan şartımız ya kuru kafaya çarpar yada ömür süresi biter.
            timer.stop();
            
            String message = "   Kaybettiniz !!\n" +
                             "Tekrar Deneyiniz \n " +
                             "Geçen Süre :" +  passed_time / 1000.0 ;
            JOptionPane.showMessageDialog(this, message);
            System.exit(0);
                    
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_UP:
                cat.setY(cat.getY() - 10);
                break;
            case VK_DOWN:
                cat.setY(cat.getY() + 10);
                break;
            case VK_LEFT:
                cat.setX(cat.getX() - 10);
                break;
            case VK_RIGHT:
                cat.setX(cat.getX() + 10);
                break;
            default:
                break;
        }

        setFocusable(true); 
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}
