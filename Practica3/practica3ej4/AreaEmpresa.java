
package practica3ej4;

public class AreaEmpresa {
    private String identificación;
    private int tardanza;

    public AreaEmpresa(String identificación, int tardanza) {
        this.identificación = identificación;
        this.tardanza = tardanza;
    }

    public String getIdentificación() {
        return identificación;
    }

    public int getTardanza() {
        return tardanza;
    }

    public void setIdentificación(String identificación) {
        this.identificación = identificación;
    }

    public void setTardanza(int tardanza) {
        this.tardanza = tardanza;
    }
    
}
