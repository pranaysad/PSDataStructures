//	Binary Tree
//	Linked List, Doubly Linked List
//	Array Search & Sort
//	Large Data Sets
//	Binary Tree
//	Serialize & DeSerialize
//	Balanced Binary Tree
//	Remove duplicates from a Binary Tree
//	Character Matrix
//	Binary Tree - Sum Tree
//	String Manipulation
//	Stack
//	Maze - shortest path first
//	Strings - anagrams, pattern matching, etc.
//	Clock hands angle
//	Machine Learning, AI, Hadoop, SQL, Large Scale Data Mining, Big Data, Rules based systems

package psdatapack;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Time;
import java.time.LocalDateTime;

import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

import java.lang.Object;

public class PSDataStructures {
	
	static class Node
	{
		int iNodeVar;
		Node oLeftNode;
		Node oRightNode;
		
		Node(int iNodeValue)
		{
			iNodeVar = iNodeValue;
		}
		
		int GetiNodeVar()
		{
			return iNodeVar;
		}
		
	}
	
	static class HeapTree
	{	
		Node oRootNode;
		
		HeapTree(int iRootNodeValue )
		{
			oRootNode.iNodeVar = iRootNodeValue;
		}
		
		boolean AddNodeRecursive(Node oNewNode, Node oRootNode)
		{	
			/*
			if (oNewNode.iNodeVar < oRootNode.iNodeVar)
			{
				//If the new node is less than the RootNode then switch
				int temp = oRootNode.iNodeVar;
				oRootNode.iNodeVar = oNewNode.iNodeVar;
				oNewNode.iNodeVar = temp;
				AddNodeRecursive(oNewNode, oRootNode);
			}
			*/
			
			//If the RootNode is null then RootNode = NewNode and return
			if (oRootNode==null)
			{
				oRootNode = new Node(oNewNode.iNodeVar);
				return true;
			}
			
			if (oRootNode.oLeftNode==null)
			{
				oRootNode.oLeftNode = new Node(oNewNode.iNodeVar);
				return true;
			}
			else {
				AddNodeRecursive(oNewNode, oRootNode.oLeftNode);
			}
			
			if (oRootNode.oRightNode==null)
			{
				oRootNode.oRightNode = new Node(oNewNode.iNodeVar);
				return true;
			}
			else {
				AddNodeRecursive(oNewNode, oRootNode.oRightNode);
			}
					
			return true;
			
		}
		
		boolean AddNode(Node oNewNode)
		{
			return AddNodeRecursive(oNewNode, oRootNode);
		}
		
		
	}
	
	static class BTree 
	{
		Node oRootNode;
		
		BTree(int iRootNodeValue)
		{
			oRootNode = new Node(iRootNodeValue);
		}
		
		boolean AddNodeRecursive(int iNewNodeVal, Node oStartNode)
		{
			
			if (oStartNode == null)
			{
				//We need to insert iNewNodeVal here
				oStartNode = new Node(iNewNodeVal);
				//System.out.println(oStartNode.iNodeVar);
				return true;
			}
			
			if (iNewNodeVal == oStartNode.iNodeVar)
			{
				//Value already exists in the tree - nothing to do
				return true;
			}
			else if (iNewNodeVal < oStartNode.iNodeVar)
			{	
					if (oStartNode.oLeftNode == null)
					{
						oStartNode.oLeftNode = new Node(iNewNodeVal);
						return true;
					}
					else AddNodeRecursive(iNewNodeVal, oStartNode.oLeftNode);
			} 
			else 
			{
					if (oStartNode.oRightNode == null)
					{
						oStartNode.oRightNode = new Node(iNewNodeVal);
						return true;
					}
					else AddNodeRecursive(iNewNodeVal, oStartNode.oRightNode);
			}
			
			return false;
		}
		
