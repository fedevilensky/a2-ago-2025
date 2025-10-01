#include "adts/linked_list.cpp"
#include <iostream>

int main()
{
  list<int> *l = new linked_list<int>();

  for (int i = 0; i < 10; i++)
  {
    l->insert(i);
  }

  iterator<int> *it = l->iterator();

  while (it->hasNext())
  {
    int n = it->next();
    std::cout << n << std::endl;
  }
}
