import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
	LevelOrderTraversalTest.class, isSymmetricTest.class, flattenTest.class,  PostorderTraversalTest.class, PreorderTraversalTest.class, InOrderTraversalTest.class, IsSameTreeTest.class
})
public class AllTests {
	
}
