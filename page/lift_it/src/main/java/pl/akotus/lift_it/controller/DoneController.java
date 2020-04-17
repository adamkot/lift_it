package pl.akotus.lift_it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.akotus.lift_it.service.InstructionService;

@Controller
public class DoneController {

    @Autowired
    private InstructionService instructionService;

    @RequestMapping(value = "/instructionDone", method = RequestMethod.GET)
    @ResponseBody
    public String instructionDone(@RequestParam String code) {
        return instructionService.instructionDone(code);
    }
}
