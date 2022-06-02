//Haydar Taha Tunc 150119745
//Emir Ege Eren 150119739
//Burak Dursun 150119743
public class InsertionSort {
    static int i = 0;
    static int numbers[];

    public InsertionSort(int size){
        numbers = new int[size];
    }

    public void Insert(int key){
        numbers[i] = key;
        i++;
    }
    public void print(int k){
        System.out.println("InsertionSort\n----------");
        long start = System.nanoTime();
        InsertionSort(numbers);
        long end = System.nanoTime();
        long time = end - start;
        System.out.print("kth element: " + numbers[k-1] + "\nExecution time: " + (double)time/1000000 + " ms");
    }
    public void InsertionSort(int numbers[]){
        int size = numbers.length;
        for (int i = 1; i<size; ++i){
            int v = numbers[i];
            int j = i - 1;
            while (j>=0 && numbers[j]>v){
                numbers[j+1] = numbers[j];
                j = j - 1;
            }
            numbers[j+1] = v;
        }
    }
}