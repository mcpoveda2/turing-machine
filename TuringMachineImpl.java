package turmach.model;

import java.util.List;
import java.util.ArrayList;
import turmach.model.TuringMachine;


public class TuringMachineImpl implements TuringMachine{
	
	private ArrayList<Character> symbolList;
	private ArrayList<String> stateList;
	private ArrayList<Rule> ruleList;
	
	
	
	private record Rule(String initState, char initSymbol, char repSymbol, Direction dir, String newState) {};

	public TuringMachineImpl () {	
		
		this.symbolList = new ArrayList<Character>();
		this.symbolList.add('.');
		this.symbolList.add('0');
		this.symbolList.add('1');
		this.symbolList.add('(');
		this.symbolList.add(')');
		this.stateList  = new ArrayList<String>();
		this.stateList.add("init");	
		this.ruleList = new ArrayList<Rule>();
	}

	@Override
	public List<Character> getSymbolList() {
		return this.symbolList;
	}

	@Override
	public char getBlankSymbol() {
		return symbolList.get(0);
	}

	@Override
	public String getInitialState() {
		return this.stateList.get(0);
	}

	@Override
	public int getRuleCount() {
		return this.ruleList.size();
	}

	@Override
	public String getRuleState(int ruleNumber) {
		return this.ruleList.get(ruleNumber).initState();
	}

	@Override
	public char getRuleSymbol(int ruleNumber) {
		return this.ruleList.get(ruleNumber).initSymbol();
	}

	@Override
	public char getRuleNewSymbol(int ruleNumber) {
		return this.ruleList.get(ruleNumber).repSymbol();
	}

	@Override
	public Direction getRuleDirection(int ruleNumber) {
		return this.ruleList.get(ruleNumber).dir;
	}

	@Override
	public String getRuleNewState(int ruleNumber) {
		return this.ruleList.get(ruleNumber).newState();
	}

	@Override
	public void changeRule(int ruleNumber, String sourceState, char triggerSymbol, char replacementSymbol,
			Direction direction, String newState) {
		try {
			this.ruleList.set(ruleNumber, new Rule(sourceState, triggerSymbol, replacementSymbol, direction, newState));
		}catch(Exception e ) {
			System.out.println(e.getMessage() + "\n the rule you are looking for is undefined");
			
		}
		
	}
	
	@Override
	public void addRule(int ruleNumber, String sourceState, char triggerSymbol, char replacementSymbol,
			Direction direction, String newState) {
		this.ruleList.add(new Rule(sourceState, triggerSymbol, replacementSymbol, direction, newState));
	}

	@Override
	public void removeRule(int ruleNumber) {
		try {
			this.ruleList.remove(ruleNumber);
		}catch(Exception e ) {
			System.out.println(e.getMessage() + "\n the rule you are looking for is undefined");
			
		}
		
	}

	@Override
	public void addSymbol(char symbol) {
		this.symbolList.add(symbol);
	}

	@Override
	public void removeSymbol(char symbol) {
		if(this.symbolList.contains(symbol))
			this.symbolList.remove(symbol);
	}

	@Override
	public void addObserver(TMObserver o) {
		
	}

	@Override
	public void deleteObserver(TMObserver o) {
		
	}
}
