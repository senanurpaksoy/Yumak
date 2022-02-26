package yumak;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

public class TheCat {
    private double life_counter = 10;// yaşam süresini ölçen değişken
    public BufferedImage image;
    private int x = 50;
    private int y = 400;
    private int state_factor = 3; // sarı top hariç diğer nesnelerin boyut faktörünü belirleyen değişken
    private int width;
    private int height;

    public TheCat() {
        updateSize();
        try {
            image = ImageIO.read(new FileImageInputStream(new File("images/cat.png")));
        } catch (IOException ex) {
            Logger.getLogger(TheCat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double getLifeCounter() {
        return life_counter;
    }

    public void setLifeCounter(double life_counter) {
        this.life_counter = life_counter;
    }
    
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    // 1(50) 2(60) 3(70) 4(80) 5(90)
    private void updateSize() { //yumağın boyutlarını ayarlıyoruz
        width = (state_factor) * 10 + 40;
        height = (state_factor) * 10 + 40;
    }
    
    // çarpışma şartları
    private static boolean collision(int l1x, int l1y, int r1x, int r1y, int l2x, int l2y, int r2x, int r2y) { 
        if ((l1x >= r2x) || (l2x >= r1x)) { 
            return false;
        }

        if ((l1y >= r2y) || (l2y >= r1y)) {
            return false;
        }

        return true;
    }
    
    //çarpışma kotrolü
    public int control(GameObjects objs) { 
        for (int i = 0; i < objs.getObjects().size(); i++) {// foreach da kullanılabilirdi. 
            int obj_x = objs.getObjects().get(i).getX();
            int obj_y = objs.getObjects().get(i).getY();
            int obj_w = objs.getObjects().get(i).getWidth();
            int obj_h = objs.getObjects().get(i).getHeight();
            
            if (collision(x, y, x + width, y + height, obj_x, obj_y, obj_x + obj_w, obj_y + obj_h)) {
                switch (objs.getObjects().get(i).type) {
                    case YELLOW_BALL:
                        life_counter += objs.getObjects().get(i).getSpeedFactor();
                        break;
                    case UP_ARROW:
                        if (state_factor < 5) {
                            state_factor++; 
                            updateSize();
                        }
                        break;
                    case DOWN_ARROW:
                        if (state_factor > 0) {
                            state_factor--; 
                            updateSize();
                        }
                        break;
                    case SKULL:
                        return -1;
                    default:
                        break;
                }
                objs.getObjects().remove(i--);
            }
        }
        
        return 1;
    }
}
