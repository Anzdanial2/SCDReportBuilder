import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LineChart extends JPanel{
    private ArrayList<ArrayList<Integer>> data;
    private ArrayList<String> xAxisLabels;
    private ArrayList<String> yAxisLabels;

    public LineChart(ArrayList<ArrayList<Integer>> data, ArrayList<String> xAxisLabels, ArrayList<String> yAxisLabels) {
        this.data = data;
        this.xAxisLabels = xAxisLabels;
        this.yAxisLabels = yAxisLabels;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int padding = 50;
        int dataWidth = width - 2 * padding;
        int dataHeight = height - 2 * padding;

        //Reconsider this again to do...
        int dataSize = data.get(0).size(); //Assuming all weeks have the same size

        // Draw x and y axes
        g.drawLine(padding, height - padding, padding, padding);
        g.drawLine(padding, height - padding, width - padding, height - padding);

        // Plot the points and connect with lines
        if (dataSize > 1) {
            int xInc = dataWidth / (dataSize - 1);
            //used maxYLabel instead of this bro
//            int maxData = data.stream().flatMap(List::stream).max(Integer::compare).orElse(0);

            // Draw x-axis labels and gridlines
            for (int i = 0; i < dataSize; i++) {
                String xLabel = xAxisLabels.get(i);
                int x = i * xInc + padding - 5;
                int y = height - padding + 15;
                g.drawString(xLabel, x, y);

                g.setColor(Color.BLACK);
                g.drawLine(i * xInc + padding, height - padding, i * xInc + padding, padding);
            }

            // Draw y-axis labels and gridlines
//            for (int i = 0; i < 6; i++) {
//                String yLabel = String.valueOf((maxData / 5) * i);
//                int x = padding - 30;
//                int y = height - padding - i * (dataHeight / 5);
//                g.drawString(yLabel, x, y);
//
//                g.setColor(Color.BLACK);
//                g.drawLine(padding, height - padding - i * (dataHeight / 5), width - padding, height - padding - i * (dataHeight / 5));
//            }
            // Draw y-axis labels and gridlines
            for (int i = 0; i < yAxisLabels.size(); i++) {
                String yLabel = yAxisLabels.get(i);
                int x = padding - 30;
                int y = height - padding - i * (dataHeight / (yAxisLabels.size() - 1));
                g.drawString(yLabel, x, y);

                g.setColor(Color.BLACK);
                g.drawLine(padding, height - padding - i * (dataHeight / (yAxisLabels.size() - 1)), width - padding, height - padding - i * (dataHeight / (yAxisLabels.size() - 1)));
            }

            //commented this and above aik or
            // Draw the last label on the y-axis
//            String lastYLabel = String.valueOf(maxData);
//            int lastY = padding - 30;
//            g.drawString(lastYLabel, lastY, padding);

            for (int j = 0; j < data.size(); j++) {
                ArrayList<Integer> weekData = data.get(j);

                for (int i = 0; i < dataSize - 1; i++) {
                    int x1 = i * xInc + padding;
                    int maxYLabel = Integer.parseInt(yAxisLabels.get(yAxisLabels.size() - 1));
                    //here changed maxData--->120 now maxYLabel
                    int y1 = height - weekData.get(i) * dataHeight / maxYLabel - padding;
                    int x2 = (i + 1) * xInc + padding;
                    int y2 = height - weekData.get(i + 1) * dataHeight / maxYLabel - padding;

                    g.setColor(getLineColor(j));
                    g.drawLine(x1, y1, x2, y2);

                    // Draw data points
                    g.setColor(getPointColor(j));
                    g.fillOval(x1 - 2, y1 - 2, 4, 4);
                }
            }
        }
    }
    public Color getLineColor(int seriesIndex) {
        switch (seriesIndex) {
            case 0:
                return Color.BLUE;
            case 1:
                return Color.GREEN;
            default:
                return Color.BLACK;
        }
    }

    public Color getPointColor(int seriesIndex) {
        switch (seriesIndex) {
            case 0:
                return Color.RED;
            case 1:
                return Color.orange;
            // Add more cases for additional series
            default:
                return Color.BLACK;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Report Builder");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        ArrayList<String> xAxisLabels = new ArrayList<>();
        ArrayList<String> yAxisLabels = new ArrayList<>();

        ArrayList<Integer> week1Data = new ArrayList<>();
        week1Data.add(20);
        week1Data.add(30);
        week1Data.add(40);
        week1Data.add(25);
        week1Data.add(50);
        week1Data.add(30);
        week1Data.add(45);

        ArrayList<Integer> week2Data = new ArrayList<>();
        week2Data.add(15);
        week2Data.add(25);
        week2Data.add(40);
        week2Data.add(30);
        week2Data.add(20);
        week2Data.add(45);
        week2Data.add(90);

        xAxisLabels.add("Monday");
        xAxisLabels.add("Tuesday");
        xAxisLabels.add("Wednesday");
        xAxisLabels.add("Thursday");
        xAxisLabels.add("Friday");
        xAxisLabels.add("Saturday");
        xAxisLabels.add("Sunday");

        yAxisLabels.add("0");
        yAxisLabels.add("20");
        yAxisLabels.add("40");
        yAxisLabels.add("60");
        yAxisLabels.add("80");
        yAxisLabels.add("100");

        data.add(week1Data);
        data.add(week2Data);

        LineChart chart = new LineChart(data,xAxisLabels,yAxisLabels);
        chart.setPreferredSize(new Dimension(600, 400));
        frame.add(chart);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
