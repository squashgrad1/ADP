package ad_2_4.treelayouter;

import org.abego.treelayout.TreeForTreeLayout;
import org.abego.treelayout.util.DefaultTreeForTreeLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Creates "Sample" trees from files
 *
 * @author Birgit Wendholt
 */
public class SampleTreeFactory {
    private static final int NODE_WIDTH = 36;
    private static final int NODE_HEIGHT = 20;


    public static <Key extends Comparable<? super Key>> TreeForTreeLayout<TextInBox> getSampleTreeFromHeap(Key[] heap) {

        TextInBox[] tbHeap = new TextInBox[heap.length];

        for (int i =1; i < tbHeap.length; i++){
            tbHeap[i] = new TextInBox(heap[i].toString(),NODE_WIDTH,NODE_HEIGHT);
        }

        DefaultTreeForTreeLayout<TextInBox> tree = new DefaultTreeForTreeLayout<>(tbHeap[1]);
        for (int i =1; 2*i < tbHeap.length; i++){
            tree.addChild(tbHeap[i],tbHeap[2*i]);
            if (2*i+1 < tbHeap.length) {
                tree.addChild(tbHeap[i],tbHeap[2*i+1]);
            }
        }
        return tree;
    }



    public static TreeForTreeLayout<TextInBox> getSampleTree(String nodes, String edges) {
        String[] nodeAry = nodes.split(" ");

        Map<String, TextInBox> nodeTable = new HashMap<>();
        // Root
        nodeTable.put(nodeAry[1],  new TextInBox(nodeAry[1], NODE_WIDTH, NODE_HEIGHT));
        DefaultTreeForTreeLayout<TextInBox> tree = new DefaultTreeForTreeLayout<>(nodeTable.get(nodeAry[1]));

        for (int i =2; i < nodeAry.length; i++) {
            nodeTable.put(nodeAry[i], new TextInBox(nodeAry[i],NODE_WIDTH,NODE_HEIGHT));
        }
        String[] edgeAry = edges.split(" ");
        createTree(tree,nodeTable,edgeAry);
        return tree;
    }

    public static TreeForTreeLayout<TextInBox> createSampleTree(String filename) throws FileNotFoundException {

        Scanner scan = new Scanner(new File(filename));
        Map<String, TextInBox> nodeTable = new HashMap<>();
        DefaultTreeForTreeLayout<TextInBox> tree = null;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] entries = line.split(" ");
            if (entries[0].equals("n")) {
                // Nodes
                if (tree == null) {
                    nodeTable.put(entries[1], new TextInBox(entries[1], NODE_WIDTH, NODE_HEIGHT));
                    tree = new DefaultTreeForTreeLayout<TextInBox>(nodeTable.get(entries[1]));
                }
                for (int i = 2; i < entries.length; i++) {
                    nodeTable.put(entries[i], new TextInBox(entries[i], NODE_WIDTH, NODE_HEIGHT));
                }
            } else if (entries[0].equals("e")) {
                if (tree == null) {
                    throw new IllegalStateException("root node does not exist");
                }
                // Edge
                createTree(tree, nodeTable,entries);

            }
        }
        return tree;
    }

    private static void createTree(DefaultTreeForTreeLayout<TextInBox> tree, Map<String, TextInBox> nodeTable, String[] edges){
        for (int p = 1; p < edges.length; p++) {
            String[] pair = edges[p].split("-");
            //System.out.println("Edge [" + pair[0]+","+ pair[1] +"]");
            TextInBox parentNode = nodeTable.get(pair[0]);
            if (parentNode == null) {
                throw new IllegalStateException(String.format("parent node %s does not exist", pair[0]));
            }
            TextInBox childNode = nodeTable.get(pair[1]);
            if (childNode == null) {
                throw new IllegalStateException(String.format("child node %s does not exist", pair[1]));
            }
            tree.addChild(parentNode, childNode);
        }
    }

}

