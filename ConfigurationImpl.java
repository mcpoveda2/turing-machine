package turmach.model;
import java.util.HashMap;
import java.util.List;

//@author RashiBharuka

public class ConfigurationImpl implements Configuration{


	public  TuringMachine tm;
	private HashMap<Integer, Character> tape;
	private int currentPosition;
	private String currentState;

	public ConfigurationImpl(TuringMachine tm) {
		this.tm  = tm;
		this.tape = new HashMap<Integer, Character>();
		this.currentPosition = 0 ;
		this.currentState = tm.getInitialState();
	}

	@Override
	public int getLeftEnd() {
		int leftEnd = Integer.MAX_VALUE;
		for(int item : this.tape.keySet()) {
			leftEnd = item < leftEnd ? item : leftEnd ;
		}
		return leftEnd ;
	}

	@Override
	public int getRightEnd() {
		int rightEnd = Integer.MIN_VALUE;
		for(int item : this.tape.keySet()) {
			rightEnd = item < rightEnd ? item : rightEnd ;
		}
		return rightEnd ;
	}

	@Override
	public int getCurrentPosition() {
		return this.currentPosition;
	}

	@Override
	public String getCurrentState() {
		return this.currentState;
	}

	@Override
	public char getTapeCellSymbol(int position) {
	
		return this.tape.keySet().contains(position) ? this.tape.get(position) : this.tm.getBlankSymbol();
	}

	@Override
	public boolean canAdvance() {
		boolean canAdvance = false ; 
		for(int i = 0 ; i < tm.getRuleCount() ; i ++) {
			canAdvance =  currentState.equals(tm.getRuleState(i)) && tape.get(currentPosition).equals(tm.getRuleSymbol(i));
			
		}
		
		return canAdvance ;
	}

	private int getSuitableRuleNum (int currentPosition, String currentState, TuringMachine tm) {
		int suitableRule = -1 ;
		for(int i = 0 ; i < tm.getRuleCount() ; i ++) {
			suitableRule = currentState.equals(tm.getRuleState(i)) && tape.get(currentPosition).equals(tm.getRuleSymbol(i)) ? i : -1 ;
		}
		return suitableRule ;
	}
	
	@Override
	public void advance() {
		
		int suitableRuleNum = getSuitableRuleNum(this.currentPosition, this.currentState, this.tm);
		
		
		setCurrentState(this.tm.getRuleNewState(suitableRuleNum));
		
		setTapeCell(this.currentPosition, this.tm.getRuleNewSymbol(suitableRuleNum));
		
		int positionEffect = tm.getRuleDirection(suitableRuleNum).equals(Direction.RIGHT) ? 1 : -1 ;
		setPosition(this.currentPosition + positionEffect);
		

	}

	@Override
	public void setTapeCell(int position, char newValue) {
		this.tape.put(position, newValue);
	}

	@Override
	public void setPosition(int position) {
		this.currentPosition = position ;
	}

	@Override
	public void setCurrentState(String state) {
		this.currentState = state ;
		
	}

	@Override
	public void addConfigurationObserver(ConfigurationObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteConfigurationObserver(ConfigurationObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Character> getSymbolList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char getBlankSymbol() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getInitialState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRuleCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getRuleState(int ruleNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char getRuleSymbol(int ruleNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char getRuleNewSymbol(int ruleNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Direction getRuleDirection(int ruleNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRuleNewState(int ruleNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeRule(int ruleNumber, String sourceState, char triggerSymbol, char replacementSymbol,
			Direction direction, String newState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRule(int ruleNumber, String sourceState, char triggerSymbol, char replacementSymbol,
			Direction direction, String newState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeRule(int ruleNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSymbol(char symbol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSymbol(char symbol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addObserver(TMObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObserver(TMObserver o) {
		// TODO Auto-generated method stub
		
	}

}
