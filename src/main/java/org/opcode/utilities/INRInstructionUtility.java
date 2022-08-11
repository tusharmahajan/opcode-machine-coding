package org.opcode.utilities;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;

public class INRInstructionUtility {

    private INRInstructionUtility(){}

    public static void incrementRegisterContent(Register register, RegisterState state){
        register.setValue(register.getValue() + 1);
        state.updateValue(register);
    }
}
