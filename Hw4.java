class Main {
  public static void main(String[] args) {
    
    Employee persArray[] = new Employee[5];

    persArray[0] = new Employee(IdGenerator.newId(), "Жданов Геннадий Петрович", "дтректор", "0345682", 100000, 55);
    persArray[1] = new Employee(IdGenerator.newId(), "Васильев Аристарх Семенович", "продавец", "04373744", 50000, 30);
    persArray[2] = new Employee(IdGenerator.newId(), "Зосимова Елена Петровна", "кассир", "24279947", 60000, 55);
    persArray[3] = new Employee(IdGenerator.newId(), "Калинина Алина Валерьевна", "менеджер", "0244965", 70000, 25);
    persArray[4] = new Employee(IdGenerator.newId(), "Кашин Алексей Сергеевич", "слесарь", "09565734", 40000, 45);

    for (int i = 0; i < 5; i++){
      if (persArray[i].getAge() > 45){
        persArray[i].printNamePosition();
      }
    }
    System.out.println();
    for (int i = 0; i < 5; i++){
        persArray[i].incrSalary();
        System.out.println(persArray[i].getId() + " " + persArray[i].getName() + "; возраст - " + persArray[i].getAge() + "; зарплата - " + persArray[i].getSalary());
        
      
    }

  }
}


public class IdGenerator {
  private static int id = 0;

  public static int newId(){
        return ++id;
    }
}


public class Employee{
  int id = 0;
  private String name;
  private String position;
  private String phone;
  private int age;
  private int salary;

  Employee(int id, String name, String position, String phone, int salary, int age){
    this.id = id;
    this.name = name;
    this.position = position;
    this.phone = phone;
    this.salary = salary;
    this.age = age;
  }

  public int getId(){
    return id;
  }

  public String getName(){
    return name;
  }

  public String getPosition(){
    return position;
  }

  public String getPhone(){
    return phone;
  }

  public int getSalary(){
    return salary;
  }

  public int getAge(){
    return age;
  }

  public void printNamePosition(){
    System.out.println(getName() + " - " + getPosition() );
  }

  public void setSalary(int salary){
    this.salary = salary;
  }

  public void incrSalary(){
    if (getAge() > 35){
      salary = getSalary() + 10000;
    }
  }
}