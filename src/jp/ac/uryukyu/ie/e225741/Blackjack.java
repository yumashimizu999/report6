package jp.ac.uryukyu.ie.e225741;

import java.util.List;
import java.util.Collections;

public class Blackjack {
    
    public static void shuffleStack(List<Integer> stack) {

        // リストに1(A)~13(K)までを代入
        for (int i = 1; i <= 13; i++) {
            stack.add(i);
        }

        // 山札をシャッフル
        Collections.shuffle(stack);

    }

    private static int toNumber(int cardNumber) {
        int number = cardNumber % 13;
        if(number == 0) {
            number = 13;
        }
     
        return number;
    }
   

    // 山札のカードの数字をトランプのランク(A,Kなど)に置き換える
    public static String toRank(int number) {
        switch(number) {
        case 1:
            return "A";
        case 11:
            return "J";
        case 12:
            return "Q";
        case 13:
            return "K";
        default:
            String str = String.valueOf(number);
            return str;
        }
    }

    public static int toPoint(int num) {
        if(num ==11||num == 12||num == 13) {
            num = 10;
        }
     
        return num;
    }

    // 引いたカードを合計する
    public static int sumPoint(List<Integer> list) {
        int sum = 0;
     
        for(int i =0;i < list.size();i++) {
            sum = sum + toPoint(toNumber(list.get(i)));
        }
     
        return sum;
    }
    // バースト処理
    public static boolean isBusted(int point) {
        if (point <= 21) {
            return false;
        } else {
            return true;
        }
    }
}
