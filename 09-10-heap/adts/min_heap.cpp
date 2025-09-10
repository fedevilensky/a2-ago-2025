#pragma once

#include "./heap.cpp"
#include <assert.h>

template <class T, class P>
class min_heap : heap<T, P>
{
  struct pair
  {
    T fst;
    P snd;

    pair(T fst, P snd)
    {
      this->fst = fst;
      this->snd = snd;
    }
  }

  pair *arr;
  int arrLength;
  int count;

private:
  void siftUp(int pos)
  {
    assert(false);
  }

  void siftDown(int pos)
  {
    assert(false);
  }

public:
  min_heap(int expectedSize)
  {
    this->arr = pair[expectedSize];
    this->arrLength this->count = 0;
  }

  virtual void push(T elem, P prio) override
  {
    if (this->count == this->arrLength)
    {
      pair *aux = arr;
      arr = pair[2 * this->arrLength];
      for (int i = 1; i < this->count; i++)
      {
        arr[i] = aux[i];
      }
    }

    this->count++;
    this->arr[this->count] = pair(elem, prio);
    siftUp(this->count);
  }

  virtual T pop() override
  {
    assert(this->count >= 1);
    pair p = (pair)arr[1];
    this->arr[1] = this->arr[this->count];
    this->count--;
    siftDown(1);

    return p.fst;
  }

  virtual T top() override
  {
    assert(this->count >= 1);
    pair p = (pair)arr[1];
    return p.fst;
  }

  virtual int size() override
  {
    return this->count;
  }

  virtual bool isEmpty() override
  {
    return this->count == 0;
  }
};
