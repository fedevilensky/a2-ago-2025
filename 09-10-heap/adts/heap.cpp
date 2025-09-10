#pragma once

template <class T, class P>
class heap
{
public:
  virtual void push(T elem, P prio) = 0;

  virtual T pop() = 0;

  virtual T top() = 0;

  virtual int size() = 0;

  virtual bool isEmpty() = 0;
};
