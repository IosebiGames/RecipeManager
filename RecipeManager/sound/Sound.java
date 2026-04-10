package sound;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import Tools.ResourceLoader;

public class Sound {
	private Clip clip;
	private ResourceLoader rl;
    
	public Sound() {
		this.rl = new ResourceLoader();
	}
    public void playSound(String path) { 
    	try {
    		clip = AudioSystem.getClip();
    	    clip.open(AudioSystem.getAudioInputStream(getClass().getResource(rl.getSoundFile(path))));	
    	    clip.start();
    	    clip.addLineListener(e -> {
    	        if(e.getType() == LineEvent.Type.STOP) {
    	        	clip.close();
    	        }
    	    });
    	}catch(Exception e) {
           System.out.println("Failed to play! " + e.getMessage());    	
    	}
    }
}
