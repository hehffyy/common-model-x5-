package com.butone.x5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD })
public @interface XuiEvent {
	String[] params() default { "event" };

	boolean action() default false;

	String event() default "";

	boolean script() default false;
}
