# Introduction
Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort. However, insertion sort has several advantages over these algorithms. It is simple to implement, requires very little additional memory, and is efficient on small lists or lists that are already partially sorted. The basic idea behind insertion sort is to iterate through the list, comparing each item with the items that come before it. If an item is smaller than the items before it, it is moved back until it reaches its correct position in the sorted portion of the list.

# Main Ideas
1. Insertion sort is a simple sorting algorithm that works by repeatedly inserting elements into a sorted sublist.

2. The algorithm starts with the first element of the list and considers it as a sorted sublist.

3. It then moves to the second element and compares it with the first element, swapping them if necessary to maintain the sorted order.

4. The algorithm continues this process for each subsequent element, inserting it into the correct position in the sorted sublist.

5. Insertion sort has a time complexity of O(n^2) in the worst case, making it less efficient than other sorting algorithms such as quicksort or mergesort.

6. However, insertion sort can be useful for small lists or partially sorted lists, where its simplicity and low overhead make it an effective choice.

7. Insertion sort can also be used as part of more complex algorithms, such as shell sort or bucket sort.

8. Overall, insertion sort is a basic but important algorithm that is widely used in computer science and programming.

### Sorted Portion 
The sorted portion of Insertion Sort is the leftmost part of the array, where all elements have been sorted in ascending order. Initially, the first element of the array is considered to be sorted. As the algorithm progresses, each subsequent element is compared with the elements in the sorted portion and inserted at its correct position to maintain the ascending order. At any point during the sorting process, all elements to the left of a particular index are guaranteed to be in sorted order.

### Unsorted Portion
The unsorted portion of insertion sort refers to the part of the array or list that has not yet been sorted. During each iteration of the algorithm, one element from the unsorted portion is selected and inserted into its correct position in the sorted portion of the array. As more elements are inserted into the sorted portion, the unsorted portion becomes smaller until all elements have been sorted. The unsorted portion is initially equal to the entire array or list and decreases in size with each iteration until it is completely sorted.

# Algorithm
Here's how insertion sort works:

1. Start with the second item in the list (the first item is already considered sorted).
2. Compare this item with the one before it.
3. If the previous item is larger, swap them.
4. Continue comparing and swapping until you reach an item that is not smaller than the previous one.
5. Move on to the next unsorted item and repeat steps 2-4 until all items are sorted.

Here's an example of how insertion sort works on a small list:

Suppose we have a list of integers: [5, 2, 4, 6, 1, 3]

Step 1: We start with the second element (2) and compare it with the first element (5). Since 2 is smaller than 5, we swap them. The list now becomes [2, 5, 4, 6, 1, 3].

Step 2: We move to the third element (4) and compare it with the second element (5). Since 4 is smaller than 5, we swap them. The list now becomes [2, 4, 5, 6, 1, 3].

Step 3: We move to the fourth element (6) and compare it with the third element (5). Since they are already in order, we don't need to do anything. The list remains [2, 4, 5, 6, 1, 3].

Step 4: We move to the fifth element (1) and compare it with the fourth element (6). Since it is smaller than the fourth element (6), we swap them. The list now becomes [2,4 ,5 ,1 ,6 ,3]. We then compare it with the third element (5), since it is also smaller than that one too we swap them again. The list now becomes [2 ,4 ,1 ,5 ,6 ,3]. Finally, we compare it with the second element (4) and swap them since 1 is smaller. The list now becomes [2 ,1 ,4 ,5 ,6 ,3].

Step 5: We move to the sixth element (3) and compare it with the fifth element (6). Since it is smaller, we swap them. The list now becomes [2 ,1 ,4 ,5 ,3 ,6]. We then compare it with the fourth element (5), since it is also smaller than that one too we swap them again. The list now becomes [2,1,4,3,5,6]. We then compare it with the third element (4), since it is also smaller than that one too we swap them again. The list now becomes [2,1,3,4,5,6]. Finally, we compare it with the second element (1) and swap them since 3 is greater. The final sorted list becomes [1,2,3,4,5,6].

Step 6: Since there are no more elements left to sort in the list we can stop here.

The final sorted list using insertion sort algorithm for this example would be [1,2,3,4,5,6].

# Example Code
## Example Method
```python
def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and key < arr[j]:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key
    return arr
```
## Example usage:
```python
arr = [3, 5, 2, 8, 4, 7]
sorted_arr = insertion_sort(arr)
print(sorted_arr) # Output: [2, 3, 4, 5, 7, 8]
```
# Conclusion 
While insertion sort is easy to implement, it is not very efficient for large datasets. This is because it has a time complexity of $O(n^{2})$, meaning that the time it takes to sort the data increases exponentially as the size of the dataset grows. As a result, insertion sort is often used for small datasets or as a sub-routine in more complex sorting algorithms.

One advantage of insertion sort, however, is that it sorts the data in place, meaning that it does not require any additional memory to be allocated. This can be useful in situations where memory usage is a concern. Such examples of situations where memory usage are a concern are embedded systems with limited memory, mobile devices with limited storage, and large datasets that cannot be loaded entirely into memory. In these cases, insertion sort can be a practical choice for sorting the data efficiently without consuming additional memory resources. Additionally, insertion sort has a relatively simple implementation and can perform well on small or nearly sorted datasets. Again,  it may not be the best choice for larger or more complex datasets where other sorting algorithms such as merge sort or quicksort may be more efficient.

Another advantage of insertion sort is that it is stable, meaning that it preserves the relative order of equal elements in the sorted output. This can be important in certain applications where maintaining the original order of equal elements is necessary. Such applications where maintaining the original order of equal elements is necessary are sorting a list of students by their last name or sorting a list of transactions by their timestamp. In these cases, insertion sort can be a better choice than other sorting algorithms that are not stable, such as quicksort or heapsort. Additionally, insertion sort has a low overhead and is efficient for small input sizes or partially sorted arrays. However, for large input sizes or completely unsorted arrays, other sorting algorithms such as merge sort or quicksort may be more efficient.

Overall, while insertion sort may not be the most efficient sorting algorithm for large datasets, its simplicity and stability make it a useful tool in certain situations.