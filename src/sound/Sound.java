package sound;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    private Clip clip;

    public Sound(){

    }
    public void laser(){
        try
        {
            AudioInputStream laserInpuStream = AudioSystem.getAudioInputStream(new File("sounds/laser.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(laserInpuStream);
            clip.start();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void blocks()
    {
        try
        {
            AudioInputStream laserInpuStream = AudioSystem.getAudioInputStream(new File("sounds/blocks.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(laserInpuStream);
            clip.start();

        } catch (Exception e)
        {
            e.printStackTrace();
        }



    }
    public void badle ()
    {
        try
        {
            AudioInputStream laserInpuStream = AudioSystem.getAudioInputStream(new File("sounds/badle1.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(laserInpuStream);
            clip.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fail()
    {
        try
        {
            AudioInputStream laserInpuStream = AudioSystem.getAudioInputStream(new File("sounds/fail.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(laserInpuStream);
            clip.start();
        } catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}