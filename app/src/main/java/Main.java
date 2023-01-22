import jp.ac.uryukyu.ie.e225741.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("<Game Start>");

        List<Integer> stack = new ArrayList<>();

        Blackjack.shuffleStack(stack);

        // 手札リスト
        List<Integer> player = new ArrayList<>();
        List<Integer> dealer = new ArrayList<>();

        player.add(stack.get(0));
        dealer.add(stack.get(1));
        player.add(stack.get(2));
        dealer.add(stack.get(3));

        // 山札を何回引いたか
        int stackCount = 4;

        // プレイヤーの手札の枚数
        int playerHands = 2;

        System.out.println("あなたの1枚目のカードは" + Blackjack.toRank(player.get(0)));

        System.out.println("ディーラーの1枚目のカードは" + Blackjack.toRank(dealer.get(0)));

        System.out.println("あなたの2枚めのカードは" + Blackjack.toRank(player.get(1)));

        System.out.println("ディーラーの2枚めのカードは秘密です。");

        // 合計ポイント
        int playerPoint = Blackjack.sumPoint(player);
        int dealerPoint = Blackjack.sumPoint(dealer);

        System.out.println("あなたの現在の合計は" + playerPoint + "です。");

        // プレイヤーがカードを引くフェーズ

        while (true) {
            System.out.println("カードを追加する？Yes:y or No:n");
            // yes or noの処理
            Scanner scan = new Scanner(System.in);
            String str = scan.next();
            if ("n".equals(str)) {
                break;
            } else if ("y".equals(str)) {
                // 手札の追加
                player.add(stack.get(stackCount));
                stackCount += 1;
                playerHands += 1;
                System.out.println("あなたの" + playerHands + "枚目のカードは" + Blackjack.toRank(player.get(playerHands - 1)));
                playerPoint = Blackjack.sumPoint(player);
                System.out.println("現在の合計は" + playerPoint);
                // プレイヤーのバーストチェック
                if (Blackjack.isBusted(playerPoint)) {
                    System.out.println("バーストにより敗北");
                    return;
                }

            } else {
                System.out.println("入力ミス");
            }
        }

        while (true) {
            // 手札が17以上の場合ブレーク
            if (dealerPoint >= 17) {
                break;
            } else {
                // 手札に山札から1枚加える
                dealer.add(stack.get(stackCount));
                // 山札を一枚進める
                stackCount += 1;

                // ディーラーの合計ポイント
                dealerPoint = Blackjack.sumPoint(dealer);
                // ディーラーのバーストチェック
                if (Blackjack.isBusted(dealerPoint)) {
                    System.out.println("バーストにより勝利");
                    return;
                }

            }
        }

        System.out.println("あなたのポイントは" + playerPoint);
        System.out.println("ディーラーのポイントは" + dealerPoint);

        if (playerPoint == dealerPoint) {
            System.out.println("引き分け");
        } else if (playerPoint > dealerPoint) {
            System.out.println("勝利！");
        } else {
            System.out.println("敗北");
        }

    }

}
