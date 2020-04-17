package pl.akotus.lift_it.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akotus.lift_it.model.Instruction;

import java.util.List;

@Repository("instructionRepository")
public interface InstructionRepository extends CrudRepository<Instruction, Integer> {

    @Query("SELECT i FROM Instruction i WHERE i.done = FALSE ORDER BY i.date")
    public List<Instruction> getAllNotDone();

    @Query("SELECT i FROM Instruction i WHERE i.done = FALSE AND i.code = ?1")
    public Instruction getByCode(String code);
}
