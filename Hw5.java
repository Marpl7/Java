import java.util.Arrays;
class Main {
  public static void main(String[] args) {

  float run = 100;
  float jump = 3;
  float swim = 5;  
    
  Dog Tuzik = new Dog(600, 0.5f, 10);
  Dog Rex = new Dog(700, 1, 20);
  Cat Murzik = new Cat(500, 10);
  Horse Buran = new Horse(2000, 3, 100);
  Bird Chizhik = new Bird(10, 0.2f);

  Animal[] competition = {Tuzik, Rex, Murzik, Buran, Chizhik};
  for (int i = 0; i < competition.length; i++){
    System.out.println(competition[i]);
    competition[i].run(run);
    competition[i].jump(jump);
    competition[i].swim(swim);
    System.out.println();
  }
  
  }
}


public class Dog extends Animal{

  float limitSwim;
  
  public Dog(float limitRun, float limitJump, float limitSwim){
    super(limitRun, limitJump);
    this.limitSwim = limitSwim;
  }

  @Override
  public void run(float length){
    if (0 < length && length <= limitRun){
      System.out.println("Песик побежал!");
    }else{
      System.out.println("Слишком длинная дистанция");
      }
  }

  @Override
  public void swim(float length){
    if (0 < length && length <= limitSwim){
      System.out.println("Песик поплыл!");
    }else{
      System.out.println("Слишком длинная дистанция");
      }
  }
  
  @Override
  public void jump(float hight){
    if (0 < hight && hight <= limitJump){
      System.out.println("Песик прыгнул!");
    }else{
      System.out.println("Слишком высоко");
      }
  }

}


public class Cat extends Animal{
  
  public Cat(float limitRun, float limitJump){
    super(limitRun, limitJump);
  }

  @Override
  public void run(float length){
    if (0 < length && length <= limitRun){
      System.out.println("Котик побежал!");
    }else{
      System.out.println("Слишком длинная дистанция");
      }
  }

  @Override
  public void swim(float length){
    
      System.out.println("Котик не умеет плавать!");
    
  }
  
  @Override
  public void jump(float hight){
    if (0 < hight && hight <= limitJump){
      System.out.println("Котик прыгнул!");
    }else{
      System.out.println("Слишком высоко");
      }
  }

}



public class Horse extends Animal{

  float limitSwim;

  public Horse(float limitRun, float limitJump, float limitSwim){
    super(limitRun, limitJump);
    this.limitSwim = limitSwim;
  }

  @Override
  public void run(float length){
    if (0 < length && length <= limitRun){
      System.out.println("Лошадка побежала!");
    }else{
      System.out.println("Слишком длинная дистанция");
      }
  }

  @Override
  public void swim(float length){
    if (0 < length && length <= limitSwim){
      System.out.println("Лошадка поплыла!");
    }else{
      System.out.println("Слишком длинная дистанция");
      }
  }
  
  @Override
  public void jump(float hight){
    if (0 < hight && hight <= limitJump){
      System.out.println("Лошадка прыгнула!");
    }else{
      System.out.println("Слишком высоко");
      }
  }

}


public class Bird extends Animal{

  public Bird(float limitRun, float limitJump){
    super(limitRun, limitJump);
  }

  @Override
  public void run(float length){
    if (0 < length && length <= limitRun){
      System.out.println("Птичка побежала!");
    }else{
      System.out.println("Слишком длинная дистанция");
      }
  }

  @Override
  public void swim(float length){
    
      System.out.println("Птичка не умеет плавать!");
    
  }
  
  @Override
  public void jump(float hight){
    if (0 < hight && hight <= limitJump){
      System.out.println("Птичка прыгнула!");
    }else{
      System.out.println("Слишком высоко");
      }
  }

}


public abstract class Animal{

  // float limitSwim;
  float limitJump;
  float limitRun;

  Animal(float limitRun, float limitJump){
    this.limitRun = limitRun;
    this.limitJump = limitJump;
    // this.limitSwim = limitSwim;
  }

  public abstract void run(float a);

  public abstract void swim(float a);
  
  public abstract void jump(float a);

}

