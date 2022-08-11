package org.opcode.utilities;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;

public class MOVInstructionUtility {

    private MOVInstructionUtility(){}

    public static void moveRegisterContentUtility(Register register, Register register1, RegisterState state){
        register.setValue(register1.getValue());
        state.updateValue(register);
    }
}
