package pl.akotus.lift_it.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akotus.lift_it.model.Instruction;

@Repository("instructionRepository")
public interface InstructionRepository extends CrudRepository<Instruction, Integer> {

}
