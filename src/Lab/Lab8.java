package Lab;

//Explanation at the bottom

import java.util.Scanner;

public class Lab8 {
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        java.util.Arrays.fill(dp, max);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter coins:");
        String coinInput = scanner.nextLine();
        String[] coinParts = coinInput.split(" ");
        int[] coins = new int[coinParts.length];
        for (int i = 0; i < coinParts.length; i++) {
            coins[i] = Integer.parseInt(coinParts[i].trim());
        }

        System.out.println("Enter amount:");
        int amount = scanner.nextInt();

        System.out.println(coinChange(coins, amount));

        scanner.close();
    }
}

/*

 */
