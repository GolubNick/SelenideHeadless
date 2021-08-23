import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.model.TestResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.List;

@Aspect
public class Aspects {

    @Around("execution(* io.qameta.allure.listener.LifecycleNotifier.beforeStepStop(..))")
    public Object setStatusAllureStep(ProceedingJoinPoint pjp) throws Throwable {
        List<StepResult> stepResultList = ((StepResult) pjp.getArgs()[0]).getSteps();
        for (StepResult stepResult : stepResultList) {
            if (Status.FAILED.equals(stepResult.getStatus())) {
                ((StepResult) pjp.getArgs()[0]).setStatus(Status.FAILED);
            } else if (Status.BROKEN.equals(stepResult.getStatus())) {
                ((StepResult) pjp.getArgs()[0]).setStatus(Status.BROKEN);
            }
        }
        return pjp.proceed();
    }

    @Around("execution(* io.qameta.allure.listener.LifecycleNotifier.beforeTestStop(..))")
    public Object setStatusAllureTest(ProceedingJoinPoint pjp) throws Throwable {
        List<StepResult> stepResultList = ((TestResult) pjp.getArgs()[0]).getSteps();
        for (StepResult stepResult : stepResultList) {
            if (Status.FAILED.equals(stepResult.getStatus())) {
                ((TestResult) pjp.getArgs()[0]).setStatus(Status.FAILED);
            } else if (Status.BROKEN.equals(stepResult.getStatus())) {
                ((TestResult) pjp.getArgs()[0]).setStatus(Status.BROKEN);
            }
        }
        return pjp.proceed();
    }
}
