//Haydar Taha Tunc 150119745
//Emir Ege Eren 150119739
//Burak Dursun 150119743
public class QuickSort {
    static int i = 0;
    static int numbers[];

    public QuickSort(int size){
        numbers = new int[size];
    }

    public void Insert(int key){
        numbers[i] = key;
        i++;
    }
    public void print(int k){
        long start = System.nanoTime();
        QuickSort(numbers, 0, numbers.length - 1);
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("QuickSort\n----------");
        System.out.print("kth element: " + numbers[k-1] + "\nExecution time: " + (double)time/1000000 + " ms");
    }
    public int HoarePartition(int numbers[], int l, int r){
        int p = numbers[l];
        int i = l-1;
        int j = r+1;
        int temp, temp2, temp3;

        while (i < j){
            do {
                i++;
            }while (numbers[i] < p);

            do {
                j--;
            }while (numbers[j] > p);

            temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        temp2 = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp2;

        temp3 = numbers[l];
        numbers[l] = numbers[j];
        numbers[j] = temp3;

        return j;
    }
    public void QuickSort(int numbers[], int l, int r){
        int s;
        if(l<r){
            s= HoarePartition(numbers,l,r);
            QuickSort(numbers,l,s);
            QuickSort(numbers,(s+1),r);
        }
    }
}