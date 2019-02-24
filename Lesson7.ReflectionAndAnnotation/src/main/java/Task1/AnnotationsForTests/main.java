package Task1.AnnotationsForTests;

public class main {
    public static void main(String[] args) {
        try{
            TestLauncher.start(ClassWithTests.class.getName());
//        TestLauncher.start(ClassWithTests.class);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
