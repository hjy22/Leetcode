package String;

//https://leetcode.com/problems/reformat-date/
public class ReformatDate1507E {
    public static void main(String[] args) {
        String date = "20th Oct 2052";
        System.out.println(reformatDate(date));
    }

    public static String reformatDate(String date) {
        String[] dateArray = date.split(" ");
        String[] monthArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String ans="";
        ans=dateArray[2]+"-";

        for(int i=0;i<monthArray.length;i++){
            if(dateArray[1].equals(monthArray[i])){
                i++;
                if(i<10){
                    ans+="0";
                }
                ans+=i;
                ans+="-";
                break;
            }
        }

        String day = dateArray[0].substring(0,dateArray[0].length()-2);
        if(Integer.parseInt(day)<10){
            ans+="0";
        }
        ans+=day;

        return ans;
    }
}
