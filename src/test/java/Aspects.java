import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import java.util.List;

@Aspect
public class Aspects {

    @Around("execution(* io.qameta.allure.listener.LifecycleNotifier.beforeStepStop(..))")
    public Object modifyAllureContainer(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(pjp.toString());
        List<StepResult> stepResultList = ((StepResult)pjp.getArgs()[0]).getSteps();
        for (StepResult stepResult : stepResultList) {
            if (Status.FAILED.equals(stepResult.getStatus())) {
                ((StepResult)pjp.getArgs()[0]).setStatus(Status.FAILED);
            } else if (Status.BROKEN.equals(stepResult.getStatus())) {
                ((StepResult)pjp.getArgs()[0]).setStatus(Status.BROKEN);
            }
        }
        return pjp.proceed();
    }
}
