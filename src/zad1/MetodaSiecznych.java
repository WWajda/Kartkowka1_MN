package zad1;

import java.util.ArrayList;

import static java.lang.Double.isNaN;

public class MetodaSiecznych {

    private ScalarFunction scalarFunction;

    public MetodaSiecznych(ScalarFunction scalarFunction) {
        this.scalarFunction = scalarFunction;
    }

    public ArrayList solver(double xn_n1, double xn_n2, int maxIter, double row, double roc, double r){
        double xn_n=0;
        double x_old;
        int iter=0;
        ArrayList<Double> wyniki = new ArrayList<>();

        while (iter<maxIter) {
            iter++;
            x_old=xn_n;
            xn_n=xn_n2-(((scalarFunction.getF(xn_n2,row,roc,r)*(xn_n1-xn_n2)))/(scalarFunction.getF(xn_n1,row,roc,r)- scalarFunction.getF(xn_n2,row,roc,r)));
            if (Math.abs(xn_n1-xn_n) < Math.abs(xn_n2-xn_n)) {
                xn_n2 = xn_n;
            }
            else{
                xn_n1=xn_n;
            }

            if(scalarFunction.getF(xn_n,row,roc,r)==0 || x_old==xn_n || isNaN(xn_n))
                iter=maxIter;

            wyniki.add(xn_n);
        }
        System.out.println("Wyznaczony pierwiastek - METODA SIECZNYCH: "+xn_n);
        return  wyniki;
    }

}
