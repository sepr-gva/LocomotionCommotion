package com.TeamHEC.LocomotionCommotion.Game_Actors;


import java.util.HashMap;

import com.TeamHEC.LocomotionCommotion.Game_Actors.Game_goal_Assets.Game_goal_RemoveBtn;
import com.TeamHEC.LocomotionCommotion.Goal.Goal;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Array;

public class Game_goal_PlayerGoals {

	private final static Array<Actor> actors = new Array<Actor>();
	private final static Array<Actor> subactors = new Array<Actor>();

	public static 	HashMap<String,Goal> player1goals ;
	public static 	HashMap<String,Game_goal_NewGoal> ownedGoals;
	private static 	HashMap<String, Game_goal_RemoveBtn> removebuttons ;
	private static 	HashMap<String, Label> ticketLabels ;

	public static Game_goal_NewGoal newgoal1, newgoal2, newgoal3;

	public Label ticket1, ticket2, ticket3;
	public LabelStyle style;


	public static Game_menuobject_ticketenclosure game_menuobject_ticketenclosure;
	public static Game_goal_RemoveBtn removebtn1,removebtn2,removebtn3;

	public static boolean open=false;

	public static int  stagestart, ticketActors, numberofOwnedGoals;


	public Game_goal_PlayerGoals(){	}

	public void create(Stage stage){

		actors.clear();
		subactors.clear();

		stagestart =0;
		ticketActors=0;

		game_menuobject_ticketenclosure=new Game_menuobject_ticketenclosure();
		actors.add(game_menuobject_ticketenclosure);


		player1goals = new HashMap<String,Goal>();
		ownedGoals = new HashMap<String,Game_goal_NewGoal>();
		//Temp Goals
		//		Goal goal1 = new Goal("London", "Paris", false, 100, 0, "Passenger","Any");
		//		Goal goal2 = new Goal("Madrid", "Moscow", false, 500, 0, "Passenger","Any");
		//		Goal goal3 = new Goal("Berlin", "Olso", false, 50, 0, "Passenger","Any");
		//		
		//		player1goals.put("1", goal1);
		//		player1goals.put("2", goal2);
		//		player1goals.put("3", goal3);
		//		//Temp end

		numberofOwnedGoals=player1goals.size();

		newgoal1= new Game_goal_NewGoal(Gdx.graphics.getHeight()-290,5,true,null);
		newgoal2= new Game_goal_NewGoal(Gdx.graphics.getHeight()-490,5,true,null);
		newgoal3= new Game_goal_NewGoal(Gdx.graphics.getHeight()-690,5,true,null);

		ownedGoals.put("1", newgoal1);
		ownedGoals.put("2", newgoal2);
		ownedGoals.put("3", newgoal3);



		//Label Styling
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/gillsans.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 17;

		BitmapFont font = generator.generateFont(parameter); 
		generator.dispose();
		style = new LabelStyle();
		style.font = font;
		//Ticket Labels
		ticketLabels = new HashMap<String, Label>();
		ticketLabels.put("1", ticket1= new Label(null,style));
		ticketLabels.put("2", ticket2= new Label(null,style));
		ticketLabels.put("3", ticket3= new Label(null,style));
		//Remove Buttons
		removebuttons = new HashMap<String, Game_goal_RemoveBtn>();
		removebuttons.put("1", removebtn1 = new Game_goal_RemoveBtn(1));
		removebuttons.put("2", removebtn2 = new Game_goal_RemoveBtn(2));
		removebuttons.put("3", removebtn3 = new Game_goal_RemoveBtn(3));
		for (int i=0; i<3; i++){
			String a = new Integer(i+1).toString();
			removebuttons.get(a).setVisible(false);

		}
		float tickety= 845, buttony = 870;

		for (int i=0; i<player1goals.size();i++){
			String a = new Integer(i+1).toString();

			ownedGoals.get(a).setGoal(player1goals.get(a));
			ownedGoals.get(a).setEmpty(false);

			ticketLabels.get(a).setColor(0,0,0,1);
			ticketLabels.get(a).setX(15);
			ticketLabels.get(a).setY(tickety);
			tickety-=200;
			ticketLabels.get(a).setText(ticketMaker(	ownedGoals.get(a).getGoal().getCarriageType(),
					ownedGoals.get(a).getGoal().getReward(),
					ownedGoals.get(a).getGoal().getSStation(),
					ownedGoals.get(a).getGoal().getStartDate(), 
					ownedGoals.get(a).getGoal().getFStation(), 
					ownedGoals.get(a).getGoal().getRoute())
					);
			removebuttons.get(a).setX(250);
			removebuttons.get(a).setY(buttony);
			buttony-=200;
			removebuttons.get(a).setVisible(true);
		}





		actors.add(newgoal1);
		actors.add(newgoal2);
		actors.add(newgoal3);
		actors.add(ticket1);
		actors.add(ticket2);
		actors.add(ticket3);
		subactors.add(removebtn1);
		subactors.add(removebtn2);
		subactors.add(removebtn3);





		stagestart= stage.getActors().size;
		for (Actor a : actors){
			if(open == true){
				a.setTouchable(Touchable.enabled);
				a.setVisible(true);}
			else
				a.setVisible(false);
			stage.addActor(a);
			ticketActors ++;
		}
		for (Actor b : subactors){
			b.setTouchable(Touchable.enabled);
			b.setVisible(false);

			stage.addActor(b);
		}




	}