		boolean AddNode(int iNewNode)
		{	
			return AddNodeRecursive(iNewNode, oRootNode);
		}
		
		
		int InOrder(Node oStartNode, int iLevel)
		{
			if (oStartNode!=null) 
			{
				System.out.println(oStartNode.iNodeVar + ":" + iLevel);
			}
			if (oStartNode.oLeftNode!=null)
			{
				iLevel = InOrder(oStartNode.oLeftNode, ++iLevel);
			}
			if (oStartNode.oRightNode!=null)
			{
				iLevel = InOrder(oStartNode.oRightNode, ++iLevel);
			}
			
			return --iLevel;
		}
		
	}
	
	class MyThread extends Thread {
		
		
		
	}
	
	public static class HelloRunnable implements Runnable {
		
		public void run()
		{
			
			System.out.println("Hello from HelloRunnable Thread");
			System.out.println("Sleeping now for 1 seconds....");
			
			int count=0;
			
			//while(!Thread.interrupted())
			{
				try {
					
					System.out.println(count++);
					
					Thread.sleep(1000);
					
					Thread.dumpStack();
					
					System.out.println("");
					
					if (Thread.interrupted()) {
				        // We've been interrupted: no more crunching.
						System.out.println("Thread Interrupted! Thread.interrupted()");
				        return;
				    }
				}
				catch (InterruptedException e)
				{
					System.out.println("Thread Interrupted! InterruptedException");
					return;
				}
			}
			
		}
	}
	
	static class LLNode {
		
		int iValue;
		
		LLNode oLLNodeNext;
		LLNode oLLNodePrev;
		
		LLNode(int iNodeValue)
		{
			iValue = iNodeValue;
			oLLNodeNext = null;
			oLLNodePrev = null;
		}
		
	}
	
	// 	Linked list consists of Linked List Nodes
	// 	Classes should clearly distinguish between operations that are done on a linked-list 
	//	and operations that are done on a Node
	static class MyLinkedList {
		
		LLNode oRootNode;
		
		MyLinkedList(int iRootNodeValue)
		{
			oRootNode = new LLNode(iRootNodeValue);
			oRootNode.oLLNodePrev = oRootNode;
		}
		
		boolean AddLLNode(int iNewNodeValue, LLNode oCurrentNode)
		{	
			if (oCurrentNode.oLLNodeNext==null)
			{
				//The next node is null so add the new Node here.
				oCurrentNode.oLLNodeNext = new LLNode(iNewNodeValue);
				
				//Point the previous of the new node to the oCurrentNode
				oCurrentNode.oLLNodeNext.oLLNodePrev = oCurrentNode;
				
				//Set the next node = null
				oCurrentNode.oLLNodeNext.oLLNodeNext = null;
				
				return true;
			}
			else {
				AddLLNode(iNewNodeValue, oCurrentNode.oLLNodeNext);		
			}
			return true;
		}
		
		boolean AddLLNode(int iNewNodeValue) 
		{
			
			AddLLNode(iNewNodeValue, oRootNode); 
			
			// Starting from oRootNode add the new Node to the last position
			// i.e Where LLNode.oLLNodeNext = nul;	
			return true;
		}
		
		boolean PrintMyLinkedList() {
			
			//Print Root Node
			if (oRootNode!=null)
			{
				System.out.println("...");
				System.out.println("oRootNode.iValue = " + oRootNode.iValue);
				System.out.println("oRootNode.oLLNodeNext.iValue = " + oRootNode.oLLNodeNext.iValue);
				System.out.println("oRootNode.oLLNodePrev.iValue = " + oRootNode.oLLNodePrev.iValue);
				System.out.println("-----");
			}
			
			LLNode tempNode = oRootNode;
			
			while (tempNode.oLLNodeNext!=null)
			{
				//Set tempNode to be the next Node
				tempNode = tempNode.oLLNodeNext;
				
				System.out.println("tempNode.iValue = " + tempNode.iValue);
				
				if (tempNode.oLLNodeNext!=null) 
					System.out.println("tempNode.oLLNodeNext.iValue = " + tempNode.oLLNodeNext.iValue);
				else {
					System.out.println("tempNode.oLLNodeNext.iValue = null");
				}
				
				if (tempNode.oLLNodeNext!=null) 
					System.out.println("tempNode.oLLNodePrev.iValue = " + tempNode.oLLNodePrev.iValue);
				else {
					System.out.println("tempNode.oLLNodePrev.iValue = null");
				}

				System.out.println("-----");
			}
			
			return true;
		}
		
		
	}
	
