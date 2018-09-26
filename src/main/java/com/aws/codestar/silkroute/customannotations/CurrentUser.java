package com.aws.codestar.silkroute.customannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;

@Target({PARAMETER, TYPE})
@Retention(RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {}