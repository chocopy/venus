package venus.riscv.insts.dsl.parsers

import venus.riscv.InstructionField
import venus.riscv.MachineCode
import venus.riscv.Program
import venus.riscv.insts.dsl.relocators.JALRelocator

object JTypeParser : InstructionParser {
    override operator fun invoke(prog: Program, mcode: MachineCode, args: List<String>) {
        checkArgsLength(args.size, 2)

        mcode[InstructionField.RD] = regNameToNumber(args[0])
        prog.addRelocation(JALRelocator, args[1])
    }
}