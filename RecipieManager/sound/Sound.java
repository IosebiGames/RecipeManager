package sound;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Tools.ResourceLoader;

public class Sound {
	
	private ResourceLoader rl;
	private String sound;
	private Clip clip;
	
	public Sound() {
		  rl = new ResourceLoader();
		  sound = rl.getSoundFile("/sound/click_sound.wav");
		  try {
           clip = AudioSystem.getClip();
       	   clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(sound)));
          }catch(Exception e) {
        	 IO.println("Failed to prepare the sound: " + e.getMessage());
        }
	}
	public void playSound() {
	     clip.start();
	}
}
