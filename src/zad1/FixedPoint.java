package zad1;

import java.util.ArrayList;

import static java.lang.Double.isNaN;

public class FixedPoint {

    private ScalarFunction scalarFunction;

    public FixedPoint(ScalarFunction scalarFunction) {
        this.scalarFunction = scalarFunction;
    }

    public ArrayList solver(double x0, int maxIter,double row, double roc, double r){
        int iter=0;
        double xn_n = x0;
        double xn_o;
        ArrayList<Double> wyniki = new ArrayList<>();

        while (iter<maxIter) {
            iter++;
            xn_o = xn_n;
            xn_n = scalarFunction.getF(xn_n,row,roc,r)+xn_n;


            if (scalarFunction.getF(xn_n,row,roc,r)==0 || xn_o==xn_n || isNaN(xn_n))
                iter=maxIter;

            wyniki.add(xn_n);
        }
        System.out.println("Wyznaczony pierwiastek - FIXED POINT: "+xn_n);
        return  wyniki;
    }
}
