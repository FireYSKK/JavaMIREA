import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int len = 8;
        Random random = new Random();
        Sort sorting = new Sort();

        Student[] students = new Student[len];
        for (int i = 0; i < len; i++) {
            students[i] = new Student(random.nextInt(1000), random.nextInt(100));
        }

        System.out.println("Source array: ");
        printArray(students);
        sorting.insertionSort(students);
        System.out.println("(Insertion sort) Sorted array: ");
        printArray(students);

        sorting.quickSort(students, 0, len-1, new SortingStudentsByGPA());
        System.out.println("(Quicksort) Now sorting high to low (score):");
        printArray(students);

        Student[] students2 = new Student[len / 2];
        for (int i = 0; i < len / 2; i++) {
            students2[i] = new Student(random.nextInt(1000), random.nextInt(100));
        }

        sorting.MergeSort(students2, 0, students2.length-1);
        sorting.MergeSort(students, 0, len-1);

        System.out.println("(Mergesort) Second array:");
        printArray(students2);

        Student[] studentUnion = new Student[students.length + students2.length];
        sorting.merge(students, students.length, students2, students2.length, studentUnion, 0);

        System.out.println("And then they are one:");
        printArray(studentUnion);
    }

    static void printArray(Student[] arr) {
        for (Student j : arr) System.out.println(j);
        System.out.println();
    }
}
