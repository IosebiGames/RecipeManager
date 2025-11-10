package sound;

import javax.sound.sampled.*;
import java.net.*;

public class Sound {
	
	private URL clickSound = getClass().getResource("/sound/click_sound.wav");
	private Clip clip;
	
	public Sound() {
		setup();
	}
	private void setup() {
         try {
        	 clip = AudioSystem.getClip();
        	 clip.open(AudioSystem.getAudioInputStream(clickSound));
         }catch(Exception e) {
        	 IO.println("Failed to prepare the sound: " + e.getMessage());
         }
	}
	public void playClickSound() {
	     clip.start();
	}
}