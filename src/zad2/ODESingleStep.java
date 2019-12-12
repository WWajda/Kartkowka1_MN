package zad2;

public interface ODESingleStep {
    double singleStep(FirstOrderODE ode, double t, double x, double h);

}
