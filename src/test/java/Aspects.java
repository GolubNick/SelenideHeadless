import io.qameta.allure.model.ExecutableItem;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.List;

@Aspect
public class Aspects {

    @Around("execution(* io.qameta.allure.listener.LifecycleNotifier.beforeStepStop(..))")
    public Object setStatusAllureStep(ProceedingJoinPoint pjp) throws Throwable {
        return extracted(pjp);
    }

    @Around("execution(* io.qameta.allure.listener.LifecycleNotifier.beforeTestStop(..))")
    public Object setStatusAllureTest(ProceedingJoinPoint pjp) throws Throwable {
        return extracted(pjp);
    }

    private Object extracted(ProceedingJoinPoint pjp) throws Throwable {
        ExecutableItem executableItem = ((ExecutableItem) pjp.getArgs()[0]);
        List<StepResult> stepResultList = executableItem.getSteps();
        for (StepResult stepResult : stepResultList) {
            if (Status.FAILED.equals(stepResult.getStatus())) {
                executableItem.setStatus(Status.FAILED);
            } else if (Status.BROKEN.equals(stepResult.getStatus())) {
                executableItem.setStatus(Status.BROKEN);
            }
        }
        return pjp.proceed();
    }
}
