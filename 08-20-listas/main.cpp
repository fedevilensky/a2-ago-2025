#include "adts/linked_list.cpp"
#include <iostream>

int main()
{
  list<int> *l = new linked_list<int>();

  for (int i = 0; i < 10; i++)
  {
    l->insert(i);
  }

  for (int i = 0; i < 11; i++)
  {
    std::cout << l->get(i) << std::endl;
  }
}
