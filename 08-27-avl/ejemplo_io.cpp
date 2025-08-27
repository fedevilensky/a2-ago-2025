#include <iostream>
#include <string>

int main()
{
  std::string nombre;
  int edad;

  std::cout << "Como es tu nombre?" << std::endl;
  std::cin >> nombre;

  std::cout << "Cual es tu edad?" << std::endl;
  std::cin >> edad;

  std::cout << "Hola " << nombre << ", tu edad es " << edad << std::endl;
}
