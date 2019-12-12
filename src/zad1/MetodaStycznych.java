package zad1;

import java.util.ArrayList;

import static java.lang.Double.isNaN;

public class MetodaStycznych {

    private ScalarFunction scalarFunction;
    private DerivedFunction derivedFunction;

    public MetodaStycznych(ScalarFunction scalarFunction, DerivedFunction derivedFunction) {
        this.scalarFunction = scalarFunction;
        this.derivedFunction=derivedFunction;
    }
    public ArrayList solver(double x0, int maxIter, double row, double roc, double r) {

        double xn_o;
        double xn_n=x0;
        int iter=0;
        ArrayList<Double> wyniki = new ArrayList<>();

        while (iter<maxIter) {
            iter++;
                xn_o = xn_n;
                xn_n=xn_o-(scalarFunction.getF(xn_o,row,roc,r)/derivedFunction.getD(xn_o,r));

        if (scalarFunction.getF(xn_n,row,roc,r)==0 || xn_o==xn_n || isNaN(xn_n))
            iter=maxIter;

        wyniki.add(xn_n);
    }
        System.out.println("Wyznaczony pierwiastek - METODA STYCZNYCH: "+xn_n);
        return  wyniki;
    }
}
