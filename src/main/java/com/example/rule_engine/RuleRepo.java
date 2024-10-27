package com.example.rule_engine;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepo extends MongoRepository<Rule,Long> {
}
