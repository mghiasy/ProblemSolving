package InterviewQuestions;

public interface Int {
    void method1();
    default void method2(){
        System.out.println("222");
    };

}
