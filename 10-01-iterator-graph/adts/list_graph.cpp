#pragma once

#include "graph.cpp"
#include "linked_list.cpp"

class ListGraph : public Graph
{
private:
  list<edge> **edges;
  int vertexCount;

public:
  ListGraph(int vertices)
  {
    this->edges = new list<edge> *[vertices + 1];
    this->vertexCount = vertices;
    for (int i = 1; i <= vertices; i++)
    {
      this->edges[i] = new linked_list<edge>();
    }
  }

  virtual int vertices() override
  {
    return this->vertexCount;
  }

  virtual iterable<edge> *neighbors(int v) override
  {
  }

  virtual void addEdge(int v, int w) override
  {
    addEdge(v, w, 1);
  }

  virtual void addEdge(int v, int w, int cost) override
  {
    edge newEdge = edge(v, w, cost);

    list<edge> *neighbors = this->edges[v];
    neighbors->remove(newEdge);

    neighbors->insert(newEdge);
  }

  virtual iterable<edge> *edges() override
  {
  }

  virtual bool isNeighbor(int v, int w) override
  {
  }

  virtual int getCost(int v, int w) override
  {
  }

  virtual void removeEdge(int v, int w) override
  {
  }
};
