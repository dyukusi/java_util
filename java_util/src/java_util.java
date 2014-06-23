import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class java_util {

	// �A�b�J�[�}���֐�
	static int Ack(int m, int n) {
		if (m == 0)
			return n + 1;
		else if (n == 0)
			return Ack(m - 1, 1);
		else
			return Ack(m - 1, Ack(m, n - 1));
	}

	/*
	 * base�i����10�i���ϊ� Base_Conversion(int �f�[�^�̊ , int�@�f�[�^) �Ⴆ�΁E�E�E
	 * Base_Conversion( 2 , int data = {1,1,1} ) �Ȃ�A7���o�͂����B
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

	// Combination �g����
	static int Combination(int n, int r) {
		if (r == 0 || n == r)
			return 1;
		else
			return Combination(n - 1, r - 1) + Combination(n - 1, r);
	}

	// Factorial �K��
	static int Factorial(int n) {

		int result = 1;

		for (int i = n; 1 < i; i--)
			result *= i;

		return result;
	}

	// �t�B�{�i�b�`���@�ςݏグ����( O(n) )
	static int Fib_stuck(int n) {

		int f0 = 0, f1 = 1, tmp;

		for (int i = 2; i <= n; i++) {
			tmp = f1;
			f1 = f0 + f1;
			f0 = tmp;
		}

		return f1;
	}

	// �[���D��T���ŗאڃ��X�g�̘A���֌W�𒲂ׂ�B
	public static boolean Connection_gudge(int data[][], int N) {
		LinkedList<Integer> Stack = new LinkedList<Integer>();
		boolean flag[] = new boolean[N];

		for (int i = 0; i < N; i++)
			flag[i] = false;

		// �T���J�n�ʒu�̏�����
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

	// �n�m�C�̓�
	static void HanoiTower(int n, String A, String B, String C) {
		if (n > 0) {
			HanoiTower(n - 1, A, C, B);
			System.out.println("�~��" + n + "�@:�@" + A + "�@���@" + B);
			HanoiTower(n - 1, C, B, A);
		}
	}

	// �Ύ��Q�[��
	static int IshiTori(int n, int[] memo) {

		if (memo[n] >= 0)
			return memo[n];

		// �΂��R�����Ȃ�S�����Ώ���
		if (n <= 3)
			return n;

		for (int i = 1; i <= 3; i++)
			if (IshiTori(n - i, memo) == 0)
				return (memo[n] = i);

		// �肪����
		return (memo[n] = 0);
	}

	// ���[�N���b�h�̌ݏ��@�F�Q���̍ő���񐔂����߂�B
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

	// �ő���{�������߂�
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

	// �f������e�[�u��
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

	// ���񐶐��֐��@Permutation
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

	// �񎟌��z��̗v�f��S�o��
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

	// �񎟌��z��̕���
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

	// �񎟌��z��̏c�������t��
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

	// �񎟌��z��̉��������t��
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

	// �Œ����ʕ����n�񒷁iLCS�j�����߂�
	private static int LCS_Length(String str1, String str2) {
		int len1 = str1.length(), len2 = str2.length();
		int[][] lcs_table = new int[len1][len2]; // LCS�����i�[�����\

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

		// LCS�\�̕\��
		// for (int i = 0; i < len1; i++) {
		// for (int j = 0; j < len2; j++)
		// System.out.print(lcs_table[i][j] + " ");
		// System.out.println();
		// }

		// LCS�\�̍ł��E����LCS�����i�[����Ă���
		return lcs_table[len1 - 1][len2 - 1];
	}

	public static void main(String[] args) {
		// ���A�b�J�[�}���֐�
		int n = 2, m = 5;
		System.out.println("Ack(" + n + "," + m + ") : " + Ack(n, m));

		// ���i���ϊ�
		int data[] = { 1, 1, 1 };
		System.out.println("�i���ϊ�(111(2�i)��10�i��):" + Base_Conversion(2, data));

		// ��Combination �g����
		int N = 5, R = 2;
		System.out.println("Combination(" + N + "," + R + ") = "
				+ Combination(N, R));

		// ��Factorial �K��
		System.out.println("�K��v�Z 4! (Factorial for������) : " + Factorial(4));

		// ��Fibonacci �t�B�{�i�b�`���@�ςݏグ��
		n = 7;
		System.out.println("Fib_�ςݏグ��(" + n + "); Result:" + Fib_stuck(n));

		// ���אڃ��X�g�̘A���֌W����֐�
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

		// ���n�m�C�̓�
		HanoiTower(3, "A", "B", "C");

		// ���Ύ��
		int[] memo = new int[999999];
		for (int i = 0; i < memo.length; i++)
			memo[i] = -1;
		System.out.println("�Ύ��Q�[��(10��):" + IshiTori(10, memo));

		// �����[�N���b�h�̌ݏ��@
		System.out.println("���[�N���b�h�̌ݏ��@(2���̍ő���񐔂����߂�) Euclid(64,24):"
				+ Euclid(64, 24));

		// ���ő���{�������߂�
		int A = 42, B = 13;
		System.out.println("LCM(" + A + "," + B + ") = " + LCM(A, B));

		// ���f������@�f������e�[�u�����쐬���A�������ɔ���
		int size = 9999;
		boolean PrimeJudgeTable[] = new boolean[size];

		CreatePrimeJudgeTable(size, PrimeJudgeTable);

		/*
		 * �z��̒��g�S�m�F for(int i=0; i < PrimeJudgeTable.length; i++)
		 * if(PrimeJudgeTable[i]){ System.out.println("T:"+i); } else{
		 * System.out.println("F:"+i); }
		 */

		// ���肷��l
		int JUDGE_NUMBER = 5557;

		if (PrimeJudgeTable[JUDGE_NUMBER])
			System.out.println("�f���ł�");
		else
			System.out.println("�������ł�");

		// ���\�[�gAPI
		int data3[] = { 2, 5, 3, 8, 7, 4, 3, 6 };
		Arrays.sort(data3);
		System.out.print("Arrays�N���X�̃\�[�g���\�b�h�T���v���F");
		for (int i = 0; i < data3.length; i++)
			System.out.print(data3[i] + ",");
		System.out.println("");

		// �����񐶐�
		System.out.println("���񐶐�:");
		Permutation(3);

		// �������̐���
		Random r = new Random();
		System.out.println("�����^���� �F " + r.nextInt());
		System.out.println("�����^����(����l100) �F " + r.nextInt(100));
		System.out.println("���������_�^���� �F " + r.nextDouble());
		System.out.println("�_���^���� �F " + r.nextBoolean());

		// ��String�N���X�̃��\�b�h
		String str = "   String Hello World!";
		System.out.println(str);
		// �������`�������̕���������̎擾
		System.out.println(str.substring(7, 12));
		// �w�肳�ꂽ�����񂪍ŏ�or�Ō�ɏo������C���f�b�N�X�̎擾
		System.out.println(str.indexOf("l")); // �ŏ�
		System.out.println(str.lastIndexOf("l")); // �Ō�
		// �w�肳�ꂽ������Ŏn�܂��Ă���or�I����Ă���Ȃ�True �I�I�啶���������͋�ʂ����I�I
		System.out.println(str.startsWith("St"));
		System.out.println(str.endsWith("d!"));
		// �����Ɉ����̕������t��������
		System.out.println(str.concat(" Tukekuwae!"));
		// �������̕�������A�������̕�����ɒu��������B
		System.out.println(str.replaceAll("Hello", "ReplaceThis"));
		// �����̕�����̗��[�̋󔒕������폜 �I�I�S�p�X�y�[�X�͕s�I�I
		System.out.println(str.trim());
		// �啶��or�������ϊ�
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		// ������̔��].�t����
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb.reverse().toString());
		
		String str2 = "abcd"; //�������̕����ǂ������H
		str = new StringBuffer(str2).reverse().toString();
		

		// �z��̗v�f�̋t�]
		int hairetu[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("���̂܂�");
		print_data(hairetu);
		reverse_column(hairetu);
		System.out.println("���ɋt");
		print_data(hairetu);
		reverse_column(hairetu);
		reverse_row(hairetu);
		System.out.println("�c�ɋt");
		print_data(hairetu);		
		
		//LCS
		System.out.println("LCS:"+LCS_Length("ABCBDAB","BDCABA"));

	}

}
