package com.TeamHEC.LocomotionCommotion.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(LocomotionCommotion.getInstance(), config);
		config.height= Gdx.graphics.getHeight();
		config.width = Gdx.graphics.getWidth();
		//config.fullscreen =true;
		
	}
}
