import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAOP {

    @Around("execution(* com.codeborne.selenide.SelenideElement.should*(..))")
    public Object monitor(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("This is Aspect");
        return pjp.proceed();
    }
}
