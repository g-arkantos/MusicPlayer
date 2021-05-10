package PlayMusikk;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class play {
    public void playmusic(String musicLocation)
    {
        try
        {
            File musicpath = new File(musicLocation);
            if (musicpath.exists())
            {
                AudioInputStream audioInput= AudioSystem.getAudioInputStream(musicpath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(clip.LOOP_CONTINUOUSLY);


                JOptionPane.showMessageDialog(null, "Press OK to Pause.");
                long clipTimePosition= clip.getMicrosecondPosition();
                clip.stop();

                JOptionPane.showMessageDialog(null, "Press OK to Resume.");
                clip.setMicrosecondPosition(clipTimePosition);
                clip.start();

                JOptionPane.showMessageDialog(null, "Press OK to Stop.");

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error: File not found! ");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
