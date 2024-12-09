package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTestRunner.class,
        CalculadoraTestRunner.class
})
public class SuiteRunner {

}
