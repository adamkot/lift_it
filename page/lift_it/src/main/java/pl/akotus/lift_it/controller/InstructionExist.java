package pl.akotus.lift_it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InstructionExist {

    @RequestMapping(value = "/isInstructionExist", method = RequestMethod.GET)
    @ResponseBody
    public String isInstructionExist() {
        String code = "0";
        //tu wpisać warunek
        //jeśli tak to zwraca kod instrukcji jeśli nie to 0
        return code;
    }
}
