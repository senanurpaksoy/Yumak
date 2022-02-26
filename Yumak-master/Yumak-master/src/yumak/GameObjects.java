package yumak;

import java.util.ArrayList;

public class GameObjects{ 
    private ArrayList<BaseClassForGameObjects> objects = new ArrayList<>();
    
    // objeleri oluşturur
    public void generateObj(int i) {
        switch (i) {
            case 0:
                YellowBall yb = new YellowBall((int)(Math.random() * 10 + 1));// HPFactor 1 ile 10 arası
                yb.setY((int)(Math.random() * 600 + 100));
                yb.setWidth(yb.getHPFactor() * -5 + 100); // HPFactor 1 ise 95,  10 ise 50 genişliğinde çizdireceğiz. 
                yb.setHeight(yb.getWidth());
                objects.add(yb); 
                break;
            case 1:
                UpArrow ua = new UpArrow();
                ua.setX(750);
                ua.setY((int)(Math.random() * 600 + 100));
                ua.setWidth(40);
                ua.setHeight(40);
                objects.add(ua);
                break;
            case 2:
                DownArrow da = new DownArrow();
                da.setX(650);
                da.setY((int)(Math.random() * 600 + 100));
                da.setWidth(40);
                da.setHeight(40);
                objects.add(da);
                break;
            case 3:
                Skull s = new Skull();
                s.setX(650);
                s.setY((int)(Math.random() * 600 + 100));
                s.setWidth(40);
                s.setHeight(40);
                objects.add(s);
                break;
            default:
                break;
        }
    }
    
    public ArrayList<BaseClassForGameObjects> getObjects() {
            return objects;
    }
}
   
