/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzysets;
import java.awt.Color;
import java.io.File;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Bayot
 */
public class CreateJFreeChart {
    
    /*Establecemos los colores que tendran las líneas a grficar*/
    private static Color COLOR_SERIE_1 = new Color(255, 128, 64);
    private static Color COLOR_SERIE_2 = new Color(28, 84, 140);
    private static Color COLOR_RECUADROS_GRAFICA = new Color(31, 87, 4);
    private static Color COLOR_FONDO_GRAFICA = Color.white;

    /*Establecer propiedades de la gráfica: tipo, titulo, conjunto de valores, toltips, urls, etc.*/
    public JFreeChart crearGrafica(XYSeriesCollection dataset, String GraphTitle, double minRange, double maxRange) {

        final JFreeChart chart = ChartFactory.createXYLineChart(GraphTitle, "Valores de los conjuntos A y B", "Grados de pertenencia",
                dataset,
                PlotOrientation.VERTICAL,
                true, // uso de leyenda
                false, // uso de tooltips  
                false // uso de urls
        );
        // color de fondo de la gráfica
        chart.setBackgroundPaint(COLOR_FONDO_GRAFICA);

        //configuramos la variable para el contenido del gráfico
        final XYPlot plot = (XYPlot) chart.getPlot();
        configurarPlot(plot);

        //Creamos la variable para el eje X de la gráfica
        final NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        configurarDomainAxis(domainAxis, minRange, maxRange);

        //Creamos la variable del eje Y de la gráfica
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        configurarRangeAxis(rangeAxis);

        //Creamos la variable de las líneas que serán pintadas en la gráfica representando el conjunto de datos
        final XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        configurarRendered(renderer);

        return chart;
    }
	
	//Configuramos el contenido del gráfico (damos un color a las líneas que sirven de guía)
	private void configurarPlot(XYPlot plot) {
        plot.setDomainGridlinePaint(COLOR_RECUADROS_GRAFICA);
        plot.setRangeGridlinePaint(COLOR_RECUADROS_GRAFICA);
    }

    // configuramos el eje X de la gráfica (se muestran números de acuerdo a los valores y de uno en uno)
    private void configurarDomainAxis(NumberAxis domainAxis, double min, double max) {
        domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        domainAxis.setTickUnit(new NumberTickUnit(0.10));
        domainAxis.setRange(min, max);
    }

    //Configuramos el eje y de la gráfica (números enterosde acuerdo a conjunto de datos y rango entre 0 y 1)
    private void configurarRangeAxis(NumberAxis rangeAxis) {
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setTickUnit(new NumberTickUnit(1));
        rangeAxis.setRange(0, 1);
    }

    // configuramos las líneas de las series (añadimos un círculo en los puntos y asignamos el color de cada serie)
    private void configurarRendered(XYLineAndShapeRenderer renderer) {
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesShapesVisible(1, true);
        renderer.setSeriesPaint(0, COLOR_SERIE_1);
        renderer.setSeriesPaint(1, COLOR_SERIE_2);
    }
}
