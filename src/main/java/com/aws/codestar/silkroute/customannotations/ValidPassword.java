package com.aws.codestar.silkroute.customannotations;

import javax.validation.Payload;

import com.aws.codestar.silkroute.customannotations.*;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;





@Documented
@Constraint(validatedBy = PasswordConstraintCheck.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface ValidPassword {

	String message() default "Incorrect password format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}