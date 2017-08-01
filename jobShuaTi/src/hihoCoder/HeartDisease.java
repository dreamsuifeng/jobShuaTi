package hihoCoder;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDisease {
	static class paifront {
		int[] fruit;
		int[] animal;
		boolean isfruit;

		public paifront() {
			fruit = new int[4];
			isfruit = false;
			animal = new int[3];
		}
	}

	private static boolean isTrue(int[] fruits, int[] animals) {
		boolean fiveflag = false;
		int sum = 0;
		for (int i : fruits) {
			sum += i;
			if (i == 5) {
				fiveflag = true;

			}
		}
		if (fiveflag || (animals[0] > 0 && sum > 0 && fruits[3] == 0) || (animals[1] > 0 && sum > 0 && fruits[1] == 0)
				|| (animals[2] > 0 && sum > 0)) {

			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] pais = new int[n];
		int flag = 0;
		int[] fruits = new int[4];
		int[] animals = new int[3];
		Arrays.fill(pais, 0, pais.length, 10000000);
		int amountdesk = 0;
		paifront[] paifronts = new paifront[n];
		for (int i=0;i<n;++i){
			paifronts[i]=new paifront();
		}
		for (int i = 0; i < k; ++i) {
			String fString = in.next();
			int[] fruit = new int[4];
			int[] animal = new int[3];
			if (fString.equals("Fruit")) {
				pais[flag]--;
				int fc = in.nextInt();
				amountdesk++;
				for (int j = 0; j < fc; ++j) {
					int index = in.nextInt();
					fruit[index]++;
				}
				paifront tmp = paifronts[flag];
				if (tmp.isfruit) {
					for (int k1 = 0; k1 < 4; ++k1) {
						fruits[k1] = fruits[k1] + (fruit[k1] - tmp.fruit[k1]);
					}
					paifronts[flag].fruit = Arrays.copyOf(fruit, 4);

				} else {
					for (int k1 = 0; k1 < 3; ++k1) {
						animals[k1] = animals[k1] - paifronts[flag].animal[k1];
					}
					for (int k1 = 0; k1 < 4; ++k1) {
						fruits[k1] = fruits[k1] + fruit[k1];
					}
					paifronts[flag].fruit = Arrays.copyOf(fruit, 4);
					paifronts[flag].isfruit = true;
					Arrays.fill(paifronts[flag].animal, 0, 3, 0);
				}
				flag++;
				if (flag == n) {
					flag = 0;
				}
			} else if (fString.equals("Animal")) {
				pais[flag]--;
				amountdesk++;
				animal[in.nextInt()]++;
				if (paifronts[flag].isfruit) {
					for (int k2 = 0; k2 < 4; ++k2) {
						fruits[k2] -= paifronts[flag].fruit[k2];
					}
					for (int k2 = 0; k2 < 3; ++k2) {
						animals[k2] += animal[k2];
					}
					paifronts[flag].isfruit = false;
					Arrays.fill(paifronts[flag].fruit, 0, 4, 0);
					paifronts[flag].animal=Arrays.copyOf(animal, 3);
				} else {
					for (int k3 = 0; k3 < 3; ++k3) {
						animals[k3] = animals[k3] + (animal[k3] - paifronts[flag].animal[k3]);
					}
					paifronts[flag].animal = Arrays.copyOf(animal, 3);
				}
				flag++;
				if (flag == n) {
					flag = 0;
				}
			} else {
				int idindex = in.nextInt();
				if (isTrue(fruits, animals)) {
					pais[idindex] += amountdesk;
					
					Arrays.fill(fruits, 0, 4, 0);
					Arrays.fill(animals, 0, 3, 0);
					amountdesk=0;
					for (int l=0;l<n;++l){
						paifronts[l]=new paifront();
					}
				} else {
					pais[idindex] -= (n - 1);
					for (int l = 0; l < n; ++l) {
						if(l==idindex) continue;
						pais[l]++;
					}
				}
				flag = idindex;
			}
		}
		for (int i : pais) {
			System.out.println(i);
		}
	}

}
