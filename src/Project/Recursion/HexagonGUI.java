package Project.Recursion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HexagonGUI extends JPanel implements ActionListener {
    //set Buttons = null
    JButton previous = null;
    JButton next = null;

    static List<String[]> solutionList = new LinkedList<String[]>();
    // store solution
    static String[]currSolution = null;
    // current solution
    static int Numberofsolution = 1;
    // indicates souldtions displaded by numbers

    static Map<Character, Color> colorMap = new HashMap<Character, Color>();

    private final static int Radius = 80;
    // redius of hexagons
    private final static int Height = (int)((Radius / 2) * Math.sqrt(3));
    // triangle's height -> hexagon
    //

    public HexagonGUI(){
        super();

        // color map
        // http://www.java2s.com/Code/Java/2D-Graphics-GUI/ColorFactory.htm
        // colorMap.put("red", Color.RED
        colorMap.put('R', Color.RED);
        colorMap.put('B', Color.BLUE);
        colorMap.put('Y', Color.YELLOW);
        colorMap.put('G', Color.GREEN);
        colorMap.put('O', Color.ORANGE);
        colorMap.put('P', Color.MAGENTA);

        previous = new JButton("previous");
        previous.addActionListener(this);
        add(previous);

        next = new JButton("next");
        next.addActionListener(this);
        add(next);

        currSolution = solutionList.get(Numberofsolution -1);
        // get current solution
    }

    @Override
    // previous && next button
    // getting confused on java awp draw so I google a lots on it
    // http://www.xuebuyuan.com/965215.html   this is chinese web

    public void actionPerformed(ActionEvent ae){
        if((JButton)ae.getSource() == previous){
            Numberofsolution = (Numberofsolution == 1)? 1:(Numberofsolution -1); // yes a no b
            // get solution
            currSolution = solutionList.get(Numberofsolution -1);
        }
        else if ((JButton)ae.getSource() == next){
            Numberofsolution = (Numberofsolution == solutionList.size())? solutionList.size():(Numberofsolution +1); //
            // get solution
            currSolution = solutionList.get(Numberofsolution -1);
        }
        repaint();
    }

    // draw segment
    public void drawSegment(Graphics g, Polygon p, Color c){
        g.setColor(c);
        g.fillPolygon(p);
        g.setColor(Color.BLACK);
        g.drawPolygon(p);
    }

    // display the number on the hexagon
    public void displayNumber(Graphics g, String position, int x, int y){
        g.setFont(new Font("Arial", Font.BOLD, 60));
        // choose Arial
        g.setColor(Color.WHITE);
        g.drawString(position, x - 20, y + 20);
    }
    //**********************// problem // *******************
    // sloved but not 100% understand
    // match found then return the file position to function
    // otherwise move to next one
    //

    // find the position of hexagon from file
    //public String findpositionfromfile(String hexa){
    //	for(String str:Hexmain.originalPosInFile.keySet()){
    // Rotate hexa to match key in original file
    //		for(int i = 0; i < hexa.length(); i++){
    //			if(str.equals(hexa)){ // match found > return the position
    //				return Hexmain.originalPosInFile.get(str);
    //				}
    //			else{char ch = hexa.charAt(0);
    //			hexa = hexa.substring(1) + ch;
    //			}
    //		}

    //	}
    //	return "";
    //	}

    // draw hexagon
    // set up the x y
    // draw each hexagon
    // starting with position 0 to 5* 6
    public void drawHexagon(Graphics g, int x1, int y1, int position){
        // first : draw triangle
        int x2 = 300;
        int y2 = 300;
        int x3 = 300;
        int y3 = 300;
        // second: hexagon
        String hexa = currSolution[position];

        // ///////////////////////////////////
        // position [0]
        Polygon seg = new Polygon();
        seg = new Polygon();
        seg.addPoint(x1, y1);

        x2 = x1 - (Radius / 2);
        y2 = y1 - Height;
        seg.addPoint(x2, y2);

        x3 = x1 + (Radius / 2);
        y3 = y1 - Height;
        seg.addPoint(x3, y3);

        drawSegment(g, seg, colorMap.get(hexa.charAt(0)));
        /////////////////////////////////////////////////////
        // position [1]
        seg = new Polygon();
        seg.addPoint(x1, y1);

        x2 = x3;
        y2 = y3;
        seg.addPoint(x2, y2);

        x3 = x1 + Radius;
        y3 = y1;
        seg.addPoint(x3, y3);

        drawSegment(g, seg, colorMap.get(hexa.charAt(1)));
        /////////////////////////////////////////////////////
        // position [2]
        seg = new Polygon();
        seg.addPoint(x1, y1);

        x2 = x3;
        y2 = y3;
        seg.addPoint(x2, y2);

        x3 = x1 + (Radius / 2);
        y3 = y1 + Height;
        seg.addPoint(x3, y3);

        drawSegment(g, seg, colorMap.get(hexa.charAt(2)));
        /////////////////////////////////////////////////////
        // position [3]
        seg = new Polygon();
        seg.addPoint(x1, y1);

        x2 = x3;
        y2 = y3;
        seg.addPoint(x2, y2);

        x3 = x1 - (Radius / 2);
        y3 = y1 + Height;
        seg.addPoint(x3, y3);

        drawSegment(g, seg, colorMap.get(hexa.charAt(3)));
        /////////////////////////////////////////////////////
        // position [4]
        seg = new Polygon();
        seg.addPoint(x1, y1);

        x2 = x3;
        y2 = y3;
        seg.addPoint(x2, y2);

        x3 = x1 - Radius;
        y3 = y1;
        seg.addPoint(x3, y3);

        drawSegment(g, seg, colorMap.get(hexa.charAt(4)));
        /////////////////////////////////////////////////////
        // position [5]
        seg = new Polygon();
        seg.addPoint(x1, y1);

        x2 = x3;
        y2 = y3;
        seg.addPoint(x2, y2);

        x3 = x1 - (Radius / 2);
        y3 = y1 - Height;
        seg.addPoint(x3, y3);

        drawSegment(g, seg, colorMap.get(hexa.charAt(5)));
        /////////////////////////////////////////////////////
        // display number on hexagon

        //displayNumber(g, findpositionfromfile(hexa), x1, y1);
        // *********problem******** cannot display white number
    }

    // draw solution
    // ************problem**********
    // tiles 0,1 wrong size *sloved (position[0] was wrong for y3

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int x1 = 300;
        int y1 = 300;

        // draw centerHexagon [0]
        drawHexagon(g, x1, y1, 0);
        // top [1]
        drawHexagon(g, x1, (y1 - (2 * Height)) - 5, 1);
        // [2] topright
        drawHexagon(g, (x1 + ((3 * Radius) / 2) + 5), (y1 - Height - 2), 2);
        // [3] bottomright
        drawHexagon(g, (x1 + ((3 * Radius) / 2) + 5), (y1 + Height + 2), 3);
        // [4] bottom
        drawHexagon(g, x1, (y1 + (2 * Height) + 5), 4);
        // [5] bottomleft
        drawHexagon(g, (x1 - ((3 * Radius) / 2) - 5), (y1 + Height) + 2, 5);
        // [6] topleft
        drawHexagon(g, (x1 - ((3 * Radius) / 2) - 5), (y1 - Height - 2), 6);
    }
    ////////////////////
    // https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html

    public static void main(String[] args){
        // readfile and soultion
        // call
        Hexmain.start();
        if(Hexmain.solution.isEmpty()){
            System.out.println("No Solution. ");
        }
        else{
            for(String solution: Hexmain.solution){
                String[] temp = solution.split("\n");

                String[] hexagons = new String[7];
                // from soultion get hexagon
                for(int i = 0; i < temp.length; i++){
                    // get color sequence from string
                    String segments = temp[i].substring(temp[i].indexOf(": ") + 2);
                    hexagons[i] = segments;
                }
                // put the solution to list
                solutionList.add(hexagons);
            }
        }

        // Create object
        HexagonGUI h = new HexagonGUI();
        // Create Frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // draw hexa
        frame.add(h);
        frame.setVisible(true);
        //frame.setVisible(false);
    }
}
