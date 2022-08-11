package org.opcode.service;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;
import org.opcode.utilities.*;

import java.util.List;

public class GeneralOpcodeInstruction implements OpcodeSimulator{

    RegisterState state;
    public GeneralOpcodeInstruction(List<Register> registers) {
        state = new RegisterState(registers);
    }

    @Override
    public RegisterState execute(List<String> instructions) {

        for(String instruction: instructions){
            String[] command = instruction.split(" ");

            switch (command[0]){
                case "RST":
                    resetRegisters();
                    break;
                case "SET":
                    Register register = state.getRegister(command[1].charAt(0));
                    setValue(register, state, Integer.parseInt(command[2]));
                    break;
                case "ADD":
                    register = state.getRegister(command[1].charAt(0));
                    addValue(register, state, Integer.parseInt(command[2]));
                    break;
                case "ADR":
                    register = state.getRegister(command[1].charAt(0));
                    Register register1 = state.getRegister(command[2].charAt(0));
                    addRegisterContent(register, register1, state);
                    break;
                case "MOV":
                    register = state.getRegister(command[1].charAt(0));
                    register1 = state.getRegister(command[2].charAt(0));
                    moveRegisterContent(register, register1, state);
                    break;
                case "INR":
                    register = state.getRegister(command[1].charAt(0));
                    incrementRegisterContent(register);
                    break;
                case "DCR":
                    register = state.getRegister(command[1].charAt(0));
                    decrementRegisterContent(register);
                    break;
                default:
                    break;
            }

        }
        return state;
    }

    private void resetRegisters() {
        ResetInstructionUtility.resetRegisters(state);
    }

    private void decrementRegisterContent(Register register) {
        DCRInstructionUtility.decrementRegisterContent(register, state);
    }

    private void incrementRegisterContent(Register register) {
        INRInstructionUtility.incrementRegisterContent(register, state);
    }

    private void moveRegisterContent(Register register, Register register1, RegisterState state) {
        MOVInstructionUtility.moveRegisterContentUtility(register, register1, state);
    }

    private void addRegisterContent(Register register, Register register1, RegisterState state) {
        ADRInstructionUtility.addRegisterContent(register, register1, state);
    }

    private void addValue(Register register, RegisterState state, int value) {
        ADDInstructionUtility.addValue(register, state, value);
    }

    private void setValue(Register register, RegisterState state, int value) {
        SETInstructionUtility.setValue(register, state, value);
    }
}
