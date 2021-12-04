Few important moments about my benchmark:

* add method makes an addition to the `end` of the collection
* get method gets `each` element of the collection
* remove method removes from the `end` of the collection

Please note that this affects the obtained results (due to the specificity of the data structure). 

Example of output:

| Called method | Number of calls    | ArrayList| LinkedList|
|:-------------:|:------------------:|:--------:|:---------:|
|    Add        | 1000               | 0,25 ms  | 0,44 ms   |
|    Get        | 1000               | 0,22 ms  | 1,00 ms   |
| Remove        | 1000               | 0,26 ms  | 0,36 ms   |
|               |                    |          |           |
|            Add|           5000     |   0,47 ms|    0,54 ms|
|            Get|           5000     |   0,32 ms|   11,78 ms|
|         Remove|           5000     |   0,39 ms|    0,49 ms|
|               |                    |          |           |
|            Add|         100000     |   2,06 ms|    3,68 ms|
|            Get|         100000     |   5,22 ms| 3021,87 ms|
|         Remove|         100000     |   3,23 ms|    5,86 ms|
