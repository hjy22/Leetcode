package Array;

public class CompareVersionNumbers165M {
    public static void main(String[] args) {
        String version1 = "1.2", version2 = "1.10";
        System.out.println(compareVersion(version1, version2));
    }

    public static int compareVersion(String version1, String version2) {
        String[] versionArray1 = version1.split("\\.");
        String[] versionArray2 = version2.split("\\.");
        for (int i = 0; i < Math.max(versionArray1.length, versionArray2.length); i++) {
            int num1 = i < versionArray1.length ? Integer.valueOf(versionArray1[i]) : 0;
            int num2 = i < versionArray2.length ? Integer.valueOf(versionArray2[i]) : 0;

            if (num1 < num2) {
                return -1;
            } 
            if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }
}
