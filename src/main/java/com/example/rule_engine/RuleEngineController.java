package com.example.rule_engine;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RuleEngineController {

    private final  RuleEngineService ruleEngineService;

    public RuleEngineController(RuleEngineService ruleEngineService) {
        this.ruleEngineService = ruleEngineService;
    }

    @PostMapping(path = "addRule")
    public Rule addRule(@RequestBody Rule rule) {
        return ruleEngineService.addRule(rule);
    }
    @GetMapping(path = "getRule")
    public List<Rule> getRule() {
        return ruleEngineService.getRules();
    }
    @PostMapping(path = "checkUser")
    public Boolean evaluateRule(@RequestBody User user) {
        return (Boolean) ruleEngineService.evaluate(user);
    }

}
