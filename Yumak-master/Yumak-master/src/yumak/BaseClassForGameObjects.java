
package yumak;

import java.awt.image.BufferedImage;

enum ObjType {YELLOW_BALL, UP_ARROW, DOWN_ARROW, SKULL};

public abstract class BaseClassForGameObjects {
    public ObjType type; 
    protected int speed_factor;// nesnelerin geliş hızını belirleyen değişken
    protected BufferedImage image;
    private int x = 700, y = 400, width, height;
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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

    public int getSpeedFactor() {
        return speed_factor;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
}
