package pl.akotus.lift_it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.akotus.lift_it.model.Instruction;
import pl.akotus.lift_it.service.InstructionService;

import javax.validation.Valid;

@Controller
public class InstructionController {

    @Autowired
    private InstructionService instructionService;

    @RequestMapping(value = "/newInstruction", method = RequestMethod.GET)
    public ModelAndView newInstruction() {
        ModelAndView modelAndView = new ModelAndView("instruction");
        modelAndView.addObject("instruction", new Instruction());
        return modelAndView;
    }

    @RequestMapping(value = "/newInstruction", method = RequestMethod.POST)
    public ModelAndView newInstructionPost(@Valid Instruction instruction) {
        ModelAndView modelAndView = new ModelAndView("instruction");
        instructionService.save(instruction);
        return modelAndView;
    }


}
