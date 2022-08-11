package org.opcode.utilities;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;

public class ADRInstructionUtility {

    private ADRInstructionUtility(){}

    public static void addRegisterContent(Register register, Register register1, RegisterState state){
        register.setValue(register1.getValue() + register.getValue());
        state.updateValue(register);
    }
}
