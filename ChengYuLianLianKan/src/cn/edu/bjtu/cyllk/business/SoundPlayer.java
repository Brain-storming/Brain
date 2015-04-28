package cn.edu.bjtu.cyllk.business;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import cn.edu.bjtu.cyllk.R;
import cn.edu.bjtu.cyllk.game.XitongSound;
import cn.edu.bjtu.cyllk.global.Constant;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class SoundPlayer {
	private static MediaPlayer music;
	private static SoundPool soundPool;
	private static Context context;

	private static final int[] musicId = { R.raw.welcom_music };
	private static Map<Integer, Integer> soundMap;// 音效资源ID与加载过后的音源ID的映射关系表

	public static void init(Context c) {
		context = c;
		initMusic();
		initsound();
	}

	// 初始化音效播放器
	private static void initsound() {
		soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 100);
		soundMap = new HashMap<Integer, Integer>();
		soundMap.put(R.raw.bt_music, soundPool.load(context, R.raw.bt_music, 1));
		soundMap.put(R.raw.cuowu_music,
				soundPool.load(context, R.raw.cuowu_music, 1));
		soundMap.put(R.raw.dianji_music,
				soundPool.load(context, R.raw.dianji_music, 1));
		soundMap.put(R.raw.quxiao_music,
				soundPool.load(context, R.raw.quxiao_music, 1));
		soundMap.put(R.raw.xiaochu_music,
				soundPool.load(context, R.raw.xiaochu_music, 1));
	}

	// 初始化音乐播放器
	private static void initMusic() {
		// int r = new Random().nextInt(musicId.length);
		music = MediaPlayer.create(context, musicId[0]);
		music.setLooping(true);
	}

	// 播放音效
	public static void playsound(int resId) {
		if (Constant.soundSt == false)
			return;
		Integer soundId = soundMap.get(resId);
		if (soundId != null)
			soundPool.play(soundId, 1, 1, 1, 0, 1);
	}

	// 暂停音乐
	public static void pauseMusic() {
		if (music.isPlaying())
			music.pause();
	}

	// 播放音乐
	public static void startMusic() {
		if (!music.isPlaying())
			music.start();
	}

	// 停止音乐
	public static void stopMusic() {
		music.stop();
		music.release();
	}

	// 更换背景音乐并播放
	// public static void changeAndPlayMusic()
	// {
	// gequhao++;
	// SoundPlayer.stopMusic();
	// music = MediaPlayer.create(context, musicId[gequhao%1]);
	//
	// music.setLooping(true);
	// SoundPlayer.startMusic();
	// }

	// 设置音乐开关
	public static void setMusicSt(boolean musicSt) {
		Constant.musicSt = musicSt;
		if (musicSt)
			music.start();
		else
			music.stop();
	}

	// 获得音效开关状态
	public static Boolean isSoundSt() {
		return Constant.soundSt;
	}

	// 设置音效开关
	public static void setSoundSt(boolean soundSt) {
		Constant.soundSt = soundSt;
	}

	public static boolean initOrNot() {
		if (context == null) {
			return false;
		} else {
			return true;
		}
	}
}
