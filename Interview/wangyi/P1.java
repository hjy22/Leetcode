package Interview.wangyi;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = new int[4];
        // while (in.hasNextLine()) {
        //     String line = in.nextLine();
        //     if(line==""){
        //         break;
        //     }
        //     System.out.println(line);
        //     int times = Integer.parseInt(in.nextLine());
        //     System.out.println(times);
        //     while (times>0) {
        //         line = in.nextLine();
        //         System.out.println(line);
        //         times--;
        //     }
        // }
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if(line==""){
                break;
            }
            String[] info = line.split(" ");
            updateInfo(info,array);

            line = in.nextLine();
            if(line==""){
                break;
            }
            int times = Integer.parseInt(line);
            
            while(times>0){
                line = in.nextLine();

                info = line.split(" ");
                updateInfo(info,array);
                times--;
            }
            if (!in.hasNextLine()) {
                break;
            }else{
                line = in.nextLine();
            }
        }
        System.out.println("atk "+array[0]);
        System.out.println("atkper "+array[1]);
        System.out.println("def "+array[2]);
        System.out.println("spd "+array[3]);
    }

    public static void updateInfo(String[] info, int[] array) {
        // System.out.println("call updateInfo");
        String properties = info[0];
        int value = Integer.parseInt(info[1]);
        switch (properties) {
            case "atk":
            array[0]+=value;
                break;
            case "atkper":
            array[1]+=value;
                break;
            case "def":
            array[2]+=value;
                break;
            case "spd":
            array[3]+=value;
                break;
            default:
                break;
        }
    }
}
