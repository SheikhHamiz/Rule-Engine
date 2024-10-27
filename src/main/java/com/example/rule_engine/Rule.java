package com.example.rule_engine;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Rule {
    @Id
    private Long id;
    private String expression;


    public Rule(Long id, String expression) {
        this.id = id;
        this.expression = expression;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Long getId() {
        return id;
    }

    public String getExpression() {
        return expression;
    }
}
