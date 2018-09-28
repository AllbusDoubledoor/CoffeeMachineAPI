package cmApiApp.controller;

import cmApiApp.service.CoffeeMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class cmApiController {

    @GetMapping(value = "/{coffeeName}", produces = "application/json")
    public String getCoffeeCup(@PathVariable String coffeeName, @Autowired CoffeeMachineService coffeeMachineService) {

        return coffeeMachineService.getCoffeeCup(coffeeName);
    }

    @PutMapping(value = "/clean", produces = "application/json")
    public String cleanCoffeeMachine(@Autowired CoffeeMachineService coffeeMachineService) {
        return coffeeMachineService.clean();
    }


}
