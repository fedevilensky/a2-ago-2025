#pragma once
#include "iterator.cpp"

class edge
{
public:
  int ori, dest, cost;

  edge(int ori, int dest)
  {
    this->ori = ori;
    this->dest = dest;
    this->cost = 1;
  }

  edge(int ori, int dest, int cost)
  {
    this->ori = ori;
    this->dest = dest;
    this->cost = cost;
  }

  bool operator==(const edge &other)
  {
    return this->ori == other.ori && this->dest == other.dest;
  }
};

class Graph
{
public:
  virtual int vertices() = 0;

  virtual iterable<edge> *neighbors(int v) = 0;

  virtual void addEdge(int v, int w) = 0;

  virtual void addEdge(int v, int w, int cost) = 0;

  virtual void removeEdge(int v, int w) = 0;

  virtual iterable<edge> *edges() = 0;

  virtual bool isNeighbor(int v, int w) = 0;

  virtual int getCost(int v, int w) = 0;
};
