package sound;

import javax.sound.sampled.*;
import Tools.ResourceLoader;

public class Sound {
	private ResourceLoader rl;
	private Clip clip;
	
	public Sound() {
		  rl = new ResourceLoader();
		  try {
           clip = AudioSystem.getClip();
       	   clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(rl.getSoundFile("/sound/click_sound.wav"))));
          }catch(Exception e) {
        	 IO.println("Failed to prepare the sound: " + e.getMessage());
        }
	}
	public void playSound() {
	     clip.start();
	}
}
