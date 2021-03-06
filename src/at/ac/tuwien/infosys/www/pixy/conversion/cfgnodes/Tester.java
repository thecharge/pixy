package at.ac.tuwien.infosys.www.pixy.conversion.cfgnodes;

import at.ac.tuwien.infosys.www.pixy.conversion.Variable;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * A special node for the builtin functions file.
 *
 * @author Nenad Jovanovic <enji@seclab.tuwien.ac.at>
 */
public class Tester extends AbstractCfgNode {
    // Set of Integer's indicating the positions of the parameters that
    // are to be tested
    private Set<Integer> paramNumbers;

    static public final int TEST_TAINT = 0;
    static public final int TEST_ARRAYLABEL = 1;

    // what to test: must be one of the above final's
    private int whatToTest;

    public Tester(int whatToTest, Set<Integer> paramNumbers) {
        super();
        this.whatToTest = whatToTest;
        this.paramNumbers = paramNumbers;
    }

    public List<Variable> getVariables() {
        return Collections.emptyList();
    }

    public int getWhatToTest() {
        return this.whatToTest;
    }

    public Set<Integer> getParamNumbers() {
        return this.paramNumbers;
    }

    public void replaceVariable(int index, Variable replacement) {
        // should not be necessary for this node
        throw new RuntimeException("SNH");
    }
}