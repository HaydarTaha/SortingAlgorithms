//Haydar Taha Tunc 150119745
//Emir Ege Eren 150119739
//Burak Dursun 150119743
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("InsertionSort:1\nMergeSort:2\nQuickSort:3\nSelectionSort:4\nHeapSort:5\nQuickSelect:6\nQuickSelectMedianOfThree:7");
        System.out.print("Select Algorithm(Enter a Value): ");
        int selectAlgorithm = scanner1.nextInt();
        System.out.print("Enter file name(without .txt): ");
        String fileName = scanner1.next();
        File file = new File("inputs/"+fileName+".txt");
        Scanner scanner = new Scanner(file);
        int size=0;
        while (scanner.hasNextLine()){
            numbers.add(scanner.nextInt());
            size++;
        }
        System.out.print("Enter k value(Between 1-"+size+"): ");
        int k = scanner1.nextInt();
        InsertionSort insertionSort = new InsertionSort(size);
        MergeSort mergeSort = new MergeSort(size);
        QuickSort quicksort = new QuickSort(size);
        SelectionSort selectionSort = new SelectionSort(size);
        QuickSelect quickSelect = new QuickSelect(size);
        HeapSort heapSort = new HeapSort(size);
        QuickSelectMedianOfThree quickSelectMedianOfThree = new QuickSelectMedianOfThree(size);
        for (int i = 0; i < size; i++) {
            insertionSort.Insert(numbers.get(i));
            mergeSort.Insert(numbers.get(i));
            quicksort.Insert(numbers.get(i));
            selectionSort.Insert(numbers.get(i));
            quickSelect.Insert(numbers.get(i));
            quickSelectMedianOfThree.Insert(numbers.get(i));
            heapSort.Insert(numbers.get(i));
        }
        switch (selectAlgorithm){
            case 1:insertionSort.print(k);
            break;
            case 2:mergeSort.print(k);
            break;
            case 3:quicksort.print(k);
            break;
            case 4:selectionSort.print(k);
            break;
            case 5:heapSort.print(k);
            break;
            case 6:quickSelect.print(k);
            break;
            case 7:quickSelectMedianOfThree.print(k);
            break;
            default:System.out.println("Invalid value.");
        }
    }
}