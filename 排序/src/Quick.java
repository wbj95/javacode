

//��������
public class Quick {
//��������
	public void quickSort(int[] A, int first, int end) {
		int port;
		if (first < end) {
			port = partition(A, first, end);//����������
			quickSort(A, first, port - 1);//���������1�����������������
			quickSort(A, port + 1, end);//�������2�����Ҳ�����������
		}
	}
	//����
	int partition(int A[], int first, int end) {
		int i = first, j = end;//��ʼ����������
		while (i < j) {
			while (i < j && A[i] <= A[j])j--;//�Ҳ�ɨ��
			if (i < j) {//����С��������ǰ��
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				i++;
			}
			while (i < j && A[i] <= A[j])i++;//���ɨ��
			if (i < j) {//���ϴ������������
				int temp = A[i];A[i] = A[j];A[j] = temp;
				j--;
			}
		}
		//System.out.println(i);
		return i;//����������
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {23,13,35,6,19,50,28 };
		Quick quick = new Quick();
		int first = 0;
		int end = A.length-1;
		//System.out.println(end);
		quick.quickSort(A, first, end);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		
	}

}
