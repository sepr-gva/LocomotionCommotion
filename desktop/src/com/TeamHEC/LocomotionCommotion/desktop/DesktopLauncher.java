package com.TeamHEC.LocomotionCommotion.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(LocomotionCommotion.getInstance(), config);
		config.height= 1050;
		config.width = 1680;
	}
}