	static class Point {
		int x;
		int y;
		Point() {x=0; y=0;}
		Point(int a, int b) {x=a; y=b;}
	}
	
	static int Slope(Point p1, Point p2)
	{
		int iSlope = 0;
		
		System.out.println(p1.y + " " + p2.y + " : " + p1.x + " " + p2.x + " = " + iSlope);
		
		if (p1.x==p2.x)
				iSlope = 0;
			else
				iSlope = (p1.y-p2.y)/(p1.x-p2.x);
		
		System.out.println(p1.y + " " + p2.y + " : " + p1.x + " " + p2.x + " = " + iSlope);
		
		
		
		return iSlope;
		
	}
	
	static int maxPoints(Vector<Point> points)
	{
		//Iterator itr1 = points.iterator();
		//Iterator itr2 = points.iterator();
		
		// Save the slope in a 2 Dimensional array
		// Find the slopes which are the maximum in number(the same slopes)
		// Print out the points corresponding to the slopes
		
		int size = points.size();
		
		System.out.println(size);
		
		//int[][] iSlopeArr = new int[size][size];
			
		// Store the Points and Slope as a HashMap
		
		// Slope, (<p1,p2>, <p2,p3>, ...)
		
		int iCount1 = 0;
		int iCount2 = 0;
		
		Map<Integer,Vector<Point[][]>> map1 = new HashMap<Integer,Vector<Point[][]>>();
		
		Map<Integer,Vector<Point>> singlemap = new HashMap<Integer,Vector<Point>>();
		Vector<Point> vectorpoint = new Vector<Point>();
		
		//Set<List> setPoints = new HashSet<Integer>();
		
		while (iCount1<size) 
		{	
			iCount2=iCount1+1;
			
			while (iCount2<size)
			{	
				int iSlope =  Slope(points.elementAt(iCount1),points.elementAt(iCount2));
				
				//iSlopeArr[iCount1][iCount2] = Slope(points.elementAt(iCount1),points.elementAt(iCount2));
				
				// We create a map which stores the mapping of slope to array of points(p1,p2)
				
				//Point[][] pmulti = new Point[][] {
				//	{p1,p2}
				//};
				
				//	Slope1  {[p1][p2],[p2][p3]}
				//	Slope2	{[p3][p4],[p4][p5]}
				
				Point[][] pmulti = new Point[][]{
					{points.elementAt(iCount1),points.elementAt(iCount2)}
				};
				
				Vector<Point[][]> vp = new Vector<Point[][]>();
				vp.add(pmulti); //This vector contains the points p1 and p2 above.
				
				//setPoints.add(pmulti);
				
				//	Check if the slope already exists in the HashMap. 
				//	If not then add a new Slope and the corresponding points or else append and increase frequency
					if (map1.containsKey(iSlope))
					{	
						//map1 consists of iSlope and Vector of Multi-Points
						
						//Add the new point to the existing vector only if it does not already exist
						Vector<Point[][]> vExist = map1.get(iSlope);
						
						System.out.println(vExist.contains(pmulti));
						
						vExist.addElement(pmulti);
						
						System.out.println(iSlope + " New Count = " + map1.get(iSlope).size());
						System.out.println();
						
					}	
					else
					{	
						map1.put(iSlope, vp);
						System.out.println(iSlope + " Count = " + map1.get(iSlope).size());
						System.out.println();
					}
				
				
				
				iCount2++;
			}
			
			iCount1++;
		}
		
		// Find the maximum number of points with the same slope
		
		return 1;
	}
	
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        //Merge the 2 arrays in any order into a new array
        //Sort the existing array
        //Find Median
        
