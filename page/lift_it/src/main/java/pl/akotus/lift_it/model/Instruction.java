package pl.akotus.lift_it.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instruction {

    private Integer id;
    private String code;
    private String instruction;
    private Date date;
    private boolean done;

}
