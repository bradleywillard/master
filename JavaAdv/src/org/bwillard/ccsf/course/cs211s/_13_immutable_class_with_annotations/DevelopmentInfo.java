import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DevelopmentInfo {
	
	public static enum Status {DEVELOPMENT, TESTING, LIVE };
	
	String developer();
	int version() default 1;
	Status status() default Status.DEVELOPMENT;
	

}