	public static String ticketMaker(String type, int  reward, String from, int startdate, String dest, String route){
		String output;
		output ="";

		output += type + getSpacing(type.length()) + reward; 
		output += "\n\n";
		output += from + getSpacing(from.length()) + startdate; 
		output += "\n\n";
		output += dest + getSpacing(dest.length()) + route;
		return output;

	}
	public static String getSpacing(int len){
		String space="";
		for (int i=0; i<(17-len)+23; i++){
			space += " ";

		}
		return space;
	}

	public static void goalMenuOpen() {

		//Move Tickets
		for (Actor a: actors){
			a.setVisible(true);
			a.setX(a.getX()+150);
			a.setY(a.getY()-200);
		}
		//Hide goal side menu
		game_menuobject_ticketenclosure.setVisible(false);
		Game_menuObject_AManager.game_menuobject_tickettoggle.setVisible(false);
		//Put the remove Buttons in the correct place
		for (int i=0;i<numberofOwnedGoals; i++){
			String a = new Integer(i+1).toString();
			removebuttons.get(a).setX(250+150);
			removebuttons.get(a).setY(925-200-(200*i));
			removebuttons.get(a).setVisible(true);
			removebuttons.get(a).refreshBounds();;

		}


	}
	public static void goalMenuClose() {
		for (Actor a: actors){
			a.setVisible(false);
			a.setX(a.getX()-150);
			a.setY(a.getY()+200);
		}
		for (int i=0;i<3; i++){
			String a = new Integer(i+1).toString();
			removebuttons.get(a).setX(250);
			removebuttons.get(a).setY(870-(200*i));
			removebuttons.get(a).setVisible(false);
			removebuttons.get(a).resetButtons();

		}
		game_menuobject_ticketenclosure.setVisible(false);
		Game_menuObject_AManager.game_menuobject_tickettoggle.setVisible(true);



	}
	public static void removeGoal(int goal){		
		if(goal==1){
			ticketLabels.get("1").setText(ticketLabels.get("2").getText());
			ownedGoals.get("1").setGoal(ownedGoals.get("2").getGoal());
			removebuttons.get("1").setUndo(removebuttons.get("2").getUndo());
			removebuttons.get("1").setnewgoalindex(removebuttons.get("2").getnewgoalindex());

			ticketLabels.get("2").setText(ticketLabels.get("3").getText());
			ownedGoals.get("2").setGoal(ownedGoals.get("3").getGoal());
			removebuttons.get("2").setUndo(removebuttons.get("3").getUndo());
			removebuttons.get("2").setnewgoalindex(removebuttons.get("3").getnewgoalindex());

			if (ownedGoals.get("2").isEmpty()){
				ticketLabels.get("1").setText("");
				ownedGoals.get("1").setEmpty(true);
				removebuttons.get("1").setVisible(false);
				removebuttons.get("1").resetButtons();
			}

			if (ownedGoals.get("3").isEmpty()){
				ticketLabels.get("2").setText("");
				ownedGoals.get("2").setEmpty(true);
				removebuttons.get("2").setVisible(false);
			}


		}
		if (goal ==2){
			ownedGoals.get("2").setGoal(ownedGoals.get("3").getGoal());
			ticketLabels.get("2").setText(ticketLabels.get("3").getText());
			removebuttons.get("2").setUndo(removebuttons.get("3").getUndo());
			removebuttons.get("2").setUndo(removebuttons.get("3").getUndo());
			removebuttons.get("2").setnewgoalindex(removebuttons.get("3").getnewgoalindex());

			if (ownedGoals.get("3").isEmpty()){
				ticketLabels.get("2").setText("");
				ownedGoals.get("2").setEmpty(true);
				removebuttons.get("2").setVisible(false);
				removebuttons.get("2").resetButtons();
			}
		}
		ticketLabels.get("3").setText("");
		ownedGoals.get("3").setEmpty(true);
		removebuttons.get("3").setVisible(false);
		removebuttons.get("3").resetButtons();

		numberofOwnedGoals-=1;

		if (numberofOwnedGoals==0)
			numberofOwnedGoals=0;
	}

