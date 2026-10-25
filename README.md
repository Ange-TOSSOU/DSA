# Data Structures and Algorithms

I created this repository to store all my implementations for this tutorial. Feel free to take a look and give me your feedback.

## Static and Dynamic Arrays
### Time Complexity
|           | Static Array | Dynamic Array |
| :----:    | :----:       | :----:        |
| Access    | `O(1)`       | `O(1)`        |
| Search    | `O(n)`       | `O(n)`        |
| Insertion | N/A          | `O(n)`        |
| Appending | N/A          | `O(1)`        |
| Deletion  | N/A          | `O(n)`        |
### Dynamic Array Implementation
- [Source code][dynamic_array_main]
- [Test code][dynamic_array_test]

## Singly and Doubly Linked Lists
### Pros and Cons
|               | Pros | Cons |
| :----:        | :----:       | :----:        |
| Singly Linked | Uses less memory<br>Simpler implementation | Cannot easily access<br>previous elements |
| Doubly Linked | Can be traversed<br>backwards | Takes 2x memory |
### Time Complexity
|                     | Singly Linked | Doubly Linked |
| :----:              | :----:        | :----:        |
| Search              | `O(n)`        | `O(n)`        |
| Insert at<br>head   | `O(1)`        | `O(1)`        |
| Insert at<br>tail   | `O(1)`        | `O(1)`        |
| Insert in<br>middle | `O(n)`        | `O(n)`        |
| Remove at<br>head   | `O(1)`        | `O(1)`        |
| Remove at<br>tail   | `O(n)`        | `O(1)`        |
| Remove in<br>middle | `O(n)`        | `O(n)`        |
### Linked Lists Implementation
- [Sources code][linked_list_main]
- [Tests code][linked_list_test]

## Stack
### Time Complexity

<table style="border-collapse: collapse; text-align: center; border: 1px solid black;">
    <tr>
        <td style="border: 1px solid black; padding: 5px">Pushing</td>
        <td style="border: 1px solid black; padding: 5px"><code>O(1)</code></td>
    </tr>
    <tr>
        <td style="border: 1px solid black; padding: 5px">Popping</td>
        <td style="border: 1px solid black; padding: 5px"><code>O(1)</code></td>
    </tr>
    <tr>
        <td style="border: 1px solid black; padding: 5px">Searching</td>
        <td style="border: 1px solid black; padding: 5px"><code>O(n)</code></td>
    </tr>
</table>

### Stack Implementation
- [Source code][stack_main]
- [Test code][stack_test]

## Queues
### Time Complexity

<table style="border-collapse: collapse; text-align: center; border: 1px solid black;">
    <tr>
        <td style="border: 1px solid black; padding: 5px">Enqueue</td>
        <td style="border: 1px solid black; padding: 5px"><code>O(1)</code></td>
    </tr>
    <tr>
        <td style="border: 1px solid black; padding: 5px">Dequeue</td>
        <td style="border: 1px solid black; padding: 5px"><code>O(1)</code></td>
    </tr>
    <tr>
        <td style="border: 1px solid black; padding: 5px">Searching</td>
        <td style="border: 1px solid black; padding: 5px"><code>O(n)</code></td>
    </tr>
</table>

### Queue Implementation
- [Source code][queue_main]
- [Test code][queue_test]

## Resources

- [Data Structures Easy to Advanced Course - Full Tutorial from a Google Engineer][dsa_material_by_william_fiset]


[dsa_material_by_william_fiset]: https://www.youtube.com/watch?v=RBSGKlAvoiM

[dynamic_array_main]: ./java/src/main/java/Arrays/
[dynamic_array_test]: ./java/src/test/java/Arrays/

[linked_list_main]: ./java/src/main/java/LinkedLists/
[linked_list_test]: ./java/src/test/java/LinkedLists/

[stack_main]: ./java/src/main/java/Stack/
[stack_test]: ./java/src/test/java/Stack/

[queue_main]: ./java/src/main/java/Queue/
[queue_test]: ./java/src/test/java/Queue/
