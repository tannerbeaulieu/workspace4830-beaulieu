package q1.extract_method.refactored;

import java.util.List;

class Graph {
	String name;
	boolean contains(String p) {
		return name.contains(p);
	}
}

class Node extends Graph {
	// other implementation.
}

class Edge extends Graph {
	// other implementation.
}

public class A {
   Node m1(List<Node> nodes, String p) {
      // TODO: Your answer
	   ex(nodes, p);
      // other implementation
      return null;
   }

   Edge m2(List<Edge> edgeList, String p) {
      // TODO: Your answer
      ex(edgeList, p);
      return null;
   }

   // TODO: Your answer
   <T extends Graph> void ex(List<T> objs, 
		   					String p) {
	   for(T obj : objs) {
		   if(obj.contains(p))
			   System.out.println(obj);
	   }
	   return;
   }
}

