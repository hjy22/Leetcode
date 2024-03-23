package OA.mihayou;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // int times=Integer.valueOf(scanner.nextLine());
        int times=1;
        System.out.println(times);
        while(times>0){
            // int length=Integer.valueOf(scanner.nextLine());
            int length=5;
            // int[] monster = new int[length];
            int[] monster={100,50, 60, 80, 70};
            // String[] monsterLine = scanner.nextLine().split(" ");
            // for(int i=0;i<length;i++){
            //     monster[i]=Integer.valueOf(monsterLine[i]);
            // }
            // String attackLine = scanner.nextLine();
            // int E =Integer.valueOf(attackLine.split(" ")[0]);
            // int cicle =Integer.valueOf(attackLine.split(" ")[1]);
            int E=25;
            int cicle=10;
            int[] result=getResult(monster,E,cicle);
            System.out.println(result[0]+" "+result[1]);
            times--;
        }
    }
    
    private static int[] getResult(int[] monster,int E,int circle){
        int[] result = new int[2];
        int resultE=0;
        int resultCicle=0;
        int[] flag = new int[monster.length];
        int[] origin = new int[monster.length];
        for(int i=0;i<monster.length;i++){
            origin[i]=monster[i];
            flag[i]=0;
        }
        while(!allZero(monster)){
            
            int times=checkHalf(origin,monster,flag);
            // for(int i=0;i<origin.length;i++){
            //     System.out.print(monster[i]+" ");
            // }
            // System.out.println("times "+times);
            while(times>0){
                attack(monster,circle);
                times--;
                resultCicle++;
                if(allZero(monster)){
                    break;
                }
            }
            if(allZero(monster)){
                break;
            }
            int temp = checkHalf_noflag(origin, monster,flag);
            if(temp==0){
                attack(monster,E);
                resultE++;
            }
            
        }
        result[0]=resultE;
        result[1]=resultCicle;
        return result;
    }
    
    private static void attack(int[] current,int attack){
        for(int i=0;i<current.length;i++){
            int result=current[i]-attack;
            if(result<0){
                result=0;
            }
            current[i]=result;
        }
    }
    
    private static boolean allZero(int[] current){
        for(int i=0;i<current.length;i++){
            if(current[i]!=0){
                return false;
            }
        }
        return true;
    }
    
    private static int checkHalf(int[] origin,int[] current,int[] flag){
        int times=0;
        for(int i=0;i<origin.length;i++){
            // System.out.println("orgin"+origin[i]+"cure"+current[i]);
            if(origin[i]>=2*current[i]){
                // System.out.println("flag:"+flag[i]+"index "+i);
                if(flag[i]==0){
                    times++;
                    flag[i]=1;
                }
            }
        }
        return times;
    }

    private static int checkHalf_noflag(int[] origin,int[] current,int[] flag){
        int times=0;
        for(int i=0;i<origin.length;i++){
            // System.out.println("orgin"+origin[i]+"cure"+current[i]);
            if(origin[i]>=2*current[i]){
                if(flag[i]==0){
                    times++;
                }
            }
        }
        return times;
    }
}
