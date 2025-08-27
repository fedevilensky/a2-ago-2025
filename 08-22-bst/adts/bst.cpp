#pragma once

template <class T>
class bst
{
  virtual void insert(T data) = 0;

  virtual void remove(T data) = 0;

  virtual int height() = 0;

  virtual int size() = 0;

  virtual bool contains(T data) = 0;

  virtual T get(T data) = 0;

  virtual T min() = 0;

  virtual T max() = 0;
};
