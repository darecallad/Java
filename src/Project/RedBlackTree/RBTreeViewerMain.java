package Project.RedBlackTree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class RBTreeViewerMain extends JPanel{

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    // create object
    private RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
    private RBTreePanel RBTreePanel = new RBTreePanel(tree);

    // set up
    public RBTreeViewerMain(){
        RBTreePanel.setBackground(new Color(235, 225, 240));
        initViews();
    }

    // draw starting position mid point
    private void setMidPoint(JScrollPane scrollPane){
        scrollPane.getViewport().setViewPosition(new Point(4100, 0));

    }

    // set up the top panel
    // top panel object
    private void setTopPanel(){
        JLabel info = new JLabel(" HI! RED BLACK TREE ");
        info.setForeground(new Color(230, 220, 250));
        JPanel panel = new JPanel();
        panel.setBackground(new Color(130, 50, 250));
        panel.add(info);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(panel, BorderLayout.NORTH);
    }

    // set up bottom panel
    // bottom panel object
    private void setBottomPanel(){
        final JTextField mTextField = new JTextField(15); //size
        final JButton btn_ins = new JButton();
        setupButton(btn_ins, "add");
        final JButton btn_del = new JButton();
        setupButton(btn_del, "del");
        final JButton btn_clr = new JButton();
        setupButton(btn_clr, "clr");
        final JButton btn_info = new JButton();
        setupButton(btn_info, "search");

        // set up panel bottom function and background color
        JPanel panel = new JPanel();
        panel.add(btn_info);
        panel.add(btn_ins);
        panel.add(mTextField);
        panel.add(btn_del);
        panel.add(btn_clr);
        panel.setBackground(Color.WHITE);
        add(panel, BorderLayout.SOUTH);

        btn_ins.addActionListener(new ActionListener(){

            // copy from website
            // forget the link but this part is normal bottom action event
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                if(mTextField.getText().equals(""))
                    return;

                Integer toInsert = Integer.parseInt(mTextField.getText());
                if(tree.contains(toInsert)){
                    JOptionPane.showMessageDialog(null,
                            "The keyvalue is already exist.");
                }
                else{
                    tree.insert(toInsert);
                    RBTreePanel.repaint();
                    mTextField.requestFocus();
                    mTextField.selectAll();
                }

            }

        });
        /////////// action for botton
        // delete
        // add
        // clear
        // search

        btn_del.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent actionEvent){
                if(mTextField.getText().equals("")){
                    return;
                }

                Integer toDelete = Integer.parseInt(mTextField.getText());
                if(!tree.contains(toDelete)){
                    JOptionPane.showMessageDialog(null,
                            "Cannot find keyvalue in the tree");
                }
                else{
                    tree.remove(toDelete);
                    RBTreePanel.repaint();
                    mTextField.requestFocus();
                    mTextField.selectAll();
                }

            }

        });

        btn_clr.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent actionEvent){
                if(tree.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Tree is already empty");
                }
                else{
                    tree.clear();
                }

                RBTreePanel.setSearch(null);
                RBTreePanel.repaint();
            }
        });

        btn_info.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent actionEvent){

                if(mTextField.getText().equals(""))
                    return;

                Integer toSearch = Integer.parseInt(mTextField.getText());
                if(!tree.contains(toSearch)){
                    JOptionPane.showMessageDialog(null,
                            "Cannot find the Node contain that Keyvalue.");
                }
                else{
                    RBTreePanel.setSearch(toSearch);
                    RBTreePanel.repaint();
                    mTextField.requestFocus();
                    mTextField.selectAll();
                }
            }

        });

        mTextField.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent actionEvent){
                btn_ins.doClick();
            }

        });

    }

    // Scrollpane
    // this is new, so I try it up
    // hope it works
    // set up SCROLL PANE
    private void setScrollPane(){
        RBTreePanel.setPreferredSize(new Dimension(9000, 4096));

        // create  object
        // and object name
        // setting size
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(RBTreePanel);
        scroll.setPreferredSize(new Dimension(750, 500));
        setMidPoint(scroll);
        add(scroll, BorderLayout.CENTER);
    }
///////

    private void initViews(){
        super.setLayout(new BorderLayout());
        setScrollPane();
        setTopPanel();
        setBottomPanel();
    }

    // bottom set up
    // using try catch (easy way... and idk other way to do it
    private void setupButton(JButton button, String imgSrc){
        try{
            //resources file .png
            Image icon = ImageIO.read(getClass().getResource(
                    "/resources/" + imgSrc + ".png"));
            button.setIcon(new ImageIcon(icon));
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // main function
    public static void main(String... args){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
        }

        JFrame j = new JFrame();
        j.setTitle("THIS IS A TREE");

        try{
            j.setIconImage(ImageIO.read(RBTreeViewerMain.class.getResource("/resources/ic_binary.png")));
        }catch (IOException e){
            e.printStackTrace();
        }

        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.add(new RBTreeViewerMain());
        j.pack();
        j.setVisible(true);


    }
}