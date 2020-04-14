package pl.akotus.lift_it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetCode {

    @RequestMapping(value = "/getInstruction", method = RequestMethod.GET)
    @ResponseBody
    public String testPage(@RequestParam String code) {
        String instruction = "";
        //tu zapytanie do bazy po kodzie instrukcji
        //i zwracanie kodu instrukcji
        return instruction;
    }
}
