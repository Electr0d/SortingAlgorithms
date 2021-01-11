# Sorting Algorithms
Sort a generated array of numbers by specifing the size of the array. The program will generate the array and sort it, then calculate how long each algorithm takes to sort. Type in `0` to automatically sort arrays starting from 2 to 524288 by doubling after each iteration.


# Installation
Note: make sure you have Java installed before proceeding in the installation.
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
## Specs
All the algorithms are tested on a PC with the following specifications:
- **Processor**:	Intel(R) Core(TM) i7-7500U CPU @ 2.70GHz, 2901 Mhz, 2 Core(s), 4 Logical Processor(s)
- **RAM**: 16 GB
- **OS**: Windows 10 Pro
  - **Version**: 20H2
  - **Build**: 19042.685
- **IDE**: Eclipse

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
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/int/pie_no_process_elapsed.png)
---

## Sorting Doubles with Minimal Background Processes
| Array Length | Selection | Insertion | Bubble | Exchange |
|:------------:|:---------:|:---------:|:------:|:--------:|
| 2            | 0         | 0         | 0      | 0        |
| 4            | 0         | 0         | 0      | 0        |
| 8            | 0         | 0         | 0      | 0        |
| 16           | 0         | 0         | 0      | 0        |
| 32           | 0         | 0         | 0      | 0        |
| 64           | 0         | 0         | 1      | 0        |
| 128          | 0         | 1         | 0      | 0        |
| 256          | 0         | 1         | 1      | 1        |
| 512          | 3         | 2         | 4      | 3        |
| 1024         | 2         | 3         | 2      | 0        |
| 2048         | 9         | 3         | 4      | 0        |
| 4096         | 5         | 2         | 17     | 3        |
| 8192         | 20        | 6         | 67     | 13       |
| 16384        | 78        | 27        | 266    | 49       |
| 32768        | 325       | 105       | 1068   | 180      |
| 65536        | 1392      | 461       | 4313   | 3102     |
| 131072       | 5283      | 1944      | 17376  | 12685    |
| 262144       | 21391     | 8601      | 70456  | 12685    |
| 524288       | 91607     | 35820     | 310780 | 58218    |

![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/double/no_process_elapsed.png)
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/double/pie_no_process_elapsed.png)
---

## Sorting Integers while CPU Under Load
| Array Length | Selection | Insertion | Bubble | Exchange |
|:------------:|:---------:|:---------:|:------:|:--------:|
| 2            | 0         | 0         | 0      | 0        |
| 4            | 0         | 0         | 0      | 0        |
| 8            | 0         | 0         | 0      | 0        |
| 16           | 0         | 0         | 0      | 0        |
| 32           | 0         | 0         | 0      | 0        |
| 64           | 0         | 0         | 0      | 0        |
| 128          | 0         | 0         | 1      | 0        |
| 256          | 2         | 1         | 1      | 1        |
| 512          | 1         | 1         | 3      | 2        |
| 1024         | 1         | 3         | 5      | 1        |
| 2048         | 11        | 3         | 4      | 1        |
| 4096         | 7         | 2         | 16     | 2        |
| 8192         | 35        | 8         | 62     | 7        |
| 16384        | 104       | 32        | 263    | 62       |
| 32768        | 464       | 106       | 1223   | 153      |
| 65536        | 7484      | 2349      | 13399  | 2260     |
| 131072       | 28063     | 7581      | 58918  | 10912    |
| 262144       | 97084     | 23872     | 235303 | 30213    |
| 524288       | 422453    | 96457     | 415175 | 187619   |

![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/int/process_elapsed.png)
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/int/pie_process_elapsed.png)

---

