import java.util.ArrayList;
public abstract class BreadthFirstSearch<T> 
{
	public boolean search(Vertex<T> v,ArrayList<Vertex<T>> graph)
	{
		ArrayList<Vertex<T>> vertices= new ArrayList<Vertex<T>>();
		ArrayList<Integer> marked = new ArrayList<Integer>();
		
		for(Vertex<T> vertex : graph)
		{
			if((!vertices.contains(vertex))&&(!marked.contains(vertices.indexOf(vertex))))
			{
				vertices.add(vertex);
			}
			for(Vertex<T> current : vertices)
			{
				if(current == v )
				{
					return true;
				}
				if(!marked.contains(vertices.indexOf(current)))
				{
					marked.add(vertices.indexOf(current));
					for(Vertex<T> adj : current.getAdjacent())
					{
						vertices.add(adj);
					}
				}
				vertices.remove(current);
			}
			
		}
		
		
		return false;
	}
}
