/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.UI.Chart.chat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;
import src.UI.Chart.blankchart.BlankPlotChart;
import src.UI.Chart.blankchart.BlankPlotChatRender;
import src.UI.Chart.blankchart.SeriesSize;
import javax.swing.SwingUtilities;

/**
 *
 * @author WINDOWS 10
 */
public class Chart extends javax.swing.JPanel {
    private List<ModelLegend> legends = new ArrayList<>();
    private List<ModelChart> model = new ArrayList<>();
    private final int seriesSize = 12;
    private final int seriesSpace = 6;
    
    private List<Color> colorList = new ArrayList<>();
    
    public List<ModelChart> getModel() {
        return model;
    }

    public void setModel(List<ModelChart> model) {
        this.model = model;
    }

    public JPanel getPanelLegend() {
        return panelLegend;
    }

    /**
     * Creates new form Chart
     */
    public void setPanelLegend(JPanel panelLegend) {    
        this.panelLegend = panelLegend;
    }

    public Chart() {
        initComponents();   
        
        blankPlotChart1.setBlankPlotChatRender(new BlankPlotChatRender() {
            @Override
            public String getLabelText(int index) {
                return model.get(index).getLabel();
            }

            @Override
            public void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index) {
                
                double totalSeriesWidth = (seriesSize * legends.size()) + (seriesSpace * (legends.size() - 1));
                double x = (size.getWidth() - totalSeriesWidth) / 2;
                double[] values = model.get(index).getValues(); // Get the values array for the current index
                double seriesValues = 0;
                for (int i = 0; i < legends.size(); i++) {
                    ModelLegend legend = legends.get(i);
                    g2.setColor(legend.getColor());
                    // Check if the values array has enough elements for the current legend
                    if (i < values.length) {
                        seriesValues = chart.getSeriesValuesOf(values[i], size.getHeight());
                        g2.fillRect((int) (size.getX() + x), (int) (size.getY() + size.getHeight() - seriesValues), seriesSize, (int) seriesValues);
                    }
                    x += seriesSpace + seriesSize;
                }
            }
        });
        
        colorList.add(Color.RED);
        colorList.add(Color.GREEN);
        colorList.add(Color.BLUE);
        colorList.add(Color.ORANGE);
        colorList.add(Color.YELLOW);
        colorList.add(Color.PINK);
        colorList.add(Color.CYAN);
        colorList.add(Color.MAGENTA);
        colorList.add(Color.GRAY);
        colorList.add(Color.DARK_GRAY);
        colorList.add(Color.LIGHT_GRAY);
        colorList.add(Color.BLACK);
        colorList.add(Color.WHITE);

        // Creating custom colors using RGB values
        colorList.add(new Color(255, 165, 0)); // Orange
        colorList.add(new Color(255, 105, 180)); // Hot Pink
        colorList.add(new Color(173, 216, 230)); // Light Blue
        colorList.add(new Color(240, 230, 140)); // Khaki
        
        colorList.add(new Color(128, 0, 128));   // Purple
        colorList.add(new Color(255, 20, 147));  // Deep Pink
        colorList.add(new Color(75, 0, 130));    // Indigo
        colorList.add(new Color(0, 128, 128));   // Teal
        colorList.add(new Color(255, 140, 0));   // Dark Orange
        colorList.add(new Color(0, 255, 255));   // Aqua
        colorList.add(new Color(127, 255, 212)); // Aquamarine
        colorList.add(new Color(210, 105, 30));  // Chocolate
        colorList.add(new Color(0, 100, 0));     // Dark Green
        colorList.add(new Color(106, 90, 205));  // Slate Blue

    }
    
    public void addLegend(String name, Color color) {
        ModelLegend data = new ModelLegend(name, color);
        legends.add(data);
        panelLegend.add(new LegendItem(data));
        panelLegend.repaint();
        panelLegend.revalidate();
    }

    public void addData(ModelChart data) {
        model.add(data);
        blankPlotChart1.setLabelCount(model.size());
        double max = data.getMaxValues();
        if (max > blankPlotChart1.getMaxValues()) {
            blankPlotChart1.setMaxValues(max);
        }
    }

    public List<Color> getColorList() {
        return colorList;
    }

    public void setColorList(List<Color> colorList) {
        this.colorList = colorList;
    }
    
    
    
    public int showData(){
        return model.size();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blankPlotChart1 = new src.UI.Chart.blankchart.BlankPlotChart();
        panelLegend = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelLegend.setOpaque(false);
        panelLegend.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(blankPlotChart1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLegend, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(blankPlotChart1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panelLegend, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private src.UI.Chart.blankchart.BlankPlotChart blankPlotChart1;
    private javax.swing.JPanel panelLegend;
    // End of variables declaration//GEN-END:variables
}
