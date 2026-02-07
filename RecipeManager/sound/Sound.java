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
       	   clip.open(AudioSystem.getAudioInputStream(getClass().getResource(rl.getSoundFile("/sound/click_sound.wav"))));
       	   
       	   clip.addLineListener(new LineListener() {
			 @Override
			 public void update(LineEvent event) {
		         if(event.getType() == LineEvent.Type.STOP) {
		             clip.close(); 	 
		         }
			   }
       	   });
          }catch(Exception e) {
        	 IO.println("Failed to prepare the sound: " + e.getMessage());
        }
	}
	public void playSound() {
	     clip.start();
	}
}
