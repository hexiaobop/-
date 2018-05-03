package calculate;

public class exerciseArr {

    public static void main(String[] args) {
        System.out.println(isEquals("asdF12", "asdf12"));


        System.out.println(maaPartArrTwo(new int[]{1, 2, 3, 4, 5, -20, 30}));
    }

    //字符串比较
    static boolean isEquals(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1 == s2) return true;
        if (s1.length() == s2.length()) {
            int n = s1.length();
            char[] s1Arr = s1.toCharArray();
            char[] s2Arr = s1.toCharArray();
            for (int i = 0; i < n; i++) {
                //忽略大小写
//                if(Character.isLetter(s1Arr[i]) && Character.isLetter(s2Arr[i])){
//                    s1Arr[i] = Character.toLowerCase(s1Arr[i]);
//                    s2Arr[i] = Character.toLowerCase(s2Arr[i]);
//                }
                if (s1Arr[i] != s2Arr[i]) return false;
            }
            return true;
        }
        return false;
    }


    /**
     * 连续子序列和
     */
    public int maaPartArrOne(int[] ints) {
        int max = 0;
        for (int i = 0; i < ints.length; i++) {
            int thisMax;
            for (int j = i; j < ints.length; j++) {

            }
        }
        return max;

    }

    public static int maaPartArrTwo(int[] ints) {
        int max = 0;
        int thisMax = 0;
        for (int i = 0; i < ints.length; i++) {
            if (thisMax < 0) {
                System.out.println("two:" + i);
                max = ints[i];
            } else {
                thisMax += ints[i];
            }

            if (max < thisMax) {
                max = thisMax;
            }

        }
        return max;
    }

    public static int maaPartArrThree(int[] ints) {
        int max = 0;
        int thisMax = 0;
        for (int i = 0; i < ints.length; i++) {
            thisMax += ints[i];
            if (thisMax < ints[i]) {
                System.out.println("three:" + i);
                max = ints[i];
            }
            if (max < thisMax) {
                max = thisMax;
            }
        }
        return max;
    }


}
