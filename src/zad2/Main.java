package zad2;

public class Main {
    public static void main(String[] args) {
        FirstOrderODESolver solver = new FirstOrderODESolver(new RungeKutt());
        SaveAllStepHandler saveAllStepHandler = new SaveAllStepHandler();
        solver.addStepHendler(saveAllStepHandler);
        double xend = solver.integrate((t,x,k,xmax)->k*(1-x/xmax)*x,0,2.555*Math.pow(10,9),50,10);

        System.out.println("Metoda Runge-Kutta");
        saveAllStepHandler.wypisz();
        System.out.println("Xend= "+xend);
    }

}
