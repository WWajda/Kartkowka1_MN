package zad2;

import java.util.ArrayList;
import java.util.List;

public class SaveAllStepHandler implements StepHandler {

    private List<Double> tList = new ArrayList<>();
    private List<Double> xList = new ArrayList<>();

    @Override
    public void handle(double t, double x) {
        this.tList.add(t);
        this.xList.add(x);
    }

    public void clear(){
        tList.clear();
        xList.clear();
    }

    public List<Double> getT(){
        List<Double> export = new ArrayList<>();
        for (Double d: tList)
            export.add(d);
        return export;
    }

    public List<Double> getX(){
        List<Double> export = new ArrayList<>();
        for (Double d: xList)
            export.add(d);
        return export;
    }


    public void wypisz(){
        int n = tList.size();
        for (int i = 0; i < n; i++) {
            System.out.printf("t= %.2f",tList.get(i));
            System.out.printf(" x= %.4f",xList.get(i));
            System.out.println("");
        }
    }
}
