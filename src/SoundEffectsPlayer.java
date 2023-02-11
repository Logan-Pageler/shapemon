


import java.io.File;
import java.time.Clock;
import java.util.Timer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JComponent;

public class SoundEffectsPlayer extends JComponent{
	static File shotSound = new File("ShotSound.wav");
	static File hitSound = new File("HitSound.wav");
	static File oppShotSound = new File("ShotSoundOpponent.wav");
	static File oppHitSound = new File("HitSoundOpponent.wav");
	static File deathSound = new File("DeathSound.wav");
	static Clip clip;
	private static boolean mute = false;

	static void playSound(File Sound) {
		if(!mute) {
			try {
				clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(Sound));
				clip.start();
			}catch(Exception e) {
				
			}
		}
	}
	static void unmute() {
		mute = false;
	}
	
	static void mute() {
		mute = true;
	}
}

