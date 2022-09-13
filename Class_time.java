import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Class_time {
    private int gio, phut, giay;
    public Class_time(int gio, int phut, int giay){
        this.gio = gio;
        this.phut = phut;
        this.giay = giay;
    }
    public int getGiay(){
        return this.gio * 3600 + this.phut * 60 + this.giay;
    }
    @Override
    public String toString(){
        return this.gio + " " + this.phut + " " + this.giay;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Class_time> arr = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            arr.add(new Class_time(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(arr, new Comparator<Class_time>() {
            @Override
            public int compare(Class_time a, Class_time b){
                return a.getGiay() - b.getGiay();
            }
        });
        for(Class_time x : arr){
            System.out.println(x);
        }
    }
}
