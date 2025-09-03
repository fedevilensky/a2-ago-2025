#pragma once

template <class T>
class hash_func
{
public:
  virtual int hash(T obj) = 0;
};
