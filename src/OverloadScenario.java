public class OverloadScenario {
    void test (int a, double b) { System.out.println("Fase A: int, double ") ;}
    void test (double a, int b) { System.out.println("Fase B: double, int");}
}
