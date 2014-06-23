import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class java_util {

	// アッカーマン関数
	static int Ack(int m, int n) {
		if (m == 0)
			return n + 1;
		else if (n == 0)
			return Ack(m - 1, 1);
		else
			return Ack(m - 1, Ack(m, n - 1));
	}

	/*
	 * base進数→10進数変換 Base_Conversion(int データの基数 , int　データ) 例えば・・・
	 * Base_Conversion( 2 , int data = {1,1,1} ) なら、7が出力される。
	 */
	static int Base_Conversion(int base, int data[]) {

		int total = 0;
		int num = 1;
		for (int i = data.length - 1; i >= 0; i--) {
			for (int j = 0; j < data[i]; j++)
				total += num;
			num *= base;
		}

		return total;
	}

	// Combination 組合せ
	static int Combination(int n, int r) {
		if (r == 0 || n == r)
			return 1;
		else
			return Combination(n - 1, r - 1) + Combination(n - 1, r);
	}

	// Factorial 階乗
	static int Factorial(int n) {

		int result = 1;

		for (int i = n; 1 < i; i--)
			result *= i;

		return result;
	}

	// フィボナッチ数　積み上げ式版( O(n) )
	static int Fib_stuck(int n) {

		int f0 = 0, f1 = 1, tmp;

		for (int i = 2; i <= n; i++) {
			tmp = f1;
			f1 = f0 + f1;
			f0 = tmp;
		}

		return f1;
	}

	// 深さ優先探索で隣接リストの連結関係を調べる。
	public static boolean Connection_gudge(int data[][], int N) {
		LinkedList<Integer> Stack = new LinkedList<Integer>();
		boolean flag[] = new boolean[N];

		for (int i = 0; i < N; i++)
			flag[i] = false;

		// 探索開始位置の初期化
		Stack.add(0);
		flag[0] = true;

		int index;
		while (!Stack.isEmpty()) {
			index = Stack.getFirst();
			Stack.removeFirst();

			for (int i = 0; i < N; i++) {
				if (data[index][i] == 1 && !flag[i]) {
					Stack.add(i);
					flag[i] = true;
				}
			}
		}
		for (int i = 0; i < N; i++)
			if (!flag[i])
				return false;
		return true;
	}

	// ハノイの塔
	static void HanoiTower(int n, String A, String B, String C) {
		if (n > 0) {
			HanoiTower(n - 1, A, C, B);
			System.out.println("円盤" + n + "　:　" + A + "　→　" + B);
			HanoiTower(n - 1, C, B, A);
		}
	}

	// 石取りゲーム
	static int IshiTori(int n, int[] memo) {

		if (memo[n] >= 0)
			return memo[n];

		// 石が３個未満なら全部取れば勝利
		if (n <= 3)
			return n;

		for (int i = 1; i <= 3; i++)
			if (IshiTori(n - i, memo) == 0)
				return (memo[n] = i);

		// 手が無い
		return (memo[n] = 0);
	}

	// ユークリッドの互除法：２数の最大公約数を求める。
	static int Euclid(int A, int B) {
		int tmp;
		if (A <= B) {
			tmp = A;
			A = B;
			B = tmp;
		}

		tmp = A % B;
		if (tmp == 0)
			return B;
		return Euclid(B, tmp);
	}

	// 最大公倍数を求める
	static int LCM(int A, int B) {
		int INF = 99999;
		System.out.println(A + "," + B);

		// int max_divisor = Euclid(A,B);
		int tmp = INF;

		/*
		 * for(int i=max_divisor; i>1 ; i--) if(A%i == 0 && B%i == 0 && tmp > i)
		 * tmp=i;
		 */

		for (int i = 2; i < INF; i++) {
			if (A % i == 0 && B % i == 0) {
				tmp = i;
				break;
			}
		}
		if (tmp == INF)
			return A * B;
		return tmp * LCM(A / tmp, B / tmp);
	}

	// 素数判定テーブル
	static void CreatePrimeJudgeTable(int num, boolean table[]) {
		int rnum = (int) Math.sqrt(num) + 1;
		LinkedList<Integer> Plist = new LinkedList<Integer>();

		for (int i = 0; i < table.length; i++)
			table[i] = true;

		boolean judge = false;
		for (int i = 2; i < rnum; i++) {
			judge = true;
			for (int j = 2; j < i; j++)
				if (i % j == 0) {
					judge = false;
					break;
				}
			if (judge)
				Plist.add(i);
		}

		int prime;
		while (!Plist.isEmpty()) {
			prime = Plist.pop();
			for (int i = prime + prime; i < table.length; i += prime)
				table[i] = false;
		}

	}

	// 順列生成関数　Permutation
	static void Permutation(int n) {
		int flag[] = new int[9999];
		for (int i = 0; i < flag.length; i++)
			flag[i] = -1;
		Perm(0, n, flag);
	}

	static void Perm(int x, int n, int[] flag) {

		if (x != n) {
			for (int i = 0; i < n; i++) {
				if (flag[i] == -1) {
					flag[i] = x;
					Perm(x + 1, n, flag);
					flag[i] = -1;
				}
			}
		} else {
			for (int i = 0; i < n; i++)
				System.out.print(flag[i] + ",");
			System.out.println("");
		}

	}

	// 二次元配列の要素を全出力
	static void print_data(int data[][]) {

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++)
				System.out.print(data[i][j]);
			System.out.println("");
		}

	}

	static void print_data(String data[][]) {

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++)
				System.out.print(data[i][j]);
			System.out.println("");
		}
	}

	// 二次元配列の複製
	static void data_copy(int from[][], int to[][]) {
		for (int i = 0; i < from.length; i++)
			for (int j = 0; j < from[0].length; j++)
				to[i][j] = from[i][j];
	}

	static void data_copy(String from[][], String to[][]) {
		for (int i = 0; i < from.length; i++)
			for (int j = 0; j < from[0].length; j++)
				to[i][j] = from[i][j];
	}

	// 二次元配列の縦方向を逆順
	static void reverse_row(int[][] data) {
		int row = data.length;
		int column = data[0].length;

		int temp[][] = new int[row][column];

		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				temp[i][j] = data[row - 1 - i][j];

		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				data[i][j] = temp[i][j];
	}

	// 二次元配列の横方向を逆順
	static void reverse_column(int[][] data) {
		int row = data.length;
		int column = data[0].length;

		int temp[][] = new int[row][column];

		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				temp[i][j] = data[i][column - 1 - j];

		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				data[i][j] = temp[i][j];
	}

	// 最長共通部分系列長（LCS）を求める
	private static int LCS_Length(String str1, String str2) {
		int len1 = str1.length(), len2 = str2.length();
		int[][] lcs_table = new int[len1][len2]; // LCS長を格納した表

		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (str1.charAt(i) == str2.charAt(j))
					lcs_table[i][j] = ((i == 0 || j == 0) ? 0
							: lcs_table[i - 1][j - 1]) + 1;
				else if (str1.charAt(i) != str2.charAt(j))
					lcs_table[i][j] = Math.max(
							i == 0 ? 0 : lcs_table[i - 1][j], j == 0 ? 0
									: lcs_table[i][j - 1]);
			}
		}

		// LCS表の表示
		// for (int i = 0; i < len1; i++) {
		// for (int j = 0; j < len2; j++)
		// System.out.print(lcs_table[i][j] + " ");
		// System.out.println();
		// }

		// LCS表の最も右下にLCS長が格納されている
		return lcs_table[len1 - 1][len2 - 1];
	}

	public static void main(String[] args) {
		// ■アッカーマン関数
		int n = 2, m = 5;
		System.out.println("Ack(" + n + "," + m + ") : " + Ack(n, m));

		// ■進数変換
		int data[] = { 1, 1, 1 };
		System.out.println("進数変換(111(2進)→10進数):" + Base_Conversion(2, data));

		// ■Combination 組合せ
		int N = 5, R = 2;
		System.out.println("Combination(" + N + "," + R + ") = "
				+ Combination(N, R));

		// ■Factorial 階乗
		System.out.println("階乗計算 4! (Factorial for文実装) : " + Factorial(4));

		// ■Fibonacci フィボナッチ数　積み上げ式
		n = 7;
		System.out.println("Fib_積み上げ式(" + n + "); Result:" + Fib_stuck(n));

		// ■隣接リストの連結関係判定関数
		int data2[][] = { { 0, 1, 1, 0, 0, 0, 0, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 1, 0, 0, 0, 0, 1 },
				{ 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0, 1, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 0, 0, 1, 1, 1, 0 } };
		if (Connection_gudge(data2, data2.length)) {
			System.out.println("YES!!");
		} else {
			System.out.println("NO!!");
		}

		// ■ハノイの塔
		HanoiTower(3, "A", "B", "C");

		// ■石取り
		int[] memo = new int[999999];
		for (int i = 0; i < memo.length; i++)
			memo[i] = -1;
		System.out.println("石取りゲーム(10個):" + IshiTori(10, memo));

		// ■ユークリッドの互除法
		System.out.println("ユークリッドの互除法(2数の最大公約数を求める) Euclid(64,24):"
				+ Euclid(64, 24));

		// ■最大公倍数を求める
		int A = 42, B = 13;
		System.out.println("LCM(" + A + "," + B + ") = " + LCM(A, B));

		// ■素数判定　素数判定テーブルを作成し、それを基に判定
		int size = 9999;
		boolean PrimeJudgeTable[] = new boolean[size];

		CreatePrimeJudgeTable(size, PrimeJudgeTable);

		/*
		 * 配列の中身全確認 for(int i=0; i < PrimeJudgeTable.length; i++)
		 * if(PrimeJudgeTable[i]){ System.out.println("T:"+i); } else{
		 * System.out.println("F:"+i); }
		 */

		// 判定する値
		int JUDGE_NUMBER = 5557;

		if (PrimeJudgeTable[JUDGE_NUMBER])
			System.out.println("素数です");
		else
			System.out.println("合成数です");

		// ■ソートAPI
		int data3[] = { 2, 5, 3, 8, 7, 4, 3, 6 };
		Arrays.sort(data3);
		System.out.print("Arraysクラスのソートメソッドサンプル：");
		for (int i = 0; i < data3.length; i++)
			System.out.print(data3[i] + ",");
		System.out.println("");

		// ■順列生成
		System.out.println("順列生成:");
		Permutation(3);

		// ■乱数の生成
		Random r = new Random();
		System.out.println("整数型乱数 ： " + r.nextInt());
		System.out.println("整数型乱数(上限値100) ： " + r.nextInt(100));
		System.out.println("浮動小数点型乱数 ： " + r.nextDouble());
		System.out.println("論理型乱数 ： " + r.nextBoolean());

		// ■Stringクラスのメソッド
		String str = "   String Hello World!";
		System.out.println(str);
		// 第一引数～第二引数の部分文字列の取得
		System.out.println(str.substring(7, 12));
		// 指定された文字列が最初or最後に出現するインデックスの取得
		System.out.println(str.indexOf("l")); // 最初
		System.out.println(str.lastIndexOf("l")); // 最後
		// 指定された文字列で始まっているor終わっているならTrue ！！大文字小文字は区別される！！
		System.out.println(str.startsWith("St"));
		System.out.println(str.endsWith("d!"));
		// 末尾に引数の文字列を付け加える
		System.out.println(str.concat(" Tukekuwae!"));
		// 第一引数の文字列を、第二引数の文字列に置き換える。
		System.out.println(str.replaceAll("Hello", "ReplaceThis"));
		// 引数の文字列の両端の空白文字を削除 ！！全角スペースは不可！！
		System.out.println(str.trim());
		// 大文字or小文字変換
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		// 文字列の反転.逆順に
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb.reverse().toString());
		
		String str2 = "abcd"; //こっちの方が良いかも？
		str = new StringBuffer(str2).reverse().toString();
		

		// 配列の要素の逆転
		int hairetu[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("そのまま");
		print_data(hairetu);
		reverse_column(hairetu);
		System.out.println("横に逆");
		print_data(hairetu);
		reverse_column(hairetu);
		reverse_row(hairetu);
		System.out.println("縦に逆");
		print_data(hairetu);		
		
		//LCS
		System.out.println("LCS:"+LCS_Length("ABCBDAB","BDCABA"));

	}

}
