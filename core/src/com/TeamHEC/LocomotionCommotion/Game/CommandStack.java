package com.TeamHEC.LocomotionCommotion.Game;

import java.util.ArrayList;
import java.util.List;

public class CommandStack {
	protected List<ICommand> stack = new ArrayList<ICommand>();
	protected int stackPointer = 0;
	
	public void execute(ICommand command) {
		stack = stack.subList(0, stackPointer);
		command.execute();
		stack.add(command);
		stackPointer++;
	}
	
	public void undo() {
		stackPointer--;
		stack.get(stackPointer).undo();
	}
	
	public boolean canUndo() {
		return stackPointer > 0;
	}
	
	public void redo() {
		stack.get(stackPointer).execute();
		stackPointer++;
	}
	
	public boolean canRedo() {
		return stackPointer < stack.size();
	}
	
}