	public static boolean addGoal(Game_goal_NewGoal newgoal){
		if (numberofOwnedGoals>2){
			return false;
		}
		else
		{
			String a = new Integer(numberofOwnedGoals+1).toString();
			ticketLabels.get(a).setText(ticketMaker(newgoal.getGoal().getCarriageType(),
					newgoal.getGoal().getReward(),
					newgoal.getGoal().getSStation(),
					newgoal.getGoal().getStartDate(), 
					newgoal.getGoal().getFStation(), 
					newgoal.getGoal().getRoute())
					);
			ownedGoals.get(a).setGoal(newgoal.getGoal());
			ownedGoals.get(a).setEmpty(false);
			removebuttons.get(a).setVisible(true);
			removebuttons.get(a).setRedoBtn();
			removebuttons.get(a).setnewgoalindex(newgoal.getIndex());

			System.out.println(outputOwnedGoals());
			numberofOwnedGoals+=1;
			return true;
		}
	}

	public static void resetGoal(int index) {
		String a = new Integer(index).toString();
		String b = new Integer(removebuttons.get(a).getnewgoalindex()).toString();
		Game_Goal_GoalScreenManager.goalLabels.get(b).setText(ticketLabels.get(a).getText());
		Game_Goal_GoalScreenManager.createdGoals.get(removebuttons.get(a).getnewgoalindex()-1).setGoal(ownedGoals.get(a).getGoal());
		Game_Goal_GoalScreenManager.createdGoals.get(removebuttons.get(a).getnewgoalindex()-1).setEmpty(false);
		removeGoal(removebuttons.get(a).index);


	}

	public static String outputOwnedGoals(){
		String output;
		output="";
		for (int i=0;i<3;i++){
			String a = new Integer(i+1).toString();
			if (ownedGoals.get(a).isEmpty()==false){
				output+= ownedGoals.get(a).getGoal().getSStation()+ " ";
			}
		}
		return output;

	}




}
/*
 * Serializes all actors and stores them in an array. This and the Game object
 * are then saved and stored to be loaded.
 */