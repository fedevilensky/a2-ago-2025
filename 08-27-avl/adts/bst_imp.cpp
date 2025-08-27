#pragma once

#include "bst.cpp"
#include <assert.h>

template <class T>
class bst_imp : public bst<T>
{
private:
  struct bst_node
  {
    T data;
    int height = 1;
    bst_node *left = nullptr;
    bst_node *right = nullptr;

    bst_node(T data)
    {
      this->data = data;
    }
  }

  bst_node *root = nullptr;
  int count = 0;

  int max(int a, int b)
  {
    if (a > b)
    {
      return a;
    }
    return b;
  }

  int height(bst_node *n)
  {
    if (n == nullptr)
    {
      return 0;
    }

    return n->height;
  }

  T minNode(bst_node *n)
  {
    assert(n != nullptr);

    if (n->left != nullptr)
    {
      return minNode(n->left);
    }
    else
    {
      return n->data;
    }
  }

  T maxNode(bst_node *n)
  {
    assert(n != nullptr);

    if (n->right != nullptr)
    {
      return maxNode(n->right);
    }
    else
    {
      return n->data;
    }
  }

  bst_node *insert(T data, bst_node *n)
  {
    if (n == nullptr)
    {
      this->count++;
      return new bst_node(data);
    }

    if (data < n->data)
    {
      n->left = insert(data, n->left);
    }
    else if (data > n->data)
    {
      n->right = insert(data, n->right);
    }

    n->height = 1 + max(height(n->left), height(n->right));

    return n;
  }

  boolean contains(T data, bst_node *n)
  {
    if (n == nullptr)
    {
      return false;
    }

    if (data == n->data)
    {
      return true;
    }

    if (data < n->data)
    {
      return contains(data, n->left);
    }
    else if (data > n->data)
    {
      return contains(data, n->right);
    }

    // unreachable code
    assert(false);
  }

public:
  virtual void insert(T data) override
  {
    this->root = insert(data, this->root);
  }

  virtual void remove(T data) override
  {
    // TODO Auto-generated method stub
  }

  virtual int height() override
  {
    return height(this->root);
  }

  virtual int size() override
  {
    return this->count;
  }

  virtual boolean contains(T data) override
  {
    return contains(data, this->root);
  }

  virtual T get(T data) override
  {
    // TODO Auto-generated method stub
  }

  virtual T min() override
  {
    return minNode(this->root);
  }

  virtual T max() override
  {
    return maxNode(this->root);
  }
};
