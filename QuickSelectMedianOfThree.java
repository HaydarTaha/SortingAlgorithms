//Haydar Taha Tunc 150119745
//Emir Ege Eren 150119739
//Burak Dursun 150119743
import java.util.Arrays;
public class QuickSelectMedianOfThree {
    static int i = 0;
    static int numbers[];

    public QuickSelectMedianOfThree(int size){
        numbers = new int[size];
    }

    public void Insert(int key){
        numbers[i] = key;
        i++;
    }
    public void print(int k){
        long start = System.nanoTime();
        QuickSelect(numbers, 0, numbers.length-1, k);
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("QuickSelectMedianOfThree\n----------");
        System.out.print("kth element: " + numbers[k-1] + "\nExecution time: " + (double)time/1000000 + " ms");
    }


    public static int findPivotMedianOfThree(int numbers[], int l, int r){

        int mid= r/2;

        int[] medianOfTree = {numbers[l], numbers[mid], numbers[r]};
        Arrays.sort(medianOfTree);
        int value = medianOfTree[1];

        int temp = numbers[r];
        numbers[r] = value;

        if (value == numbers[l]){
            numbers[l] = temp;
        } else if (value == numbers[mid]){
            numbers[mid] = temp;
        }

        return LomutoPartition(numbers, l, r);
    }


    public static int LomutoPartition(int numbers[], int l, int r){
        int p = numbers[r];
        int s = l;
        int temp;
        int temp2;
        for(int i=l; i<=r; i++){
            if(numbers[i]<p){
                temp = numbers[i];
                numbers[i] = numbers[s];
                numbers[s] = temp;
                s=s+1;
            }
        }
        temp2 = numbers[r];
        numbers[r] = numbers[s];
        numbers[s] = temp2;
        return s;
    }


    public int QuickSelect(int numbers[], int low , int high, int k) {

        int s = findPivotMedianOfThree(numbers,low,high);

        if (s == k - 1) {
            return numbers[s];
        } else if (s < k -1) {
            return QuickSelect(numbers, s + 1, high, k);
        } else {
            return QuickSelect(numbers, low, s - 1, k);
        }
    }
}