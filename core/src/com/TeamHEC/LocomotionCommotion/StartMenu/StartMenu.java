package com.TeamHEC.LocomotionCommotion.StartMenu;

import java.util.ArrayList;

import com.TeamHEC.LocomotionCommotion.LocomotionCommotion;

public class StartMenu {
	public int pageX;
	public int pageY;
	public ArrayList<SMAsset> smAssets;
	float w = LocomotionCommotion.width;
	float h = LocomotionCommotion.height;
	
	
	public void populateAssetList(){
		//Title asset
		SMAsset title = new SMAsset();
		title.assetID=1;
		title.name = "Title";
		title.file = "smTitle";
		title.pageX =0;
		title.pageY =0;
		title.posi = 0;
		title.posj = h- title.height;
		
		
		
	
		
		
	}
}
