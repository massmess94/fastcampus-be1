package me.day08.practice;

import java.util.StringTokenizer;

public class Practice04 {
    public static void main(String[] args) {
        String str = "";

        for (int i = 0; i < 100000; i++) {
            str += i;
        }

        final String STR = str;

        //////////////////////////////////////////

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String[] splitString = STR.split(", ");
            }
        });

        /* 새로운 공간을 만들어 반환하기 때문에 복사하는 시간으로 속도가 느려질 수 밖에 없음 */
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                StringTokenizer stringTokenizer = new StringTokenizer(STR, ", ");

                while (stringTokenizer.hasMoreTokens()) {
                    String token = stringTokenizer.nextToken();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
