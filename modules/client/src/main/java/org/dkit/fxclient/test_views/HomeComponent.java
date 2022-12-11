package org.dkit.fxclient.test_views;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.SOURCE)
@interface View{
	String title();
	String path();
	String[] styles() default {};
}

@View(title = "main", path = "/")
public class HomeComponent {
}

