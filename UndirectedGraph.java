import java.util.ArrayList;
public class UndirectedGraph<T> 
{
	public UndirectedGraph()
	{
		vertices = new ArrayList<Vertex<T>>();
	}
	public UndirectedGraph(ArrayList<Vertex<T>> v)
	{
		vertices = new ArrayList<Vertex<T>>(v);
	}
	
	public void addEdge(Vertex<T> s, Vertex<T> e) throws Exception
	{
		try
		{
			s.addEdge(e);
			e.addEdge(s);
		}
		catch(Exception edgeExists)
		{
			throw edgeExists;
		}
	}
	public void addVertex(Vertex<T> v) throws Exception
	{
		if(!vertices.contains(v))
			vertices.add(v);
		else
			throw new Exception("Cannot add vertex " + v + " it already exists in this graph");
	}
	public void removeVertex(Vertex<T> v) throws Exception
	{
		if(vertices.contains(v))
			vertices.remove(v);
		else
			throw new Exception("Cannot remove vertex " + v + "; it does not exist in this graph");
	}
	public void removeEdge(Vertex<T> v, Vertex<T> e) throws Exception
	{
		try
		{
			v.removeEdge(e);
			e.removeEdge(v);
		}
		catch(Exception EdgeDoesNotExist)
		{
			throw EdgeDoesNotExist;
		}
	}
	public int getDegreeOfVertex(Vertex<T> v)
	{
		return v.getDegree();
	}
	public ArrayList<Vertex<T>> getAdjacentVertices(Vertex<T> v)
	{
		return v.getAdjacent();
	}
	public int vertexAmount()
	{
		return vertices.size();
	}
	public ArrayList<Vertex<T>> getVertices()
	{
		return vertices;
	}
	/*public Vertex<T> getVertexAt(int i)
	{
		Vertex[] array = vertices.toArray();
		vertices.
	}*/
	
	
	private ArrayList<Vertex<T>> vertices;
}
