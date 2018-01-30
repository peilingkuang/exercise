import com.kpl.exercise.InnerClassExercise;
import com.kpl.exercise.InnerClassExercise1;
import com.kpl.exercise.Selector;
import org.junit.Test;

public class ExerciseTest {
    @Test
    public void InnerClassTest(){
        InnerClassExercise outer = new InnerClassExercise("sdklfja");
        outer.setInnerClass();
        outer.getInner().innerFunc();

        InnerClassExercise.InnerClass in = outer.new InnerClass();
        in.innerFunc();

        InnerClassExercise1 ex = new InnerClassExercise1("asfd");
        Selector s = ex.innerSelector();
        s.next();
        System.out.println(s.current());

        //illegal,can not new the protected innerselector
//        Selector se = ex.new InnerSelector();
//        System.out.println(se.current());
    }

}
