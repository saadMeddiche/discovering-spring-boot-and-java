package com.discovering.springbootandjava.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SeederEnabledCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context , AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().getProperty("seeder.enabled", Boolean.class, false);
    }
}