    	int len1 = nums1.length;
    	int len2 = nums2.length;
    	int len = len1+len2;
    	
    	double dVar = 0;
    	
    	int[] combined = new int[len];
    	
    	for(int i=0;i<nums1.length;i++)
    	{
    		combined[i]=nums1[i];
    	}
    	
    	for(int i=0;i<nums2.length;i++)
    	{
    		combined[len1+i] = nums2[i];
    	}
        
    	//merge-sort
		//int arr1[] = new int[]{1,5,10};		
		//int arr2[] = new int[]{3,7};
		
    	int[] both = new int[len];
    	
    	int count=0;
    	int count1=0;
    	int count2=0;
    	
    	while(count<len)
    	{
    		//System.out.println(combined[i]);
    		//Sort the existing array
    		//Remember both arrays are already sorted	
    		//While you have not completed parsing any one of the arrays completely
    		if (count1<len1 && count2<len2)
    		{
    			if (nums1[count1]<nums2[count2])
    			{
    				both[count]=nums1[count1];
    				System.out.println(both[count]);
    				count1++;
    				count++;
    				
    			}
    			else
    			{
    				both[count]=nums2[count2];
    				System.out.println(both[count]);
    				
    				count2++;
    				count++;
    				
    			}
    		}
    		else
    		{
    			//Array1 has already been incorporated fully into the both array
    			//Append array2 to both and call it a day
    			if (count1>=len1)
    			{
    				for(int i=count2;i<len2;i++)
    				{
    					both[count]=nums2[i];
    					System.out.println(both[count]);
    					
    					count++;
    				}
    			}
    			else //count2 has exceeded the nums2 array
    			{
    				for(int i=count1;i<len1;i++)
    				{
    					both[count]=nums1[i];
    					System.out.println(both[count]);
    					
    					count++;
    				}
    			}
    			
    		}
    	
    	}
    
    	//If len is odd then the median is int(len/2+1)
    	
    	System.out.println(len);
    	if (len % 2 != 0 )	//odd
    	{	
    		
    		double index = Math.floor(len/2)+1;
    		
    		index=index-1;
    		System.out.println(index);
    		
    		dVar = both[(int) index];
    	}
    	else 		//even
    	{
    		double tempindex = Math.floor(len/2);
    		int index = (int)tempindex;
    		
    		index=index-1;
    		System.out.println(index);
    		
    		System.out.println(both[index]);
    		System.out.println(both[index+1]);
    		
    		dVar = ( (double) both[index] + (double) both[index+1] ) / 2.0;
    		
    		System.out.println(dVar);
    		
    	}
    	
