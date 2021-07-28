#Binary search trees

##Introduction
Binary Search Tree is a data structure for rapid access to stored data. 

Binary Search Tree is used in many search applications where data is constantly entering/leaving, such as the map and set objects in many languages' libraries.


##Applications
**Binary Space Partition** - Used in almost every 3D video game to determine what objects need to be rendered.

**Hash Trees** - used in p2p programs and specialized image-signatures in which a hash needs to be verified, but the whole file is not available.

**Heaps** - Used in implementing efficient priority-queues, which in turn are used for scheduling processes in many operating systems, Quality-of-Service in routers, and A* (path-finding algorithm used in AI applications, including robotics and video games). Also used in heap-sort.

**Huffman Coding Tree (Chip Uni)** - used in compression algorithms, such as those used by the .jpeg and .mp3 file-formats.

**GGM Trees** - Used in cryptographic applications to generate a tree of pseudo-random numbers.

**Syntax Tree** - Constructed by compilers and (implicitly) calculators to parse expressions.

**Treap** - Randomized data structure used in wireless networking and memory allocation.

**T-tree** - Though most databases use some form of B-tree to store data on the drive, databases which keep all (most) their data in memory often use T-trees to do so.

##Why BST has many Applications
Because is an ordered data structure with dependencies father-children, with many uses, for example
you can create a syntax tree for arithmetic operations, where the root nodes can be the operators and the
leaves nodes can be the operands.   
On the other hand, in Binary Space Partition the space can be divided in two parts recursively to allow determine which specific spaces 
needs to be used for some operation without to use all spaces. 
The key is the parent-children dependencies and its order, for example is used for compiler where is possible to specify 
the precedence and associative of syntax code using binary trees.

###BST vs hastable
A BST is used instead of a hashtable when is important to save ordered elements for its rapid access.

###BST vs AVL TREE
BST is used when the insertions are more relevant than the queries, but if the queries are more important than the insertions
is recommendable to use a AVL tree because its search complexity will be O( log(N) )

### O (n) of the operations on a binary tree.
This happens in BST when you inserts an ordered ascendant list and you want to get the maximum element. This is not common!, 
if you always inserts ordered ascendant elements is better to use another data structure like LinkedList or ArrayList. 


###Sources: 
https://stackoverflow.com/questions/2130416/what-are-the-applications-of-binary-trees
http://www.ijritcc.org/download/browse/Volume_3_Issues/November_15_Volume_3_Issue_11/1448604438_27-11-2015.pdf
