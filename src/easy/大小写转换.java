package easy;

/**
 * demo
 *  Input:  "Hello"
 *  Output: "hello"
 */
public class 大小写转换 {


    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(toLowerCase_4(str));
    }


    // 最传统的办法
    public static String toLowerCase_1(String str) {
        return str.toLowerCase();
    }


    // 利用ASCII值的规律得出的算法
    public static String toLowerCase_2(String str) {
        char[] a = str.toCharArray();

        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');

        return new String(a);
    }

    // 利用ASCII
    public static String toLowerCase_3(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = (char)(str.charAt(i) | 32);
            sb.append(c);
        }
        return sb.toString();
    }

    public static String toLowerCase_4(String str) {
        char[] strChar = str.toCharArray();
        for (int i = 0; i < strChar.length; i++) {
            strChar[i] = (char) (strChar[i] & -33);
        }
        return new String(strChar);
    }

    /**
     * 备注：
     *  统一小写  ：   | 32
     *  统一大写  ：   & -33 或者 & 95
     *  大小写互转：   ^ 32
     */
}
