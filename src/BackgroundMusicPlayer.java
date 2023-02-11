


import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BackgroundMusicPlayer extends SoundEffectsPlayer{

	static File battleThemeSong = new File("BattleThemeSong.wav");
	static File overWorldThemeSong = new File("OverWorldThemeSong.wav");
	static Clip clip;
	
	static void playBGM(File BGM) {
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(BGM));
			clip.start();
		}catch(Exception e) {
			
		}
	}
	
	static void resume() {
		int x = clip.getFramePosition();
		clip.start();
		clip.setFramePosition(x);
	}
	
	static void pause() {
		clip.stop();
	}
}
