public class Sort {


    public void insertionSort(Student[] students){
        Student key;
        int j;

        for(int i = 1; i < students.length; i++){
            key = students[i];
            j = i;
            while ((j > 0) && (key.getiDNumbers() < students[j-1].getiDNumbers())){
                students[j] = students[j-1];
                j--;
            }
            students[j] = key;
        }
    }

    //Quicksort >>по убыванию<<
    private static int partition(Student[] students, int low, int high, SortingStudentsByGPA sort) {
        Student pivot = students[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (sort.compare(students[j], pivot) > 0) {
                i++;

                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }

        Student temp = students[i + 1];
        students[i + 1] = students[high];
        students[high] = temp;

        return i + 1;
    }

    public void quickSort(Student[] students, int low, int high, SortingStudentsByGPA sort) {
        if (low < high) {
            int index = partition(students, low, high, sort);

            quickSort(students, low, index - 1, sort);
            quickSort(students, index + 1, high, sort);
        }
    }


    //MergeSort
    // Разделение массива на подмассивы
    public void MergeSort(Student[] students, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            MergeSort(students, l, m);
            MergeSort(students, m + 1, r);
            split(students, l, m, r);
        }
    }

    // Слияние 2х массивов в 1 упорядоченный
    public void split(Student[] students, int l, int m, int r) {
        // Определение длин подмассивов
        int n1 = m - l + 1;
        int n2 = r - m;

        // Создание подмассивов
        Student[] L = new Student[n1];
        Student[] R = new Student[n2];

        // Перенос данных в подмассивы
        System.arraycopy(students, l, L, 0, n1);
        System.arraycopy(students, m + 1, R, 0, n2);
        merge(L, n1, R, n2, students, l);
    }


    public void merge(Student[] L, int n1, Student[] R, int n2, Student[] students, int l) {
        // Индексы подмассивов
        int i = 0, j = 0;

        // Индекс результирующего массива
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getiDNumbers() <= R[j].getiDNumbers()) {
                students[k] = L[i];
                i++;
            }
            else {
                students[k] = R[j];
                j++;
            }
            k++;
        }

        // Дописываются оставшиеся элементы первого подмассива
        while (i < n1) {
            students[k] = L[i];
            i++;
            k++;
        }

        // Дописываются оставшиеся элементы второго подмассива
        while (j < n2) {
            students[k] = R[j];
            j++;
            k++;
        }
    }
}