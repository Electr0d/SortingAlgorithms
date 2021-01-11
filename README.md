# Sorting Algorithms
Sort a generated array of numbers by specifing the size of the array. The program will generate the array and sort it, then calculate how long each algorithm takes to sort. Type in `0` to automatically sort arrays starting from 2 to 524288 by doubling after each iteration.


# Installation
```
git clone https://www.github.com/Electr0d/SortingAlgorithms
javac -d bin src/*.java
cd bin
java main
```

# Algorithms

## Selection Sort
### Explanation
Selection sort is made of searching and sorting. In each pass, the unsorted value with the smallest/largest value is moved to its proper position in the array.

### Example
| Pass | arr[0] | arr[1] | arr[2] | arr[3] | arr[4] | arr[5] |
|:----:|:------:|:------:|:------:|:------:|:------:|:------:|
| 0    | 5      | 6      | 4      | 2      | 1      | 3      |
| 1    | 1      | 6      | 4      | 2      | 5      | 3      |
| 2    | 1      | 2      | 4      | 6      | 5      | 3      |
| 3    | 1      | 2      | 3      | 6      | 5      | 4      |
| 4    | 1      | 2      | 3      | 4      | 5      | 6      |
| 5    | 1      | 2      | 3      | 4      | 5      | 6      |

### Code
```java
public int[] selection (int [] numbers) {
  int first, temp;
  for (int i = 0; i < numbers.length; i++) {
    first = 0;   //initialize to subscript of first element

    // locate smallest element between positions 1 and i.
    for(int j = 1; j <= i; j ++) {
      // switch to "<" for descending order   
      if(numbers[j] > numbers[first]) first = j;
    }
    temp = numbers[first]; //swap smallest found with element in position i.
    numbers[first] = numbers[i];
    numbers[i] = temp;
  }
  return numbers;
}
```



---
## Insertion Sort
### Explanation
Unlike other sorting algorithms, insertion Sort passes through the array once. Insertion sort splits up the array into 2.The 1st sub-array is sorted and the other sub-array contains the unsorted numbers. The 1st sub-array is gradually filled up as the algorithm goes through the 2nd sub-array.

### Code
```java
public void insertion(int [] numbers) {
  int j, i;
  int key;

  // Start with 1 (not 0)
  for (j = 1; j < numbers.length; j++) {
      key = numbers[j];
      for(i = j - 1; (i >= 0) && (numbers[i] < key); i--) {
      // Smaller values are moving up
        numbers[i + 1] = numbers[i];
    }
    numbers[i + 1] = key;    // Put the key in its proper location
  }
}
```



---
## Bubble Sort
### Explanation
Bubble sort swaps two integers that are out of order, so if a big number is in the first number, it gradually moves up the array in each loop. Hence why it's called "Bubble Sort".

### Example
| Pass | arr[0] | arr[1] | arr[2] | arr[3] | arr[4] | arr[5] | arr[6] | arr[7] | arr[8] |
|:----:|:------:|:------:|:------:|:------:|:------:|:------:|:------:|:------:|:------:|
| 0    | 9      | 7      | 8      | 2      | 4      | 1      | 3      | 5      | 6      |
| 1    | 7      | 8      | 2      | 4      | 1      | 3      | 5      | 6      | 9      |
| 2    | 7      | 2      | 4      | 1      | 3      | 5      | 6      | 8      | 9      |
| 3    | 2      | 4      | 1      | 3      | 5      | 6      | 7      | 8      | 9      |
| 4    | 2      | 1      | 3      | 4      | 5      | 6      | 7      | 8      | 9      |
| 5    | 1      | 2      | 3      | 4      | 5      | 6      | 7      | 8      | 9      |

### Code
```java
public void bubble(int[] numbers) {
  int i, temp;
  boolean flag = true;   // set flag to true to begin first pass

  while (flag) {
    flag = false;    //set flag to false awaiting a possible swap
    for(i = 0; i < numbers.length -1; i++)
    {
      // change to > for ascending sort
      if(numbers[i] > numbers[i + 1]) {
        temp = numbers[i];                //swap elements
        numbers[i] = numbers[i + 1];
        numbers[i + 1] = temp;
        flag = true;              //shows a swap occurred 
      }
    }
  }
}
```




---
## Exchange Sort
### Explanation
The exchange sort is similar to Bubble sort. The difference is in the way they compare the elements.
Exchange sort compares the first element with all the following elements, making any necessary swaps.

### Example
| Pass | arr[0] | arr[1] | arr[2] | arr[3] | arr[4] | arr[5] |
|:----:|:------:|:------:|:------:|:------:|:------:|:------:|
| 0    | 5      | 6      | 4      | 2      | 1      | 3      |
| 1    | 5      | 4      | 3      | 2      | 1      | 6      |
| 2    | 4      | 3      | 2      | 1      | 5      | 6      |
| 3    | 3      | 2      | 1      | 4      | 5      | 6      |
| 4    | 2      | 1      | 3      | 4      | 5      | 6      |
| 5    | 1      | 2      | 3      | 4      | 5      | 6      |


### Code
```java
public void exchange (int[] numbers) {
  int temp;  //be sure that the temp variable is the same "type" as the array
  for (int i = 0; i < numbers.length - 1; i++)  {
    for (int j = i + 1; j < numbers.length; j++) {
      if(numbers[i] > numbers[j])         //sorting into descending order
      {
        temp = numbers[i];   //swapping
        numbers[i] = numbers[j];
        numbers[j] = temp; 
      }           
    }
  }
}	
```

# Observations

## Sorting Integers with Minimal Background Processes
| Array Length | Selection | Insertion | Bubble | Exchange |
|:------------:|:---------:|:---------:|:------:|:--------:|
| 2            | 0         | 0         | 0      | 0        |
| 4            | 0         | 0         | 0      | 0        |
| 8            | 0         | 0         | 0      | 0        |
| 16           | 0         | 0         | 0      | 0        |
| 32           | 0         | 0         | 0      | 0        |
| 64           | 0         | 0         | 0      | 0        |
| 128          | 1         | 0         | 1      | 0        |
| 256          | 0         | 1         | 2      | 0        |
| 512          | 4         | 2         | 8      | 3        |
| 1024         | 8         | 3         | 13     | 6        |
| 2048         | 12        | 10        | 14     | 7        |
| 4096         | 16        | 16        | 25     | 10       |
| 8192         | 46        | 35        | 74     | 19       |
| 16384        | 187       | 150       | 338    | 62       |
| 32768        | 733       | 621       | 1209   | 170      |
| 65536        | 3047      | 2268      | 4470   | 655      |
| 131072       | 11473     | 8907      | 18979  | 2561     |
| 262144       | 67214     | 39838     | 85615  | 10494    |
| 524288       | 186772    | 144126    | 333559 | 60091    |

![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/int/no_process_elapsed.png)