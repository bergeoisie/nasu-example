package edu.umd.math.nasu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jgrapht.EdgeFactory;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.DirectedPseudograph;

import edu.umd.math.GEdge;
import edu.umd.math.GVertex;
import edu.umd.math.GammaEdge;
import edu.umd.math.GammaVertex;
import edu.umd.math.OutputHelper;
import edu.umd.math.Textile;
import edu.umd.math.TextileBuilder;

public class Nasu {
	
	static final Logger logger = LogManager.getLogger(Nasu.class.getName());

	public static void main(String args[]) {
		Textile t = generateTOne();
		System.out.println("Hello world" + t.toString());
		OutputHelper.printTextile(t);
		
	//	Textile invT = TextileBuilder.createInverse(t);
	//	OutputHelper.printTextile(invT);
		
		Textile Td = TextileBuilder.createDual(t);
	//	OutputHelper.printTextile(Td);
		
	//	Textile Tbug = TextileBuilder.createHigherBlockTextile(t, 2);
	//	OutputHelper.printTextile(Tbug);
		
		Textile Ttwod = TextileBuilder.createHigherBlockTextile(Td, 3);
		OutputHelper.printTextile(Ttwod);
		
		Ttwod.trim();
		OutputHelper.printTextile(Ttwod);
		
		
	}
	
	public static Textile generateTNaught() {
		
		EdgeFactory<GammaVertex,GammaEdge> gammaEF = new ClassBasedEdgeFactory<GammaVertex,GammaEdge>(GammaEdge.class);
		EdgeFactory<GVertex,GEdge> gEF = new ClassBasedEdgeFactory<GVertex,GEdge>(GEdge.class);
		
		DirectedPseudograph<GammaVertex,GammaEdge> gamma = new DirectedPseudograph<GammaVertex,GammaEdge>(gammaEF);
		DirectedPseudograph<GVertex,GEdge> g = new DirectedPseudograph<GVertex,GEdge>(gEF);
		
		GVertex gv1 = new GVertex("0");
		GVertex gv2 = new GVertex("1");

		g.addVertex(gv1);
		g.addVertex(gv2);
		
		GEdge ge1 = new GEdge("0","0","a");
		GEdge ge2 = new GEdge("0","0","b");
		GEdge ge3 = new GEdge("0","1","c");
		GEdge ge4 = new GEdge("1","0","d");
		GEdge ge5 = new GEdge("1","1","e");
		
		g.addEdge(gv1, gv1, ge1);
		g.addEdge(gv1, gv1, ge2);
		g.addEdge(gv1, gv2, ge3);
		g.addEdge(gv2, gv1, ge4);
		g.addEdge(gv2, gv2, ge5);
		
		GammaVertex gammav1 = new GammaVertex(gv1,gv1,"u");
		GammaVertex gammav2 = new GammaVertex(gv1,gv2,"v");
		GammaVertex gammav3 = new GammaVertex(gv2,gv1,"w");
		
		gamma.addVertex(gammav1);
		gamma.addVertex(gammav2);
		gamma.addVertex(gammav3);
		
		GammaEdge gammae1 = new GammaEdge("u","u","a","a","A");
		GammaEdge gammae2 = new GammaEdge("u","v","a","c","B");
		GammaEdge gammae3 = new GammaEdge("u","w","c","b","C");
		GammaEdge gammae4 = new GammaEdge("v","u","b","d","D");
		GammaEdge gammae5 = new GammaEdge("v","v","b","e","E");
		GammaEdge gammae6 = new GammaEdge("w","u","d","a","F");
		GammaEdge gammae7 = new GammaEdge("w","v","d","c","G");
		GammaEdge gammae8 = new GammaEdge("w","w","e","b","H");

		gamma.addEdge(gammav1, gammav1, gammae1);
		gamma.addEdge(gammav1, gammav2, gammae2);
		gamma.addEdge(gammav1, gammav3, gammae3);
		gamma.addEdge(gammav2, gammav1, gammae4);
		gamma.addEdge(gammav2, gammav2, gammae5);
		gamma.addEdge(gammav3, gammav1, gammae6);
		gamma.addEdge(gammav3, gammav2, gammae7);
		gamma.addEdge(gammav3, gammav3, gammae8);
		
		return new Textile(gamma,g);
		
		
	}
	
