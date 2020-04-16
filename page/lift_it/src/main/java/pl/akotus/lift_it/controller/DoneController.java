package pl.akotus.lift_it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DoneController {

    @RequestMapping(value = "/instructionDone", method = RequestMethod.GET)
    @ResponseBody
    public String instructionDone(@RequestParam String code) {
        //pobrać po code
        //wysłać do service i zmienić done na true
        return "OK";
    }
}
