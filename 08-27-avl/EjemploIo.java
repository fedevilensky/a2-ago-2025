import java.util.Scanner;

public class EjemploIo {
  public static void main(String[] args) {
    String nombre;
    int edad;

    Scanner sc = new Scanner(System.in);
    System.out.println("Como es tu nombre?");
    nombre = sc.next();
    System.out.println("Cual es tu edad?");
    edad = sc.nextInt();

    System.out.println("Hola " + nombre + ", tu edad es " + edad);
  }
}
