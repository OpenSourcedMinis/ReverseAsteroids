package info.nanodesu.reverseasteroids.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.reflect.ArrayReflection;

public class Utls {
	
	public static int WORLD_WIDTH = 600;
	public static int WORLD_HEIGHT = 360;
	
	public static BitmapFont getFont() {
		return new BitmapFont(Gdx.files.internal("gfx/font.fnt"), Gdx.files.internal("gfx/font.png"), false);
	}
	
	public static <T> T[] flatten(T[][] arr) {
		int cnt = 0;
		for (T[] a: arr) {
			cnt += a.length;
		}

		@SuppressWarnings("unchecked")
		T[] result= (T[]) ArrayReflection.newInstance(arr.getClass().getComponentType().getComponentType(), cnt);
		
		int offset = 0;
		for (T[] a: arr) {
			System.arraycopy(a, 0, result, offset, a.length);
			offset += a.length;
		}
		
		return result;
	}
}