package zad1;

import java.util.ArrayList;

import static java.lang.Double.isNaN;

public class RegularFalsi {

    private ScalarFunction scalarFunction;

    public RegularFalsi(ScalarFunction scalarFunction) {
        this.scalarFunction = scalarFunction;
    }

    public ArrayList solver(double xl, double xu,  int maxIter, double row, double roc, double r){
        double xr_n=0;
        int iter=0;
        double x_old;
        xu=Math.max(xl,xu);
        xl=Math.min(xl,xu);
        ArrayList<Double> wyniki = new ArrayList<>();


        while (iter<maxIter) {
            iter++;
            x_old=xr_n;
                xr_n = xu-((scalarFunction.getF(xu,row,roc,r)*(xl-xu))/(scalarFunction.getF(xl,row,roc,r)- scalarFunction.getF(xu,row,roc,r)));
                if (scalarFunction.getF(xl,row,roc,r) * scalarFunction.getF(xr_n,row,roc,r) <= 0) {
                    xu = xr_n;
                } else if (scalarFunction.getF(xu,row,roc,r) * scalarFunction.getF(xr_n,row,roc,r) <= 0) {
                    xl = xr_n;
                }

            if(scalarFunction.getF(xr_n,row,roc,r)==0 || x_old==xr_n || isNaN(xr_n))
                iter=maxIter;

                wyniki.add(xr_n);
            }
        System.out.println("Wyznaczony pierwiastek - REGULAR FALSI: "+xr_n);
        return  wyniki;
    }

}
