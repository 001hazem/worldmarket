import org.testng.annotations.Test;

public class TestDe {
    @Test
    void testOne(){
        System.out.println("Test 1");
    }
    @Test(dependsOnMethods = "testOne")
    void  testTwo(){
        System.out.println("Test 2");
    }
    @Test(dependsOnMethods = "testTwo")

    void testThree(){
        System.out.println("Test 3");
    }
    @Test(dependsOnMethods = "testThree")
    void testFour(){
        System.out.println("Test 4");
    }

}