    	//If len is even then median = average of (len/2) + (len/2+1)
    	
        
        return dVar;
        
    }
	
    //	Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
    //	If there is no non-empty subarray with sum at least K, return -1.
    //	Algo
	//	Take all sub arrays of size 1 and check if their sum are >=K
    //	Take all sub arrays of size 2 and check if their sum is >=K
    
    //start=0;iLen=1
    static int ssRecurse(int[] A,int K, int start, int iLen)
    {
    	//int iLength = 0;
    	//int sum = 0;
    	//Return if we are at the end of the Array
    	//if (start >= A.length) return iLen;
    	// Add iLen number of digits starting at position "start"
    	//for(int i=start;i<start+iLen;i++)
    	//{
    	//	sum = sum + A[i];
    	//}
    	//if (sum>=K) return iLen;
    	 	
    	if (iLen<=0) return 0;
    	
    	System.out.println("start = " + start);
    	System.out.println("iLen = " + iLen);
    	System.out.println("A[start] = " + A[start]);
  
    	return (ssRecurse(A, K, start+1, iLen-1) + A[start]) ;

    }
    		
    
    public static int shortestSubarray(int[] A, int K) {
    	
    	int iSum = 0;
    	
    	//Find the length of the integer array A so that you know when you stop
    	
		int start = 0;
		int iLen=1;
    	int iALen = A.length;
    	
    	//	{2,-1,2}
    	//	Length = 3
    	//	2			0,1		0	1	
    	//	-1			1,1		1	1
    	//	2			2,1		2	1
    	//	2,-1		0,2		0	2
    	//	-1,2		1,2		1	2
    	//	2,-1,2		0,3		0	3
    	
    	while (iLen<=iALen)
    	{
    	
	    	for (int i=0; i<iALen; i++)		//0,1,2
	    	{	
	    		start=i;
	    		
	    		if (start+iLen<=iALen)
	    		{
	    			
	    			System.out.println("iALen = " + iALen + ": start = " + start + " : iLen = " + iLen);
	    			System.out.println("");
	    			iSum = ssRecurse(A, K, start, iLen);
	    			System.out.println("iSum = " + iSum);
	    			System.out.println("*****");
	    		}
	    	
	    		
	    	}
    		
	    	iLen++;
    	
    	}
    	
    	return iSum;
    	
    }
    
    
    public static int[] findRedundantConnection(int[][] edges) {
		
    	
    	
    	
    	return null;
    
    }
    
    
    
	public static void main(String[] args) {
		
		//08/05/18 03:10:12
		
		int[][] edges = new int[][] {
			{1,2},
			{1,3},
			{2,3}
		};
		
		//		1	2	3
		//	1	0	1	1
		//	2	1	0	1
		//	3	1	1	0
		
		//	[[1,2], [2,3], [3,4], [1,4], [1,5]]
		
		//		1	2	3	4	5
		//	1	0	1	0	1	1	3
		//	2	1	0	1	0	0	2
		//	3	0	1	0	1	0	2
		//	4	1	0	1	0	0	2
		//	5	1	0	0	0	0	1
		//		3	2	2	2	1
				
		//	1	2	4	5
		//	2	1	3
		//	3	2	4
		//	4	1	3	
		//	5	1
		
		//Graph - Adjacency matrix
		
		
		//	Read from the file
		try {
			
			//URL url = getClass().getResource("subset_male_actors.rtf");
			
			//URL url = PSDataStructures.class.getResource("subset_male_actors.rtf");
			
			//File fNames = new File(PSDataStructures.class.getResource("subset_male_actors.rtf").getPath());
			
			
			
			
			
			
			File file = new File(PSDataStructures.class.getResource("test/subset_male_actors.rtf").getFile());
			
			//File fNames = new File(url.getPath());
			System.out.println(file.getPath());
			
			Scanner s = new Scanner(file);
			
			while (s.hasNext()) {
			    System.out.println("word:" + s.next());
			  }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		// 07/19/18 02:11:31
		// 07/19/18 15:28:05
		// TODO Auto-generated method stub
		
		//Serialize and De-serialize a Binary Tree
		
		//						Algorithm
		//												50
		//				25												75		
		//		15				35								60		 		90
		//	-1		-1		-1			-1					-1		-1	 	-1		-1
		
		
		//	File (In-order) = -1,15,-1,	25, -1,35,-1, 50,-1		 (Convert file to Pre-order)
		//	File (Pre-order) = 50,25,15,-1,-1,35,-1,-1,-1 
		//		
		
		//	Read from file
		//	The first number we read will be the root since this is Pre-order
		//	Root = 25
		
		//	Pre-order-Populate(Node root, Int array)
		//	If array[0]!=null
		//	{
		//		root.value = array[0];
		//	
		//	}
		//	if array[0]==-1
		//	{
		//			?
		//	}
		//		Pre-order-populate(node.left,array[1 to end])
		//		Pre-order-populate(node.right,array[1 to end])
		
		//int[] iArray = {50,25,15,-1,-1,35,-1,-1,75,60,-1,-1,90,-1,-1};
		
		//BTree oBTree = new BTree(50);
		
		//oBTree.AddNode(25);
		//oBTree.AddNode(15);
		//oBTree.AddNode(35);
		//oBTree.AddNode(75);
		//oBTree.AddNode(60);
		//oBTree.AddNode(90);
		
		//oBTree.InOrder(oBTree.oRootNode, 0);
		
		// 	int InOrder(Node oStartNode, int iLevel)
		//	boolean AddNode(int iNewNode)
		
		
		//	Its the same as regular in-order add into a binary tree except that you read from a file 
		//	and you need to handle the point when you see a -1 in the file
		//	-1 means that the previous node points to null
		
		//Tensor inputs = new Tensor();
		
		// Regression :	Y = f(w1.x1+w2.x2+b)
		// Sigmoid : 	
		/*
		 
		Point p1 = new Point(1,1);
		Point p2 = new Point(3,2);
		Point p3 = new Point(5,3);
		Point p4 = new Point(4,1);
		Point p5 = new Point(2,3);
		Point p6 = new Point(1,4);
				
		Vector<Point> points = new Vector<Point>();
		
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		points.add(p5);
		points.add(p6);
		maxPoints(points);
		System.out.println("END");
	
		*/
		
		/*
		Vector<Point[][]> v1 = new Vector<Point[][]>();
		
		Point[][] pmulti = new Point[][] {
			{p1,p2}
		};
		
		v1.add(pmulti);
		*/
		//Map<Integer,Vector<Point[][]>> m1 = new HashMap<Integer,Vector<Point[][]>>();
		//m1.put(0,v1);
		//m1.put(1,v1);
		/*
		
		BTree oBTree = new BTree(10);
		
		//System.out.println(oBTree.oRootNode.iNodeVar);
		
		//Node oNewNode = new Node(5);
		
		//oBTree.AddNode(oNewNode);
		oBTree.AddNode(5);
		//System.out.println(oBTree.oRootNode.oLeftNode.iNodeVar);
		
		oBTree.AddNode(15);
		//System.out.println(oBTree.oRootNode.oRightNode.iNodeVar);
		
		oBTree.AddNode(1);
		//System.out.println(oBTree.oRootNode.oLeftNode.oLeftNode.iNodeVar);
		
		oBTree.AddNode(8);
		
		oBTree.AddNode(13);
		
		oBTree.AddNode(20);
		
		oBTree.InOrder(oBTree.oRootNode, 0);
				
		System.out.println("BTREE ENDED");
		
		// LinkedList
		// RootNode.Next = Node1.Next = Node2
		// Processes & Threads
		// InterProcess Communication
		
		try {
				System.out.println(LocalDateTime.now());
				Thread.sleep(1000);
				System.out.println(LocalDateTime.now());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HelloRunnable oThread1 = new HelloRunnable();
		oThread1.run();
		
		HelloRunnable oThread2 = new HelloRunnable();
		oThread2.run();
		
		
		System.out.println("EXIT");
		
		MyLinkedList oMyLinkedList = new MyLinkedList(1);
		
		oMyLinkedList.AddLLNode(2);
		
		oMyLinkedList.AddLLNode(3);
		
		oMyLinkedList.AddLLNode(4);
		
		oMyLinkedList.PrintMyLinkedList();
		
		*/
		
		//int arr1[] = new int[]{1,5,6,10};		
		//int arr2[] = new int[]{3,7};
		
		//double dVarTemp = findMedianSortedArrays(arr1,arr2);
		
		//System.out.println(dVarTemp);
		
		//int[] A = {2,-1,2};
		//int K=3;
		
		//	2			Sum = 2
		//	-1			Sum = -1
		//	2			Sum = 2
		
		//	2	-1	= 	Sum = 1
		//	-1	2	= 	Sum = 1
		
		//	2	-1	2	Sum = 3
		
		//int sum = shortestSubarray(A, K);
		
		
		
		
	
	}
}

