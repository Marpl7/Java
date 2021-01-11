import java.util.*;

class Pet {
      String name;
      String type;
      int age;

      public Pet(String name, String type, int age){
        this.name = name;
        this.type = type;
        this.age = age;
      }

      public void print(){
        System.out.println(this.name +", " + this.type + ", " + this.age);
      }
    }


class Main {
  public static void main(String[] args) {

    long startTime;
    long operationTime;

    // реализация бейсик стека 
    startTime = System.nanoTime();
    Stack<Pet> stackPet = new Stack<>();

    stackPet.push(new Pet("Tuzik", "dog", 3)); //вставка
    stackPet.push(new Pet("Murka", "cat", 5));
    stackPet.push(new Pet("Nemo", "fish", 1));

    stackPet.peek().print(); //просмотр
    
    while(!stackPet.empty()){
      stackPet.pop().print();

    }

    operationTime = System.nanoTime() - startTime;
    System.out.println("Реализация простого стека " + operationTime);

    //реализация простой очереди 

    startTime = System.nanoTime();  

    Queue<Pet> queuePet = new LinkedList<>();

    queuePet.add(new Pet("Tuzik", "dog", 3));
    queuePet.add(new Pet("Murka", "cat", 5));
    queuePet.add(new Pet("Nemo", "fish", 1));

    queuePet.peek(); // просмотр
    queuePet.offer(new Pet("Zorka", "cow", 2)); //вставка

    while(!queuePet.isEmpty()){
      queuePet.poll().print(); //удаление
    }
    operationTime = System.nanoTime() - startTime;
    System.out.println("Реализация простой очереди " + operationTime + "\n");

    //реализация дека
    startTime = System.nanoTime(); 

    Deque<Pet> dequePet = new ArrayDeque<>();

    dequePet.add(new Pet("Tuzik", "dog", 3));
    dequePet.add(new Pet("Murka", "cat", 5));
    dequePet.add(new Pet("Nemo", "fish", 1));

    dequePet.add(new Pet("Barbos", "dog", 10));
    dequePet.addFirst(new Pet("Zorka", "cow", 2));
    dequePet.addLast(new Pet("Nochka", "cow", 1));
    dequePet.peekFirst().print();
    dequePet.peekLast().print();
    dequePet.pollFirst().print();
    dequePet.pollLast().print();


    while (!dequePet.isEmpty()) {
      dequePet.poll().print();
    }

   

    operationTime = System.nanoTime() - startTime;
    System.out.println("Реализация простого дека " + operationTime + "\n");


    //реализация приоритетной очереди
    startTime = System.nanoTime(); 

    PriorityQueue<Integer> priorityQ = new PriorityQueue<>();

    priorityQ.add(10);
    priorityQ.add(2);
    priorityQ.add(5);
    priorityQ.add(7);
    priorityQ.offer(1);

    while(!priorityQ.isEmpty()){
      System.out.println(priorityQ.poll());
    }

    

   

    operationTime = System.nanoTime() - startTime;
    System.out.println("Реализация приоритетной очереди " + operationTime + "\n");


  //реализация стека на основе связанного списка
  startTime = System.nanoTime(); 

  MyStack myStack = new MyStack();

  myStack.push(new Pet("Tuzik", "dog", 3));
  myStack.push(new Pet("Murzik", "cat", 2));
  myStack.push(new Pet("Flaber", "fish", 1));
  myStack.display();
  while(!myStack.isEmpty()){
    System.out.print("Удален - "); 
    myStack.pop().print();
      
    
  }

  operationTime = System.nanoTime() - startTime;
  System.out.println("Реализация стека на базе связанного списка " + operationTime + "\n");

  //реализация очереди на основе связанного списка
  startTime = System.nanoTime(); 

  MyQueue myQueue = new MyQueue();

  myQueue.push(new Pet("Tuzik", "dog", 3));
  myQueue.push(new Pet("Murzik", "cat", 2));
  myQueue.push(new Pet("Flaber", "fish", 1));
  myQueue.display();
  while(!myQueue.isEmpty()){
    System.out.print("Удален - "); 
    myQueue.pop().print();
      
    
  }

  operationTime = System.nanoTime() - startTime;
  System.out.println("Реализация очереди на базе связанного списка " + operationTime);

    


  }
}


 // Реализация односвязного списка и его базовых методов

    class Node {
      public Pet data;
	    public Node next;
 
	     public Node(Pet data) {    
            this.data = data;    
            this.next = null;    
        } 

      public void display(){this.data.print();} 
	

    }

    class SinglLinkedList{
      public Node head = null;
      public Node tail = null;    

      public boolean isEmpty(){return (head == null);}

      // вставить в начало списка

      public void addFirst(Pet data) {
        
		    Node newNode = new Node(data);
		
		    if (isEmpty()) {
				  head = newNode;
		    } else {
				  newNode.next = head;
  			  head = newNode;
		    }
	    }

      // вставить в конец списка

      public void addLast(Pet data) {
        
		    Node newNode = new Node(data);
		
		    if (isEmpty()) {
				  head = newNode;
          tail = head;
		    } else {
				  tail.next = newNode;
  			  tail = newNode; 
		    }
         
	    }

      // удалить с начала списка

       public Node deleteFirst() {
        Node temp;				
		    if (isEmpty()) {
          System.out.println("Список пуст!");
          return null;
		    } else {
          temp = head;
				  head = head.next;
          return temp;
		    }
        
        
	    }

      // показать элементы списка

       public void display() {
        			
		    if (isEmpty()) {
          System.out.println("Список пуст!");
		    } else {
          Node current = head;
          while(current != null){
            current.data.print();
            current = current.next;
          }
				  
		    }
	    }

      
    }

    class MyStack {
      private SinglLinkedList list;

      public MyStack() {list = new SinglLinkedList();}
      public void push(Pet data) {list.addFirst(data);}
      public Pet pop() {return list.deleteFirst().data;}
      public void display() {list.display();}
      public boolean isEmpty(){return list.isEmpty();}


    }


 class MyQueue {
      private SinglLinkedList queue;

      public MyQueue() {queue = new SinglLinkedList();}
      public void push(Pet data) {queue.addLast(data);}
      public Pet pop() {return queue.deleteFirst().data;}
      public void display() {queue.display();}
      public boolean isEmpty(){return queue.isEmpty();}


    }


