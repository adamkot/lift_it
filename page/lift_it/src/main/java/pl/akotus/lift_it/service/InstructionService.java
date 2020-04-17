package pl.akotus.lift_it.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.akotus.lift_it.model.Instruction;
import pl.akotus.lift_it.repository.InstructionRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("instructionService")
public class InstructionService {

    private InstructionRepository instructionRepository;

    public InstructionService(@Qualifier("instructionRepository") InstructionRepository instructionRepository) {
        this.instructionRepository = instructionRepository;
    }

    public void save(Instruction instruction) {
        UUID uuid = UUID.randomUUID();
        instruction.setCode(uuid.toString());
        instruction.setDate(new Date());
        instruction.setDone(false);
        instructionRepository.save(instruction);
    }

    public String getInstruction(String code) {
        Instruction instruction = instructionRepository.getByCode(code);
        if (instruction != null) {
            return instruction.getLineInstruction();
        } else {
            return "0";
        }
    }

    public String getCode() {
        List<Instruction> list = instructionRepository.getAllNotDone();
        if (list.size() > 0) {
            return list.get(0).getCode();
        } else {
            return "0";
        }
    }

    public String instructionDone(String code){
        Instruction instruction = instructionRepository.getByCode(code);
        if (instruction != null) {
            instruction.setDone(true);
            instructionRepository.save(instruction);
            return "OK";
        } else {
            return "ERROR";
        }
    }

}