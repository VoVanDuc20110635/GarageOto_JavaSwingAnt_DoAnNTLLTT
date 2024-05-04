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
    private int hoverIndex = -1;
    private int selectedIndex = -1;
    
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
        
        model = new ArrayList<>();
        setForeground(new Color(60, 60, 60));

        MouseAdapter mouseEvent = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int index = checkMouseHover(e.getPoint().x, e.getPoint().y);
                if (index != hoverIndex) {
                    hoverIndex = index;
                    repaint();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int index = checkMouseHover(e.getPoint().x, e.getPoint().y);
                    if (index != -1) {
                        if (index != selectedIndex) {
                            selectedIndex = index;
                        } else {
                            selectedIndex = -1;
                        }
                        repaint();
                    }
                }
            }
        };
        addMouseListener(mouseEvent);
        addMouseMotionListener(mouseEvent);
        
       
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
    
    private int checkMouseHover(int mouseX, int mouseY) {
        int index = -1;
        double barWidth = calculateBarWidth();
        double x = calculateStartingX();
        for (int i = 0; i < model.size(); i++) {
            ModelChart data = model.get(i);
            Rectangle barBounds = new Rectangle((int)x, calculateY(data), (int)barWidth, calculateHeight(data));
            if (barBounds.contains(mouseX, mouseY)) {
                index = i;
                break;
            }
            x += barWidth + calculateSpacing();
        }
        return index;
    }

    // Dummy methods for calculating bar dimensions - you'll need to implement these based on your data and chart size
    private double calculateBarWidth() {
        return 50; // Example fixed width
    }

    private double calculateStartingX() {
        return 10; // Example starting X position
    }

    private int calculateY(ModelChart data) {
        // Calculate the Y position based on the data value
        return 100; // Example Y position
    }

    private int calculateHeight(ModelChart data) {
        // Calculate the height of the bar based on the data value
        return 50; // Example height
    }

    private double calculateSpacing() {
        return 10; // Example spacing between bars
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
