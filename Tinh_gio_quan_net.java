
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Tinh_gio_quan_net {
    private String accname, pass, name, timein, timeout;
    public Tinh_gio_quan_net(String accname, String pass, String name, String timein, String timeout){
        this.accname = accname;
        this.pass = pass;
        this.name = name;
        this.timein = timein;
        this.timeout = timeout;
    }
    public static int solve(String x, String y){
        String[] arr1 = x.split(":");
        String[] arr2 = y.split(":");
        int phut1 = Integer.valueOf(arr1[0]) * 60 +  Integer.valueOf(arr1[1]);
        int phut2 = Integer.valueOf(arr2[0]) * 60 + Integer.valueOf(arr2[1]);
        return phut2 - phut1;
    }
    @Override
    public String toString(){
        int tmp = solve(timein, timeout);
        int h = tmp / 60, m = tmp % 60;
        return accname + " " + pass + " " + name + " " + h + " gio " + m + " phut";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        ArrayList<Tinh_gio_quan_net> arr = new ArrayList<>();
        while(t-- > 0){
            String accname = sc.nextLine();
            String pass  = sc.nextLine();
            String name = sc.nextLine();
            String timein = sc.nextLine();
            String timeout = sc.nextLine();
            arr.add(new Tinh_gio_quan_net(accname, pass, name, timein, timeout));
            
            Collections.sort(arr, new Comparator<Tinh_gio_quan_net>(){
                @Override
                public int compare(Tinh_gio_quan_net a, Tinh_gio_quan_net b){
                     int x = solve(a.timein, a.timeout);
                     int y = solve(b.timein, b.timeout);
                     if(x != y) return y - x;
                     else{
                         return a.accname.compareTo(b.accname);
                     }
                }
            });
        }
        for(Tinh_gio_quan_net x : arr){
                System.out.println(x);
            }
    }
}
