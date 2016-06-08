package org.bwillard.ccsf.course.cs211s.assn13;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * 
 * @author bradleywillard
 *
 */
@Documented 
@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.FIELD)
public @interface ProperLength {

	int minLength() default 1;
	int maxLength() default 255;
	
	
}