## Sorting Doubles while CPU Under Load
| Array Length | Selection | Insertion |  Bubble  | Exchange |
|:------------:|:---------:|:---------:|:--------:|:--------:|
| 2            | 0         | 0         | 0        | 0        |
| 4            | 0         | 0         | 0        | 0        |
| 8            | 0         | 0         | 0        | 0        |
| 16           | 0         | 0         | 0        | 0        |
| 32           | 0         | 0         | 0        | 0        |
| 64           | 0         | 0         | 1        | 0        |
| 128          | 0         | 0         | 1        | 1        |
| 256          | 1         | 1         | 3        | 1        |
| 512          | 4         | 5         | 7        | 3        |
| 1024         | 1         | 14        | 3        | 1        |
| 2048         | 4         | 10        | 10       | 75       |
| 4096         | 31        | 146       | 49       | 119      |
| 8192         | 337       | 143       | 717      | 85       |
| 16384        | 1425      | 418       | 2590     | 273      |
| 32768        | 2427      | 828       | 9909     | 1524     |
| 65536        | 11708     | 4622      | 33228    | 3151     |
| 131072       | 44979     | 17108     | 62650    | 15826    |
| 262144       | 84914     | 30416     | 22121    | 39985    |
| 524288       | 268898    | 176872    | 1202021  | 268788   |

![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/double/process_elapsed.png)
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/double/pie_process_elapsed.png)
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/bubble/elapsed.png)

---

## Integer Sorting Time w/ CPU Load – Integer Sorting Time
| Array Length | Selection | Insertion | Bubble | Exchange |
|:------------:|:---------:|:---------:|:------:|:--------:|
| 2            | 0         | 0         | 0      | 0        |
| 4            | 0         | 0         | 0      | 0        |
| 8            | 0         | 0         | 0      | 0        |
| 16           | 0         | 0         | 0      | 0        |
| 32           | 0         | 0         | 0      | 0        |
| 64           | 0         | 0         | 0      | 0        |
| 128          | -1        | 0         | 0      | 0        |
| 256          | 2         | 0         | -1     | 1        |
| 512          | -3        | -1        | -5     | -1       |
| 1024         | -7        | 0         | -8     | -5       |
| 2048         | -1        | -7        | -10    | -6       |
| 4096         | 9         | -14       | -9     | -8       |
| 8192         | -11       | -27       | -12    | -12      |
| 16384        | -83       | -118      | -75    | 0        |
| 32768        | -269      | -515      | 14     | -17      |
| 65536        | 4437      | 81        | 8929   | 1605     |
| 131072       | 16590     | -1326     | 39939  | 8351     |
| 262144       | 29870     | -15966    | 149688 | 19719    |
| 524288       | 235681    | -47669    | 81616  | 127528   |

![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/int/difference.png)
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/int/pie_difference.png)

---

## Double Sorting Time w/ CPU Load – Double Sorting Time
| Array Length | Selection | Insertion |  Bubble  | Exchange |
|:------------:|:---------:|:---------:|:--------:|:--------:|
| 2            | 0         | 0         | 0        | 0        |
| 4            | 0         | 0         | 0        | 0        |
| 8            | 0         | 0         | 0        | 0        |
| 16           | 0         | 0         | 0        | 0        |
| 32           | 0         | 0         | 0        | 0        |
| 64           | 0         | 0         | 0        | 0        |
| 128          | 0         | -1        | 1        | 1        |
| 256          | 1         | 0         | 2        | 0        |
| 512          | 1         | 3         | 3        | 0        |
| 1024         | -1        | 11        | 1        | 1        |
| 2048         | -5        | 7         | 6        | 75       |
| 4096         | 26        | 144       | 32       | 116      |
| 8192         | 317       | 137       | 650      | 72       |
| 16384        | 1347      | 391       | 2324     | 224      |
| 32768        | 2102      | 723       | 8841     | 1344     |
| 65536        | 10316     | 4161      | 28915    | 2355     |
| 131072       | 39696     | 15164     | 45274    | 12724    |
| 262144       | 63523     | 21815     | -48335   | 27300    |
| 524288       | 177291    | 141052    | 891241   | 210570   |

![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/double/difference.png)
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/double/pie_difference.png)

---

