/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzysets;
import javax.swing.JOptionPane;
import UserView.InputData;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.text.DecimalFormat;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import UserView.FuzzyCalculus;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author OscarMoralesBeltran
 */
public class FuzzyOperations {

    private final DecimalFormat df2 = new DecimalFormat("#.##");
    private final double LIMITE = 1;
    protected int Anumber;          
    private int Bnumber;            
    private double[] Aelements;     
    private double[] Belements;     
    private double[] AnewElements;  
    private double[] BnewElements;  
    private double[] Interseccion;  
    private double[] Union;         
    private double[] complementoA;  
    private double[] complementoB;  
    private String function;        
    private Double[] wrappedDoubles;
    private Object[] objetosdouble;
    
    //valores para las funciones de pertenencia (Piramidal, trapezoidal)
    private double limite_inferior; 
    private double limite_superior; 
    private double punto_medio;     
    private double limite_inferiorB;
    private double limite_superiorB;
    private double punto_medioB;    
    //valores complementarias, función trapezidal
    private double limite_inferior_soporte;
    private double limite_superior_soporte;
    private double limite_inferior_soporteB;
    private double limite_superior_soporteB;
    //valores complementarios, Función Gaussiana
    private double desviacion_estandar;
    double a = 0;
    double b = 0;
    
    
    public void verifyFunction(){
        setFunction(getSelectedFunction());
        if (getSelectedFunction() != null && !InputData.jTFA.getText().isEmpty() && !InputData.jTFB.getText().isEmpty()) {
            getSetsElements();
            InputData.btnAceptar.setEnabled(true);
            getParametersFunction();
        }else{
            JOptionPane.showMessageDialog(null, "Se requiere que seleccione una función de transferencia"
                    + "\n y que ingrese la contidad de elementos para los conjuntos", "Algunos campos importantes están vacios", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void establishCheckBoxes(){
        InputData.functionsGroup.add(InputData.radioTrapezoidal);
        InputData.functionsGroup.add(InputData.radioPiramidal);
        InputData.functionsGroup.add(InputData.radioCampana);
    }
    
    public String getSelectedFunction(){
        if (InputData.radioTrapezoidal.isSelected()) {
            return InputData.radioTrapezoidal.getText();
        }else if (InputData.radioPiramidal.isSelected()) {
            return InputData.radioPiramidal.getText();
        }else if (InputData.radioCampana.isSelected()) {
            return InputData.radioCampana.getText();
        }
        return null;
    }
    
    public void getSetsElements(){
            setAnumber(Integer.parseInt(InputData.jTFA.getText()));
            setBnumber(Integer.parseInt(InputData.jTFB.getText()));
            Aelements = getElements(getAnumber(), 'A');
            Belements = getElements(getBnumber(), 'B');
            AnewElements = new double[getAnumber()];
            BnewElements = new double[getBnumber()];
            Union = new double[getAnumber()];
            Interseccion = new double[getAnumber()];
            complementoA = new double[getAnumber()];
            complementoB = new double[getBnumber()];
    }
    
    private double[] getElements(int longitud, char a){
        String val;
        double[] values = new double[longitud];
        try{
            for (int i = 0; i < longitud; i++) {
                val = JOptionPane.showInputDialog(null, "Ingresa el valor del conjunto " + a, "Esperando valores", JOptionPane.INFORMATION_MESSAGE);
                values[i] = Double.parseDouble(val);
            }
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Entrada inválida --> " + nfe.getMessage(), "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
        return values;
    }
    
    private void convertPrimitiveToObject(double[] valores){
        wrappedDoubles = Arrays.stream(valores).boxed().toArray(Double[]::new);
        objetosdouble  = wrappedDoubles;
    }
    
    private double getMainValues(double[] arr, double var,String varName){
        convertPrimitiveToObject(arr);
        Object selectedValue = JOptionPane.showInputDialog(null, "Elige un valor para " + varName, "Valor a", JOptionPane.INFORMATION_MESSAGE
        , null,objetosdouble, objetosdouble[0]);
        JOptionPane.showMessageDialog(null, "El valor que seleccionaste fue --> " + selectedValue.toString());
        for (int i = 0; i < arr.length; i++) {
            if (selectedValue.equals(arr[i])) {
                var = arr[i];
                break;
            }
        }
        return var;
    }
    
    private void getParametersFunction(){
        switch(getSelectedFunction().toLowerCase()){
            case "trapezoidal":
                getLimitsVaues(1);
                trapezoidalOperations();
                callExtraFunction();
                break;
            case "piramidal":
                getLimitsVaues(0);
                piramidalOperations();
                callExtraFunction();
                break;
            case "campana":
                JOptionPane.showMessageDialog(null, "Datos para graficar el conjunto A","Valores de pertenencia",JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    
    private void universalOperations(){
        getIntersection_Union(Union, AnewElements, BnewElements, 0);
        getIntersection_Union(Interseccion, AnewElements, BnewElements, 1);
        getComplementoX(complementoA, AnewElements);
        getComplementoX(complementoB, BnewElements);
    }
    
    private void getLimitsVaues(int funcionType){
        JOptionPane.showMessageDialog(null, "Datos para graficar el conjunto A", "Valores de pertenencia", JOptionPane.INFORMATION_MESSAGE);
        setLimite_inferior(getMainValues(Aelements, limite_inferior, "a: limite inferior"));
        setPunto_medio(getMainValues(Aelements, punto_medio, "m: punto medio"));
        setLimite_superior(getMainValues(Aelements, limite_superior, "b: limite superior"));
        if (funcionType != 0) {
            setLimite_inferior_soporte(getMainValues(Aelements, limite_inferior_soporte, "a: limite de soporte inferior"));
            setLimite_superior_soporte(getMainValues(Aelements, limite_superior_soporte, "a: limite de soporte superior"));
        }
        JOptionPane.showMessageDialog(null, "Datos para graficar el conjunto B","Valores de pertenencia",JOptionPane.INFORMATION_MESSAGE);
        setLimite_inferiorB(getMainValues(Belements,limite_inferiorB, "a: limite inferior"));
        setPunto_medioB(getMainValues(Belements, punto_medioB, "m: punto medio"));
        setLimite_superiorB(getMainValues(Belements,limite_superiorB, "b: limite superior"));
        if (funcionType != 0) {
            setLimite_inferior_soporteB(getMainValues(Belements, limite_inferior_soporteB, "B: limite de soporte inferior"));
            setLimite_superior_soporteB(getMainValues(Belements, limite_superior_soporteB, "B: limite de soporte superior"));
        }
    }
    
    private void callExtraFunction(){
        arrayFormat(AnewElements);
        arrayFormat(BnewElements);
        universalOperations();
        arrayFormat(complementoA);
        arrayFormat(complementoB);
    }
    
    private void piramidalOperations(){
        double x;
        for (int i = 0; i < AnewElements.length; i++) {
            x = Aelements[i];
            if (x <= limite_inferior || x >= limite_superior) {
                AnewElements[i] = 0;
            }else if (limite_inferior < x || x <= punto_medio) {
                AnewElements[i] = (x - limite_inferior)/(punto_medio - limite_inferior);
            }else if (punto_medio < x || x < limite_superior) {
                AnewElements[i] = (limite_superior - x)/(limite_superior - punto_medio);
            }
        }
        
        for (int i = 0; i <BnewElements.length; i++) {
            x = Belements[i];
            if (x <= limite_inferiorB || x >= limite_superiorB) {
                BnewElements[i] = 0;
            }else if (limite_inferiorB < x || x <= punto_medioB) {
                BnewElements[i] = (x - limite_inferiorB)/(punto_medioB - limite_inferiorB);
            }else if (punto_medioB < x || x < limite_superiorB) {
                BnewElements[i] = (limite_superiorB - x)/(limite_superiorB - punto_medioB);
            }
        }
    }
    
    private void trapezoidalOperations(){
        double x;
        for (int i = 0; i < AnewElements.length; i++) {
            x = Aelements[i];
            if (x < limite_inferior || x > limite_superior) {
                AnewElements[i] = 0;
            }else if (limite_inferior <= x || x <= limite_superior) {
                AnewElements[i] = (x - limite_inferior)/(limite_superior - limite_inferior);
            }else if (limite_inferior_soporte <= x || x <= limite_superior_soporte) {
                AnewElements[i] = (limite_superior_soporte - x)/(limite_superior_soporte - limite_inferior_soporte);
            }else if (limite_superior <= x || x <= limite_inferior_soporte) {
                AnewElements[i] = 1;
            }
        }
        
        for (int i = 0; i < BnewElements.length; i++) {
            x = Belements[i];
            if (x < limite_inferiorB || x > limite_superiorB) {
                BnewElements[i] = 0;
                System.out.print(BnewElements[i]);
            }else if (limite_inferiorB <= x || x <= limite_superiorB) {
                BnewElements[i] = (x - limite_inferiorB)/(limite_superiorB - limite_inferiorB);
                System.out.print(BnewElements[i]);
            }else if (limite_inferior_soporteB <= x || x <= limite_superior_soporteB) {
                BnewElements[i] = (limite_superior_soporteB - x)/(limite_superior_soporteB - limite_inferior_soporteB);
                System.out.print(BnewElements[i]);
            }else if (limite_superiorB <= x || x <= limite_inferior_soporteB) {
                BnewElements[i] = 1;
                System.out.print(BnewElements[i]);
            }
        }
        System.out.println("");
    }
    
    private void getIntersection_Union(double[] arrResult, double[] arrBase1, double[] arrBase2, int bandera){
        for (int i = 0; i < getAnumber(); i++) {
            if (bandera == 0) {
                arrResult[i] = Math.max(arrBase1[i], arrBase2[i]);
            }else if (bandera == 1){
                arrResult[i] = Math.min(arrBase1[i], arrBase2[i]);
            }
        }
    }
    
    private void getComplementoX(double[] arrResult, double[] arrBase){
        for (int i = 0; i < arrBase.length; i++) {
            arrResult[i] = LIMITE - arrBase[i];
        }
    }
    
    private void arrayFormat(double[] arrValue){
        String[] arrNew = new String[arrValue.length];
        for (int i = 0; i < arrValue.length; i++) {
            arrNew[i] = df2.format(arrValue[i]);
            arrValue[i] = Double.parseDouble(arrNew[i]);
        }
    }
    
    public void showUI(){
        FuzzyCalculus fc = new FuzzyCalculus();
        fc.setVisible(true);
        if (getSelectedFunction() != null) {
            JOptionPane.showMessageDialog(null, "Si obtengo un mensaje");
        }
        switch(getSelectedFunction().toLowerCase()){
            case "trapezoidal":
                setTrapezoidalGraph(AnewElements[0], getLimite_inferior(), AnewElements[1], getLimite_inferior_soporte(), AnewElements[2], getLimite_superior_soporte(), AnewElements[3], getLimite_superior(), BnewElements[0], getLimite_inferiorB(), BnewElements[1], getLimite_inferior_soporteB(), BnewElements[2], getLimite_superior_soporteB(), BnewElements[3], getLimite_superiorB(), FuzzyCalculus.GraphPanel, FuzzyCalculus.GraphLevel, "Conjuntos A y B");
                setTrapezoidalGraph(complementoA[0], getLimite_inferior(), complementoA[1], getLimite_inferior_soporte(), complementoA[2], getLimite_superior_soporte(), complementoA[3], getLimite_superior(), complementoB[0], getLimite_inferiorB(), complementoB[1], getLimite_inferior_soporteB(), complementoB[2], getLimite_superior_soporteB(), complementoB[3], getLimite_superiorB(), FuzzyCalculus.GraphPanelComplement, FuzzyCalculus.GraphLavelComplement, "Complemento de los conjuntos A y B");
                showGP(AnewElements, FuzzyCalculus.LabelGPFuzzy, "Los valores de pertenencia del conjunto A son: {");
                showGP(BnewElements, FuzzyCalculus.LabelGPFuzzyB, "Los valores de pertenencia del conjunto B son: {");
                showGP(Union, FuzzyCalculus.LabelGPFuzzyUnion, "Los valores de unión son: {");
                showGP(Interseccion, FuzzyCalculus.LabelGPFuzzyInterseccion, "Los valores de intersección son: {");
                showGP(complementoA, FuzzyCalculus.LabelGPFuzzyComplementoA, "Complemento A: {");
                showGP(complementoB, FuzzyCalculus.LabelGPFuzzyComplementoB, "Complemento B: {");
                break;
            case "piramidal":
                setGraph(Aelements, AnewElements, Belements, BnewElements, FuzzyCalculus.GraphPanel, FuzzyCalculus.GraphLevel, "Unión de los conjuntos A y B");//unión
                setGraph(Aelements, complementoA, Belements, complementoB, FuzzyCalculus.GraphPanelComplement, FuzzyCalculus.GraphLavelComplement, "Complemento de los conjuntos A y B");//complemento
                showGP(AnewElements, FuzzyCalculus.LabelGPFuzzy, "Los valores de pertenencia del conjunto A son: {");
                showGP(BnewElements, FuzzyCalculus.LabelGPFuzzyB, "Los valores de pertenencia del conjunto B son: {");
                showGP(Union, FuzzyCalculus.LabelGPFuzzyUnion, "Los valores de unión son: {");
                showGP(Interseccion, FuzzyCalculus.LabelGPFuzzyInterseccion, "Los valores de intersección son: {");
                showGP(complementoA, FuzzyCalculus.LabelGPFuzzyComplementoA, "Complemento A: {");
                showGP(complementoB, FuzzyCalculus.LabelGPFuzzyComplementoB, "Complemento B: {");
                break;
            case "campana":
		//en desarrollo
                break;
        }
    }
    
    public void backToNew(){
        InputData in = new InputData();
        in.setVisible(true);
    }
    
    public void setGraph(double[] arrX, double[] arrY, double[] arrBX, double[] arrBY, JPanel p, JLabel lavel, String title){
        XYSeries serie1 = new XYSeries("Conjunto A");
        for (int i = 0; i < getAnumber(); i++) {
            serie1.add(arrX[i], arrY[i]);
        }
        
        
        XYSeries serie2 = new XYSeries("Conjunto B");
        for (int i = 0; i < getAnumber(); i++) {
            serie2.add(arrBX[i], arrBY[i]);
        }
        
        XYSeriesCollection colecion = new XYSeriesCollection();
        colecion.addSeries(serie1);
        colecion.addSeries(serie2);
        
        try{
            final CreateJFreeChart prueba = new CreateJFreeChart();
            final JFreeChart grafica = prueba.crearGrafica(colecion, title, getMinLimit(), getMaxLimit());
            BufferedImage graficoMuestra = grafica.createBufferedImage(600, 250);
            lavel.setSize(p.getSize());
            lavel.setIcon(new ImageIcon(graficoMuestra));
        }catch(Exception ex){
            ex.getMessage();
        }
    }
    
    private double getMinLimit(){
        if (getLimite_inferior() > getLimite_inferiorB()) {
            return getLimite_inferiorB();
        }else{
            return getLimite_inferior();
        }
    }
    
    private double getMaxLimit(){
        if (getLimite_superior() > getLimite_superiorB()) {
            return getLimite_superior();
        }else{
            return getLimite_superiorB();
        }
    }
    
    public void setTrapezoidalGraph(double a,double aX, double c,double cX, double d,double dX, double b,double bX, 
            double ba, double baX, double bc, double bcX, double bd, double bdX, double bb, double bbX, JPanel p, JLabel lavel, String title){
        XYSeries serie1 = new XYSeries("Conjunto A");
        serie1.add(aX, a);
        serie1.add(cX, c);
        serie1.add(dX, d);
        serie1.add(bX, b);
        
        
        XYSeries serie2 = new XYSeries("Conjunto B");
        serie2.add(baX, ba);
        serie2.add(bcX, bc);
        serie2.add(bdX, bd);
        serie2.add(bbX, bb);
        
        XYSeriesCollection colecion = new XYSeriesCollection();
        colecion.addSeries(serie1);
        colecion.addSeries(serie2);
        try{
            final CreateJFreeChart prueba = new CreateJFreeChart();
            final JFreeChart grafica = prueba.crearGrafica(colecion, title, getMinLimit(), getMaxLimit());
            BufferedImage graficoMuestra = grafica.createBufferedImage(600, 250);
            lavel.setSize(p.getSize());
            lavel.setIcon(new ImageIcon(graficoMuestra));
        }catch(Exception ex){
            ex.getMessage();
        }
    }
    
    private void showGP(double[] valoresConjuntoX,JLabel lavel, String cadena){
        String contenido = cadena;
        for (int i = 0; i < valoresConjuntoX.length; i++) {
            if (i == valoresConjuntoX.length-1) {
                contenido += valoresConjuntoX[i] + "}";
            }else{
                contenido += valoresConjuntoX[i] + " + ";
            }
        }
        lavel.setText(contenido);
    }
    
    /*Estos métodoso no son obligatorios aunque deben ser usados si dichas variables a los cuales
    * pertenecen serán usadas en clases distintas a esta
    */
    public void setAnumber(int a){
        Anumber = a;
    }
    
    public void setBnumber(int b){
        Bnumber = b;
    }
    
    public int getAnumber(){
        return Anumber;
    }
    
    public int getBnumber(){
        return Bnumber;
    }
    
    public void setFunction(String function){
        this.function = function;
    }
    
    public String getFunction(){
        return function;
    }

    public double getLimite_inferior() {
        return limite_inferior;
    }

    public void setLimite_inferior(double limite_inferior) {
        this.limite_inferior = limite_inferior;
    }

    public double getLimite_superior() {
        return limite_superior;
    }

    public void setLimite_superior(double limite_superior) {
        this.limite_superior = limite_superior;
    }

    public double getPunto_medio() {
        return punto_medio;
    }

    public void setPunto_medio(double punto_medio) {
        this.punto_medio = punto_medio;
    }

    public double getLimite_inferior_soporte() {
        return limite_inferior_soporte;
    }

    public void setLimite_inferior_soporte(double limite_inferior_soporte) {
        this.limite_inferior_soporte = limite_inferior_soporte;
    }

    public double getLimite_superior_soporte() {
        return limite_superior_soporte;
    }

    public void setLimite_superior_soporte(double limite_superior_soporte) {
        this.limite_superior_soporte = limite_superior_soporte;
    }

    public double getDesviacion_estandar() {
        return desviacion_estandar;
    }

    public void setDesviacion_estandar(double desviacion_estandar) {
        this.desviacion_estandar = desviacion_estandar;
    }    

    public double getLimite_inferiorB() {
        return limite_inferiorB;
    }

    public void setLimite_inferiorB(double limite_inferiorB) {
        this.limite_inferiorB = limite_inferiorB;
    }

    public double getLimite_superiorB() {
        return limite_superiorB;
    }

    public void setLimite_superiorB(double limite_superiorB) {
        this.limite_superiorB = limite_superiorB;
    }

    public double getPunto_medioB() {
        return punto_medioB;
    }

    public void setPunto_medioB(double punto_medioB) {
        this.punto_medioB = punto_medioB;
    }

    public double getLimite_inferior_soporteB() {
        return limite_inferior_soporteB;
    }

    public void setLimite_inferior_soporteB(double limite_inferior_soporteB) {
        this.limite_inferior_soporteB = limite_inferior_soporteB;
    }

    public double getLimite_superior_soporteB() {
        return limite_superior_soporteB;
    }

    public void setLimite_superior_soporteB(double limite_superior_soporteB) {
        this.limite_superior_soporteB = limite_superior_soporteB;
    }
    
    /*Getters para los arreglos*/

    public double[] getAelements() {
        return Aelements;
    }

    public double[] getBelements() {
        return Belements;
    }    
}