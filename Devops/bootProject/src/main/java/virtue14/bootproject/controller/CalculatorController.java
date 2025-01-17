package virtue14.bootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import virtue14.bootproject.dto.CalculatorDTO;
import virtue14.bootproject.service.CalculatorService;

@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/health_check")
    public String health() {
        return "fine";
    }

    @GetMapping("/plus")
    public CalculatorDTO getPlus(CalculatorDTO calculatorDTO) {
//        System.out.println(calculatorDTO.getNum1() + ", " + calculatorDTO.getNum2());
        int result = calculatorService.plus(calculatorDTO);
        calculatorDTO.setSum(result);
        return calculatorDTO;
    }
}