## Double - Integer Sorting Time Difference
| Array Length | Selection | Insertion | Bubble | Exchange |
|:------------:|:---------:|:---------:|:------:|:--------:|
| 2            | 0         | 0         | 0      | 0        |
| 4            | 0         | 0         | 0      | 0        |
| 8            | 0         | 0         | 0      | 0        |
| 16           | 0         | 0         | 0      | 0        |
| 32           | 0         | 0         | 0      | 0        |
| 64           | 0         | 0         | 1      | 0        |
| 128          | -1        | 1         | -1     | 0        |
| 256          | 0         | 0         | -1     | 1        |
| 512          | -3        | 0         | -4     | 0        |
| 1024         | -6        | 0         | -11    | -6       |
| 2048         | -3        | -7        | -10    | -7       |
| 4096         | -11       | -14       | -8     | -7       |
| 8192         | -11       | -29       | -7     | -6       |
| 16384        | -109      | -123      | -72    | -13      |
| 32768        | -408      | -516      | -141   | 10       |
| 65536        | -1655     | -1807     | -157   | 141      |
| 131072       | -6190     | -6963     | -1603  | 541      |
| 262144       | -45823    | -31237    | -15159 | 2191     |
| 524288       | -95165    | -108306   | -22779 | -1873    |

![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/no_process_difference.png)

---

## Double - Integer w/ CPU Load Sorting Time Difference
| Array Length | Selection | Insertion |  Bubble  | Exchange |
|:------------:|:---------:|:---------:|:--------:|:--------:|
| 2            | 0         | 0         | 0        | 0        |
| 4            | 0         | 0         | 0        | 0        |
| 8            | 0         | 0         | 0        | 0        |
| 16           | 0         | 0         | 0        | 0        |
| 32           | 0         | 0         | 0        | 0        |
| 64           | 0         | 0         | 1        | 0        |
| 128          | 0         | 0         | 0        | 1        |
| 256          | -1        | 0         | 2        | 0        |
| 512          | 3         | 4         | 4        | 1        |
| 1024         | 0         | 11        | -2       | 0        |
| 2048         | -7        | 7         | 6        | 74       |
| 4096         | 24        | 144       | 33       | 117      |
| 8192         | 302       | 135       | 655      | 78       |
| 16384        | 1321      | 386       | 2327     | 211      |
| 32768        | 1963      | 722       | 8686     | 1371     |
| 65536        | 4224      | 2273      | 19829    | 891      |
| 131072       | 16916     | 9527      | 3732     | 4914     |
| 262144       | -12170    | 6544      | -213182  | 9772     |
| 524288       | -153555   | 80415     | 786846   | 81169    |

![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/process_difference.png)

---

## Sorting Arrays in 5 Minutes
|       Prseset       | Selection | Insertion |  Bubble  | Exchange |
|:-------------------:|:---------:|:---------:|:--------:|:--------:|
| Integer             | 325645    | 249660    | 476625   | 561580   |
| Double              | 158875    | 4404019   | 503316   | 705326   |
| Integer w/ CPU Load | 374491    | 630535    | 374491   | 838860   |
| Double w/ CPU Load  | 587202    | 891289    | 131172   | 587202   |

![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/timed/pie_no_process_int.png)
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/timed/pie_no_process_double.png)
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/timed/pie_process_int.png)
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/timed/pie_process_double.png)



# FAQ
1. Which sort seems to be the best “overall” for most purposes? Explain.

The overall best sorting algorithm is “Insertion Sort”. The reason why, is because unlike other sorting algorithms. Insertion Sort passes through the array once.
Insertion sort splits up the array into 2.The 1st sub-array is sorted and the other sub-array contains the unsorted numbers. The 1st sub-array is gradually filled up as the algorithm goes through the 2nd sub-array.



2. Which sort appears to be the least efficient? Explain. Why do you think this sort is taught?

Bubble Sort seems to be the least efficient sorting algorithm. This algorithm is taught because of its simple nature, unlike more complex sorting algorithms such as, insertion sort. Bubble sort swaps two integers that are out of order, so if a big number is in the first number, it gradually moves up the array in each loop. Unlike Insertion sort where it is put in its definitive position. The diagram below explains how Insertion sort works in comparison to Bubble sort.

| Pass | arr[0] | arr[1] | arr[2] | arr[3] | arr[4] | arr[5] | arr[6] | arr[7] | arr[8] |
|:----:|:------:|:------:|:------:|:------:|:------:|:------:|:------:|:------:|:------:|
| 0    | 9      | 7      | 8      | 2      | 4      | 1      | 3      | 5      | 6      |
| 1    | 7      | 8      | 2      | 4      | 1      | 3      | 5      | 6      | 9      |
| 2    | 7      | 2      | 4      | 1      | 3      | 5      | 6      | 8      | 9      |
| 3    | 2      | 4      | 1      | 3      | 5      | 6      | 7      | 8      | 9      |
| 4    | 2      | 1      | 3      | 4      | 5      | 6      | 7      | 8      | 9      |
| 5    | 1      | 2      | 3      | 4      | 5      | 6      | 7      | 8      | 9      |

