package pay.money.paymoney;

import java.util.Scanner;

public class PayMoneySolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the transaction array
        System.out.println("Enter the size of the transaction array:");
        int size = scanner.nextInt();

        // Input the values of the transaction array
        System.out.println("Enter the values of the array:");
        int[] transactions = new int[size];
        for (int i = 0; i < size; i++) {
            transactions[i] = scanner.nextInt();
        }

        // Input the total number of targets
        System.out.println("Enter the total number of targets that need to be achieved:");
        int numTargets = scanner.nextInt();

        // Input and process each target
        for (int targetIndex = 1; targetIndex <= numTargets; targetIndex++) {
            System.out.println("Enter the value of target " + targetIndex + ":");
            int target = scanner.nextInt();

            // Check if the target is achievable
            int transactionsRequired = calculateMinimumTransactions(transactions, target);
            if (transactionsRequired > 0) {
                System.out.println("Target achieved after " + transactionsRequired + " transactions");
            } else {
                System.out.println("Given target is not achieved");
            }
        }

        scanner.close();
    }

    // Function to calculate the minimum number of transactions
    private static int calculateMinimumTransactions(int[] transactions, int target) {
        int sum = 0;
        int transactionsRequired = 0;

        for (int transaction : transactions) {
            sum += transaction;
            transactionsRequired++;

            if (sum >= target) {
                return transactionsRequired;
            }
        }

        return -1; // Indicates that the target is not achievable
    }
}
