package zad1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        Bisection bisection = new Bisection((x,row,roc,r) -> (((4./3.)*Math.pow(r,3))-(Math.pow(x,2)*((3*r-x)/3))-((4./3.)*Math.pow(r,3)*(roc/row))));
        FixedPoint fixedPoint = new FixedPoint((x,row,roc,r) -> (((4./3.)*Math.pow(r,3))-(Math.pow(x,2)*((3*r-x)/3))-((4./3.)*Math.pow(r,3)*(roc/row))));
        RegularFalsi regularFalsi = new RegularFalsi((x,row,roc,r) -> (((4./3.)*Math.pow(r,3))-(Math.pow(x,2)*((3*r-x)/3))-((4./3.)*Math.pow(r,3)*(roc/row))));
        MetodaSiecznych metodaSiecznych = new MetodaSiecznych((x,row,roc,r) -> (((4./3.)*Math.pow(r,3))-(Math.pow(x,2)*((3*r-x)/3))-((4./3.)*Math.pow(r,3)*(roc/row))));
        MetodaStycznych metodaStycznych = new MetodaStycznych((x,row,roc,r) -> (((4./3.)*Math.pow(r,3))-(Math.pow(x,2)*((3*r-x)/3))-((4./3.)*Math.pow(r,3)*(roc/row))),(x,r) -> x*(x-2*r));

        ArrayList solution_b=bisection.solver(0,2,50,1000,200,1);
        System.out.println(solution_b);
        ArrayList solution_fp=fixedPoint.solver(0.5,50,1000,200,1);
        System.out.println(solution_fp);
        ArrayList solution_rf=regularFalsi.solver(0,2,50,1000,200,1);
        System.out.println(solution_rf);
        ArrayList solution_ms=metodaSiecznych.solver(0,2,50,1000,200,1);
        System.out.println(solution_ms);
        ArrayList solution_mst=metodaStycznych.solver(0.5,50,1000,200,1);
        System.out.println(solution_mst);

    }
}
