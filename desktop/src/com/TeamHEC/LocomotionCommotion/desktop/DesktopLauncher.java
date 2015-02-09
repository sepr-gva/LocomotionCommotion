package com.TeamHEC.LocomotionCommotion.desktop;

import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(LocomotionCommotion.getInstance(), config);
		config.width = 1680;
		config.height = 1050;
		config.fullscreen = false;	
	}
}
