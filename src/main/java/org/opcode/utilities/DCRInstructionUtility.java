package org.opcode.utilities;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;

public class DCRInstructionUtility {

    private DCRInstructionUtility(){}

    public static void decrementRegisterContent(Register register, RegisterState state){
        register.setValue(register.getValue() - 1);
        state.updateValue(register);
    }
}
