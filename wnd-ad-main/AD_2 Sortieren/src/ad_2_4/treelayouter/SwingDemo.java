package ad_2_4.treelayouter;

import org.abego.treelayout.TreeForTreeLayout;
import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.util.DefaultConfiguration;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;


public class SwingDemo {


    private static void showInDialog(String title, JComponent panel) {
        JDialog dialog = new JDialog();
        dialog.setTitle(title);
        Container contentPane = dialog.getContentPane();
        ((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder(
                20, 20, 20, 20));
        contentPane.setBackground(Color.WHITE);
        contentPane.add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    private static void showInDialog(JComponent panel) {
        showInDialog(" ",panel);
    }

    private static TreeForTreeLayout<TextInBox> getSampleTree(String treeName) throws FileNotFoundException {
        TreeForTreeLayout<TextInBox> tree= SampleTreeFactory.createSampleTree(treeName);
        return tree;
    }

    /**
     * Shows a dialog with a tree in a layout created by
     * using the Swing component.
     *
     * @param args args[0]: treeName (default="")
     */
    public static void main(String[] args) throws FileNotFoundException {
        // get the sample tree
        String treeName = args[0];
        String prefix = "treespecs/";
        // out/production/AD_2_Sortieren/treespecs/heaporderedsample
        TreeForTreeLayout<TextInBox> tree = getSampleTree(prefix+treeName);

        // setup the tree layout configuration
        double gapBetweenLevels = 50;
        double gapBetweenNodes = 10;
        DefaultConfiguration<TextInBox> configuration = new DefaultConfiguration<TextInBox>(
                gapBetweenLevels, gapBetweenNodes);

        // create the NodeExtentProvider for TextInBox nodes
        TextInBoxNodeExtentProvider nodeExtentProvider = new TextInBoxNodeExtentProvider();

        // create the layout
        TreeLayout<TextInBox> treeLayout = new TreeLayout<TextInBox>(tree,
                nodeExtentProvider, configuration);

        // Create a panel that draws the nodes and edges and show the panel
        TextInBoxTreePane panel = new TextInBoxTreePane(treeLayout);
        showInDialog(panel);
    }

    public static <Key extends Comparable<? super Key>> void showTreeUI(String title, Key[] heap){
        TreeForTreeLayout<TextInBox> tree = SampleTreeFactory.getSampleTreeFromHeap(heap);

        // setup the tree layout configuration
        double gapBetweenLevels = 50;
        double gapBetweenNodes = 10;
        DefaultConfiguration<TextInBox> configuration = new DefaultConfiguration<TextInBox>(
                gapBetweenLevels, gapBetweenNodes);

        // create the NodeExtentProvider for TextInBox nodes
        TextInBoxNodeExtentProvider nodeExtentProvider = new TextInBoxNodeExtentProvider();

        // create the layout
        TreeLayout<TextInBox> treeLayout = new TreeLayout<TextInBox>(tree,
                nodeExtentProvider, configuration);

        // Create a panel that draws the nodes and edges and show the panel
        TextInBoxTreePane panel = new TextInBoxTreePane(treeLayout);
        showInDialog(title,panel);
    }
}