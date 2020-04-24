package club.banyuan;

import club.banyuan.animal.Dog;
import club.banyuan.animal.Cat;
import club.banyuan.human.Persion;

public class main {

  public static void main(String[] args) {
    Persion persion = new Persion();
    Cat cat = new Cat();
    cat.name = "汤姆";
    Dog dog = new Dog();
    dog.setName("小强");
    persion.train(dog);
    dog.playWith(cat);
  }
}
