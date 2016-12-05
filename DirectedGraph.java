import java.util.ArrayList;
public class DirectedGraph<T> extends UndirectedGraph<T>
{
	public DirectedGraph()
	{
		vertices = new ArrayList<Vertex<T>>();
	}
	public DirectedGraph(ArrayList<Vertex<T>> V)
	{
		vertices = new ArrayList<Vertex<T>>(V);
	}
	
	public void addEdge(Vertex<T> s, Vertex<T> e) throws Exception
	{
		try
		{
			s.addEdge(e);
		}
		catch(Exception EdgeExists)
		{
			throw EdgeExists;
		}
	}
	public void removeEdge(Vertex<T> v, Vertex<T> e) throws Exception
	{
		try
		{
			v.removeEdge(e);
		}
		catch(Exception EdgeDoesNotExist)
		{
			throw EdgeDoesNotExist;
		}
	}
	public int getInDegreeOfVertex(Vertex<T> v)
	{
		return 0;  
	}
	
	
	
	private ArrayList<Vertex<T>> vertices;
}
