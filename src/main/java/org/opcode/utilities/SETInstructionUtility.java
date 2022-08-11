package org.opcode.utilities;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;

public class SETInstructionUtility {

    private SETInstructionUtility(){}
    public static void setValue(Register register, RegisterState state, int value) {
        register.setValue(value);
        state.updateValue(register);
    }
}
