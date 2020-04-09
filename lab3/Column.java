package lab3;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
@Target(ElementType.FIELD)
public @interface Column {
	String value() default " ";
}