	public static Textile generateT() {
		
		EdgeFactory<GammaVertex,GammaEdge> gammaEF = new ClassBasedEdgeFactory<GammaVertex,GammaEdge>(GammaEdge.class);
		EdgeFactory<GVertex,GEdge> gEF = new ClassBasedEdgeFactory<GVertex,GEdge>(GEdge.class);
		
		DirectedPseudograph<GammaVertex,GammaEdge> gamma = new DirectedPseudograph<GammaVertex,GammaEdge>(gammaEF);
		DirectedPseudograph<GVertex,GEdge> g = new DirectedPseudograph<GVertex,GEdge>(gEF);
		
		GVertex gv1 = new GVertex("0");
		GVertex gv2 = new GVertex("1");

		g.addVertex(gv1);
		g.addVertex(gv2);
		
		GEdge ge1 = new GEdge("0","0","a");
		GEdge ge2 = new GEdge("0","0","b");
		GEdge ge3 = new GEdge("0","1","c");
		GEdge ge4 = new GEdge("1","0","d");
		GEdge ge5 = new GEdge("1","1","e");
		
		g.addEdge(gv1, gv1, ge1);
		g.addEdge(gv1, gv1, ge2);
		g.addEdge(gv1, gv2, ge3);
		g.addEdge(gv2, gv1, ge4);
		g.addEdge(gv2, gv2, ge5);
		
		GammaVertex gammav1 = new GammaVertex(gv1,gv1,"u");
		GammaVertex gammav2 = new GammaVertex(gv1,gv2,"v");
		GammaVertex gammav3 = new GammaVertex(gv2,gv1,"w");
		
		gamma.addVertex(gammav1);
		gamma.addVertex(gammav2);
		gamma.addVertex(gammav3);
		
		GammaEdge gammae1 = new GammaEdge("u","u","a","a","A");
		GammaEdge gammae2 = new GammaEdge("u","v","a","c","B");
		GammaEdge gammae3 = new GammaEdge("u","w","c","a","C");
		GammaEdge gammae4 = new GammaEdge("v","u","b","d","D");
		GammaEdge gammae5 = new GammaEdge("v","v","b","e","E");
		GammaEdge gammae6 = new GammaEdge("w","u","d","b","F");
		GammaEdge gammae7 = new GammaEdge("w","v","d","c","G");
		GammaEdge gammae8 = new GammaEdge("w","w","e","a","H");

		gamma.addEdge(gammav1, gammav1, gammae1);
		gamma.addEdge(gammav1, gammav2, gammae2);
		gamma.addEdge(gammav1, gammav3, gammae3);
		gamma.addEdge(gammav2, gammav1, gammae4);
		gamma.addEdge(gammav2, gammav2, gammae5);
		gamma.addEdge(gammav3, gammav1, gammae6);
		gamma.addEdge(gammav3, gammav2, gammae7);
		gamma.addEdge(gammav3, gammav3, gammae8);
		
		return new Textile(gamma,g);
		
	}
	
	public static Textile generateTOne() {
		
		EdgeFactory<GammaVertex,GammaEdge> gammaEF = new ClassBasedEdgeFactory<GammaVertex,GammaEdge>(GammaEdge.class);
		EdgeFactory<GVertex,GEdge> gEF = new ClassBasedEdgeFactory<GVertex,GEdge>(GEdge.class);
		
		DirectedPseudograph<GammaVertex,GammaEdge> gamma = new DirectedPseudograph<GammaVertex,GammaEdge>(gammaEF);
		DirectedPseudograph<GVertex,GEdge> g = new DirectedPseudograph<GVertex,GEdge>(gEF);
		
		GVertex gv1 = new GVertex("0");
		GVertex gv2 = new GVertex("1");

		g.addVertex(gv1);
		g.addVertex(gv2);
		
		GEdge ge1 = new GEdge("0","0","a");
		GEdge ge2 = new GEdge("0","0","b");
		GEdge ge3 = new GEdge("0","1","c");
		GEdge ge4 = new GEdge("1","0","d");
		GEdge ge5 = new GEdge("1","1","e");
		
		g.addEdge(gv1, gv1, ge1);
		g.addEdge(gv1, gv1, ge2);
		g.addEdge(gv1, gv2, ge3);
		g.addEdge(gv2, gv1, ge4);
		g.addEdge(gv2, gv2, ge5);
		
		GammaVertex gammav1 = new GammaVertex(gv2,gv1,"1");
		GammaVertex gammav2 = new GammaVertex(gv1,gv2,"2");
		GammaVertex gammav3 = new GammaVertex(gv1,gv1,"3");
		GammaVertex gammav4 = new GammaVertex(gv1,gv1,"4");
		
		gamma.addVertex(gammav1);
		gamma.addVertex(gammav2);
		gamma.addVertex(gammav3);
		gamma.addVertex(gammav4);
		
		GammaEdge gammae1 = new GammaEdge("1","1","e","b","A");
		GammaEdge gammae2 = new GammaEdge("1","2","d","c","B");
		GammaEdge gammae3 = new GammaEdge("1","3","d","b","C");
		GammaEdge gammae4 = new GammaEdge("2","1","c","d","D");
		GammaEdge gammae5 = new GammaEdge("2","2","a","e","E");
		GammaEdge gammae6 = new GammaEdge("2","3","a","d","F");
		GammaEdge gammae7 = new GammaEdge("3","3","b","a","G");
		GammaEdge gammae8 = new GammaEdge("3","4","b","a","H");
		GammaEdge gammae9 = new GammaEdge("4","1","c","b","I");
		GammaEdge gammae10 = new GammaEdge("4","2","a","c","J");
		GammaEdge gammae11 = new GammaEdge("4","3","a","b","K");
		
		gamma.addEdge(gammav1, gammav1, gammae1);
		gamma.addEdge(gammav1, gammav2, gammae2);
		gamma.addEdge(gammav1, gammav3, gammae3);
		gamma.addEdge(gammav2, gammav1, gammae4);
		gamma.addEdge(gammav2, gammav2, gammae5);
		gamma.addEdge(gammav2, gammav3, gammae6);
		gamma.addEdge(gammav3, gammav3, gammae7);
		gamma.addEdge(gammav3, gammav4, gammae8);
		gamma.addEdge(gammav4, gammav1, gammae9);
		gamma.addEdge(gammav4, gammav2, gammae10);
		gamma.addEdge(gammav4, gammav3, gammae11);
		
		return new Textile(gamma,g);
		
		
	}
}
