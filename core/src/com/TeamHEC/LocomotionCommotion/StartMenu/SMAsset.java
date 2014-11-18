package com.TeamHEC.LocomotionCommotion.StartMenu;

	public class SMAsset {
		public int assetID;
		public String name;
		public String file;
		public int pageX;
		public int pageY;
		public float posi;
		public float posj;
		public float realPosx;
		public float realPosy;
		public float width;
		public float height;
		
	
		
		//Getters
		public float getPosi(){
			return this.posi;
		}
		public float getPosj(){
			return this.posj;
		}
		public float getRealPosx(){
			return this.realPosx;
		}
		public float getrealPosy(){
			return this.realPosy;
		}
		
		public String getAsset(){
			return this.file;
			
		}

	}