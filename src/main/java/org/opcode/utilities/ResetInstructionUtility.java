package org.opcode.utilities;

import org.opcode.model.RegisterState;

public class ResetInstructionUtility {

    private ResetInstructionUtility(){}

    public static void resetRegisters(RegisterState state){
        state.reset();
    }
}