As shown above. High numbers move to the end of the array just like how bubbles move up, hence why it is called “Bubble Sort”.



3. Under some circumstances, insertion sort can be the most efficient (in time). What would be one of the circumstances? Explain.

When sorting large amounts of doubles. The reason why is because insertion sort puts the number in its definitive position unlike bubble sort where it gradually goes in the proper order.

The table below shows how Insertion sort performs against other sorting algorithms when sorting Doubles with minimal background processes.

| Array Length | Selection | Insertion | Bubble | Exchange |
|:------------:|:---------:|:---------:|:------:|:--------:|
| 2            | 0         | 0         | 0      | 0        |
| 4            | 0         | 0         | 0      | 0        |
| 8            | 0         | 0         | 0      | 0        |
| 16           | 0         | 0         | 0      | 0        |
| 32           | 0         | 0         | 0      | 0        |
| 64           | 0         | 0         | 1      | 0        |
| 128          | 0         | 1         | 0      | 0        |
| 256          | 0         | 1         | 1      | 1        |
| 512          | 3         | 2         | 4      | 3        |
| 1024         | 2         | 3         | 2      | 0        |
| 2048         | 9         | 3         | 4      | 0        |
| 4096         | 5         | 2         | 17     | 3        |
| 8192         | 20        | 6         | 67     | 13       |
| 16384        | 78        | 27        | 266    | 49       |
| 32768        | 325       | 105       | 1068   | 180      |
| 65536        | 1392      | 461       | 4313   | 3102     |
| 131072       | 5283      | 1944      | 17376  | 12685    |
| 262144       | 21391     | 8601      | 70456  | 12685    |
| 524288       | 91607     | 35820     | 310780 | 58218    |



4. List all the factors you can think of that might affect the time required to sort a file.

The factors that might affect the time required to sort a file/array are:
- CPU Power
  - Cores
  - Threads
  - Cache size
  - Clock Speed
- RAM speed
-	File/array size
-	Background and foreground processes
-	Programming language
-	Algorithm efficiency
-	Data type (integer or double)
-	PC cooling (throttling while sorting can increase sorting times).
-	Power saving settings on laptops might lock the CPU under a certain clock speed, effecting sorting times



5. 	Suppose you have two data files with the same kind of data but one file is exactly twice as large as the second (twice as much data). Initially, how do you think the sort times should compare between these files? 

Sorting times differ between each algorithm. Although, generally speaking sorting times grow exponentially as the file size doubles.



6. Test #5 above: Double the size of the array and repeat the test. How did the sort times change? Explain. Can you explain this “discrepancy”?

![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/int/no_process_elapsed_full.png)

Sorting times grew exponentially as predicted. The reason why the sorting times double as the file size double is because sorting algorithms have to do more operations to move a number to its proper position, then more numbers around it to their proper position. Doubling the array size means more numbers around it need to gradually move into their position which takes a toll on sorting time and does not necessarily mean doubling the sorting time or passes.



7. Run many YouTube (or other) videos in the background. Load a few other apps. Play some music (with the volume off or with headphones), run some other programs or do some video / picture editing. Try to make the CPU work to slow down your computer. Run your sorting algorithms again and see what effect the background applications had on the sort time. Record the time difference (the increase in amount of times the sorts took).

![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/int/difference.png)
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/int/pie_difference.png)
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/double/difference.png)
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/double/pie_difference.png)

8. Change the data type of the numbers from integer to double. How much did this affect the sort times?

Sorting times increased when sorting doubles. The trend can be visualized below:
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/double/no_process_elapsed.png)
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/elapsed.png)
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/difference_bubble.png)
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/no_process_difference.png)
![](https://github.com/Electr0d/SortingAlgorithms/blob/master/docs/graphs/process_difference.png)
As shown above double sorting time is sometimes shorter and sometimes longer than double sorting time. Generally speaking, sorting times are longer, though. The likely cause is that Integers are easier to compare due to the lack of decimal points.