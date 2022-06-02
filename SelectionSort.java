//Haydar Taha Tunc 150119745
//Emir Ege Eren 150119739
//Burak Dursun 150119743
public class SelectionSort {
    static int i = 0;
    static int numbers[];

    public SelectionSort(int size){
        numbers = new int[size];
    }

    public void Insert(int key){
        numbers[i] = key;
        i++;
    }
    public void print(int k){
        long start = System.nanoTime();
        SelectionSort(numbers, k);
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("SelectionSort\n----------");
        System.out.print("kth element: " + numbers[k-1] + "\nExecution time: " + (double)time/1000000 + " ms");
    }

    public void SelectionSort(int numbers[], int k){
        int temp = 0;
        for (int i = 0; i < k; i++) {
            int minIndex = i;
            int minValue = numbers[i];
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[j] < minValue){
                    minIndex = j;
                    minValue = numbers[j];
                    temp = numbers[i];
                    numbers[i] = numbers[minIndex];
                    numbers[minIndex] = temp;
                }
            }
        }
    }
}