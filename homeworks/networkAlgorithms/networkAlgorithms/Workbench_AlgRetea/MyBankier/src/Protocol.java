import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class Protocol {

	private static int[] resurseDispnibile = null;

	private static int nrProcese = 0;
	private static int nrResurse = 0;

	private HashMap<String, int[]> hmResurseOcupate = new HashMap<String, int[]>();
	private HashMap<String, int[]> hmResurseCerute = new HashMap<String, int[]>();

	private static HashMap<String, String> hmClientId = new HashMap<String, String>();

	public static void addClientId(String id, String client) {
		hmClientId.put(id, client);
	}

	int[][] matriceResOcupate;
	int[][] matriceResCerute;

	String sequence = "";

	public static int[] getResurseDispnibile() {
		return resurseDispnibile;
	}

	public static int getNrProcese() {
		return nrProcese;
	}

	public static int getNrResurse() {
		return nrResurse;
	}

	public int[] parseVector(String inputLine) {
		int[] result = null;
		String[] parts = inputLine.split(";");
		result = new int[parts.length];
		int pos = 0;
		for (String strNo : parts) {
			int no = 0;
			try {
				no = Integer.parseInt(strNo);
			} catch (Exception e) {
				no = 0;
			}
			result[pos++] = no;
		}

		return result;
	}

	public static String displayArray(int[] x) {
		String res = "";
		for (int i : x) {
			res = res + "  " + i;
		}
		return res;
	}

	public void doProcessing() {

		String out="a terminat";
		
		int work[] = resurseDispnibile;
		boolean finish[] = new boolean[nrProcese];

		for (int i = 0; i < nrProcese; i++) {
			finish[i] = false;
		}

		boolean check = true;
		while (check) {
			check = false;
			for (int i = 0; i < nrProcese; i++) {
				if (!finish[i]) {
					int j;
					for (j = 0; j < nrResurse; j++) {
						if (matriceResCerute[i][j] > work[j]) {
							break;
						}
					}

					if (j == nrResurse) {
						for (j = 0; j < nrResurse; j++) {
							work[j] = work[j] + matriceResOcupate[i][j];
						}
						finish[i] = true;
						check = true;
						sequence += i + ", ";
					}
					if(!check)
						//procesul nu a  terminat
					{
						out="nu a terminat";
					}
				}
			}
		}
		boolean allFinished = true;
		int i;
		for (i = 0; i < nrProcese; i++) {
			if (!finish[i]) {
				allFinished = false;
			}
		}

		if (allFinished) {
			System.out.println("SUPER, toate au terminat");
		} else {
			System.out.println("DEADLOCK");
		}

	
	}

	public void addToResurseOcupate(String serial, int[] inputLine) {
		hmResurseOcupate.put(serial, inputLine);
		System.out.println("matrice resurse ocupate");
		construireMatrice(matriceResOcupate, inputLine);
	}

	public void addToResurseCerute(String serial, int[] inputLine) {
		hmResurseCerute.put(serial, inputLine);
		System.out.println("matrice resurse cerute");
		construireMatrice(matriceResCerute, inputLine);

		System.out.println("--------");
		System.out.println("resurse ocupate ");
		displayHM(hmResurseOcupate);
		System.out.println("resurse cerute");
		displayHM(hmResurseCerute);
		System.out.println("--------");
	}

	private void construireMatrice(int[][] matrice, int[] vector) {
		for (int i = 0; i < nrProcese; i++) {
			if (matrice[i][0] == -1) {
				for (int j = 0; j < nrResurse; j++)
					matrice[i][j] = vector[j];
				break;
			}
		}
		for (int i = 0; i < nrProcese; i++) {
			for (int j = 0; j < nrResurse; j++)
				System.out.print(matrice[i][j] + " ");
			System.out.println();
		}
	}

	public void displayHM(HashMap<String, int[]> hm) {
		for (String key : hm.keySet()) {
			System.out.println(key + " : " + displayArray(hm.get(key)));
		}
	}

	
	public static void displayHMClientId() {
		for (String key : hmClientId.keySet()) {
			System.out.println(key + " : " + hmClientId.get(key));
		}
	}
	public void addToResurseDisponibile(int[] vectorRD) {
		resurseDispnibile = vectorRD;
		System.out.println("resurse disponibile "
				+ displayArray(resurseDispnibile));

	}

	public void creareMatrici(int[] nrProcRes) {
		nrProcese = nrProcRes[0];
		nrResurse = nrProcRes[1];
		matriceResOcupate = new int[nrProcese][nrResurse];
		matriceResCerute = new int[nrProcese][nrResurse];
		for (int i = 0; i < nrProcese; i++)
			for (int j = 0; j < nrResurse; j++) {
				matriceResOcupate[i][j] = -1;
				matriceResCerute[i][j] = -1;
			}
	}
}
