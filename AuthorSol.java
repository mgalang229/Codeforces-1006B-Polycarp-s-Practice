import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class AuthorSol {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = fs.nextInt();
			int k = fs.nextInt();
			ArrayList<Pair> res = new ArrayList<>(n);
			ArrayList<Integer> arr = new ArrayList<>(n);
			for (int i = 0; i < n; i++) {
				res.add(new Pair(fs.nextInt(), i + 1));
				arr.add(res.get(i).first);
			}
			Collections.sort(res, new Comparator<Pair>() {
				@Override
				public int compare(Pair a, Pair b) {
					if (a.first > b.first) {
						return -1;
					}
					return 1;
				}
			});
			System.out.println();
			Collections.sort(res.subList(0, k), new Comparator<Pair>() {
				@Override
				public int compare(Pair a, Pair b) {
					if (a.second < b.second) {
						return -1;
					}
					return 1;
				}
			});
			int last = 0;
			int sum = 0;
			for (int i = 0; i < k - 1; i++) {
				sum += Collections.max(arr.subList(last, res.get(i).second));
				last = res.get(i).second;
			}
			sum += Collections.max(arr.subList(last, n));
			System.out.println(sum);
			last = 0;
			for (int i = 0; i < k - 1; i++) {
				System.out.print(res.get(i).second - last + " ");
				last = res.get(i).second;
			}
			System.out.println(n - last);
		}
		out.close();
	}
	
	static class Pair {
		int first;
		int second;
		
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for (int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
	
	static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
