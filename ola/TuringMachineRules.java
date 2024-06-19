

public class TuringMachineRules {
    private TuringMachine tm;

    public TuringMachineRules(TuringMachine tm) {
        this.tm = tm;
    }


    public boolean canAdvance(String currentState, char currentSymbol) {
        for (int i = 0; i < tm.getRuleCount(); i++) {
            if (currentState.equals(tm.getRuleState(i)) && currentSymbol == tm.getRuleSymbol(i)) {
                return true;
            }
        }
        return false;
    }

    public int getSuitableRuleNum(String currentState, char currentSymbol) {
        for (int i = 0; i < tm.getRuleCount(); i++) {
            if (currentState.equals(tm.getRuleState(i)) && currentSymbol == tm.getRuleSymbol(i)) {
                return i;
            }
        }
        return -1;
    }
}