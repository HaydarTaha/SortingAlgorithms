//Haydar Taha Tunc 150119745
//Emir Ege Eren 150119739
//Burak Dursun 150119743
public class MergeSort {
    static int i = 0;
    static int numbers[];

    public MergeSort(int size){
        numbers = new int[size];
    }

    public void Insert(int key){
        numbers[i] = key;
        i++;
    }
    public void Merge(int numbers[], int numbersL[], int numbersR[]){
        int numbersLSize = numbersL.length;
        int numbersRSize = numbersR.length;
        int i = 0, j = 0, k = 0;
        while (i < numbersLSize && j < numbersRSize){
            if (numbersL[i] <= numbersR[j]){
                numbers[k] = numbersL[i];
                i++;
            }else {
                numbers[k] = numbersR[j];
                j++;
            }
            k++;
        }
        while (i<numbersLSize){
            numbers[k] = numbersL[i];
            i++;
            k++;
        }
        while (j<numbersRSize){
            numbers[k] = numbersR[j];
            j++;
            k++;
        }
    }

    public void MergeSort(int numbers[]){
        int size = numbers.length;
        int middle = size/2;
        int numbersL[] = new int[middle];
        int numbersR[] = new int[size-middle];
        if (numbers.length>1){
            int half = size/2;
            for (int i = 0; i< half; i++){
                int tempNum = numbers[i];
                numbersL[i] = tempNum;
            }
            for (int i = half; i< size; i++){
                int tempNum = numbers[i];
                numbersR[i - half] = tempNum;
            }
            MergeSort(numbersL);
            MergeSort(numbersR);
            Merge(numbers, numbersL, numbersR);
        }
    }

    public void print(int k){
        long start = System.nanoTime();
        MergeSort(numbers);
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("MergeSort\n----------");
        System.out.print("kth element: " + numbers[k-1] + "\nExecution time: " + (double)time/1000000 + " ms");
    }

}