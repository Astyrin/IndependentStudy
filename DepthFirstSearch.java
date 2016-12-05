import java.util.ArrayList;
public class DepthFirstSearch
{
	public static boolean search(Vertex<Integer> v, ArrayList<Vertex<Integer>> vertices)
	{
//		if(!marked.isEmpty())
//			marked.clear();
		//marked = new ArrayList<Vertex<T>>();
		ArrayList<Vertex<Integer>> marked = new ArrayList<Vertex<Integer>>();
		for(Vertex<Integer> vertex : vertices)
		{
			if(!marked.contains(vertex))
			{
				if(searchHelper(v,vertices,vertex,marked))
					return true;
			}
		}
		return false;
	}
	//used to implement DFS recursively
	private static boolean searchHelper(Vertex<Integer> v, ArrayList<Vertex<Integer>> vertices, Vertex<Integer> vertex, ArrayList<Vertex<Integer>> marked )
	{
		if(!marked.contains(vertex))
		{
			if(vertex == v)
				return true;
			for(Vertex<Integer> adj : vertex.getAdjacent())
			{
				if(!marked.contains(adj))
				{
					marked.add(adj);
					if(adj == v)
						return true;
					return searchHelper(v,vertices,adj,marked);
				}
			}
		}
		return false;
	}
	//private ArrayList<Vertex<Integer>> marked = new ArrayList<Vertex<Integer>>();
}
