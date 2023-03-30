# Introduction 
The Bubble Sort algorithmis a simple sorting algorithm that repeatedly steps through the list to be sorted, compares each pair of adjacent items and swaps them if they are in the wrong order. The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted. The algorithm gets its name from the way smaller elements "bubble" to the top of the list as it is being sorted. It is not an efficient algorithm for large lists, but it is easy to understand and implement.

# Algorithm
Here's how Bubble Sort works:

1. Start at the beginning of the list.
2. Compare the first two elements. If the first element is greater than the second element, swap them.
3. Move to the next pair of elements (second and third) and compare them.
4. Continue this process until you reach the end of the list.
5. Repeat steps 1-4 until no more swaps are needed.

Here's an example of Bubble Sort in action:Suppose we have an array of integers: [5, 2, 9, 1, 5]

First pass:
- Compare the first two elements (5 and 2), swap them because 2 is smaller than 5.
- Compare the second and third elements (5 and 9), do not swap because they are already in order.
- Compare the third and fourth elements (9 and 1), swap them because 1 is smaller than 9.
- Compare the fourth and fifth elements (9 and 5), swap them because 5 is smaller than 9.

The array now looks like this: [2, 5, 1, 5, 9]

Second pass:
- Compare the first two elements (2 and 5), do not swap because they are already in order.
- Compare the second and third elements (5 and 1), swap them because 1 is smaller than 5.
- Compare the third and fourth elements (5 and 5), do not swap because they are already in order.

The array now looks like this: [2,1,5,5,9]

Third pass:
- Compare the first two elements (2 and 1), swap them because 1 is smaller than
2.

The array now looks like this: [1,2,5,5,9]

The array is now sorted.

# Example Code
Here is an example implementation of the bubble sort algorithm in Python:

```python
def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        # Last i elements are already sorted
        for j in range(0, n-i-1):
            # Swap if the element found is greater than the next element
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
    return arr
```

This function takes an array `arr` as input and sorts it using the bubble sort algorithm. The outer loop iterates over each element of the array, while the inner loop compares adjacent elements and swaps them if they are out of order. This process is repeated until no more swaps are needed, indicating that the array is fully sorted.

Here's an example usage of this function:

```python
arr = [64, 34, 25, 12, 22, 11, 90]
sorted_arr = bubble_sort(arr)
print(sorted_arr) # Output: [11, 12, 22, 25, 34, 64, 90]
```

In this example, we start with an unsorted array `arr` and pass it to `bubble_sort()`. The function returns a sorted version of the array which we store in `sorted_arr`. Finally we print out `sorted_arr` to verify that it has been correctly sorted. 

# Conclusion 
Whis a simple sorting algorithm, it is not the most efficient. It works by repeatedly swapping adjacent elements if they are in the wrong order. The algorithm continues until no more swaps are needed, indicating that the list is sorted. While bubble sort is easy to understand and implement, it has a time complexity of $O(n^{2})$, which means that it becomes very slow for large lists of data. Therefore, other sorting algorithms such as quicksort or mergesort are often preferred for larger datasets where efficiency is important.ile bubble sort 
