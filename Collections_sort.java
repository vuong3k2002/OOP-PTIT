import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Nhan_vien1 {
    private String maNV, name, gioiTinh, ngaySinh, address, phoneN, ngayKi;
    public Nhan_vien1(String maNV, String name, String gioiTinh, String ngaySinh, String address, String phoneN, String ngayKi){
        this.maNV = maNV;
        this.name = name;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.address = address;
        this.phoneN = phoneN;
        this.ngayKi = ngayKi;
    }
    public static String chuanHoa(String x){
        String[] arr = x.split("/");
        String res = " ";
        for(int i = 0 ; i < arr.length-1 ; i++){
            if(arr[i].length() < 2) arr[i] = "0" + arr[i];
        }
        return arr[0] + "/" + arr[1] + "/" + arr[2];
    }
    public static String getNgaySinh(String x){
        String[] arr = x.split("/");
        String m = arr[2] + arr[1] + arr[0];
        return m;
    }
    @Override
    public String toString(){
        return this.maNV + " " + this.name + " " +  this.gioiTinh + " " + this.ngaySinh + " " + this.address + " " + this.phoneN + " " + this.ngayKi;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Nhan_vien1> arr = new ArrayList<>();
        sc.nextLine();
        for(int i = 1 ; i <= n ; i++){
            String maNV = Integer.toString(i);
            while(maNV.length() < 5) maNV = "0" + maNV;
            String name = sc.nextLine();
            String gioiTinh = sc.nextLine();
            String ngaySinh = sc.nextLine();
            String address = sc.nextLine();
            String phoneN = sc.nextLine();
            String ngayKi = sc.nextLine();
            ngaySinh = chuanHoa(ngaySinh);
            ngayKi = chuanHoa(ngayKi);
            arr.add(new Nhan_vien1(maNV, name, gioiTinh, ngaySinh, address, phoneN, ngayKi));
        }
        Collections.sort(arr, new Comparator<Nhan_vien1>() {
            @Override
            public int compare(Nhan_vien1 o1, Nhan_vien1 o2) {
                String x1 = getNgaySinh(o1.ngaySinh);
                String x2 = getNgaySinh(o2.ngaySinh);
                if(!x2.equals(x1)) return x1.compareTo(x2);
                else{
                    return o1.maNV.compareTo(o2.maNV);
                }
            }
        });
        for(Nhan_vien1 x : arr){
            System.out.println(x);
        }
    }
}
