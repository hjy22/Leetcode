package Google;

// https://leetcode.com/problems/maximum-swap/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class MaximumSwap670M {
    public static void main(String[] args) {
        int num = 98368;
        System.out.println(maximumSwap(num));
    }

    public static int maximumSwap(int num) {
        char[] str = String.valueOf(num).toCharArray();
        int[] lastIndex = new int[10];

        //存最后出现的index
        for(int i=0;i<str.length;i++){
            lastIndex[str[i]-'0']=i;
        }

        /*
         * 第一个for从入参数字的第一位遍历
         * 第二个for从9遍历到当前数字，找有没有最大的
         */
        for(int i=0;i<str.length;i++){
            int curNum = str[i]-'0';
            for(int j=9;j>curNum;j--){
                if(lastIndex[j]>i){
                    char tmp = str[lastIndex[j]];
                    str[lastIndex[j]]=str[i];
                    str[i]=tmp;

                    return Integer.valueOf(new String(str));
                }
            }
        }
        return num;
    }
}
