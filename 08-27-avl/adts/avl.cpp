#pragma once
#include <assert.h>
#include "bst.cpp"

template <class T>
class avl : public bst<T>
{
private:
  struct avl_node
  {
    T data;
    int height = 1;
    avl_node *left = nullptr;
    avl_node *right = nullptr;

    avl_node(T data)
    {
      this->data = data;
    }
  }

  avl_node *root = nullptr;
  int count = 0;

  int max(int a, int b)
  {
    if (a > b)
    {
      return a;
    }
    return b;
  }

  int height(avl_node *n)
  {
    if (n == nullptr)
    {
      return 0;
    }

    return n->height;
  }

  T minNode(avl_node *n)
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

  T maxNode(avl_node *n)
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

  avl_node *leftRotation(avl_node *z)
  {
    avl_node *y = z->right;
    avl_node *yLeft = y->left;

    y->left = z;
    z->right = yLeft;

    z->height = 1 + max(height(z->left), height(z->right));
    y->height = 1 + max(height(y->left), height(y->right));

    return y;
  }

  avl_node *rebalance(avl_node *n)
  {
    int bF = height(n->left) - height(n->right);

    if (bF < 1)
    { // desbalance der-?
      avl_node *aux = n->right;
      bF = height(aux->left) - height(aux->right);

      if (bF < 0)
      { // desbalance der-der
        n = leftRotation(n);
      }
      else
      { // desbalance der-izq
        // bF > 0
        n = rightLeftRotation(n);
      }
    }
    else if (bF > 1)
    { // desbalance izq-?
      avl_node *aux = n->left;
      bF = height(aux->left) - height(aux->right);

      if (bF < 0)
      { // desbalance izq-der
        n = leftRightRotation(n);
      }
      else
      { // desbalance izq-izq
        // bF > 0
        n = rightRotation(n);
      }
    }

    return n;
  }

  avl_node *insert(T data, avl_node *n)
  {
    if (n == nullptr)
    {
      this->count++;
      return new avl_node(data);
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

    n = rebalance(n);
    return n;
  }

  boolean contains(T data, avl_node *n)
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
