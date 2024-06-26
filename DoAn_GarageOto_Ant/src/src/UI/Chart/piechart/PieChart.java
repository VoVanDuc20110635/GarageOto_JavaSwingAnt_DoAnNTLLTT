/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.UI.Chart.piechart;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
/**
 *
 * @author WINDOWS 10
 */
public class PieChart extends JComponent{
    private final List<ModelPieChart> models;
    private final DecimalFormat format = new DecimalFormat("#,##0.#");
    private PeiChartType chartType = PeiChartType.DEFAULT;
    private int selectedIndex = -1;
    private int hoverIndex = -1;
    private float borderHover = 0.05f;
    private float padding = 0.2f;
    
    private List<Color> colorList = new ArrayList<>();
    
    public void setModelsEmpty(){
        models.clear();
    }
    
    public PieChart() {
        models = new ArrayList<>();
        setForeground(new Color(60, 60, 60));
        MouseAdapter mouseEvent = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int index = checkMouseHover(e.getPoint());
                if (index != hoverIndex) {
                    hoverIndex = index;
                    repaint();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int index = checkMouseHover(e.getPoint());
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
        
        // Adding 20 more colors
        colorList.add(new Color(255, 165, 0));   // Orange
        colorList.add(new Color(255, 215, 0));   // Gold
        colorList.add(new Color(218, 165, 32));  // Golden Rod
        colorList.add(new Color(220, 20, 60));   // Crimson
        colorList.add(new Color(95, 158, 160));  // Cadet Blue
        colorList.add(new Color(0, 206, 209));   // Dark Turquoise
        colorList.add(new Color(148, 0, 211));   // Dark Violet
        colorList.add(new Color(255, 99, 71));   // Tomato
        colorList.add(new Color(64, 224, 208));  // Turquoise
        colorList.add(new Color(244, 164, 96));  // Sandy Brown
        colorList.add(new Color(210, 180, 140)); // Tan
        colorList.add(new Color(255, 105, 180)); // Hot Pink
        colorList.add(new Color(112, 128, 144)); // Slate Gray
        colorList.add(new Color(255, 228, 181)); // Moccasin
        colorList.add(new Color(32, 178, 170));  // Light Sea Green
        colorList.add(new Color(47, 79, 79));    // Dark Slate Gray
        colorList.add(new Color(0, 128, 0));     // Green
        colorList.add(new Color(72, 61, 139));   // Dark Slate Blue
        colorList.add(new Color(143, 188, 143)); // Dark Sea Green
        colorList.add(new Color(60, 179, 113));  // Medium Sea Green
        
        colorList.add(new Color(255, 0, 0));     // Red
        colorList.add(new Color(0, 0, 255));     // Blue
        colorList.add(new Color(0, 128, 0));     // Green (Duplicate, consider removing or replacing)
        colorList.add(new Color(255, 255, 0));   // Yellow
        colorList.add(new Color(0, 0, 0));       // Black
        colorList.add(new Color(255, 255, 255)); // White
        colorList.add(new Color(128, 0, 0));     // Maroon
        colorList.add(new Color(128, 128, 0));   // Olive
        colorList.add(new Color(0, 128, 128));   // Teal (Duplicate, consider removing or replacing)
        colorList.add(new Color(0, 0, 128));     // Navy
        colorList.add(new Color(139, 69, 19));   // Saddle Brown
        colorList.add(new Color(255, 69, 0));    // Orange Red
        colorList.add(new Color(75, 0, 130));    // Indigo (Duplicate, consider removing or replacing)
        colorList.add(new Color(255, 20, 147));  // Deep Pink (Duplicate, consider removing or replacing)
        colorList.add(new Color(123, 104, 238)); // Medium Slate Blue
        colorList.add(new Color(0, 191, 255));   // Deep Sky Blue
        colorList.add(new Color(34, 139, 34));   // Forest Green
        colorList.add(new Color(255, 127, 80));  // Coral
        colorList.add(new Color(188, 143, 143)); // Rosy Brown
        colorList.add(new Color(153, 50, 204));  // Dark Orchid
        colorList.add(new Color(233, 150, 122)); // Dark Salmon
        colorList.add(new Color(250, 128, 114)); // Salmon
        colorList.add(new Color(244, 102, 27));  // Vermilion
        colorList.add(new Color(255, 182, 193)); // Light Pink
        colorList.add(new Color(30, 144, 255));  // Dodger Blue
        colorList.add(new Color(210, 180, 222)); // Thistle
        colorList.add(new Color(107, 142, 35));  // Olive Drab
        colorList.add(new Color(102, 205, 170)); // Medium Aquamarine
        colorList.add(new Color(0, 255, 127));   // Spring Green
        colorList.add(new Color(70, 130, 180));  // Steel Blue

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double width = getWidth();
        double height = getHeight();
        float p = borderHover;
        double size = Math.min(width, height);
        size -= (size * p) + padding * size;
        double x = (width - size) / 2;
        double y = (height - size) / 2;
        double centerX = width / 2;
        double centerY = height / 2;
        double totalValue = getTotalvalue();
        double drawAngle = 90;
        float fontSize = (float) (getFont().getSize() * size * 0.0045f);
        if (hoverIndex >= 0) {
            g2.setColor(models.get(hoverIndex).getColor());
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
            g2.fill(createShape(hoverIndex, 0, borderHover));
        }
        if (selectedIndex >= 0) {
            g2.setColor(models.get(selectedIndex).getColor());
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            g2.fill(createShape(selectedIndex, 0.018f, borderHover));
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        for (int i = 0; i < models.size(); i++) {
            ModelPieChart data = models.get(i);
            double angle = data.getValues() * 360 / totalValue;
            Area area = new Area(new Arc2D.Double(x, y, size, size, drawAngle, -angle, Arc2D.PIE));
            if (chartType == PeiChartType.DONUT_CHART) {
                double s1 = size * 0.5f;
                double x1 = (width - s1) / 2;
                double y1 = (height - s1) / 2;
                area.subtract(new Area(new Ellipse2D.Double(x1, y1, s1, s1)));
            }
            g2.setColor(data.getColor());
            g2.fill(area);
            g2.setColor(Color.WHITE);
            g2.draw(area);
            drawAngle -= angle;
        }
        drawAngle = 90;
        for (int i = 0; i < models.size(); i++) {
            ModelPieChart data = models.get(i);
            double angle = data.getValues() * 360 / totalValue;
            //  Draw Text
            double textSize = size / 2 * 0.75f;
            double textAngle = -(drawAngle - angle / 2);
            double cosX = Math.cos(Math.toRadians(textAngle));
            double sinY = Math.sin(Math.toRadians(textAngle));
            String text = getPercentage(data.getValues()) + "%";
            g2.setFont(getFont().deriveFont(fontSize));
            FontMetrics fm = g2.getFontMetrics();
            Rectangle2D r = fm.getStringBounds(text, g2);
            double textX = centerX + cosX * textSize - r.getWidth() / 2;
            double textY = centerY + sinY * textSize + fm.getAscent() / 2;
            g2.setColor(Color.WHITE);
            g2.drawString(text, (float) textX, (float) textY);
            //  Draw label
            if (hoverIndex == i) {
                double labelSize = size / 2;
                double labelX = centerX + cosX * labelSize;
                double labelY = centerY + sinY * labelSize;
                String detail = format.format(data.getValues()) + " (" + text + ")";
                drawPopupLabel(g2, size, textAngle, labelX, labelY, data.getName(), detail);
            }
            drawAngle -= angle;
        }

        g2.dispose();
        super.paintComponent(g);
    }

    private void drawPopupLabel(Graphics2D g2, double size, double angle, double labelX, double labelY, String text, String detail) {
        float fontSize = (float) (getFont().getSize() * size * 0.0035f);
        boolean up = !(angle > 0 && angle < 180);
        double space = size * 0.03f;
        double spaceV = size * 0.01f;
        double paceH = size * 0.01f;
        FontMetrics fm1 = g2.getFontMetrics(getFont().deriveFont(Font.PLAIN, fontSize));
        FontMetrics fm2 = g2.getFontMetrics(getFont().deriveFont(Font.BOLD, fontSize));
        Rectangle2D r1 = fm1.getStringBounds(text, g2);
        Rectangle2D r2 = fm1.getStringBounds(detail, g2);
        double width = Math.max(r1.getWidth() + paceH * 2, r2.getWidth() + paceH * 2);
        double height = r1.getHeight() + r2.getHeight() + spaceV * 2;
        double recY = up ? labelY - height - space : labelY + space;
        double recX = labelX -= width / 2;
        g2.setColor(Color.WHITE);
        RoundRectangle2D rec = new RoundRectangle2D.Double(recX, recY, width, height, 5, 5);
        g2.fill(rec);
        g2.setColor(new Color(235, 235, 235));
        g2.draw(rec);
        g2.setColor(getForeground());
        recX += paceH;
        g2.setFont(getFont().deriveFont(Font.PLAIN, fontSize));
        g2.drawString(text, (float) recX, (float) (recY + fm1.getAscent() + spaceV));
        g2.setFont(getFont().deriveFont(Font.BOLD, fontSize));
        g2.drawString(detail, (float) recX, (float) (recY + height - r2.getHeight() + fm2.getAscent() - spaceV));

    }

    private Shape createShape(int index, float a, float p) {
        Shape shape = null;
        double width = getWidth();
        double height = getHeight();
        double size = Math.min(width, height);
        size -= (size * a) + (padding * size);
        double x = (width - size) / 2;
        double y = (height - size) / 2;
        double totalValue = getTotalvalue();
        double drawAngle = 90;
        for (int i = 0; i < models.size(); i++) {
            double angle = models.get(i).getValues() * 360 / totalValue;
            if (index == i) {
                Area area = new Area(new Arc2D.Double(x, y, size, size, drawAngle, -angle, Arc2D.PIE));
                size -= size * p - size * a * 2;
                x = (width - size) / 2;
                y = (height - size) / 2;
                area.subtract(new Area(new Arc2D.Double(x, y, size, size, drawAngle, -angle, Arc2D.PIE)));
                shape = area;
                break;
            }
            drawAngle -= angle;
        }
        return shape;
    }

    private String getPercentage(double value) {
        double total = getTotalvalue();
        return format.format(value * 100 / total);
    }

    private int checkMouseHover(Point point) {
        int index = -1;
        double width = getWidth();
        double height = getHeight();
        float p = borderHover;
        double size = Math.min(width, height);
        size -= (size * p) + padding * size;
        double x = (width - size) / 2;
        double y = (height - size) / 2;
        double totalValue = getTotalvalue();
        double drawAngle = 90;
        for (int i = 0; i < models.size(); i++) {
            ModelPieChart data = models.get(i);
            double angle = data.getValues() * 360 / totalValue;
            Area area = new Area(new Arc2D.Double(x, y, size, size, drawAngle, -angle, Arc2D.PIE));
            if (chartType == PeiChartType.DONUT_CHART) {
                double s1 = size * 0.5f;
                double x1 = (width - s1) / 2;
                double y1 = (height - s1) / 2;
                area.subtract(new Area(new Ellipse2D.Double(x1, y1, s1, s1)));
            }
            if (area.contains(point)) {
                index = i;
                break;
            }
            drawAngle -= angle;
        }
        return index;
    }

    private double getTotalvalue() {
        double max = 0;
        for (ModelPieChart data : models) {
            max += data.getValues();
        }
        return max;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        if (selectedIndex >= -1 && selectedIndex < models.size()) {
            this.selectedIndex = selectedIndex;
            repaint();
        }
    }

    public int getHoverIndex() {
        return hoverIndex;
    }

    public float getBorderHover() {
        return borderHover;
    }

    public void setBorderHover(float borderHover) {
        this.borderHover = borderHover;
        repaint();
    }

    public float getPadding() {
        return padding;
    }

    public void setPadding(float padding) {
        this.padding = padding;
        repaint();
    }

    public PeiChartType getChartType() {
        return chartType;
    }

    public void setChartType(PeiChartType chartType) {
        this.chartType = chartType;
        repaint();
    }

    public void clearData() {
        models.clear();
        repaint();
    }

    public void addData(ModelPieChart data) {
        models.add(data);
    }

    public static enum PeiChartType {
        DEFAULT, DONUT_CHART
    }
    
    public List<Color> getColorList() {
        return colorList;
    }

    public void setColorList(List<Color> colorList) {
        this.colorList = colorList;
    }
    
}
