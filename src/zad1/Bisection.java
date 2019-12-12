package zad1;

import java.util.ArrayList;

public class Bisection {
    private ScalarFunction scalarFunction;

    public Bisection(ScalarFunction scalarFunction) {
        this.scalarFunction = scalarFunction;
    }

    public ArrayList solver(double xl, double xu, int maxIter, double row, double roc, double r) {
        double xr_n=0;
        int iter=0;
        double x_old;
        xu=Math.max(xl,xu);
        xl=Math.min(xl,xu);
        ArrayList<Double> wyniki = new ArrayList<>();

        while (iter<maxIter) {
            iter++;
            x_old=xr_n;
                xr_n = (xl + xu) / 2;
                if (scalarFunction.getF(xl,row,roc,r) * scalarFunction.getF(xr_n,row,roc,r) <= 0) {
                    xu = xr_n;
                } else if (scalarFunction.getF(xu,row,roc,r) * scalarFunction.getF(xr_n,row,roc,r) <= 0) {
                    xl = xr_n;
                }

            if (scalarFunction.getF(xl,row,roc,r)==0 || x_old==xr_n)
                iter=maxIter;

           wyniki.add(xr_n);
    }
        System.out.println("Wyznaczony pierwiastek - BISEKCJA: "+xr_n);
        return  wyniki;
    }
}
