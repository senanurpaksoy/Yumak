
package yumak;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;


public class UpArrow extends BaseClassForGameObjects {
    UpArrow() {
        type = ObjType.UP_ARROW;
        try {
            image = ImageIO.read(new FileImageInputStream(new File("images/yukariOk.png")));
        } 
        catch(IOException ex){
            Logger.getLogger(GameObjects.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        speed_factor = 5; // Hızını belirtiyor.
    }
}
