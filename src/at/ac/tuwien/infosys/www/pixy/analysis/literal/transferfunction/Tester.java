package at.ac.tuwien.infosys.www.pixy.analysis.literal.transferfunction;

import at.ac.tuwien.infosys.www.pixy.analysis.AbstractLatticeElement;
import at.ac.tuwien.infosys.www.pixy.analysis.AbstractTransferFunction;
import at.ac.tuwien.infosys.www.pixy.analysis.literal.LiteralLatticeElement;
import at.ac.tuwien.infosys.www.pixy.conversion.Literal;
import at.ac.tuwien.infosys.www.pixy.conversion.Variable;

/**
 * Transfer function for special ~_test_ node.
 *
 * @author Nenad Jovanovic <enji@seclab.tuwien.ac.at>
 */
public class Tester extends AbstractTransferFunction {
    // provides access to the return variable of the function enclosing
    // this ~_test_ node
    private Variable retVar;

// *********************************************************************************
// CONSTRUCTORS ********************************************************************
// *********************************************************************************

    public Tester(at.ac.tuwien.infosys.www.pixy.conversion.cfgnodes.Tester cfgNode) {
        this.retVar = cfgNode.getEnclosingFunction().getRetVar();
    }

// *********************************************************************************
// OTHER ***************************************************************************
// *********************************************************************************

    public AbstractLatticeElement transfer(AbstractLatticeElement inX) {

        LiteralLatticeElement in = (LiteralLatticeElement) inX;
        LiteralLatticeElement out = new LiteralLatticeElement(in);

        // this one is easy: just set the return variable to TOP
        out.setRetVar(this.retVar, Literal.TOP);
        return out;
    }
}