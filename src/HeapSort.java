//Haydar Taha Tunc 150119745
//Emir Ege Eren 150119739
//Burak Dursun 150119743
public class HeapSort {
    static int numbers[];
    static int i = 0;

    public HeapSort(int size){
        numbers = new int[size];
    }

    public void Insert(int key){
        numbers[i] = key;
        i++;
    }
    public void buildMaxHeap(int numbers[], int k){
        int startPoint = numbers.length/2;
        int size = numbers.length;
        for (int i = startPoint; i >= 0; i--) {
            MaxHeap(i, size);
        }
        for (int i = 0; i < numbers.length - k; i++) {
            numbers[0] = numbers[size - 1];
            size = size - 1;
            MaxHeap(0, size);
        }
    }

    public void MaxHeap(int index, int size){
        int parent = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && numbers[left] > numbers[parent]){
            parent = left;
        }

        if (right < size && numbers[right] > numbers[parent]){
            parent = right;
        }

        if (parent != index){
            int temp = numbers[index];
            numbers[index] = numbers[parent];
            numbers[parent] = temp;

            MaxHeap(parent, size);
        }
    }

    public void print(int k){
        System.out.println("HeapSort\n----------");
        long start = System.nanoTime();
        buildMaxHeap(numbers, k);
        long end = System.nanoTime();
        long time = end - start;
        System.out.print("kth element: " + numbers[0] + "\nExecution time: " + (double)time/1000000 + " ms");
    }
}