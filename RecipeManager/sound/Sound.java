package sound;

import javax.sound.sampled.*;
import Tools.ResourceLoader;

public class Sound {
	private Clip clip;
	private ResourceLoader rl = new ResourceLoader();
    
    public void playSound(String path, boolean preciseDebugging) { 
    	try {
    		clip = AudioSystem.getClip();
    	    clip.open(AudioSystem.getAudioInputStream(getClass().getResource(rl.getSoundFile(path))));	
    	    clip.start();
    	    clip.addLineListener(e -> {
    	      if(e.getType() == LineEvent.Type.STOP) { 
    	            clip.close();
    	      }});
    	}catch(Exception e) {
    		if(preciseDebugging) e.printStackTrace();	
    		else {
    			IO.println("Failed to play! " + e.getMessage());    	
    		}
    	}
    }
}
