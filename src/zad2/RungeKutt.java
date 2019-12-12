package zad2;

public class RungeKutt implements ODESingleStep {
    @Override
public double singleStep(FirstOrderODE ode, double t, double x, double h) {
        double k=0.026;
        double xmax= 12*Math.pow(10,9);
    double k1=ode.f(t,x,k,xmax);
    double k2=ode.f(t+h/2,x+(k1/2)*h,k,xmax);
    double k3=ode.f(t+h,x-(h*k1)+(2*h*k2),k,xmax);

    double xn=x+(1./6.)*(k1+4*k2+k3)*h;
    return xn;
}

}
