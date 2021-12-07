package lcs;

import java.util.Scanner;

public class LCS {
	
	
	public static char[][] lcs(char[] X, char[] Y, int m, int n ) {
		
		int c[][] = new int[m+1][n+1];
		char b[][] = new char[m+1][n+1];
		
		
		for(int i = 1; i <= m; i++) {
			c[i][0] = 0;
		}
		for (int j = 0; j <= n; j++) {
			c[0][1] = 0;
		}
		
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (X[i-1] == Y[j-1]) {
					c[i][j] = c[i-1][j-1]+1;
					b[i][j] = '*';
				}
				else {
					if(c[i-1][j] >= c[i][j-1]) {
						c[i][j] = c[i-1][j];
						b[i][j] = '^';
					} else {
						c[i][j] = c[i][j-1];
						b[i][j] = '<';
					}
				}
			}
		}
		
		return b;
			
	}
	
	
	public static void printLCS(char b[][], char X[], int i, int j) {
		if (i == 0 || j == 0) {
			return;
		} else if (b[i][j] == '*') {
			printLCS(b, X, i-1, j-1);
			System.out.print(X[i-1]);
				
			
		} else if (b[i][j] == '^') {
			printLCS(b,X,i-1,j);
			
		} else {
			printLCS(b,X,i,j-1);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter first string: ");
		String input1 = scanner.next();
		System.out.println("Please enter next string: ");
		String input2 = scanner.next();
		
		char[] X = input1.toCharArray();
		char[] Y = input2.toCharArray();
		
		int m = X.length;
		int n = Y.length;
		
		char b[][] = lcs(X, Y, m, n);
		printLCS(b, X, m, n);
	}

}
