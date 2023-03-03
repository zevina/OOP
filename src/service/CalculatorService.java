package service;

public class CalculatorService {
    private double num1;
    private double num2;
    private char mathSymbol;
    private String complex1;
    private String complex2;
    private double a1;
    private double a2;
    private double b1;
    private double b2;

    public char getMathSymbol() {
        return mathSymbol;
    }

    public void setMathSymbol(char mathSymbol) {
        this.mathSymbol = mathSymbol;
    }


    // рациональные числа RN

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double sum() {
        return this.num1 + this.num2;
    }

    public double subtract() {
        return this.num1 - this.num2;
    }

    public double multiply() {
        return this.num1 * this.num2;
    }

    public double divide() {
        return this.num1 / this.num2;
    }


    // комплексные числа CN

    public String getComplex1() {
        return complex1;
    }

    public String getComplex2() {
        return complex2;
    }

    public void setComplex1(String complex1) {
        this.complex1 = complex1;
    }

    public void setComplex2(String complex2) {
        this.complex2 = complex2;
    }

    public void getCoef1(String complex1) {
        String sep = "";
        if (complex1.contains(" -")) {
            sep = " -";
        } else if (complex1.contains(" +")) {
            sep = " +";
        }
        String[] coefS = complex1.replaceAll("i", "").split(sep);
        double[] coefI = new double[2];
        for (int i = 0; i < coefS.length; i++) {
            coefI[i] = Double.parseDouble(coefS[i]);
        }
        this.a1 = coefI[0];
        this.b1 = coefI[1];
    }

    public void getCoef2(String complex2) {
        String sep = "";
        if (complex2.contains(" -")) {
            sep = " -";
        } else if (complex2.contains(" +")) {
            sep = " +";
        }
        String[] coefS = complex2.replaceAll("i", "").split(sep);
        double[] coefI = new double[2];
        for (int i = 0; i < coefS.length; i++) {
            coefI[i] = Double.parseDouble(coefS[i]);
        }
        this.a2 = coefI[0];
        this.b2 = coefI[1];
    }

    public String sumCN() {
        getCoef1(this.complex1);
        getCoef2(this.complex2);

        double a1 = this.a1;
        double b1 = this.b1;
        double a2 = this.a2;
        double b2 = this.b2;

        StringBuilder res = new StringBuilder();
        double resRE = a1 + a2;
        double resIM = b1 + b2;
        res.append(String.format("%.1f", resRE));

        if (resIM < 0) {
            res.append("-");
        } else res.append("+");

        res.append(String.format("%.1f", resIM));
        res.append("i");

        return res.toString();
    }

    public String subtractCN() {
        getCoef1(this.complex1);
        getCoef2(this.complex2);

        double a1 = this.a1;
        double b1 = this.b1;
        double a2 = this.a2;
        double b2 = this.b2;

        StringBuilder res = new StringBuilder();
        double resRE = a1 - a2;
        double resIM = b1 - b2;

        res.append(String.format("%.1f", resRE));

        if (resIM < 0) {
            res.append("-");
        } else res.append("+");

        res.append(String.format("%.1f", resIM));
        res.append("i");

        return res.toString();
    }

    public String multiplyCN() {
        getCoef1(this.complex1);
        getCoef2(this.complex2);

        double a1 = this.a1;
        double b1 = this.b1;
        double a2 = this.a2;
        double b2 = this.b2;
        StringBuilder res = new StringBuilder();
        double resRE = a1 * a2 - b1 * b2;
        double resIM = a1 * b2 + a2 * b1;
        res.append(String.format("%.1f", resRE));

        if (resIM < 0) {
            res.append("-");
        } else res.append("+");

        res.append(String.format("%.1f", resIM));
        res.append("i");

        return res.toString();
    }

    public String divideCN() {
        getCoef1(this.complex1);
        getCoef2(this.complex2);

        double a1 = this.a1;
        double b1 = this.b1;
        double a2 = this.a2;
        double b2 = this.b2;
        StringBuilder res = new StringBuilder();
        double resRE = (a1 * a2 + b1 * b2) / (a2 * a2 + b2 * b2);
        double resIM = (a2 * b1 - a1 * b2) / (a2 * a2 + b2 * b2);
        res.append(String.format("%.1f", resRE));

        if (resIM < 0) {
            res.append("-");
        } else res.append("+");

        res.append(String.format("%.1f", resIM));
        res.append("i");

        return res.toString();
    }

}