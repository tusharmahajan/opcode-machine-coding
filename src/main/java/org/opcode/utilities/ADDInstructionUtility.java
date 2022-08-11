package org.opcode.utilities;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;

public class ADDInstructionUtility{

    private ADDInstructionUtility(){}

    public static void addValue(Register register, RegisterState state, int value){
        register.setValue(register.getValue() + value);
        state.updateValue(register);
    }
}
