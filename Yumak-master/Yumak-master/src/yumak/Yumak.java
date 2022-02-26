/*
               2A
  Senanur PAKSOY-Rümeysa KARAOĞLAN
    02185076030 - 02195076062  
*/

package yumak;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Yumak {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Yumak");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new Game());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}