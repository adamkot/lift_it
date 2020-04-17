package pl.akotus.lift_it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.akotus.lift_it.service.InstructionService;

@Controller
public class InstructionExist {

    @Autowired
    private InstructionService instructionService;

    @RequestMapping(value = "/isInstructionExist", method = RequestMethod.GET)
    @ResponseBody
    public String isInstructionExist() {
        String code = "0";
        code = instructionService.getCode();
        return code;
    }
}
