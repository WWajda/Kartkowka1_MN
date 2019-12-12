package zad2;

public class FirstOrderODESolver {

    private ODESingleStep odeSingleStep;
    private StepHandler stepHandler;

    public FirstOrderODESolver(ODESingleStep odeSingleStep) {
        this.odeSingleStep = odeSingleStep;
    }

    public  void addStepHendler(StepHandler stepHandler){
        this.stepHandler=stepHandler;
    }

    public double integrate(FirstOrderODE ode, double tStart, double xStart, double tStop, int n ){
        double h=Math.abs(tStop-tStart)/n;
        double x=xStart;
        double t=tStart;

        if (stepHandler!=null)
            stepHandler.handle(t,x);


        for (int i = 0; i < n; i++) {
            x = odeSingleStep.singleStep(ode,t,x,h);
            t+=h;

        if (stepHandler!=null)
            stepHandler.handle(t,x);

        }

        return x;
    }


}
