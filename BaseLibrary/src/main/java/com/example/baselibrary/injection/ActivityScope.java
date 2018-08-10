package com.example.baselibrary.injection;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by lc on 2018/8/10.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface ActivityScope {
}
