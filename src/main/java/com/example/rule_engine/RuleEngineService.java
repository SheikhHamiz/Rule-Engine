package com.example.rule_engine;

import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.apache.commons.jexl2.Script;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class RuleEngineService {
    private  final RuleRepo ruleRepo;

    public RuleEngineService(RuleRepo ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    public Rule addRule(Rule rule) {
        JexlEngine jexlEngine = new JexlEngine();
        jexlEngine.createScript(rule.getExpression());
        rule.setId(ruleRepo.count() + 1);
        return ruleRepo.save(rule);
    }

    public List<Rule> getRules() {
        return ruleRepo.findAll();
    }

    public Object evaluate(User user) {
        Script script = combinedRules();
        Map<String, Object> map = user.getUserMap();
        MapContext context = new MapContext();
        System.out.println(script.getVariables());
        for (List<String> v : script.getVariables()) {
            context.set(v.get(0),map.get(v.get(0)));
        }
        return script.execute(context);
    }

    private Script combinedRules() {
        List<Rule> rules = getRules();
        StringBuilder expression = new StringBuilder();
        int i = 0;
        for(Rule r : rules) {
            expression.append(r.getExpression());
            if(i < rules.size()-1)expression.append("&&");
            i++;
        }
        return new JexlEngine().createScript(expression.toString());
    }
}
