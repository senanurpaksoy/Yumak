
package yumak;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;


public class YellowBall extends BaseClassForGameObjects {
    private int hp_factor;// sarı topların boyut ayarı

    public int getHPFactor() {
        return hp_factor;
    }

    YellowBall(int index) {
        type = ObjType.YELLOW_BALL;
        try{
            image = ImageIO.read(new FileImageInputStream(new File("images/sariTop" + index + ".png")));
        } 
        catch(IOException ex) {
            Logger.getLogger(GameObjects.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        hp_factor = index;
        speed_factor = index;// hızını belirliyor
    }
}
