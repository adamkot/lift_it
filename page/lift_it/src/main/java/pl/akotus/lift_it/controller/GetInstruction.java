package pl.akotus.lift_it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.akotus.lift_it.service.InstructionService;

@Controller
public class GetInstruction {

    @Autowired
    private InstructionService instructionService;

    @RequestMapping(value = "/getInstruction", method = RequestMethod.GET)
    @ResponseBody
    public String testPage(@RequestParam String code) {
        String instruction = "";
        instruction = instructionService.getInstruction(code);
        return instruction;
    }
}
