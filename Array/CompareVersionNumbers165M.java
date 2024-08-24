package Array;

public class CompareVersionNumbers165M {
    public static void main(String[] args) {
        String version1 = "1.2", version2 = "1.10";
        System.out.println(compareVersion(version1, version2));
    }

    public static int compareVersion(String version1, String version2) {
        String[] versionArray1 = version1.split("\\.");
        String[] versionArray2 = version2.split("\\.");
        if (Integer.valueOf(versionArray1[0]) > Integer.valueOf(versionArray2[0])) {
            return 1;
        } else if (Integer.valueOf(versionArray1[0]) < Integer.valueOf(versionArray2[0])) {
            return -1;
        } else {
            if (Integer.valueOf(versionArray1[1]) > Integer.valueOf(versionArray2[1])) {
                return -1;
            } else if (Integer.valueOf(versionArray1[1]) < Integer.valueOf(versionArray2[1])) {
                {
                    return 1;
                }
            }
        }
        return 0;
    }
}
